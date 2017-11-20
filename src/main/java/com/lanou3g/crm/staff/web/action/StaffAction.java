package com.lanou3g.crm.staff.web.action;

import com.lanou3g.crm.staff.domain.Department;
import com.lanou3g.crm.staff.domain.Post;
import com.lanou3g.crm.staff.domain.Staff;
import com.lanou3g.crm.staff.service.DepartmentService;
import com.lanou3g.crm.staff.service.PostService;
import com.lanou3g.crm.staff.service.StaffService;
import com.lanou3g.crm.utils.CrmStringUtils;
import com.lanou3g.crm.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by dllo on 2017/10/24.
 */
@Controller("staffAction")
@Scope("prototype")
public class StaffAction extends ActionSupport implements ModelDriven<Staff> {
    private Staff staff =new Staff();
    private Post post = new Post();
    //使用spring属性注解完成service层的装载
    @Resource
    private StaffService staffService;
    private List<Department> departments;
    private List<Post> posts = new ArrayList<>();
    private String depId;
    private String postId;
    private String pwd;
    private String repwd;
    private String doubleRePwd;


    @Resource(name = "departmentService")
    private DepartmentService departmentService;
    @Resource(name = "postService")
    private PostService postService;

    @SkipValidation
    public String findAll(){
        if (pageNum == 0){
            pageNum = 1;
        }
        PageBean<Staff> all =
                staffService.findAll
                        (getModel(),pageNum,pageSize);
        ActionContext.getContext().put("pageBean",all);
        return SUCCESS;
    }
    /**
     * 查询部门
     * @return
     */
    @SkipValidation
    public String findDepartment() {
        departments = departmentService.findAllDepartment();
        return SUCCESS;
    }

    /**
     * 查询某个部门所有职位
     * @return
     */
    @SkipValidation
    public String findPostByDepId() {
        posts = postService.findPostByDepId(depId);
        return SUCCESS;
    }
    @SkipValidation
    public String findByStaffId(){
        List<Staff> byStaffId = staffService.findByStaffId(staff);
        ActionContext.getContext().getSession().put("byStaffId",byStaffId.get(0));
        ActionContext.getContext().getSession().put("setPostId",byStaffId.get(0).getPost().getPostId());
        ActionContext.getContext().getSession().put("setPostName",byStaffId.get(0).getPost().getPostName());
        return SUCCESS;
    }


    @SkipValidation
    public String highQuery(){

        staffs = staffService.highQuery(depId, staff.getPostId(), staff.getStaffName());
        return SUCCESS;
    }

    @SkipValidation
    public String add(){
        staff.setLoginPwd(CrmStringUtils.getMD5Value(staff.getLoginPwd()));
        staffService.addStaff(staff);
        departments = staffService.findDept();
        return SUCCESS;
    }

    @SkipValidation
    public String update(){
        staff.setLoginPwd(CrmStringUtils.getMD5Value(staff.getLoginPwd()));
        staffService.updateStaff(staff);
        departments = staffService.findDept();
        return SUCCESS;
    }



    @SkipValidation
    public String findSome(){
        pageSize = 20;
        PageBean<Staff> some = staffService.findSome(getModel(), pageNum, pageSize);
        ActionContext.getContext().getSession().put("pageBean",some.getData());
        staffs = some.getData();
        return SUCCESS;
    }

    @SkipValidation

    /**
     * 查询所有部门
     * @return
     */
    public String findDepts(){
        departments = staffService.findDept();
        ActionContext.getContext().getSession().put("departments", departments);
        return SUCCESS;
    }


    @SkipValidation
    public String ListStaff(){

        staffs = staffService.ListStaff();
        ActionContext.getContext().getSession().put("staffs",staffs);
        return SUCCESS;
    }



    /**
     * 登录判断
     * 如果填入的账号密码和数据库数据匹配,则登录
     * 如果不匹配则返回错误
     * @return
     */
    @SkipValidation
    public String login() {
        Staff s = staffService.login(staff.getLoginName(), CrmStringUtils.getMD5Value(staff.getLoginPwd()));
        if (s != null) {
            ActionContext.getContext().getSession().put("staff", s);
            return SUCCESS;
        }
        addFieldError("msg","密码错误");
        return ERROR;
    }

    /**
     * 重登陆
     * @return
     */
    @SkipValidation
    public String overLogin(){
        ActionContext.getContext().getSession().remove("staff");
        return SUCCESS;
    }

    /**
     * 修改密码
     * @return
     */
    @SkipValidation
    public String reLoginPwd(){
        Staff staff1 = (Staff) ActionContext.getContext().getSession().get("staff");
        if (!CrmStringUtils.getMD5Value(pwd).equals(staff1.getLoginPwd())||!repwd.equals(doubleRePwd)){
            addActionError("密码输入错误");
            return ERROR;
        }else {
            staffService.reLoginPwd(staff1,CrmStringUtils.getMD5Value(repwd));
            return SUCCESS;
        }
    }

    /**
     * 登录拦截
     * @return
     */
    @SkipValidation
    public String interceptor(){
        return SUCCESS;
    }

    /**
     * 针对登录动作进行的验证
     */
    @SkipValidation
    public void validateLogin() {
        if (StringUtils.isBlank(staff.getLoginName()) && StringUtils.isBlank(staff.getLoginPwd())) {
            addFieldError("msg", "用户名密码不能");
            ActionContext.getContext().getSession().put("msg", "用户名密码不能为空 !~~~~");
        }
    }
    private int pageNum;
    private int pageSize = 10;
    private List<Staff> staffs;





    @Override
    public Staff getModel() {
        return staff;
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

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRepwd() {
        return repwd;
    }

    public void setRepwd(String repwd) {
        this.repwd = repwd;
    }

    public String getDoubleRePwd() {
        return doubleRePwd;
    }

    public void setDoubleRePwd(String doubleRePwd) {
        this.doubleRePwd = doubleRePwd;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

}
