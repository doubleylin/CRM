package com.lanou3g.crm.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 2017/10/20.
 */
public interface BaseDao<T> {

    T findById(Serializable id, Class<T> tClass);

    List<T> findAll(String sql);

    List<T> find(String sql, Map<String, Object> params);

    T findSingle(String sql, Map<String, Object> params);

    void save(T t);

    void update(T t);

    int getTotalRecord(String condition, Object[] params);

     List<T> findAllGet(String condition, Object[] params, int startIndex, int pageSize);
}
