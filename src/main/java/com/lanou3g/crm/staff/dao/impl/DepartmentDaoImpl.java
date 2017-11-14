package com.lanou3g.crm.staff.dao.impl;

import com.lanou3g.crm.base.impl.BaseAction;
import com.lanou3g.crm.staff.dao.DepartmentDao;
import com.lanou3g.crm.staff.domain.Department;
import com.lanou3g.crm.utils.PageHibernateCallback;

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

public class DepartmentDaoImpl extends BaseAction<Department> implements DepartmentDao {
    @Override
    public List<Department> findAllDepartment() {
        String sql = "from Department";
        return findAll(sql);
    }

    @Override
    public void addDepartment(Department department) {
        save(department);
    }

    @Override
    public void updateDepartment(Department department) {
        update(department);
    }

    @Override
    public Department findById(String depId) {
        Map<String, Object> map = new HashMap<>();
        map.put("id",depId);
        return findSingle("from Department where depId=:id",map);
    }

    @Override
    public int getTotalDept() {
        String  sql = "select count(d) from Department d where 1=1";

        List<Long> find = (List<Long>) getHibernateTemplate().find(sql);
        if (find != null) {
            return find.get(0).intValue();
        }
        return 0;
    }

    @Override
    public List<Department> findGet(int startIndex, int pageSize) {
        String sql = "from Department where 1=1 ";
        return getHibernateTemplate().
                execute(new PageHibernateCallback<Department>
                        (sql, startIndex, pageSize));
    }
}
