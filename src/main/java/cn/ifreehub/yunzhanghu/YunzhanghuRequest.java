package cn.ifreehub.yunzhanghu;


import cn.ifreehub.yunzhanghu.constant.HttpMethod;
import cn.ifreehub.yunzhanghu.internal.util.YzhJsonUtils;

/**
 * @author Quding Ding
 * @since 2018/6/25
 */
public interface YunzhanghuRequest<T extends YunzhanghuResponse> {
  /**
   * 得到请求地址
   *
   * @return 请求地址
   */
  String getRequestUrl();

  /**
   * 得到API相应结果类型
   *
   * @return 相应结果类型, 可以直接反射创建该类
   */
  Class<T> getResponseClass();

  /**
   * 得到请求方式
   *
   * @return get or postw
   */
  HttpMethod getHttpMethod();

  /**
   * 返回请求数据
   *
   * @return 请求数据
   */
  default String getRequestJson() {
    return YzhJsonUtils.writeString(this);
  }

}
