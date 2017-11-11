package com.lanou3g.crm.utils;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;

import java.util.List;

/**
 * Created by dllo on 2017/10/28.
 */
public class PageHibernateCallback<T> implements HibernateCallback<List<T>> {

    private String sql;

    private Object[] params;

    private int startIndex;

    private int pageSize;

    public PageHibernateCallback(String sql, Object[] params, int startIndex, int pageSize) {
        this.sql = sql;
        this.params = params;
        this.startIndex = startIndex;
        this.pageSize = pageSize;
    }

    public PageHibernateCallback(String sql, int startIndex, int pageSize) {
        this.sql = sql;
        this.startIndex = startIndex;
        this.pageSize = pageSize;
    }

    @Override
    public List<T> doInHibernate(Session session) throws HibernateException {

        // 1. 通过hql语句获取query对象
        Query queryObject = session.createQuery(sql);

        if (params != null) {

            // 2. 条件的设置
            for (int i = 0; i < params.length; i++) {

                queryObject.setParameter(i, params[i]);

            }

        }

        // 3.分页
        queryObject.setFirstResult(startIndex);

        queryObject.setMaxResults(pageSize);

        // 4.查询所有
        return queryObject.list();
    }
}
