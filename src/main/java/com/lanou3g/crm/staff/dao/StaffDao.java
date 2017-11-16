package com.lanou3g.crm.staff.dao;

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
     * 查询出所有的职员
     * @return
     */
    List<Staff> findAll();

    /**
     * 添加职员
     * @param staff
     */
    void addStaff(Staff staff);

    /**
     * 通过职员id查询具体某个职员
     * @param stsffId
     * @return
     */
    Staff findByStaffId(String stsffId);

    /**
     * 修改职员信息
     * @param staff
     */
    void updateStaff(Staff staff);

    /**
     * 通过部门+职位查询职员
     * 由于部门职位是二级联动
     * 因此获取职位即可
     * @param postId
     * @return
     */
    List<Staff> findStaffByPostId(String postId);

    /**
     * 查询某个部门名字像XX的职员
     * @param postId
     * @param staffName
     * @return
     */
    List<Staff> findStaffByPostIdAndStaffName(String postId,String staffName);

    /**
     * 查询名字像XX的所有人
     * @param staffName
     * @return
     */
    List<Staff> findStaffBystaffName(String staffName);

    /**
     * 获取所有的职员数
     * @return
     */
    int getTotalStaff();

    /**
     * 将显示的职员分页
     * @param startIndex
     * @param pageSize
     * @return
     */
    List<Staff> findStaffByPage(int startIndex, int pageSize);

}
