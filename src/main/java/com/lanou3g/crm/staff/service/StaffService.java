package com.lanou3g.crm.staff.service;

import com.lanou3g.crm.staff.domain.Department;
import com.lanou3g.crm.staff.domain.Post;
import com.lanou3g.crm.staff.domain.Staff;
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

public interface StaffService {
    Staff login(String name,String password);
    Staff overLogin(Staff staff);
    PageBean<Staff> findAll(Staff staff, int pageNum, int pageSize);
    List<Department> findDept();
    void reLoginPwd(Staff staff,String rePwd);
    PageBean<Staff> findSome(Staff staff, int pageNum, int pageSize);
    List<Post> findPostByDepId(Staff staff);
    void addStaff(Staff staff);
    void updateStaff(Staff staff);
    List<Staff>  findByStaffId(Staff staff);

    List<Staff> ListStaff();

    List<Staff> highQuery(String depId, String postId, String staffName);
}
