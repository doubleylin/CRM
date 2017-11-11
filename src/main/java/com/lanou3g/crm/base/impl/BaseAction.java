package com.lanou3g.crm.base.impl;

import com.lanou3g.crm.base.BaseDao;
import com.lanou3g.crm.utils.PageHibernateCallback;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

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

/**
 * 泛型也可以称之为类的参数
 * 参数的类型是某个类,而不是对象
 * T:type
 * E:element/entity
 * K:key
 * V:value
 */
public class BaseAction<T> extends HibernateDaoSupport implements BaseDao<T> {
    protected T model;
//    protected S service;
    private final Class<? extends BaseAction> clazz;

    public BaseAction(){
        //获取当前类的Class
        clazz = getClass();
        //获取父类的泛型参数
        ParameterizedType type = (ParameterizedType) clazz.getGenericSuperclass();
        //获取所有的泛型的集合(因为可能会有多个泛型)
        Type[] typeArguments = type.getActualTypeArguments();
        //因为当前只有一个泛型参数
        //所以只取第一个就能获取到泛型的Class
        Class modelClass = (Class) typeArguments[0];
        //根据反射创建出泛型的对象
        try {
            model = (T) modelClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    //向session中存放数据
//    public void sessionPut(String key, Object value){
//        ActionContext.getContext().getSession().put(key, value);
//    }

    /**
     * 通过id获取对象
     * @param id
     * @param tClass
     * @return
     */
    @Override
    public T findById(Serializable id, Class<T> tClass) {
        Session session = currentSession();

        T t = session.get(tClass,id);
        return t;
    }

    /**
     * 查询所有对象
     * @param sql
     * @return
     */
    public List<T> findAll(String sql){
        Session session = currentSession();
        Query query = session.createQuery(sql);
        List<T> tList = query.list();
        return tList;
    }

    /**
     * 根据条件查询,返回查询到的结果集
     * @param sql
     * @param params 参数列表
     * @return
     */
    @Override
    public List<T> find(String sql, Map<String, Object> params) {
        Session session = currentSession();
        Query query = session.createQuery(sql);
        if (params !=null && !params.isEmpty()){
            for (String s : params.keySet()) {
                query.setParameter(s,params.get(s));
            }
        }
        List<T> tList = query.list();
        return tList;
    }

    /**
     * 根据条件查询,返回查询的结果
     * @param sql 查询语句
     * @param params 参数列表
     * @return
     */
    @Override
    public T findSingle(String sql, Map<String, Object> params) {
        List<T> tList = find(sql, params);
        if (tList.size()>0){
            /**
             * 如果查询到结果,那么返回查询到的第一个值
             * 如果查询后为空,返回null
             */
            return tList.get(0);
        }
        return null;
    }

    /**
     * 查询所有的数据
     * @param t
     */
    @Override
    public void save(T t) {
        getHibernateTemplate().save(t);

    }

    @Override
    public void update(T t) {
        Session session = currentSession();
        session.merge(t);
    }

    /**
     * 根据查询条件获取查询结果
     * 如果存在结果,将查到的结果从第一个开始显示
     * 显示到规定的当前页的个数
     * @param condition
     * @param params
     * @return
     */
    @Override
    public int getTotalRecord(String condition, Object[] params) {
        String sql = "select count(c) from" + clazz.getName()+"c where 1=1 "+ condition;
        List<Long> find = (List<Long>) getHibernateTemplate().find(sql, params);
        if (find!=null){
            return find.get(0).intValue();
        }
        return 0;
    }

    /**
     * 将数据库中的所有的符合条件的数据查出来
     * 然后根据每页的条数进行分组,
     * 计算出总共需要多少页
     * 实现分页
     * @param condition
     * @param params
     * @param startIndex
     * @param pageSize
     * @return
     */
    @Override
    public List<T> findAllGet(String condition, Object[] params, int startIndex, int pageSize) {
        String hql = "from " + clazz.getName() + " where 1=1 " + condition;
        return this.getHibernateTemplate().execute(new PageHibernateCallback<T>(hql,params,startIndex,pageSize));
    }
    //application
    //request
    //Context

    public HttpServletRequest getRequest(){
        return ServletActionContext.getRequest();
    }
    public HttpServletResponse getResponse(){
        return ServletActionContext.getResponse();
    }

//    public void setService(S service) {
//        this.service = service;
//    }
    public <E> E create(E entity){
        return entity;
    }
}
