package com.lanou3g.crm.staff.dao.impl;

import com.lanou3g.crm.staff.dao.StaffDao;
import com.lanou3g.crm.staff.domain.Staff;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

public class StaffDaoImpl extends HibernateDaoSupport implements StaffDao {
    /**
     * 员工注册登录
     * @param staff
     * @return
     */
    @Override
    public Staff login(Staff staff ) {
        getHibernateTemplate().save(staff);
        return staff;

    }

    @Override
    public Staff overLogin(String name, String password) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("password",password);
        return overLogin(name,password);
    }

    /**
     * 登录验证
     * 账号不存在注册登录
     * 账号存在检查密码是否正确
     * @param staff
     * @return
     */
    @Override
    public List<Staff> findAll(Staff staff) {
        return (List<Staff>) getHibernateTemplate().find("from Staff crm_staff");
    }
}
