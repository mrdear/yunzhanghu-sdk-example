package cn.ifreehub.yunzhanghu;

/**
 * @author Quding Ding
 * @since 2018/6/25
 */
public class YunzhanghuException extends RuntimeException {
  private static final long serialVersionUID = -3482010738711327330L;

  public YunzhanghuException(Throwable cause) {
    super(cause);
  }

  public YunzhanghuException(String message, Throwable cause) {
    super(message, cause);
  }
}
