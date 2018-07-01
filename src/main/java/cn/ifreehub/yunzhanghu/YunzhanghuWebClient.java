package cn.ifreehub.yunzhanghu;

import java.util.Map;

/**
 * 该接口只是暴露出去使得HttpClient能够被外部所定义
 *
 * @author Quding Ding
 * @since 2018/6/25
 */
public interface YunzhanghuWebClient {
  /**
   * 单纯的get请求
   *
   * @return 结果
   */
  String yzh_Get(Map<String, Object> headers, String url, Map<String, Object> queryParam) throws Exception;

  /**
   * 单纯的post请求
   *
   * @return 结果
   */
  String yzh_Post(Map<String, Object> headers, String url, Map<String, Object> formParam) throws Exception;

}
