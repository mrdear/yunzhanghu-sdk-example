package cn.ifreehub.yunzhanghu.request;


import com.fasterxml.jackson.annotation.JsonProperty;

import cn.ifreehub.yunzhanghu.YunzhanghuRequest;
import cn.ifreehub.yunzhanghu.constant.HttpMethod;
import cn.ifreehub.yunzhanghu.response.VerifyBankcardThreeFactorResp;

/**
 * 银⾏行行卡三要素验证
 * @author Quding Ding
 * @since 2018/6/25
 */
public class VerifyBankcardThreeFactorReq implements YunzhanghuRequest<VerifyBankcardThreeFactorResp> {

  /**
   * 银行卡号
   */
  @JsonProperty("card_no")
  private String cardNo;
  /**
   * 身份证号
   */
  @JsonProperty("id_card")
  private String idCard;
  /**
   * 真实姓名
   */
  @JsonProperty("real_name")
  private String realName;

  @Override
  public String getRequestUrl() {
    return "/authentication/verify-bankcard-three-factor";
  }

  @Override
  public Class<VerifyBankcardThreeFactorResp> getResponseClass() {
    return VerifyBankcardThreeFactorResp.class;
  }

  @Override
  public HttpMethod getHttpMethod() {
    return HttpMethod.POST;
  }

  // -------- get set --------


  public String getCardNo() {
    return cardNo;
  }

  public void setCardNo(String cardNo) {
    this.cardNo = cardNo;
  }

  public String getIdCard() {
    return idCard;
  }

  public void setIdCard(String idCard) {
    this.idCard = idCard;
  }

  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }

}
