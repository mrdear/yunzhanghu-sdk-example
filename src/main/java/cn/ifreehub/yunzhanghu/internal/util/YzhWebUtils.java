package cn.ifreehub.yunzhanghu.internal.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.ifreehub.yunzhanghu.YunzhanghuWebClient;

import java.util.HashMap;
import java.util.Map;

public class YzhWebUtils {

  private static final Logger logger = LoggerFactory.getLogger(YzhWebUtils.class);


  private YunzhanghuWebClient yunzhanghuWebClient;

  public YzhWebUtils(YunzhanghuWebClient yunzhanghuWebClient) {
    this.yunzhanghuWebClient = yunzhanghuWebClient;
  }

  /**
   * get请求
   * @param dealerId 商户代码
   * @param requestId 请求id
   * @param url 请求地址
   * @param queryParam 参数
   * @return resp
   */
  public String doGet(String dealerId, String requestId, String url, Map<String, Object> queryParam) {
    try {
      Map<String, Object> header = new HashMap<>(2);
      header.put("dealer-id", dealerId);
      header.put("request-id", requestId);
      return yunzhanghuWebClient.yzh_Get(header, url, queryParam);
    } catch (Exception e) {
      logger.error("yunzhanghu get error, url is {}",url, e);
      return "";
    }
  }

  /**
   * post请求
   * @param dealerId 商户代码
   * @param requestId 请求id
   * @param url 请求地址
   * @param params 参数
   * @return resp
   */
  public String doPost(String dealerId, String requestId, String url, Map<String, Object> params) {
    Map<String, Object> header = new HashMap<>(3);
    header.put("Content-Type", "application/x-www-form-urlencoded");
    header.put("dealer-id", dealerId);
    header.put("request-id", requestId);

    try {
      return yunzhanghuWebClient.yzh_Post(header, url, params);
    } catch (Exception e) {
      logger.error("yunzhanghu post error, url is {}",url, e);
      return null;
    }
  }

}