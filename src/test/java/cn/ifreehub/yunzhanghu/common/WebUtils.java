package cn.ifreehub.yunzhanghu.common;


import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.ifreehub.yunzhanghu.YunzhanghuWebClient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class WebUtils implements YunzhanghuWebClient {

  private static final Logger logger = LoggerFactory.getLogger("main");

  private static final String DEFAULT_CHARSET = "UTF-8";

  private static final PoolingHttpClientConnectionManager phccm =
      new PoolingHttpClientConnectionManager();

  static { // 这边来设置并发
    phccm.setDefaultMaxPerRoute(5);
    phccm.setMaxTotal(50);
  }

  private static CloseableHttpClient client = HttpClients.custom().setConnectionManager(phccm)
      .build();

  private static final RequestConfig CONFIG = RequestConfig.custom()
      .setConnectTimeout(3000).setSocketTimeout(3000)
      .build();

  @Override
  public String yzh_Get(Map<String, Object> headers, String url, Map<String, Object> queryParam) throws Exception {
    URI uri = generateURLParams(url, queryParam);
    HttpGet get = new HttpGet(uri);
    get.setConfig(CONFIG);
    CloseableHttpResponse httpResponse = null;
    try {
      headers.forEach((k, v) -> get.setHeader(k, String.valueOf(v)));
      httpResponse = client.execute(get);
      return generateHttpResponse(httpResponse);
    } catch (IOException e) {
      logger.error(url, e);
      return "";
    }
  }

  @Override
  public String yzh_Post(Map<String, Object> headers, String url, Map<String, Object> formParam) throws Exception {
    HttpPost post = new HttpPost(url);
    post.setConfig(CONFIG);

    headers.forEach((k, v) -> post.setHeader(k, String.valueOf(v)));

    CloseableHttpResponse httpResponse = null;
    try {
      post.setEntity(new UrlEncodedFormEntity(generateParams(formParam)));
      httpResponse = client.execute(post);
      return generateHttpResponse(httpResponse);
    } catch (IOException e) {
      logger.error(url, e);
      return null;
    }

  }



  private static List<NameValuePair> generateParams(Map<String, Object> params) {
    if (null == params) {
      return Collections.emptyList();
    }
    List<NameValuePair> paramsList = new ArrayList<>(params.size());
    params.forEach((k, v) -> paramsList.add(new BasicNameValuePair(k, String.valueOf(v))));
    return paramsList;
  }

  private static URI generateURLParams(String url, Map<String, Object> params) {
    URI uri = null;
    try {
      URIBuilder uriBuilder = new URIBuilder(url);
      if (null != params) {
        for (Entry<String, Object> entry : params.entrySet()) {
          uriBuilder.addParameter(entry.getKey(), String.valueOf(entry.getValue()));
        }
      }
      uri = uriBuilder.build();
    } catch (URISyntaxException e) {
      logger.error(url, e);
    }
    return uri;
  }

  private static String generateHttpResponse(CloseableHttpResponse httpResponse) {
    if (null != httpResponse) {
      HttpEntity entity = null;
      try {
        entity = httpResponse.getEntity();
        return EntityUtils.toString(entity, DEFAULT_CHARSET);
      } catch (IOException e) {
        return null;
      } finally {
        try {
          httpResponse.close();
        } catch (IOException e) {
          logger.error("Close Response Failed", e);
        }
      }
    }
    return null;
  }

}