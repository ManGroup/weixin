package com.xgframe.platform;

import com.xgframe.platform.sms.WxSmsClient;
import org.junit.Test;

/**
 * Created by Antony on 14-2-22.
 */
public class WxSmsClientTest {
    @Test
    public void sendSms() {
        System.out.println("fasong");
        WxSmsClient wxSmsClient = new WxSmsClient();
        try {
            wxSmsClient.sendMsg("您的验证码是：345882，有效期为10分钟。如非本人操作，可不用理会。【梦创】", "18642698912");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
