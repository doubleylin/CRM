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
    private List<Post> posts;

    public String findAllPost(){
        posts = postService.findAllPost();
        ActionContext.getContext().getSession().put("posts", posts);
        return SUCCESS;
    }

    public String findPostByPage(){
        if (pageNum==0){
            pageNum=1;
        }
        PageBean<Post> all = postService.findPostByPage(post,pageNum,pageSize);
        ActionContext.getContext().getSession().put("pageBean",all);
        return SUCCESS;
    }

    public String addPost(){

        if (post.getPostId().equals("")) {
            Department department = departmentService.findById(post.getDepartment().getDepId());
            post.setDepartment(department);
            postService.addPost(post);


        } else {
            Department department = departmentService.findById(post.getDepartment().getDepId());
            post.setDepartment(department);
            postService.updatePost(post);

        }
        if ("-1".equals(deptId)){
            addActionError("请选择部门");
            return INPUT;
        }
        if ("".equals(post.getPostName())){
            addActionError("职务名称不能为空");
            return INPUT;
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

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
