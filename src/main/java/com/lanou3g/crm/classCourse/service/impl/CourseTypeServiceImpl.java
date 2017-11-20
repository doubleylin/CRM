package com.lanou3g.crm.classCourse.service.impl;


import com.lanou3g.crm.classCourse.dao.CourseTypeDao;
import com.lanou3g.crm.classCourse.domain.CourseType;
import com.lanou3g.crm.classCourse.service.CourseTypeService;
import com.lanou3g.crm.utils.PageBean;

import org.springframework.stereotype.Service;


import java.util.List;

/**
 * Created by dllo on 2017/10/27.
 */
@Service("courseTypeService")
public class CourseTypeServiceImpl implements CourseTypeService {

    private CourseTypeDao courseTypeDao;


    @Override
    public List<CourseType> findAllCourseType() {
        return courseTypeDao.findAllCourse();
    }

    @Override
    public CourseType findById(String courseTypeId) {
        return courseTypeDao.findById(courseTypeId);
    }

    @Override
    public void saveCourse(CourseType courseType) {
        courseTypeDao.saveCourse(courseType);
    }

    @Override
    public void updateCourse(CourseType courseType) {
        courseTypeDao.updateCourse(courseType);
    }

    @Override
    public PageBean<CourseType> findCourseByPage(CourseType crmCourseType, int pageNum, int pageSize) {
        int total = courseTypeDao.getTotalCourse();
        PageBean<CourseType> pageBean = new PageBean<>(pageNum,pageSize,total);
        List<CourseType> data =
                courseTypeDao.findCourseByPage(pageBean.getStartIndex(),pageBean.getPageSize());
        pageBean.setData(data);
        return pageBean;
    }
}
