package weixin.service.impl;

import com.alibaba.fastjson.JSON;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import weixin.service.inf.UserServiceI;

import javax.annotation.Resource;
import java.awt.*;
import java.util.HashMap;
import java.util.List;


/**
 * Created by chenyingxi on 14-2-19.
 */
@Service("userService")
public class UserService implements UserServiceI {
    private static final Logger logger= Logger.getLogger(UserService.class);

    @Override
    public String login(String username, String password) {
        return null;
    }
}
