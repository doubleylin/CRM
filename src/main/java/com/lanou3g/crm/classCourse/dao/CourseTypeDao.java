package com.lanou3g.crm.classCourse.dao;


import com.lanou3g.crm.classCourse.domain.CourseType;

import java.util.List;

/**
 * Created by dllo on 2017/10/27.
 */
public interface CourseTypeDao {

    List<CourseType> findAllCourse();


    CourseType findById(String courseTypeId);

    void saveCourse(CourseType courseType);

    void updateCourse(CourseType courseType);

    int getTotalCourse();

    List<CourseType> findCourseByPage(int startIndex, int pageSize);
}
