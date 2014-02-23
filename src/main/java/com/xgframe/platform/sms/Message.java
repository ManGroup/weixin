package com.xgframe.platform.sms;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Message {

    String mob = "1322222222,1326666666";//电话号码
    private static final String addr = "http://api.sms7.com.cn/";
    private static final String userid = "userid=";

    public int send(String msg, String mobile) throws Exception {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxx");
        int nRet = 0;
        String straddr = addr + "?uid=lxj5891&pwd=493f18c5bb077773b4b6a74372f9acb4&mobile=" + mobile + "&encode=utf8";
//        String straddr = addr + "?uid=test&pwd=b9887c5ebb23ebb294acab183ecf0769&mobile=" + mobile + "&encode=utf8";
        StringBuffer sb = new StringBuffer(straddr);


        //
        sb.append("&content=" + URLEncoder.encode(msg, "UTF-8"));

        System.out.println(sb.toString());
        //
        URL url = new URL(sb.toString());

        //URL  url = new URL(URLEncoder.encode(sb.toString(),"UTF-8") );


        //
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        //
        connection.setRequestMethod("POST");

        //
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

        //
        String inputline = in.readLine();

        //
        System.out.println(inputline);

        //if(! inputline.equals("100"))
        //   nRet = 1;

        return nRet;
    }

}



