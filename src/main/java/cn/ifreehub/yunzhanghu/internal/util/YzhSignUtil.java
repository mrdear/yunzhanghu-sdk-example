package cn.ifreehub.yunzhanghu.internal.util;


import cn.ifreehub.yunzhanghu.YunzhanghuSignException;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author Quding Ding
 * @since 2018/6/25
 */
public class YzhSignUtil {

  /**
   * 3des算法加密
   * @param content 加密内容
   * @param des3Key 加密key
   * @return 加密结果
   */
  public static String tripleDesEncrypt(String content, String des3Key) {
    try {
      byte[] icv = new byte[8];
      byte[] desKeyBytes = des3Key.getBytes("utf-8");
      System.arraycopy(desKeyBytes, 0, icv, 0, 8);
      byte[] desEncrypt = tripleDesEncrypt(content.getBytes("utf-8"), desKeyBytes, icv);
      return Base64.getEncoder().encodeToString(desEncrypt);
    } catch (Exception e) {
      throw new YunzhanghuSignException(e);
    }
  }

  public static String tripleDesDecrypt(String base64Content, String des3Key){
    try {
      byte[] icv = new byte[8];
      byte[] desKeyBytes = des3Key.getBytes("utf-8");
      System.arraycopy(desKeyBytes, 0, icv, 0, 8);
      byte[] decode = Base64.getDecoder().decode(base64Content);
      return new String(tripleDesDecrypt(decode, desKeyBytes, icv));
    } catch (Exception e) {
      throw new YunzhanghuSignException(e);
    }
  }

  /**
   * (hmac('sha256', data=xxx&mess=xxx&timestamp=xxx&key=appkey, appkey))
   *
   * @return 签名
   */
  public static String hmacSignReqData(String appKey, String data, String mess, Long timestamp) {
    try {
      String signContent = "data=" + data + "&" +
          "mess=" + mess + "&" +
          "timestamp=" + timestamp + "&" +
          "key=" + appKey;

      return hmacSign(appKey.getBytes("utf-8"), signContent.getBytes("utf-8"));
    } catch (Exception e) {
      throw new YunzhanghuSignException(e);
    }
  }

  static String hmacSign(byte[] appKey, byte[] signContent) throws Exception {
    SecretKey secretKey = new SecretKeySpec(appKey, "HmacSHA256");
    Mac mac = Mac.getInstance("HmacSHA256");
    mac.init(secretKey);
    return byteArrayToHexString(mac.doFinal(signContent));
  }


  // -------- private ------------

  private static byte[] tripleDesEncrypt(byte[] content, byte[] key, byte[] icv) throws Exception {
    SecretKey secretKey = new SecretKeySpec(key, "DESede");
    Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
    IvParameterSpec iv = new IvParameterSpec(icv);
    cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
    return cipher.doFinal(content);
  }

  private static byte[] tripleDesDecrypt(byte[] content, byte[] key, byte[] icv) throws Exception {
    SecretKey secretKey = new SecretKeySpec(key, "DESede");
    Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
    IvParameterSpec iv = new IvParameterSpec(icv);
    cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
    return cipher.doFinal(content);
  }

  private static String byteArrayToHexString(byte[] b) {
    StringBuilder hs = new StringBuilder();
    String stmp;
    for (int n = 0; b!=null && n < b.length; n++) {
      stmp = Integer.toHexString(b[n] & 0XFF);
      if (stmp.length() == 1)
        hs.append('0');
      hs.append(stmp);
    }
    return hs.toString().toLowerCase();
  }

}
