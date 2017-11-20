package com.lanou3g.crm.staff.service.impl;

import com.lanou3g.crm.staff.dao.StaffDao;
import com.lanou3g.crm.staff.domain.Department;
import com.lanou3g.crm.staff.domain.Post;
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
     * @param staff
     * @return
     */

    @Override
    public Staff overLogin(Staff staff ) {
        return staffDao.overLogin(staff);
    }

    @Override
    public PageBean<Staff> findAll(Staff staff, int pageNum, int pageSize) {
        int totalRecord = staffDao.getTotal(null);
        int totalPage;
        int startIndex = (pageNum - 1) * 5;
        if(totalRecord % pageSize == 0){
            totalPage = totalRecord / pageSize;
        } else {
            totalPage = totalRecord / pageSize + 1;
        }
        PageBean<Staff> pageBean = new PageBean<>(pageNum,pageSize,totalRecord,startIndex,totalPage);
        List<Staff> data =
                staffDao.findAll(pageBean.getStartIndex(),pageBean.getPageSize());
        pageBean.setData(data);
        return pageBean;
    }


    @Override
    public List<Department> findDept() {
        return staffDao.findDept();
    }



    /**
     * 修改密码
     * @param staff
     * @param rePwd
     */
    @Override
    public void reLoginPwd(Staff staff, String rePwd) {
        staffDao.reLoginPwd(staff,rePwd);
    }

    @Override
    public PageBean<Staff> findSome(Staff staff, int pageNum, int pageSize) {
        String depId = staff.getPost().getDepartment().getDepId();
        String postId = staff.getPost().getPostId();
        String staffName = staff.getStaffName();

        String ss = returnSql(depId,postId,staffName);

        int totalRecord = staffDao.getTotal(ss);
        int totalPage;
        int startIndex = (pageNum - 1) * 5;
        if(totalRecord % pageSize == 0){
            totalPage = totalRecord / pageSize;
        } else {
            totalPage = totalRecord / pageSize + 1;
        }
        PageBean<Staff> pageBean = new PageBean<>
                (pageNum,pageSize,totalRecord,startIndex,totalPage);
        List<Staff> data =
                staffDao.findSome(ss, pageBean.getStartIndex(),pageBean.getPageSize());
        pageBean.setData(data);
        return pageBean;
    }

    @Override
    public List<Post> findPostByDepId(Staff staff) {
        return staffDao.findPostByDepId(staff);
    }

    @Override
    public void addStaff(Staff staff) {
        staffDao.addStaff(staff);
    }

    @Override
    public void updateStaff(Staff staff){
        staffDao.updateStaff(staff);
    }

    /**
     * 通过员工Id查询员工
     * @param staff
     * @return
     */
    @Override
    public List<Staff> findByStaffId(Staff staff) {
        return  staffDao.findByStaffId(staff);
    }

    @Override
    public List<Staff> ListStaff() {
        return staffDao.ListStaff();
    }

    @Override
    public List<Staff> highQuery(String depId, String postId, String staffName) {
        return staffDao.highQuery(depId, postId, staffName);
    }


    /**
     * 高级查询的判断条件
     * @param depId  判断传来的部门Id是否为空
     * @param postId  判断传来的职位Id是否为空
     * @param staffName  判断传来的员工名字是否为空
     * @return
     */
    public String returnSql(String depId, String postId, String staffName){
        String sql;
        // 三个都空
        if (depId.equals("-1")&&postId.equals("-1")&&staffName.equals("")){
            sql = "";
            return sql;
        }
        // 前两个空
        if (depId.equals("-1")&&postId.equals("-1")){
            sql = "and staffName like '%" + staffName + "%'";
            return sql;
        }
        // 后两个空
        if (postId.equals("-1")&&staffName.equals("")){
            sql = "and post.department.depId='" + depId + "'";
            return sql;
        }
        // 后一个空
        if (staffName.equals("")){
            sql="and post.department.depId ='" + depId + "' and post.postId='" + postId + "'";
            return sql;
        }

        // 中间空
        if (postId.equals("-1")){
            sql = "and post.department.depId='" + depId + "' and staffName like '%" + staffName + "%'";
            return sql;
        }

        // 三个都不空
        sql = "and post.department.depId='" + depId + "' and post.postId='"
                + postId + "' and staffName like '%" + staffName + "%'";

        return sql;
    }




    public StaffDao getStaffDao() {
        return staffDao;
    }

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }
}
