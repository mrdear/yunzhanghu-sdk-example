package cn.ifreehub.yunzhanghu;


import cn.ifreehub.yunzhanghu.response.CallbackResponse;

/**
 * 云账户客户端
 * @author Quding Ding
 * @since 2018/6/25
 */
public interface YunzhanghuClient {


  /**
   * 通用执行请求,没有特殊要求就选这个
   * @param request 请求实体,根据自己的业务选择
   * @return response 返回
   */
  <T extends YunzhanghuResponse> T execute(YunzhanghuRequest<T> request);

  /**
   * 验证数据是否合法
   * @param data 数据
   * @return true合法
   */
  CallbackResponse verify(String data);


}
