package cn.ifreehub.yunzhanghu;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import cn.ifreehub.yunzhanghu.constant.YzhStatus;

import java.io.Serializable;

/**
 * @author Quding Ding
 * @since 2018/6/25
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class YunzhanghuResponse implements Serializable {

  private static final long serialVersionUID = 9198800526626686602L;

  private YzhStatus code;

  private String message;

  @JsonProperty("request_id")
  private String requestId;
  /**
   * 完整的请求返回地址
   */
  @JsonIgnore
  private String body;

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public YzhStatus getCode() {
    return code;
  }

  public void setCode(YzhStatus code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  @Override
  public String toString() {
    return "YunzhanghuResponse{" +
        "code='" + code + '\'' +
        ", message='" + message + '\'' +
        ", requestId='" + requestId + '\'' +
        ", body='" + body + '\'' +
        '}';
  }
}
