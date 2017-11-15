package com.lanou3g.crm.staff.dao.impl;

import com.lanou3g.crm.base.impl.BaseAction;
import com.lanou3g.crm.staff.dao.StaffDao;
import com.lanou3g.crm.staff.domain.Staff;
import com.lanou3g.crm.utils.PageHibernateCallback;
import org.hibernate.Session;

import java.io.Serializable;
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
     * 查询所有的职员
     * @return
     */
    @Override
    public List<Staff> findAll() {
        return (List<Staff>) getHibernateTemplate().find("from Staff crm_staff");
    }

    /**
     * 添加职员
     * @param staff
     */
    @Override
    public void addStaff(Staff staff) {
        save(staff);
    }

    /**
     * 查询id为XXX的某个职员
     * @param staffId
     * @return
     */
    @Override
    public Staff findByStaffId(String staffId) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",staffId);
        return findSingle("from Staff where staffId=:id",map);
    }

    /**
     * 修改职员的信息
     * @param staff
     */
    @Override
    public void updateStaff(Staff staff) {
        update(staff);
    }

    /**
     * 通过职位查询
     * @param postId
     * @return
     */
    @Override
    public List<Staff> findStaffByPostId(String postId) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",postId);
        return find("from Staff where postId=:id",map);
    }
    /**
     * 查询某个职位是否有名字像XXX的职员
     * 显示
     */
    @Override
    public List<Staff> findStaffByPostIdAndStaffName(String postId, String staffName) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",postId);
        return find("from Staff where postId=:id and staffName like '%"+staffName+"%'",map);
    }

    /**
     * 查询名字叫XXX的职员
     * @param staffName
     * @return
     */
    @Override
    public List<Staff> findStaffBystaffName(String staffName) {
        return findAll("from Staff where staffName like '%" + staffName + "%'");
    }

    /**
     * 获取职员的条数
     * @return
     */
    @Override
    public int getTotalStaff() {
        String  sql = "select count(s) from Staff s where 1=1";

        List<Long> find = (List<Long>) getHibernateTemplate().find(sql);

        if (find != null) {
            return find.get(0).intValue();
        }
        return 0;
    }

    /**
     * 分页显示
     * @param startIndex
     * @param pageSize
     * @return
     */
    @Override
    public List<Staff> findStaffByPage(int startIndex, int pageSize) {
        String sql = "from Staff where 1=1 ";
        return getHibernateTemplate().execute(new PageHibernateCallback<Staff>(sql, startIndex, pageSize));
    }

    /**
     * 通过主键id查询对象
     * @param id
     * @return
     */
    public Staff get(Serializable id){
        Session session = currentSession();

        return (Staff)session.get(Staff.class,id);
    }
}

