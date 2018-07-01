package cn.ifreehub.yunzhanghu.constant;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author Quding Ding
 * @since 2018/6/25
 */
public enum YzhStatus {

  DELETE(-1, "被标记为删除的订单"),
  SUCCESS(0, "成功"),
  PAIED_SUCCESS(1, "已打款"),
  PAIED_FAIL(2, "打款失败"),
  PAIED_PAUSE(4, "一般余额不足"),
  PAY_INPROGRESS(5, "打款中(状态未知)"),
  PAIED_PREPARE(8, "待打款,订单税务处理完毕,等待打款"),
  PAIED_REFUND(9, "打款被退回"),
  PAIED_PART_SUCCESS(11, "部分成功"),
  PAIED_CANCEL(15,"取消支付"),
  CAN_NOT_PAY(18, "无需付款"),
  INTERNAL_ERROR(6000, "内部错误"),
  ;


  private int code;

  private String desc;

  YzhStatus(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  @JsonCreator
  public static YzhStatus of(int code) {
    for (YzhStatus yzhStatus : YzhStatus.values()) {
      if (yzhStatus.code == code) {
        return yzhStatus;
      }
    }
    return null;
  }

  @JsonValue
  public int getCode() {
    return code;
  }

  public String getDesc() {
    return desc;
  }
}
