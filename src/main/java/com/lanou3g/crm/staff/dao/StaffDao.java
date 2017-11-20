package com.lanou3g.crm.staff.dao;

import com.lanou3g.crm.staff.domain.Department;
import com.lanou3g.crm.staff.domain.Post;
import com.lanou3g.crm.staff.domain.Staff;

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

public interface StaffDao {
    /**
     * 用户登录
     * 检验用户登录名以及登录密码
     * @param name
     * @param password
     * @return
     */
    Staff login(String name,String password);

    /**
     * 重登陆
     * @param staff
     * @return
     */
    Staff overLogin(Staff staff);

    /**
     * 修改密码
     * @param staff
     * @param rePwd
     */
    void reLoginPwd(Staff staff,String rePwd);

    /**
     * 分页查询员工
     * @param startIndex  开始索引的值
     * @param pageSize  每页显示的信息数
     * @return
     */
    List<Staff> findAll(int startIndex, int pageSize);
    /**
     * 查询所有部门
     * @return
     */
    List<Department> findDept();

    /**
     * 根据部门Id查询职位
     * @param staff 员工对象(用来传递depId)
     * @return
     */
    List<Post> findPostByDepId(Staff staff);

    /**
     * 高级查询
     * @param ss 判断之后的拼接sql语句
     * @param startIndex  开始索引的值
     * @param pageSize 每页显示的信息数
     * @return
     */
    List<Staff> findSome(String ss, int startIndex, int pageSize);

    /**
     * 员工的添加
     * @param staff
     */
    void addStaff(Staff staff);

    /**
     * 修改员工
     * @param staff
     */
    void updateStaff(Staff staff);

    /**
     * 根据员工Id查询对应员工信息
     * @param staff
     * @return
     */
    List<Staff> findByStaffId(Staff staff);


    /**
     * 查询信息总数
     * @param s 判断之后的拼接sql语句
     * @return 返回将要查询信息的总数
     */
    int getTotal(String s);


    List<Staff> ListStaff();


    List<Staff> highQuery(String depId, String postId, String staffName);

}
