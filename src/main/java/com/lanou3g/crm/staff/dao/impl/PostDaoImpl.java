package com.lanou3g.crm.staff.dao.impl;

import com.lanou3g.crm.base.impl.BaseAction;
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

public class PostDaoImpl extends BaseAction<Post> implements PostDao {
    @Override
    public List<Post> findAllPost() {
        String sql = "from Post";
        return findAll(sql);
    }

    @Override
    public void addPost(Post post) {
        save(post);
    }

    @Override
    public void updatePost(Post post) {
        update(post);
    }

    @Override
    public List<Post> findPostByDepId(String depId) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", depId);
        return find("from Post where depId=:id", map);
    }

    @Override
    public Post findPostByPostId(String postId) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",postId);
        return findSingle("from Post where postId=:id",map);
    }

    @Override
    public int getTotalPost() {
        String  sql = "select count(p) from Post p where 1=1";

        List<Long> find = (List<Long>) getHibernateTemplate().find(sql);

        if (find != null) {
            return find.get(0).intValue();
        }
        return 0;
    }

    @Override
    public List<Post> findPostByPage(int startIndex, int pageSize) {
        String sql = "from Post where 1=1 ";
        return getHibernateTemplate().execute(new PageHibernateCallback<Post>(sql, startIndex, pageSize));
    }
}
