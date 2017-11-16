package com.lanou3g.crm.staff.dao.impl;

import com.lanou3g.crm.HibernateUtil;
import com.lanou3g.crm.staff.dao.PostDao;
import com.lanou3g.crm.staff.domain.Department;
import com.lanou3g.crm.staff.domain.Post;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

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

public class PostDaoImplTest {
    private PostDao postDao = new PostDaoImpl();
    @Test
    public void findAllPost() throws Exception {
        Session session = HibernateUtil.openSession();
        Post post1 = session.get(Post.class,"2c9090135fbe841b015fbe85a20d0000");
        Post post2 = session.get(Post.class,"2c9090135fbe841b015fbe861ae00001");
        Post post3 = session.get(Post.class,"2c9090135fbe86ee015fbe892ed90000");
        Post post4 = session.get(Post.class,"2c9090135fbe86ee015fbe8958b10001");
        Post post5 = session.get(Post.class,"2c9090135fbe86ee015fbe898dc40002");

        System.out.println(post1);
        System.out.println(post2);
        System.out.println(post3);
        System.out.println(post4);
        System.out.println(post5);

        HibernateUtil.commit();
    }

    @Test
    public void addPost() throws Exception {
        Session session = HibernateUtil.openSession();
        Department department = new Department("更新部");
        Post post = new Post("数据处理");
        post.setDepartment(department);

        department.getPosts().add(post);
        session.save(post);
        session.save(department);
        HibernateUtil.commit();

    }

    @Test
    public void updatePost() throws Exception {
        Session session = HibernateUtil.openSession();
        Post post = session.get(Post.class,"2c9090135fc41638015fc417a8bd0000");
        post.setPostName("数据更新员");
        session.save(post);
        HibernateUtil.commit();
    }

    @Test
    public void findPostByDepId() throws Exception {
        List<Post> posts = postDao.findPostByDepId("2c9090135fb4bf9c015fb4bff2900000");

            System.out.println(posts);


    }

    @Test
    public void findPostByPostId() throws Exception {
        Session session = HibernateUtil.openSession();
        Post post = session.get(Post.class,"2c9090135fbe841b015fbe85a20d0000");
        System.out.println(post);
        HibernateUtil.commit();
    }


}