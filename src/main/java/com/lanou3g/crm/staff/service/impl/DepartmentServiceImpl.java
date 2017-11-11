package com.lanou3g.crm.staff.service.impl;

import com.lanou3g.crm.staff.dao.DepartmentDao;
import com.lanou3g.crm.staff.domain.Department;
import com.lanou3g.crm.staff.service.DepartmentService;
import com.lanou3g.crm.utils.PageBean;

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

public class DepartmentServiceImpl  implements DepartmentService{

    private DepartmentDao departmentDao;
    @Override
    public List<Department> findAllDepartment() {
        return departmentDao.findAllDepartment();
    }

    @Override
    public void addDepartment(Department department) {
        departmentDao.addDepartment(department);
    }

    @Override
    public void updateDepartment(Department department) {
        departmentDao.updateDepartment(department);
    }

    @Override
    public Department findById(String depId) {
        return departmentDao.findById(depId);
    }

    @Override
    public PageBean<Department> findAllDeptByPage(Department department, int pageNum, int pageSize) {
        int totalDept = departmentDao.getTotalDept();
        PageBean<Department> pageBean = new PageBean<>(pageNum,pageSize,totalDept);
        List<Department> data =
                departmentDao.findGet(pageBean.getStartIndex(),pageBean.getPageSize());
        pageBean.setData(data);
        return pageBean;
    }

    public DepartmentDao getDepartmentDao() {
        return departmentDao;
    }

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }
}
