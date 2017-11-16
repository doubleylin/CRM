package com.lanou3g.crm.staff.dao.impl;

import com.lanou3g.crm.HibernateUtil;
import com.lanou3g.crm.staff.domain.Department;
import org.hibernate.Session;
import org.junit.Test;

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

public class DepartmentDaoImplTest {
    @Test
    public void findAllDepartment() throws Exception {
        Session session = HibernateUtil.openSession();
        Department department = session.get(Department.class,"2c9090135fbe4ffb015fbe50c4510000");
        System.out.println(department);
        HibernateUtil.commit();
    }

    @Test
    public void addDepartment() throws Exception {
        Session session = HibernateUtil.openSession();
        Department department = new Department("666");
        session.save(department);
        HibernateUtil.commit();

    }

    @Test
    public void updateDepartment() throws Exception {
        Session session = HibernateUtil.openSession();
        Department department = session.get(Department.class,"2c9090135fc3e9a0015fc3e9a1d30000");
        department.setDepName("更新部");
        session.save(department);
        HibernateUtil.commit();
    }

    @Test
    public void findById() throws Exception {
        Session session = HibernateUtil.openSession();
        Department department = session.get(Department.class,"2c9090135fc3e9a0015fc3e9a1d30000");
        System.out.println(department);
        HibernateUtil.commit();
    }

    @Test
    public void getTotalDept() throws Exception {
        Session session = HibernateUtil.openSession();
        Department department = session.get(Department.class, "2c9090135fc3e9a0015fc3e9a1d30000");
        System.out.println(department);
        HibernateUtil.commit();

    }


}