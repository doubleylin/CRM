package com.lanou3g.crm.classCourse.service.impl;


import com.lanou3g.crm.classCourse.dao.ClassesDao;
import com.lanou3g.crm.classCourse.domain.Classes;
import com.lanou3g.crm.classCourse.service.ClassesService;
import com.lanou3g.crm.utils.PageBean;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 2017/10/30.
 */
public class ClassesServiceImpl implements ClassesService {

    private ClassesDao classesDao;


    @Override
    public void addOrUpdateClasses(Classes classes) {

    }

    @Override
    public PageBean<Classes> findAll(Classes classes, int pageNum, int pageSize) {
        return null;
    }

    @Override
    public Classes findClassesByClassId(String classId) {
        return null;
    }
}
