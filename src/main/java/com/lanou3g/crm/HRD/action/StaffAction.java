package com.lanou3g.crm.HRD.action;

import com.lanou3g.crm.HRD.domain.Staff;
import com.lanou3g.crm.HRD.service.StaffService;
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
@Controller("staffAction")
@Scope("prototype")
public class StaffAction extends ActionSupport implements ModelDriven<Staff>{

    private Staff staff = new Staff();
    @Resource(name = "staffService")
    private StaffService staffService;

    /**
     * 员工注册登录
     * @return
     */
    public String login(){
        staffService.login(staff);
        System.out.println(staff);
        return SUCCESS;
    }

    /**
     * 登录验证
     * @return
     */
    public void validateLogin(){
        List<Staff> staffs = staffService.findAll(staff);
        for (Staff staff1 : staffs) {
            if (staff1.getLoginName().equals(staff.getLoginName())){
                if (staff1.getLoginPwd().equals(staff.getLoginPwd())){
                    break;
                }
            }else {
                addFieldError("password","密码错误");
            }
            break;
        }

    }


    @Override
    public Staff getModel() {
        return staff;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
