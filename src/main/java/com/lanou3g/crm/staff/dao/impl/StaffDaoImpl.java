package com.lanou3g.crm.staff.dao.impl;


import com.lanou3g.crm.base.impl.BaseDaoImpl;
import com.lanou3g.crm.staff.dao.StaffDao;
import com.lanou3g.crm.staff.domain.Department;
import com.lanou3g.crm.staff.domain.Post;
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

public class StaffDaoImpl extends BaseDaoImpl<Staff> implements StaffDao {
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
     * @param staff
     * @return
     */
    @Override
    public Staff overLogin(Staff staff) {
        return staff;

    }

    /**
     * 修改登录的密码
     * @param staff
     * @param rePwd
     */
    @Override
    public void reLoginPwd(Staff staff, String rePwd) {
        List<Staff> staffList = (List<Staff>) getHibernateTemplate().find("from Staff staff where staff.loginName=?", staff.getLoginName());
        if (staffList.size()>0){
            Staff staff1 = staffList.get(0);
            staff1.setLoginPwd(rePwd);
            getHibernateTemplate().update(staff1);
        }

    }

    @Override
    public List<Staff> findAll(int startIndex, int pageSize) {
        String sql = "from Staff where 1=1 ";
        return getHibernateTemplate().
                execute(new PageHibernateCallback<Staff>
                        (sql, startIndex, pageSize));
    }

    @Override
    public List<Department> findDept() {
        return (List<Department>) getHibernateTemplate().find("from Department ");
    }

    @Override
    public List<Post> findPostByDepId(Staff staff) {
        return (List<Post>) getHibernateTemplate()
                .find("from Post where department.depId=?"
                        ,staff.getPost().getDepartment().getDepId());
    }

    @Override
    public List<Staff> findSome(String ss, int startIndex, int pageSize) {
        String sql = "from Staff where 1=1 " + ss;

        return getHibernateTemplate().
                execute(new PageHibernateCallback<Staff>
                        (sql, startIndex, pageSize));
    }

    @Override
    public void addStaff(Staff staff) {
        save(staff);
    }

    @Override
    public void updateStaff(Staff staff){
        update(staff);
    }


    /**
     * 查询信息总数
     * @param s
     * @return
     */
    @Override
    public int getTotal(String s) {
        String  sql = "select count(s) from Staff s where 1=1 ";
        if (s == null){
            List<Long> find = (List<Long>) getHibernateTemplate().find(sql);
            if (find != null) {
                return find.get(0).intValue();
            }
        }else {
            List<Long> find = (List<Long>) getHibernateTemplate().find(sql + s);
            if (find != null) {
                return find.get(0).intValue();
            }
        }
        return 0;
    }

    @Override
    public List<Staff> ListStaff() {
        String sql ="from Staff crm_staff";
        List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql);
        return list;
    }

    @Override
    public List<Staff> highQuery(String depId, String postId, String staffName) {
        if (depId.equals("-1") && postId.equals("-1") && staffName.equals("")) {
            String sql = "from Staff crm_staff";
            List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql);
            return list;
        }
        if (postId.equals("-1") && staffName.equals("")) {
            String sql = "from Staff crm_staff WHERE post.department.depId=?";
            List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql, depId);
            return list;
        }
        if (depId.equals("-1") && postId.equals("-1")) {
            String sql = "from Staff crm_staff where staffName like ?";
            List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql, "%" + staffName + "%");
            return list;
        }
        if (staffName.equals("")) {
            String sql = "from Staff crm_staff WHERE post.department.depId=? and post.postId=?";
            List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql, depId, postId);
            return list;
        }
        if (postId.equals("-1")) {
            String sql = "from Staff crm_staff WHERE post.department.depId=? and staffName=?";
            List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql, depId, staffName);
            return list;
        }

        String sql = "from Staff crm_staff WHERE post.department.depId=? and post.postId=? and staffName like ?";
        List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql, depId, postId, "%" + staffName + "%");
        return list;
    }


    @Override
    public List<Staff> findByStaffId(Staff staff) {
        return (List<Staff>) getHibernateTemplate()
                .find("from Staff where staffId=?",staff.getStaffId());
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

