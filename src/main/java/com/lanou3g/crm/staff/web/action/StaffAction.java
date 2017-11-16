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
    private Staff staff = new Staff();
    //使用spring属性注解完成service层的装载
    @Resource
    private StaffService staffService;
    private List<Department> departments = new ArrayList<>();
    private List<Post> posts = new ArrayList<>();
    private String depId;
    private String pwd;
    private String repwd;
    private String doubleRePwd;


    @Resource(name = "departmentService")
    private DepartmentService departmentService;
    @Resource(name = "postService")
    private PostService postService;

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
        posts = postService.findPostByDepId(this.depId);
        return SUCCESS;
    }

    /**
     * 显示职员
     * 逻辑:
     * 如果部门,职位,模糊名字都不填:查询全部
     * 选择部门:查询此部门下所有职位的所有职员
     * 选择部门+职位:查询这个职位下所有职员
     * 只填写模糊名字:查询名字包含输入字符串的职员
     * 填写部门+名字:查询某个部门名字包含输入字符串的职员
     * 填写全部:查询某个职位名字包含输入字符的职员
     * @return
     */
    @SkipValidation
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
            if ("-1".equals(staff.getDepartment().getDepId())) {
                List<Staff> staffs = staffService.findStaffByStaffName(staff.getStaffName());
                ActionContext.getContext().getSession().put("staffs", staffs);
            } else if ("-1".equals(staff.getPost().getPostId())) {
                List<Post> posts = postService.findPostByDepId(staff.getDepartment().getDepId());
                List<Staff> staffs = new ArrayList<>();
                for (Post post : posts) {
                    List<Staff> staffByPostId = staffService.findStaffByPostIdAndStaffName(post.getPostId(), staff.getStaffName());
                    for (Staff staff1 : staffByPostId) {
                        staffs.add(staff1);
                    }
                }
                ActionContext.getContext().getSession().put("staffs", staffs);
            } else {
                List<Staff> staffs = staffService.findStaffByPostIdAndStaffName(staff.getPost().getPostId(), staff.getStaffName());
                ActionContext.getContext().getSession().put("staffs", staffs);
            }
        }
        return SUCCESS;
    }

    /**
     * 添加职员
     * @return
     */
    @SkipValidation
    public String addStaff() {

        if ("".equals(staff.getLoginName())) {
            addActionError("登录名不能为空");
            return INPUT;
        }
        if ("".equals(staff.getLoginPwd())) {
            addActionError("密码不能为空");
            return INPUT;
        }
        if ("".equals(staff.getStaffName())) {
            addActionError("姓名不能为空");
            return INPUT;
        }
        if ("".equals(staff.getGender())) {
            addActionError("性别不能为空");
            return INPUT;
        }
        if ("-1".equals(staff.getDepartment().getDepId())) {
            addActionError("请选择部门");
            return INPUT;
        }
        if ("-1".equals(staff.getPost().getPostId())) {
            addActionError("请选择职务");
            return INPUT;
        }
        if (staff.getOnDutyDate() == null) {
            addActionError("入职时间不能为空");
            return INPUT;
        }
        Department byId = departmentService.findById(staff.getDepartment().getDepId());
        staff.setDepartment(byId);
        staff.setLoginPwd(CrmStringUtils.getMD5Value(staff.getLoginPwd()));
        staff.getPost().setDepartment(byId);
        Post post1 = postService.findPostByPostId(staff.getPost().getPostId());
        staff.setPost(post1);
        staffService.addStaff(staff);
        return SUCCESS;
    }

    /**
     * 罗列显示职员
     * @return
     */
    @SkipValidation
    public String listStaff() {
        List<Staff> staffs = staffService.findAll();
        ActionContext.getContext().getSession().put("staffs", staffs);
        return SUCCESS;
    }

    /**
     * 查找部门和职位
     * 用于二级联动
     * @return
     */
    @SkipValidation
    public String findDeptAndPost() {
        staff = staffService.findByStaffId(staff.getStaffId());
        List<Department> departments = departmentService.findAllDepartment();
        ActionContext.getContext().getSession().put("departments", departments);

        List<Post> posts = postService.findPostByDepId(staff.getPost().getDepartment().getDepId());
        ActionContext.getContext().getSession().put("posts", posts);
        return SUCCESS;
    }

    /**
     * 修改职员
     * @return
     */
    @SkipValidation
    public String updateStaff() {
        Department byId = departmentService.findById(staff.getDepartment().getDepId());
        staff.setDepartment(byId);
        staff.setLoginPwd(CrmStringUtils.getMD5Value(staff.getLoginPwd()));
        staff.getPost().setDepartment(byId);
        Post post1 = postService.findPostByPostId(staff.getPost().getPostId());
        staff.setPost(post1);
        staffService.updateStaff(staff);
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

        return ERROR;
    }
    @SkipValidation
    public String overLogin(){
        Staff s = staffService.overLogin(staff);
        ActionContext.getContext().getSession().remove("staff",s);
        return SUCCESS;
    }
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


    /**
     * 获取所有的职员
     * @return
     */
    @SkipValidation
    public String findAllStaffs(){
        staffs = staffService.findAll();
        ActionContext.getContext().getSession().put("staffs", staffs);
        return SUCCESS;
    }

    /**
     * 分页
     * @return
     */
    @SkipValidation
    public String findStaffsByPage(){
        if (pageNum==0){
            pageNum=1;
        }
        PageBean<Staff> all = staffService.findStaffByPage(staff,pageNum,pageSize);
        ActionContext.getContext().getSession().put("pageBean",all);
        return SUCCESS;
    }

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
}
