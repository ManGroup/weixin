package com.xgframe.platform.oss;

import com.xgframe.platform.oss.impl.WxOSSClientImpl;
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

        WxOSSClient wxOSSClient = new WxOSSClientImpl();
        try {
            tmpKey = wxOSSClient.putObject("qcheng", "test.png", "/Users/Antony/Desktop/Untitled-1.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        WxOSSClient wxOSSClientGet = new WxOSSClientImpl();
        try {
            wxOSSClientGet.getObject("qcheng", "test.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
