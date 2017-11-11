package com.lanou3g.crm.staff.web.action;

import com.lanou3g.crm.staff.domain.Department;
import com.lanou3g.crm.staff.domain.Post;
import com.lanou3g.crm.staff.domain.Staff;
import com.lanou3g.crm.staff.service.StaffService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    private String deptId;
//    @Resource(name = "departmentService")
//    private DepartmentService departmentService;

//    public String findDepartment(){
//        departments = departmentService.findAllDepartment();
//        return SUCCESS;
//    }

    public String findPostByDeptId(){
        return SUCCESS;
    }
    /**
     * 员工注册登录
     *
     * @return
     */
    public String login() {
        Staff s = staffService.login(staff.getLoginName(), staff.getLoginPwd());
        if (s != null) {
            ActionContext.getContext().getSession().put("staff", s);
            return SUCCESS;
        }

        return ERROR;
    }

    /**
     * 登录验证
     *
     * @return
     */
    public void validateLogin() {
        if (StringUtils.isBlank(staff.getLoginName()) && StringUtils.isBlank(staff.getLoginPwd())) {
            addFieldError("msg", "用户名密码不能");
            ActionContext.getContext().getSession().put("msg", "用户名密码不能为空 !~~~~");
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

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }
}
