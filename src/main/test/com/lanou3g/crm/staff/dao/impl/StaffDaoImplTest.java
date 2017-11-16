package com.lanou3g.crm.staff.dao.impl;

import com.lanou3g.crm.HibernateUtil;
import com.lanou3g.crm.staff.dao.StaffDao;
import com.lanou3g.crm.staff.domain.Post;
import com.lanou3g.crm.staff.domain.Staff;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

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

public class StaffDaoImplTest {

    private StaffDao staffDao = new StaffDaoImpl();



    @Test
    public void findAll() throws Exception {
        Session session = HibernateUtil.openSession();
        Staff staff = session.get(Staff.class,"2c9090135fbe4ffb015fbe54bce30001");
        System.out.println(staff);
        HibernateUtil.commit();
    }

    @Test
    public void addStaff() throws Exception {
        Session session = HibernateUtil.openSession();
        Post post = new Post("数据更新员");
        Staff staff = new Staff("dou");
        staff.setPost(post);
        session.save(staff);
        session.save(post);
        HibernateUtil.commit();
    }

    @Test
    public void findByStaffId() throws Exception {
        Session session = HibernateUtil.openSession();
        Staff staff = session.get(Staff.class,"2c9090135fbe4ffb015fbe54bce30001");
        System.out.println(staff);
        HibernateUtil.commit();
    }

    @Test
    public void updateStaff() throws Exception {
        Session session = HibernateUtil.openSession();
        Staff staff = session.get(Staff.class,"2c9090135fbe4ffb015fbe54bce30001");
        staff.setStaffName("3r23");
        session.save(staff);
        HibernateUtil.commit();
    }

    @Test
    public void findStaffByPostId() throws Exception {
        List<Staff> staffs = staffDao.findStaffByPostId("2c9090135fbe4ffb015fbe54bce30001");
        System.out.println(staffs);

    }

    @Test
    public void findStaffByPostIdAndStaffName() throws Exception {
        List<Staff> staffs = staffDao.findStaffByPostIdAndStaffName("2c9090135fbe4ffb015fbe54bce30001", "李");
        System.out.println(staffs);

    }

    @Test
    public void findStaffBystaffName() throws Exception {
        List<Staff> staffs = staffDao.findStaffBystaffName("lose");
        System.out.println(staffs);
    }



}