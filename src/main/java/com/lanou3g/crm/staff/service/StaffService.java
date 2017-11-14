package com.lanou3g.crm.staff.service;

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

public interface StaffService {
    Staff login(String name,String password);
    Staff overLogin(String name,String password);
    List<Staff> findAll();
    void addStaff(Staff staff);
    void updateStaff(Staff staff);
    Staff findByStaffId(String staffId);
    List<Staff> findStaffByPostId(String postId);
    List<Staff> findStaffByStaffName(String staffName);
    List<Staff> findStaffByPostIdAndStaffName(String postId,String staffName);
}
