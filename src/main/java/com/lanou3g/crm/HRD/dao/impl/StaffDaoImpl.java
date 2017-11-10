package com.lanou3g.crm.HRD.dao.impl;

import com.lanou3g.crm.HRD.dao.StaffDao;
import com.lanou3g.crm.HRD.domain.Staff;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

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

public class StaffDaoImpl extends HibernateDaoSupport implements StaffDao {
    /**
     * 员工注册登录
     * @param staff
     * @return
     */
    @Override
    public Staff login(Staff staff) {
        getHibernateTemplate().save(staff);
        return staff;
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
