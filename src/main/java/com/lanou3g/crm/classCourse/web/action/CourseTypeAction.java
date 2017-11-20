package com.lanou3g.crm.classCourse.web.action;

import com.lanou3g.crm.classCourse.domain.CourseType;
import com.lanou3g.crm.classCourse.service.CourseTypeService;
import com.lanou3g.crm.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

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
@Controller("courseTypeAction")
@Scope("prototype")
public class CourseTypeAction extends ActionSupport implements ModelDriven<CourseType>{

    private CourseType courseType;
    @Resource(name = "courseTypeService")
    private CourseTypeService courseTypeService;

    private int pageNum=1;
    private int pageSize=5;

    public String findCourseTypeByPage(){
        if (pageNum == 0){
            pageNum = 1;
        }
        PageBean<CourseType> all =
                courseTypeService.findCourseByPage(courseType,pageNum,pageSize);

        ActionContext.getContext().put("pageBean",all);
        return SUCCESS;

    }

    public String addOrEditUI(){
        if (courseType.getCourseName().trim().equals("")){
            addActionError("课程类别不能为空");
            return INPUT;
        }
        if (courseType.getTotal()==0){
            addActionError("课时不能为0");
            return INPUT;
        }
        if (courseType.getTotal().equals("")){
            addActionError("课时不能为空");
        }
        if (courseType.getCourseTypeId().equals("")){
            courseTypeService.saveCourse(courseType);
        }
        else {
            courseTypeService.updateCourse(courseType);
        }
        return SUCCESS;

    }

    public String findAllCourse(){
        List<CourseType> courseTypes =
                courseTypeService.findAllCourseType();
        ActionContext.getContext().getSession().put("courseTypes",courseTypes);
        return SUCCESS;
    }

    @Override
    public CourseType getModel() {
        return null;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {

        this.pageSize = pageSize;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

}
