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

    private DepartmentService departmentService;

    private int pageNum;
    private int pageSize = 5;

    public String addDepartment(){
        if (department.getDepName().trim().equals("")){
            addActionError("部门名称空了!");
            return INPUT;
        }
        if (department.getDepId().equals("")){
            departmentService.addDepartment(department);
        }else {
            departmentService.updateDepattment(department);
        }
        return SUCCESS;
    }
    public String findAllDeptByPage(){
        if (pageNum==0){
            pageNum=1;
        }
        PageBean<Department> data = departmentService.findAllDepartmentP(department,pageNum,pageSize);
        ActionContext.getContext().put("pageBean",data);
        return SUCCESS;
    }

    public String findAllDept(){
        List<Department> departments = departmentService.findAllDepartment();
        ActionContext.getContext().getSession().put("departments",departments);
        return SUCCESS;
    }
    @Override
    public Department getModel() {
        return null;
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
