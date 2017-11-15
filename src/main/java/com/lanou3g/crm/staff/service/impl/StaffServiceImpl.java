package com.lanou3g.crm.staff.service.impl;

import com.lanou3g.crm.staff.dao.StaffDao;
import com.lanou3g.crm.staff.service.StaffService;
import com.lanou3g.crm.staff.domain.Staff;
import com.lanou3g.crm.utils.PageBean;
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

    /**
     * 重新登录
     * 将session保存的账号密码移除
     * 退回到登录状态
     * @param name
     * @param password
     * @return
     */

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
     * 添加员工
     * @param staff
     */
    @Override
    public void addStaff(Staff staff) {
        staffDao.addStaff(staff);
    }

    /**
     * 修改员工信息
     * @param staff
     */
    @Override
    public void updateStaff(Staff staff) {
        staffDao.updateStaff(staff);
    }

    /**
     * 通过员工Id查询员工
     * @param staffId
     * @return
     */
    @Override
    public Staff findByStaffId(String staffId) {
        return staffDao.findByStaffId(staffId);
    }

    /**
     * 通过部门职位查询员工信息
     * 不能二级联动查出来职位
     * 因此只需要通过职位就可以查出员工信息
     * @param postId
     * @return
     */
    @Override
    public List<Staff> findStaffByPostId(String postId) {
        return staffDao.findStaffByPostId(postId);
    }

    /**
     * 通过员工名字查询
     * 这里设置的是模糊条件查询
     * @param staffName
     * @return
     */
    @Override
    public List<Staff> findStaffByStaffName(String staffName) {
        return staffDao.findStaffBystaffName(staffName);
    }

    /**
     * 通过部门以及名字查询结果
     * @param postId
     * @param staffName
     * @return
     */
    @Override
    public List<Staff> findStaffByPostIdAndStaffName(String postId, String staffName) {
        return staffDao.findStaffByPostIdAndStaffName(postId, staffName);
    }

    @Override
    public PageBean<Staff> findStaffByPage(Staff staff, int pageNum, int pageSize) {
        int totalPost = staffDao.getTotalStaff();
        PageBean<Staff> pageBean = new PageBean<>(pageNum,pageSize,totalPost);
        List<Staff> data =
                staffDao.findStaffByPage(pageBean.getStartIndex(),pageBean.getPageSize());
        pageBean.setData(data);
        return pageBean;
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
