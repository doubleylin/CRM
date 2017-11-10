package com.lanou3g.crm.staff.web.action;

import com.lanou3g.crm.staff.domain.Department;
import com.lanou3g.crm.staff.domain.Post;
import com.lanou3g.crm.staff.domain.Staff;
import com.lanou3g.crm.staff.service.StaffService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * .                       .::::.
 * .                     .::::::::.
 * .                    :::::::::::  Jack Slow fuck
 * .                ..:::::::::::'
 * .            '::::::::::::::'
 * .               ':::::::::::
 * .           '::::::::::::::..
 * .                ..::::::::::::.
 * .              ``::::::::::::::::
 * .               ::::``:::::::::'        .:::.
 * .              ::::'   ':::::'       .::::::::.
 * .            .::::'      ::::     .:::::::'::::.
 * .           .:::'       :::::  .:::::::::' ':::::.
 * .          .::'        :::::.:::::::::'      ':::::.
 * .         .::'         ::::::::::::::'         ``::::.
 * .     ...:::           ::::::::::::'              ``::.
 * .    ```` ':           ':::::::::'                  ::::..
 * .                       '.:::::'                    ':'````..
 */
@Controller("staffAction")
@Scope("prototype")
public class StaffAction extends ActionSupport implements ModelDriven<Staff> {

    private Staff staff = new Staff();
    @Resource(name = "staffService")
    private StaffService staffService;
    private List<Department> departments = new ArrayList<>();
    private List<Post> posts = new ArrayList<>();

    /**
     * 员工注册登录
     *
     * @return
     */
    public String login() {
        staffService.login(staff);
        ServletActionContext.getRequest().getSession()
                .setAttribute("staff",staff);
        return SUCCESS;
    }

    /**
     * 登录验证
     *
     * @return
     */
    public void validateLogin() {
        List<Staff> staffs = staffService.findAll(staff);
        for (Staff staff1 : staffs) {
            if (staff1.getLoginName().equals(staff.getLoginName())) {
                if (staff1.getLoginPwd().equals(staff.getLoginPwd())) {
                    break;
                } else {
                    addFieldError("password", "密码错误");
                }
            }
            break;
        }

    }

    /**
     * 重新登录
     * @return
     */
    public String overLogin(){
        Staff s = staffService.overLogin(staff.getLoginName(), staff.getLoginPwd());
        if (s != null) {
            ActionContext.getContext().getSession().put("staff", s);
            return SUCCESS;
        }

        return ERROR;
    }


    @Override
    public Staff getModel() {
        return staff;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
