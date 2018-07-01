package cn.ifreehub.yunzhanghu;

/**
 * 签名错误
 * @author Quding Ding
 * @since 2018/6/25
 */
public class YunzhanghuSignException extends RuntimeException {
  private static final long serialVersionUID = -1814042752855056890L;

  public YunzhanghuSignException(Throwable cause) {
    super(cause);
  }

  public YunzhanghuSignException(String message, Throwable cause) {
    super(message, cause);
  }
}
