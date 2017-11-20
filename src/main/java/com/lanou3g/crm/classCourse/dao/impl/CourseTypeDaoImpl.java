package com.lanou3g.crm.classCourse.dao.impl;


import com.lanou3g.crm.base.impl.BaseDaoImpl;
import com.lanou3g.crm.classCourse.dao.CourseTypeDao;
import com.lanou3g.crm.classCourse.domain.CourseType;
import com.lanou3g.crm.utils.PageHibernateCallback;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 2017/10/27.
 */
public class CourseTypeDaoImpl extends BaseDaoImpl<CourseType> implements CourseTypeDao {


    @Override
    public List<CourseType> findAllCourse() {
        String sql = "from CourseType";
        return findAll(sql);
    }


    @Override
    public CourseType findById(String courseTypeId) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",courseTypeId);
        return findSingle("from CourseType where courseTypeId=:id",map);
    }

    @Override
    public void saveCourse(CourseType courseType) {
        save(courseType);
    }

    @Override
    public void updateCourse(CourseType courseType) {
        update(courseType);
    }


    @Override
    public int getTotalCourse() {
        String  sql = "select count(c) from CourseType c where 1=1";

        List<Long> find = (List<Long>) getHibernateTemplate().find(sql);

        if (find != null) {
            return find.get(0).intValue();
        }
        return 0;
    }

    @Override
    public List<CourseType> findCourseByPage(int startIndex, int pageSize) {
        String sql = "from CourseType where 1=1 ";
        return getHibernateTemplate().execute(new PageHibernateCallback<CourseType>(sql, startIndex, pageSize));
    }
}
