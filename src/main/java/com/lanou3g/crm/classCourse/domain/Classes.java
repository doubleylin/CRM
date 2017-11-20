package com.lanou3g.crm.classCourse.domain;

import java.util.Date;

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

public class Classes {
    private String classId;
    private String name;
    private Date beginTime;
    private Date endTime;
    private String status;
    private Integer totalCount;
    private Integer upgradeCount;
    private Integer changeCount;
    private Integer runoffCount;
    private String remark;
    private Date uploadTime;
    private String uploadPath;
    private String uploadFilename;

    private CourseType courseType;

    public Classes() {
    }

    public Classes(String name, Date beginTime, Date endTime, String status, Integer totalCount, Integer upgradeCount, Integer changeCount, Integer runoffCount, String remark, Date uploadTime, String uploadPath, String uploadFilename, CourseType courseType) {
        this.name = name;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.status = status;
        this.totalCount = totalCount;
        this.upgradeCount = upgradeCount;
        this.changeCount = changeCount;
        this.runoffCount = runoffCount;
        this.remark = remark;
        this.uploadTime = uploadTime;
        this.uploadPath = uploadPath;
        this.uploadFilename = uploadFilename;
        this.courseType = courseType;
    }

    public Classes(String classId, String name, Date beginTime, Date endTime, String status, Integer totalCount, Integer upgradeCount, Integer changeCount, Integer runoffCount, String remark, Date uploadTime, String uploadPath, String uploadFilename, CourseType courseType) {
        this.classId = classId;
        this.name = name;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.status = status;
        this.totalCount = totalCount;
        this.upgradeCount = upgradeCount;
        this.changeCount = changeCount;
        this.runoffCount = runoffCount;
        this.remark = remark;
        this.uploadTime = uploadTime;
        this.uploadPath = uploadPath;
        this.uploadFilename = uploadFilename;
        this.courseType = courseType;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "classId='" + classId + '\'' +
                ", name='" + name + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", status='" + status + '\'' +
                ", totalCount=" + totalCount +
                ", upgradeCount=" + upgradeCount +
                ", changeCount=" + changeCount +
                ", runoffCount=" + runoffCount +
                ", remark='" + remark + '\'' +
                ", uploadTime=" + uploadTime +
                ", uploadPath='" + uploadPath + '\'' +
                ", uploadFilename='" + uploadFilename + '\'' +
                ", courseType=" + courseType +
                '}';
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getUpgradeCount() {
        return upgradeCount;
    }

    public void setUpgradeCount(Integer upgradeCount) {
        this.upgradeCount = upgradeCount;
    }

    public Integer getChangeCount() {
        return changeCount;
    }

    public void setChangeCount(Integer changeCount) {
        this.changeCount = changeCount;
    }

    public Integer getRunoffCount() {
        return runoffCount;
    }

    public void setRunoffCount(Integer runoffCount) {
        this.runoffCount = runoffCount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public String getUploadFilename() {
        return uploadFilename;
    }

    public void setUploadFilename(String uploadFilename) {
        this.uploadFilename = uploadFilename;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }
}
