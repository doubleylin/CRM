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
     * 登录注册服务
     * @param staff
     * @return
     */
    @Override
    public Staff login(Staff staff) {
        staffDao.login(staff);
        return staff;
    }

    @Override
    public Staff overLogin(String name, String password) {
        return staffDao.overLogin(name,password);
    }

    /**
     * 登录验证
     * @param staff
     * @return
     */
    @Override
    public List<Staff> findAll(Staff staff) {
        return staffDao.findAll(staff);

    }

    public StaffDao getStaffDao() {
        return staffDao;
    }

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }
}
