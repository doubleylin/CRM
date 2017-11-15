package com.lanou3g.crm.staff.dao;

import com.lanou3g.crm.staff.domain.Department;

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

public interface DepartmentDao {

    /**
     * 查询所有的部门
     * @return
     */
    List<Department> findAllDepartment();

    /**
     * 添加部门
     * @param department
     */
    void addDepartment(Department department);

    /**
     * 修改部门
     * @param department
     */
    void updateDepartment(Department department);

    /**
     * 通过部门id查询部门的名字
     * @param depId
     * @return
     */
    Department findById(String depId);

    /**
     * 计算部门的总数
     * @return
     */
    int getTotalDept();

    /**
     * 分页
     * @param startIndex  开始的位置
     * @param pageSize   一页显示多少
     * @return
     */
    List<Department> findGet(int startIndex,int pageSize);
}
