# 云账户结算系统SDK封装示例

该仓库提供一种使用命令模式封装第三方组件的案例.

在命令模式下,调用如下,简单明了,非常适合封装第三方服务.

```java

  /**
   * 初始化调用者
   */
  private YunzhanghuClient client =
      new DefaultYunzhanghuClient("0123456", "sha256",
          "78f9b4fad3481fbce1df0b30eee58577", "123456788765432112345678", new WebUtils());

  @Test
  public void test() {
    // 构造银行卡三要素验证命令
    VerifyBankcardThreeFactorReq req = new VerifyBankcardThreeFactorReq();
    req.setCardNo("");
    req.setIdCard("");
    req.setRealName("");

    // 发送命令,并拿到返回值
    VerifyBankcardThreeFactorResp resp = client.execute(req);

    System.out.println(resp);
  }

```