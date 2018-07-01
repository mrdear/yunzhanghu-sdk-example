package cn.ifreehub.yunzhanghu.response;


import com.fasterxml.jackson.annotation.JsonProperty;

import cn.ifreehub.yunzhanghu.YunzhanghuResponse;
import cn.ifreehub.yunzhanghu.constant.YzhStatus;

/**
 * @author Quding Ding
 * @since 2018/6/25
 */
public class CallbackResponse extends YunzhanghuResponse {
  private static final long serialVersionUID = -4763200454032106117L;

  @JsonProperty("notify_id")
  private String notifyId;

  @JsonProperty("notify_time")
  private String notifyTime;

  @JsonProperty("data")
  private CallbackResponseData data;


  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public String getNotifyId() {
    return notifyId;
  }

  public void setNotifyId(String notifyId) {
    this.notifyId = notifyId;
  }

  public String getNotifyTime() {
    return notifyTime;
  }

  public void setNotifyTime(String notifyTime) {
    this.notifyTime = notifyTime;
  }

  public CallbackResponseData getData() {
    return data;
  }

  public void setData(CallbackResponseData data) {
    this.data = data;
  }

  public static class CallbackResponseData {
    @JsonProperty("pay")
    private String pay;
    @JsonProperty("anchor_id")
    private String anchorId;
    @JsonProperty("broker_amount")
    private String brokerAmount;
    @JsonProperty("borker_id")
    private String borkerId;
    @JsonProperty("card_no")
    private String cardNo;
    @JsonProperty("dealer_id")
    private String dealerId;
    @JsonProperty("id_card")
    private String idCard;
    @JsonProperty("order_id")
    private String orderId;
    @JsonProperty("phone_no")
    private String phoneNo;
    @JsonProperty("real_name")
    private String realName;
    @JsonProperty("ref")
    private String ref;
    @JsonProperty("notes")
    private String notes;
    @JsonProperty("status")
    private YzhStatus status;
    @JsonProperty("status_detail")
    private Integer statusDetail;
    @JsonProperty("status_detail_message")
    private String statusDetailMessage;
    @JsonProperty("sys_amount")
    private String sysAmount;
    @JsonProperty("pay_remark")
    private String payRemark;
    @JsonProperty("tax")
    private String tax;
    @JsonProperty("tax_level")
    private String taxLevel;
    @JsonProperty("sys_wallet_ref")
    private String sysWalletRef;
    @JsonProperty("sys_bank_bill")
    private String sysBankBill;
    @JsonProperty("broker_wallet_ref")
    private String brokerWalletRef;
    @JsonProperty("broker_bank_bill")
    private String brokerBankBill;

    public String getPay() {
      return pay;
    }

    public void setPay(String pay) {
      this.pay = pay;
    }

    public String getAnchorId() {
      return anchorId;
    }

    public void setAnchorId(String anchorId) {
      this.anchorId = anchorId;
    }

    public String getBrokerAmount() {
      return brokerAmount;
    }

    public void setBrokerAmount(String brokerAmount) {
      this.brokerAmount = brokerAmount;
    }

    public String getBorkerId() {
      return borkerId;
    }

    public void setBorkerId(String borkerId) {
      this.borkerId = borkerId;
    }

    public String getCardNo() {
      return cardNo;
    }

    public void setCardNo(String cardNo) {
      this.cardNo = cardNo;
    }

    public String getDealerId() {
      return dealerId;
    }

    public void setDealerId(String dealerId) {
      this.dealerId = dealerId;
    }

    public String getIdCard() {
      return idCard;
    }

    public void setIdCard(String idCard) {
      this.idCard = idCard;
    }

    public String getOrderId() {
      return orderId;
    }

    public void setOrderId(String orderId) {
      this.orderId = orderId;
    }

    public String getPhoneNo() {
      return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
      this.phoneNo = phoneNo;
    }

    public String getRealName() {
      return realName;
    }

    public void setRealName(String realName) {
      this.realName = realName;
    }

    public String getRef() {
      return ref;
    }

    public void setRef(String ref) {
      this.ref = ref;
    }

    public String getNotes() {
      return notes;
    }

    public void setNotes(String notes) {
      this.notes = notes;
    }

    public YzhStatus getStatus() {
      return status;
    }

    public void setStatus(YzhStatus status) {
      this.status = status;
    }

    public Integer getStatusDetail() {
      return statusDetail;
    }

    public void setStatusDetail(Integer statusDetail) {
      this.statusDetail = statusDetail;
    }

    public String getStatusDetailMessage() {
      return statusDetailMessage;
    }

    public void setStatusDetailMessage(String statusDetailMessage) {
      this.statusDetailMessage = statusDetailMessage;
    }

    public String getSysAmount() {
      return sysAmount;
    }

    public void setSysAmount(String sysAmount) {
      this.sysAmount = sysAmount;
    }

    public String getPayRemark() {
      return payRemark;
    }

    public void setPayRemark(String payRemark) {
      this.payRemark = payRemark;
    }

    public String getTax() {
      return tax;
    }

    public void setTax(String tax) {
      this.tax = tax;
    }

    public String getTaxLevel() {
      return taxLevel;
    }

    public void setTaxLevel(String taxLevel) {
      this.taxLevel = taxLevel;
    }

    public String getSysWalletRef() {
      return sysWalletRef;
    }

    public void setSysWalletRef(String sysWalletRef) {
      this.sysWalletRef = sysWalletRef;
    }

    public String getSysBankBill() {
      return sysBankBill;
    }

    public void setSysBankBill(String sysBankBill) {
      this.sysBankBill = sysBankBill;
    }

    public String getBrokerWalletRef() {
      return brokerWalletRef;
    }

    public void setBrokerWalletRef(String brokerWalletRef) {
      this.brokerWalletRef = brokerWalletRef;
    }

    public String getBrokerBankBill() {
      return brokerBankBill;
    }

    public void setBrokerBankBill(String brokerBankBill) {
      this.brokerBankBill = brokerBankBill;
    }
  }

}
