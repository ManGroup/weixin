package weixin.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import weixin.util.weixin.platform.wx.WeixinMessage;
import weixin.util.weixin.platform.wx.WeixinUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/restful/weixin.do")
public class HelloController {
    @RequestMapping(method = RequestMethod.GET)
    public String doGet(HttpServletRequest request) {
        String echostr = request.getParameter("echostr");
        request.setAttribute("echostr", echostr);
        return "hello";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        WeixinMessage wxMsg = null;
        try {
            wxMsg = WeixinUtils.parseXML(request.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(wxMsg.getContent());
        System.out.println("wxMsg.getReceiver()" + wxMsg.getReceiver());
        System.out.println("wxMsg.getSender()" + wxMsg.getSender());
        List list = new ArrayList();
        Map a1 = new HashMap();
        a1.put("name","李浩");
        a1.put("phone","18642698912");
        Map a2 = new HashMap();
        a2.put("name","李四");
        a2.put("phone","123123123");
        Map a3 = new HashMap();
        a3.put("name","刘鹏");
        a3.put("phone","33343434");
        Map a4 = new HashMap();
        a4.put("name","大爷");
        a4.put("phone","3123434");
        list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);
        request.setAttribute("wxMsg", wxMsg.getReply());
        String phone = "";
        for(int i = 0 ; i<list.size();i++){
            Map result = (Map)list.get(i);
            String s = (String)result.get("name");
            String p = (String)result.get("phone");
            if(s.equals(wxMsg.getContent())) {
                phone = p;
            }
        }
        if(phone.length() == 0 ){
            phone = "查无此人";
        }
        System.out.println(phone);
        response.setContentType("text/xml; charset=UTF-8");
        request.setAttribute("content", phone);

        return "weixin";
    }


}