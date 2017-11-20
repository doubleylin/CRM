package com.lanou3g.crm.classCourse.domain;

import java.util.HashSet;
import java.util.Set;

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

public class CourseType {
    private String courseTypeId;
    private double courseCost;
    private Integer total;
    private String courseName;
    private String remark;

    private String totalStart;
    private String totalEnd;

    private String courseCostStart;
    private String courseCostEnd;

    private Set<Classes> classesSet = new HashSet<>();

    public CourseType() {
    }

    public CourseType(double courseCost, Integer total, String courseName, String remark) {
        this.courseCost = courseCost;
        this.total = total;
        this.courseName = courseName;
        this.remark = remark;
    }

    public CourseType(String courseTypeId, double courseCost, Integer total, String courseName, String remark) {
        this.courseTypeId = courseTypeId;
        this.courseCost = courseCost;
        this.total = total;
        this.courseName = courseName;
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "CourseType{" +
                "courseTypeId='" + courseTypeId + '\'' +
                ", courseCost=" + courseCost +
                ", total=" + total +
                ", courseName='" + courseName + '\'' +
                ", remark='" + remark + '\'' +
                ", totalStart='" + totalStart + '\'' +
                ", totalEnd='" + totalEnd + '\'' +
                ", courseCostStart='" + courseCostStart + '\'' +
                ", courseCoustEnd='" + courseCostEnd + '\'' +
                ", classesSet=" + classesSet +
                '}';
    }

    public String getCourseTypeId() {
        return courseTypeId;
    }

    public void setCourseTypeId(String courseTypeId) {
        this.courseTypeId = courseTypeId;
    }

    public double getCourseCost() {
        return courseCost;
    }

    public void setCourseCost(double courseCost) {
        this.courseCost = courseCost;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTotalStart() {
        return totalStart;
    }

    public void setTotalStart(String totalStart) {
        this.totalStart = totalStart;
    }

    public String getTotalEnd() {
        return totalEnd;
    }

    public void setTotalEnd(String totalEnd) {
        this.totalEnd = totalEnd;
    }

    public String getCourseCostStart() {
        return courseCostStart;
    }

    public void setCourseCostStart(String courseCostStart) {
        this.courseCostStart = courseCostStart;
    }

    public String getCourseCostEnd() {
        return courseCostEnd;
    }

    public void setCourseCoustEnd(String courseCoustEnd) {
        this.courseCostEnd = courseCoustEnd;
    }

    public Set<Classes> getClassesSet() {
        return classesSet;
    }

    public void setClassesSet(Set<Classes> classesSet) {
        this.classesSet = classesSet;
    }
}
