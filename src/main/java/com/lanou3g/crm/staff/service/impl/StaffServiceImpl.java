package com.lanou3g.crm.staff.service.impl;

import com.lanou3g.crm.staff.dao.StaffDao;
import com.lanou3g.crm.staff.service.StaffService;
import com.lanou3g.crm.staff.domain.Staff;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
@Service("staffService")
public class StaffServiceImpl implements StaffService {
    @Resource(name = "staffDao")
    private StaffDao staffDao;

    /**
     * 登录注册
     * @param name
     * @param password
     * @return
     */
    @Override
    public Staff login(String name,String password) {
        return staffDao.login(name, password);

    }

    @Override
    public Staff overLogin(String name, String password) {
        return staffDao.overLogin(name,password);
    }

    /**
     * 查询所有对象
     * @return
     */
    @Override
    public List<Staff> findAll() {
        return staffDao.findAll();
    }

    /**
     * 登录验证
     * @param
     * @return
     */


    public StaffDao getStaffDao() {
        return staffDao;
    }

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }
}
