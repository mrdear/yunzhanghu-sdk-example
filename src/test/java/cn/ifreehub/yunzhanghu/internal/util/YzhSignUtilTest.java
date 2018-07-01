package cn.ifreehub.yunzhanghu.internal.util;

import org.junit.Assert;
import org.junit.Test;

public class YzhSignUtilTest {

  @Test
  public void testDes3() throws Exception {
    String contentStr = "{\"order_id\": \"201609010016562012987\",\"init_batch_id\":\"201609_-NDJ\",\"cur_batch_id\": \"201609_-NDJ\",\"issue_id\": \"201609- NDJ\",\"reserve_id\": \"56244623 " +
        "20160901-1\",\"dealer_id\": \"sixcn\",\"broker_id\":\"0\",\"anchor_id\": \"56244623\",\"real_name\": \"张三\",\"card_no\":\"6228880199872220\",\"bank_name\": \"招商银⾏行行\",\"bank_branch\": \"上地分⾏行行\",\"bank_prov\": \"北北京\",\"bank_city\": \"北北京\",\"phone_no\": \"13488795491\",\"id_card\":\"123532612312312321\",\"yyyy_mm\": \"201609\",\"pay\": \"100000.00\"}";

    String descKey = "123456788765432112345678";

    String enc = YzhSignUtil.tripleDesEncrypt(contentStr, descKey);

    String dec = YzhSignUtil.tripleDesDecrypt(enc, descKey);

    Assert.assertEquals(dec, contentStr);

  }

  @Test
  public void testSign() throws Exception {
    String appKey = "78f9b4fad3481fbce1df0b30eee58577";

    String data = "data=0eUw2Nk2isX+IRlttM7eKomZCAfJlocPw2lG4uVrc0qIIbhOusoy0Pp5hl5sWKRxrp4+/" +
        "YVTJKqFGlS+dB+0/ApQ9/" +
        "yVvQmmDdIx4kdUw487S4KruUxMy14qkrqSreTHKkGww71pUX8Xe6jBBZHkGTeibyOWEi" +
        "axp3UUNJs7Qxo0rWAct4+0ntTdniNMalsQbKQ7AvhuwWJY+c9HSgMtizJ7IlkhzfOC9SyUr" +
        "7353G/" +
        "fd1GX7p2Q+j22b7YceAyZyIgsdEyX24z0tPeh6b49pKJpThf792UJxkxCDq3rdbAfAVpmf+er" +
        "Q8qBHgD+KElyB5ywHBkTNLxZEW1tzMmd7C76ANmrQgY8oOz7e91DTjbuc8z4Qr8QsW" +
        "ub0+mUNrlGvbYeCfc2+emkeo1moVZXujLof8JmrCZUSstrg9qE1kEptj0SvnELk9RYEAYqX" +
        "e15O0fLWz/" +
        "ywRgCmerpWdqRViWp+YV4+9QrI1bCRlWRp+7Xuc8hNCsIojaOxK0Xpn4gbde1+dX1SY" +
        "OJu9RqIMDRdTzﬂlUwzsGexLu9sb3NphodW7brNG5l/lG4k5vs23565DJgbr/" +
        "zvXYTslLwHkr+RkVYSyhjr0xPF1ZQQHzZdzdN4DiliRAlATE27BDHSTvV&mess=12313&ti" +
        "mestamp=123457&key=78f9b4fad3481fbce1df0b30eee58577";

    String sign = YzhSignUtil.hmacSign(appKey.getBytes("utf-8"),
        data.getBytes("utf-8"));

    Assert.assertEquals("3c4b615ce62bc944def676c1ac68be0cb51559d8ce5417642609f2cb66e32f2f", sign);
  }

}