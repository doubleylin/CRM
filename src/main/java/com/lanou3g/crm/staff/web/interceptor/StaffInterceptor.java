package com.lanou3g.crm.staff.web.interceptor;


import com.lanou3g.crm.staff.domain.Staff;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * Created by dllo on 2017/10/30.
 */
public class StaffInterceptor extends MethodFilterInterceptor {

    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        Staff staff = (Staff) ActionContext.getContext().getSession().get("staff");
        if (!"admin".equals(staff.getLoginName())) {
            ActionContext.getContext().put("msg","对不起,你没有权限");
            return "miss";
        }
        return actionInvocation.invoke();
    }
}
