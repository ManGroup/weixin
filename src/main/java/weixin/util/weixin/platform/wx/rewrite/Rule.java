package weixin.util.weixin.platform.wx.rewrite;

import org.jetbrains.annotations.Nullable;
import weixin.util.weixin.platform.wx.WeixinMessage;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * rewrite rule
 *
 * @author linux_china
 */
public interface Rule {
    /**
     * match weixin message?
     *
     * @param wxMsg    weixin message
     * @param request  http servlet request
     * @param response http servlet response
     * @return rewritten url
     * @throws java.io.IOException               io exception
     * @throws javax.servlet.ServletException          servlet exception
     */
    @Nullable
    public RewrittenUrl matches(WeixinMessage wxMsg,
                                final HttpServletRequest request,
                                final HttpServletResponse response)
            throws IOException, ServletException;
}
