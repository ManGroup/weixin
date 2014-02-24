package com.xgframe.platform.sms;

/**
 * Created by Antony on 14-2-22.
 */
public class WxSmsClient {
    public void sendMsg(String msg, String mobile) throws Exception {
        Message message = new Message();
        message.send(msg, mobile);
    }

}
