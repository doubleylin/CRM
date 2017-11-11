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

    List<Post> findAllPost();

    void addPost(Post post);

    void updatePost(Post post);

    List<Post> findPostByDepId(String depId);

    Post findPostByPostId(String postId);

    int getTotalPost();

    List<Post> findPostByPage(int startIndex, int pageSize);

}
