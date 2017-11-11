package com.lanou3g.crm.staff.web.action;

import com.lanou3g.crm.staff.domain.Department;
import com.lanou3g.crm.staff.domain.Post;
import com.lanou3g.crm.staff.service.DepartmentService;
import com.lanou3g.crm.staff.service.PostService;
import com.lanou3g.crm.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
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
@Controller("postAction")
@Scope("prototype")
public class PostAction extends ActionSupport implements ModelDriven<Post> {

    private Post post = new Post();

    private String deptId;

    private String postId;

    @Resource(name = "postService")
    private PostService postService;

    @Resource(name = "departmentService")
    private DepartmentService departmentService;

    private int pageNum;
    private int pageSize = 5;

    public String findAllPost(){
        List<Post> posts = postService.findAllPost();
        ActionContext.getContext().getSession().put("posts",posts);
        return SUCCESS;
    }

    public String findPostByPage(){
        if (pageNum==0){
            pageNum=1;
        }
        PageBean<Post> data = postService.findPostByPage(post,pageNum,pageSize);
        ActionContext.getContext().getSession().put("pageBean",data);
        return SUCCESS;
    }

    public String addPost(){
        if ("-1".equals(deptId)){
            addActionError("请选择部门");
            return INPUT;
        }
        if (postId.equals("")){
            Department department = departmentService.findById(deptId);
            post.setDepartment(department);
            postService.addPost(post);
        }else {
            Department department = departmentService.findById(deptId);
            post.setDepartment(department);
            post.setPostId(postId);
            postService.updatePost(post);
        }
        return SUCCESS;
    }

    @Override
    public Post getModel() {
        return post;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }
}
