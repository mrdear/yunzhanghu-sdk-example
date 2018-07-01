package cn.ifreehub.yunzhanghu.internal.util;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author Quding Ding
 * @since 2018/6/25
 */
public class YzhJsonUtils {

  private static final ObjectMapper OBJECTMAPPER = new ObjectMapper();

  static {
    // 设定不从get set,直接从对应的属性字段获取
    OBJECTMAPPER.setVisibility(PropertyAccessor.SETTER, JsonAutoDetect.Visibility.NONE);
    OBJECTMAPPER.setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
    OBJECTMAPPER.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
  }

  /**
   * 转换任意object到json String
   * @param value 任意object
   * @return json string
   */
  public static String writeString(Object value) {
    try {
      return OBJECTMAPPER.writeValueAsString(value);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * 读取
   * @param jsonContent json字符串
   * @param clazz 类型
   */
  public static <T> T readValue(String jsonContent, Class<T> clazz) {
    try {
      return OBJECTMAPPER.readValue(jsonContent, clazz);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
