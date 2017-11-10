package com.lanou3g.crm.HRD.service.impl;

import com.lanou3g.crm.HRD.dao.StaffDao;
import com.lanou3g.crm.HRD.domain.Staff;
import com.lanou3g.crm.HRD.service.StaffService;
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
