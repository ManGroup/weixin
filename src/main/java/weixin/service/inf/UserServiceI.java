package weixin.service.inf;

/**
 * Created by chenyingxi on 14-2-19.
 */
public interface UserServiceI {
    /**
     *
     * @param username  用户名
     * @param password  密码
     * @return    success :用户可以看到的菜单
     *              false : 1
     */
    String login(String username, String password);


}
