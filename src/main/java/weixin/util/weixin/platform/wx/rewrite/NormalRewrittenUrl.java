package weixin.util.weixin.platform.wx.rewrite;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * normal rewrite url
 *
 * @author linux_china
 */
public class NormalRewrittenUrl implements RewrittenUrl {
    /**
     * target forward url
     */
    private String target;

    /**
     * construct method
     *
     * @param target target url
     */
    public NormalRewrittenUrl(String target) {
        this.target = target;
    }

    /**
     * get target url
     *
     * @return target url
     */
    public String getTarget() {
        return this.target;
    }

    /**
     * execute rewrite
     *
     * @param request  http servlet request
     * @param response http servlet response
     * @return rewrite mark
     * @throws javax.servlet.ServletException servlet exception
     * @throws java.io.IOException      IO exception
     */
    public boolean doRewrite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(getTarget()).forward(request, response);
        return true;
    }
}
