package com.lanou3g.crm.staff.web.action;

import com.lanou3g.crm.staff.domain.Department;
import com.lanou3g.crm.staff.service.DepartmentService;
import com.lanou3g.crm.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
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
@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {
    private Department department = new Department();
    @Resource(name = "departmentService")
    private DepartmentService departmentService;

    private int pageNum;
    private int pageSize = 5;

    /**
     * 添加部门
     * 添加判断
     * 部门名称不能空
     * 如果到页面传过来id则执行修改方法
     * 如果没有传到页面id则执行
     * @return
     */
    public String addDepartment(){
        if (department.getDepName().trim().equals("")){
            addActionError("部门名称空了!");
            return INPUT;
        }
        if (department.getDepId().equals("")){
            departmentService.addDepartment(department);
        }else {
            departmentService.updateDepartment(department);
        }
        return SUCCESS;
    }

    /**
     * 分页显示部门
     * @return
     */
    public String findAllDeptByPage(){
        if (pageNum == 0){
            pageNum = 1;
        }
        PageBean<Department> all =
                departmentService.findAllDeptByPage
                (department,pageNum,pageSize);
        ActionContext.getContext().put("pageBean",all);
        return SUCCESS;
    }

    public String findById(){
        Department byId = departmentService.findById(department.getDepId());
        ActionContext.getContext().put("byId",byId);
        return SUCCESS;
    }

    /**
     * 查询所有部门
     * @return
     */
    public String findAllDept(){
        List<Department> departments =
                departmentService.findAllDepartment();
        ActionContext.getContext().getSession().put("departments",departments);
        return SUCCESS;
    }
    @Override
    public Department getModel() {
        return department;
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
