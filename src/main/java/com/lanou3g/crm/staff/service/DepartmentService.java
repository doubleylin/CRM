package com.lanou3g.crm.staff.service;

import com.lanou3g.crm.staff.domain.Department;
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

public interface DepartmentService {

    List<Department> findAllDepartment();
    void addDepartment(Department department);
    void updateDepartment(Department department);

    Department findById(String depId);

    PageBean<Department> findAllDeptByPage(Department department, int pageNum, int pageSize);
}
