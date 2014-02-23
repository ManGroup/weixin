package com.xgframe.platform.oss;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Antony on 14-2-23.
 */
public class WxOSSClientTest {
    String tmpKey = "";

    @Test
    public void put() {

        WxOSSClient wxOSSClient = new WxOSSClient();
        try {
            tmpKey = wxOSSClient.putObject("qcheng", "test.png", "C:\\Strap\\base\\weixin\\src\\main\\test\\jp\\co\\dreamarts\\platform\\oss\\test.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        WxOSSClient wxOSSClientGet = new WxOSSClient();
        try {
            wxOSSClientGet.getObject("qcheng", "test.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
