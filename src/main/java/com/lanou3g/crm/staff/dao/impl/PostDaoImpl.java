package com.lanou3g.crm.staff.dao.impl;

import com.lanou3g.crm.base.impl.BaseDaoImpl;
import com.lanou3g.crm.staff.dao.PostDao;
import com.lanou3g.crm.staff.domain.Department;
import com.lanou3g.crm.staff.domain.Post;
import com.lanou3g.crm.utils.PageHibernateCallback;

import java.util.HashMap;
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

public class PostDaoImpl extends BaseDaoImpl<Post> implements PostDao {
    /**
     * 查询所有的部门
     * @return
     */
    @Override
    public List<Post> findAllPost() {
        String sql = "from Post";
        return findAll(sql);
    }

    @Override
    public List<Department> findDept() {
        return (List<Department>) getHibernateTemplate().find("from Department ");
    }

    /**
     * 添加职位
     * @param post
     */
    @Override
    public void addPost(Post post) {
        save(post);
    }

    /**
     * 修改职位
     * @param post
     */
    @Override
    public void updatePost(Post post) {
        update(post);
    }

    /**
     * 查询某个部门的所有职位
     * @param depId
     * @return
     */
    @Override
    public List<Post> findPostByDepId(String depId) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", depId);
        return find("from Post where depId=:id", map);
    }

    /**
     * 通过职位的id查询某部门的名字
     * @param postId
     * @return
     */
    @Override
    public Post findPostByPostId(String postId) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",postId);
        return findSingle("from Post where postId=:id",map);
    }

    /**
     * 获取职位的条数
     * @return
     */
    @Override
    public int getTotalPost() {
        String  sql = "select count(p) from Post p where 1=1";

        List<Long> find = (List<Long>) getHibernateTemplate().find(sql);

        if (find != null) {
            return find.get(0).intValue();
        }
        return 0;
    }

    /**
     * 分页
     * @param startIndex  开始的位置
     * @param pageSize   每页的条数
     * @return
     */
    @Override
    public List<Post> findPostByPage(int startIndex, int pageSize) {
        String sql = "from Post where 1=1 ";
        return getHibernateTemplate().execute(new PageHibernateCallback<Post>(sql, startIndex, pageSize));
    }
}
