package com.lanou3g.crm.staff.dao.impl;

import com.lanou3g.crm.base.impl.BaseAction;
import com.lanou3g.crm.staff.dao.StaffDao;
import com.lanou3g.crm.staff.domain.Staff;

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

public class StaffDaoImpl extends BaseAction<Staff> implements StaffDao {
    /**
     * 员工登录
     * 查询数据库数据进行登录验证
     * 验证通过进行登录
     * 否则跳转到error.jsp
     * @param name
     * @param password
     * @return
     */
    @Override
    public Staff login(String name,String password) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("password",password);
        return findSingle("from Staff where loginName=:name and loginPwd=:password",map);

    }

    /**
     * 重新登录
     * remove session值
     * 返回登录界面
     * 不保存登录状态
     * 用户需重新登录
     * @param name
     * @param password
     * @return
     */
    @Override
    public Staff overLogin(String name, String password) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("password",password);
        return overLogin(name,password);
    }

    /**
     * 登录验证
     * 账号不存在跳转到错误界面
     * 账号存在检查密码是否正确
     * @return
     */
    @Override
    public List<Staff> findAll() {
        return (List<Staff>) getHibernateTemplate().find("from Staff crm_staff");
    }

    @Override
    public void addStaff(Staff staff) {
        save(staff);
    }

    @Override
    public Staff findByStaffId(String staffId) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",staffId);
        return findSingle("from Staff where staffId=:id",map);
    }

    @Override
    public void updateStaff(Staff staff) {
        update(staff);
    }

    @Override
    public List<Staff> findStaffByPostId(String postId) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",postId);
        return find("from Staff where postId=:id",map);
    }

    @Override
    public List<Staff> findStaffByPostIdAndStaffName(String postId, String staffName) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",postId);
        return find("from Staff where postId=:id and staffName like '%"+staffName+"%'",map);
    }

    @Override
    public List<Staff> findStaffBystaffName(String staffName) {
        return findAll("from Staff where staffName like '%" + staffName + "%'");
    }
}
