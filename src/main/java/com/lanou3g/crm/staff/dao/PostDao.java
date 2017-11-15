package com.lanou3g.crm.staff.dao;


import com.lanou3g.crm.staff.domain.Post;

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

public interface PostDao {
    /**
     * 查询所有的职位
     * @return
     */
    List<Post> findAllPost();

    /**
     * 添加职员
     * @param post
     */
    void addPost(Post post);

    /**
     * 修改职员
     * @param post
     */
    void updatePost(Post post);

    /**
     * 通过部门id查询职位
     * 即查询某部门的所有职位
     * @param depId
     * @return
     */
    List<Post> findPostByDepId(String depId);

    /**
     * 通过部门的id查询部门的名字
     * @param postId
     * @return
     */
    Post findPostByPostId(String postId);

    /**
     * 获取总共的部门数
     * @return
     */
    int getTotalPost();

    /**
     * 分页显示部门
     * @param startIndex  开始的位置
     * @param pageSize   每页的条数
     * @return
     */
    List<Post> findPostByPage(int startIndex, int pageSize);

}
