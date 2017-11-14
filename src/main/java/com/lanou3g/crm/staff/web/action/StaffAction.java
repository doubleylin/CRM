package com.lanou3g.crm.staff.web.action;

import com.lanou3g.crm.staff.domain.Department;
import com.lanou3g.crm.staff.domain.Post;
import com.lanou3g.crm.staff.domain.Staff;
import com.lanou3g.crm.staff.service.DepartmentService;
import com.lanou3g.crm.staff.service.PostService;
import com.lanou3g.crm.staff.service.StaffService;
import com.lanou3g.crm.utils.CrmStringUtils;
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
    @Resource(name = "departmentService")
    private DepartmentService departmentService;
    @Resource(name = "postService")
    private PostService postService;

    public String findDepartment() {
        departments = departmentService.findAllDepartment();

        return SUCCESS;
    }

    public String findPostByDeptId() {
        posts = postService.findPostByDepId(this.deptId);
        return SUCCESS;
    }

    public String showStaff() {
        if ("".equals(staff.getStaffName())) {
            if ("-1".equals(staff.getDepartment().getDepId())) {
                List<Staff> staffs = staffService.findAll();
                ActionContext.getContext().getSession().put("staffs", staffs);
            } else if ("-1".equals(staff.getPost().getPostId())) {
                List<Post> posts = postService.findPostByDepId(staff.getDepartment().getDepId());
                List<Staff> staffs = new ArrayList<>();
                for (Post post : posts) {
                    List<Staff> staffByPostId = staffService.findStaffByPostId(post.getPostId());
                    for (Staff staff1 : staffByPostId) {
                        staffs.add(staff1);

                    }
                }
                ActionContext.getContext().getSession().put("staffs", staffs);
            } else {
                List<Staff> staffs = staffService.findStaffByPostId(staff.getPost().getPostId());
                ActionContext.getContext().getSession().put("staffs", staffs);
            }
        } else {
            if ("-1".equals(staff.getDepartment().getDepId())){
                List<Staff> staffs = staffService.findStaffByStaffName(staff.getStaffName());
                ActionContext.getContext().getSession().put("staffs",staffs);
            }else if ("-1".equals(staff.getPost().getPostId())){
                List<Post> posts = postService.findPostByDepId(staff.getDepartment().getDepId());
                List<Staff> staffs = new ArrayList<>();
                for (Post post : posts) {
                    List<Staff> staffByPostId = staffService.findStaffByPostIdAndStaffName(post.getPostId(),staff.getStaffName());
                    for (Staff staff1 : staffByPostId) {
                        staffs.add(staff1);
                    }
                }
                ActionContext.getContext().getSession().put("staffs",staffs);
            }else {
                List<Staff> staffs = staffService.findStaffByPostIdAndStaffName(staff.getPost().getPostId(),staff.getStaffName());
                ActionContext.getContext().getSession().put("staffs",staffs);
            }
        }
        return SUCCESS;
    }
    public String addStaff(){
        if ("".equals(staff.getLoginName())){
            addActionError("登录名不能为空");
            return INPUT;
        }
        if ("".equals(staff.getLoginPwd())){
            addActionError("密码不能为空");
            return INPUT;
        }
        if ("".equals(staff.getStaffName())){
            addActionError("姓名不能为空");
        }
        if ("-1".equals(staff.getPost().getDepartment().getDepId())){
            addActionError("请选择部门");
        }
        if ("-1".equals(staff.getPost().getPostId())){
            addActionError("请选择职位");
        }
        Department deptById = departmentService.findById(staff.getPost().getDepartment().getDepId());
        staff.getPost().setDepartment(deptById);
        staff.setLoginPwd(CrmStringUtils.getMD5Value(staff.getLoginPwd()));
        staff.getPost().setDepartment(deptById);
        Post post1 = postService.findPostByPostId(staff.getPost().getPostId());
        staff.setPost(post1);
        staffService.addStaff(staff);
        return SUCCESS;
    }
    public String listStaff(){
        List<Staff> staffs = staffService.findAll();
        ActionContext.getContext().getSession().put("staffs",staffs);
        return SUCCESS;
    }

    public String findDeptAndPost(){
        staff = staffService.findByStaffId(this.staff.getStaffId());
        List<Department> departments = departmentService.findAllDepartment();
        ActionContext.getContext().getSession().put("departments",departments);

        List<Post> posts = postService.findAllPost();
        ActionContext.getContext().getSession().put("posts",posts);
        return SUCCESS;
    }

    public String updateStaff(){
        Department deptById = departmentService.findById(staff.getDepartment().getDepId());
        staff.getPost().setDepartment(deptById);
        staff.getPost().setDepartment(deptById);
        Post post1 = postService.findPostByPostId(staff.getPost().getPostId());
        staff.setPost(post1);
        staffService.updateStaff(staff);
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
     *
     * @return
     */
    public String overLogin() {
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
