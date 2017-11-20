package com.lanou3g.crm.classCourse.service;


import com.lanou3g.crm.classCourse.domain.Classes;
import com.lanou3g.crm.utils.PageBean;

/**
 * Created by dllo on 2017/10/30.
 */
public interface ClassesService {
    void addOrUpdateClasses(Classes classes);

    PageBean<Classes> findAll(Classes classes, int pageNum, int pageSize);

    Classes findClassesByClassId(String classId);
}
