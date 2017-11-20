package com.lanou3g.crm.classCourse.service;


import com.lanou3g.crm.classCourse.domain.CourseType;
import com.lanou3g.crm.utils.PageBean;

import java.util.List;

/**
 * Created by dllo on 2017/10/27.
 */
public interface CourseTypeService {
    List<CourseType> findAllCourseType();

    CourseType findById(String courseTypeId);

    void saveCourse(CourseType courseType);

    void updateCourse(CourseType courseType);



    PageBean<CourseType> findCourseByPage(CourseType crmCourseType, int pageNum, int pageSize);
}
