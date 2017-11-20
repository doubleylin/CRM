package com.lanou3g.crm.staff.service.impl;

import com.lanou3g.crm.staff.dao.PostDao;
import com.lanou3g.crm.staff.domain.Department;
import com.lanou3g.crm.staff.domain.Post;
import com.lanou3g.crm.staff.service.PostService;
import com.lanou3g.crm.utils.PageBean;

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

public class PostServiceImpl implements PostService {

    private PostDao postDao;
    @Override
    public List<Post> findAllPost() {
        return postDao.findAllPost();
    }

    @Override
    public List<Department> findDept() {
        return postDao.findDept();
    }

    @Override
    public void addPost(Post post) {
        postDao.addPost(post);
    }

    @Override
    public void updatePost(Post post) {
        postDao.updatePost(post);
    }

    @Override
    public List<Post> findPostByDepId(String depId) {
        return postDao.findPostByDepId(depId);
    }

    @Override
    public Post findPostByPostId(String postId) {
        return postDao.findPostByPostId(postId);
    }

    @Override
    public PageBean<Post> findPostByPage(Post post ,int pageNum,int pageSize) {
        int totalPost = postDao.getTotalPost();
        PageBean<Post> pageBean = new PageBean<>(pageNum,pageSize,totalPost);
        List<Post> data =
                postDao.findPostByPage(pageBean.getStartIndex(),pageBean.getPageSize());
        pageBean.setData(data);
        return pageBean;
    }

    public PostDao getPostDao() {
        return postDao;
    }

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }
}
