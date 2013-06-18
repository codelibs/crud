package org.codelibs.crud.base.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.seasar.struts.util.ActionMessagesUtil;
import org.seasar.struts.util.RequestUtil;

public class SAStrutsUtil {
    public static void addMessage(String key) {
        addMessage(RequestUtil.getRequest(), key);
    }

    public static void addMessage(HttpServletRequest request, String key) {
        ActionMessages msgs = new ActionMessages();
        msgs.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(key));
        ActionMessagesUtil.saveMessages(request, msgs);
    }

    public static void addMessage(String key, Object... values) {
        addMessage(RequestUtil.getRequest(), key, values);
    }

    public static void addMessage(HttpServletRequest request, String key,
            Object... values) {
        ActionMessages msgs = new ActionMessages();
        msgs.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(key, values));
        ActionMessagesUtil.saveMessages(request, msgs);
    }

    public static void addSessionMessage(String key) {
        addSessionMessage(RequestUtil.getRequest(), key);
    }

    public static void addSessionMessage(HttpServletRequest request, String key) {
        ActionMessages msgs = new ActionMessages();
        msgs.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(key));
        ActionMessagesUtil.saveMessages(request.getSession(), msgs);
    }

    public static void addSessionMessage(String key, Object... values) {
        addSessionMessage(RequestUtil.getRequest(), key, values);
    }

    public static void addSessionMessage(HttpServletRequest request,
            String key, Object... values) {
        ActionMessages msgs = new ActionMessages();
        msgs.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(key, values));
        ActionMessagesUtil.saveMessages(request.getSession(), msgs);
    }
}
