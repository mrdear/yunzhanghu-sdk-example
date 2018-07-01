package cn.ifreehub.yunzhanghu;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.ifreehub.yunzhanghu.constant.HttpMethod;
import cn.ifreehub.yunzhanghu.response.CallbackResponse;
import cn.ifreehub.yunzhanghu.internal.util.YzhJsonUtils;
import cn.ifreehub.yunzhanghu.internal.util.YzhSignUtil;
import cn.ifreehub.yunzhanghu.internal.util.YzhWebUtils;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Quding Ding
 * @since 2018/6/25
 */
public class DefaultYunzhanghuClient implements YunzhanghuClient {

  private static Logger logger = LoggerFactory.getLogger(DefaultYunzhanghuClient.class);

  /**
   * 请求的API地址
   */
  private final String baseApiUrl = "https://api-jiesuan.yunzhanghu.com/";

  /**
   * 商户代码,由结算系统分配
   */
  private final String dealerId;
  /**
   * 签名方式,目前sdk版本固定为sha256
   */
  private final String signType;
  /**
   *  结算系统提供的key
   */
  private final String appKey;
  /**
   * 结算系统提供的3des key
   */
  private final String des3Key;
  /**
   * 请求工具
   */
  private final YzhWebUtils yzhWebUtils;

  public DefaultYunzhanghuClient(String dealerId, String signType, String appKey, String des3Key, YunzhanghuWebClient webClient) {
    this.dealerId = dealerId;
    this.signType = signType;
    this.appKey = appKey;
    this.des3Key = des3Key;
    this.yzhWebUtils = new YzhWebUtils(webClient);
  }


  @Override
  public <T extends YunzhanghuResponse> T execute(YunzhanghuRequest<T> request) {
    Map<String, Object> requestData = generateRequestData(request);

    String requestId = UUID.randomUUID().toString();
    String fullUrl = getFullUrl(request);

    String resp = "";
    if (request.getHttpMethod() == HttpMethod.GET) {
      resp = yzhWebUtils.doGet(dealerId, requestId, fullUrl, requestData);
    } else if (request.getHttpMethod() == HttpMethod.POST) {
      resp = yzhWebUtils.doPost(dealerId, requestId, fullUrl, requestData);
    }

    T instance = YzhJsonUtils.readValue(resp, request.getResponseClass());
    instance.setBody(resp);

    return instance;
  }

  @Override
  public CallbackResponse verify(String data) {
    try {
      String decryptData = YzhSignUtil.tripleDesDecrypt(data, des3Key);
      return YzhJsonUtils.readValue(decryptData, CallbackResponse.class);
    } catch (Exception e) {
      throw new YunzhanghuException("yunzhanghu verify fail",e);
    }
  }

  /**
   * 得到请求完整地址
   * @param request 请求实体
   * @return 完整地址
   */
  private String getFullUrl(YunzhanghuRequest request) {
    return baseApiUrl + request.getRequestUrl();
  }

  /**
   * 生成请求数据
   * @param request 请求实体
   * @return 数据
   */
  private Map<String, Object> generateRequestData(YunzhanghuRequest request) {
    String reqJson = request.getRequestJson();
    String data = YzhSignUtil.tripleDesEncrypt(reqJson, des3Key);
    String mess = UUID.randomUUID().toString();
    long timestamp = System.currentTimeMillis() / 1000L;
    String sign = YzhSignUtil.hmacSignReqData(appKey, data, mess, timestamp);

    Map<String, Object> result = new LinkedHashMap<>(5);
    result.put("data", data);
    result.put("mess", mess);
    result.put("timestamp", timestamp);
    result.put("sign", sign);
    result.put("sign_type", signType);
    return result;
  }
}
