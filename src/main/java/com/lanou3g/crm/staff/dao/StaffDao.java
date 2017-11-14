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
    Staff login(String name,String password);
    Staff overLogin(String name,String password);
    List<Staff> findAll();
    void addStaff(Staff staff);
    Staff findByStaffId(String stsffId);
    void updateStaff(Staff staff);
    List<Staff> findStaffByPostId(String postId);
    List<Staff> findStaffByPostIdAndStaffName(String postId,String staffName);
    List<Staff> findStaffBystaffName(String staffName);

}
