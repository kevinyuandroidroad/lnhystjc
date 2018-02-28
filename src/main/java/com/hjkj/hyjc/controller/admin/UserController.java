package com.hjkj.hyjc.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hjkj.hyjc.comm.util.BeanUtil;
import com.hjkj.hyjc.comm.util.StringUtil;
import com.hjkj.hyjc.controller.BaseController;
import com.hjkj.hyjc.model.admin.SysDepartment;
import com.hjkj.hyjc.model.admin.SysRole;
import com.hjkj.hyjc.model.admin.SysUsers;
import com.hjkj.hyjc.query.ResponsePage;
import com.hjkj.hyjc.query.admin.UserQuery;
import com.hjkj.hyjc.service.admin.IDepartmentService;
import com.hjkj.hyjc.service.admin.IRoleService;
import com.hjkj.hyjc.service.admin.IUserService;

@Controller
@RequestMapping("/admin/user")
public class UserController extends BaseController<SysUsers, String> {
    @Autowired
    private IUserService userService;
    @Autowired
    IRoleService roleService;
    @Autowired
    IDepartmentService departmentService;

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResponsePage list(HttpServletRequest request, Model model, UserQuery query) {
        ResponsePage responsePage = userService.queryList(query);
        return responsePage;
    }

    @RequestMapping(value = "/tolist", method = RequestMethod.GET)
    public String tolist(HttpServletRequest request, Model model) {

        return "admin/user/user_list";
    }

    @RequestMapping(value = "/toEdit", method = RequestMethod.GET)
    public String toEdit(HttpServletRequest request, Model model, @RequestParam(value = "id", required = false) String userId) {
        super.toEdit(model, userId);
        List<SysRole> roleList = roleService.findAll();
        if (userId == null) {

        } else {
            SysUsers user = userService.findById(userId);
            List<SysDepartment> departments = departmentService.getDeptByUserId(userId);
            if (departments != null && departments.size() > 0)
                // 查询用户部门
                user.setDepartment(departmentService.getDeptByUserId(userId).get(0));
            List<SysRole> role = roleService.findRoleByUser(userId);
            if (role != null && role.size() > 0)
                user.setRole(role.get(0));
            // 查询用户角色
            model.addAttribute("user", user);
        }
        model.addAttribute("roleList", roleList);
        return "admin/user/user_edit";
    }

    /***
     * 个人信息修改
     * 
     * @param request
     * @param model
     * @param userId
     * @return
     */
    @RequestMapping(value = "/toPersonalSet", method = RequestMethod.GET)
    public String toPersonalSet(HttpServletRequest request, Model model, @RequestParam(value = "userId", required = false) String userId) {
        super.toEdit(model, userId);
        List<SysRole> roleList = roleService.findAll();
        if (userId == null) {

        } else {
            SysUsers user = userService.findById(userId);
            List<SysDepartment> departments = departmentService.getDeptByUserId(userId);
            if (departments != null && departments.size() > 0)
                // 查询用户部门
                user.setDepartment(departmentService.getDeptByUserId(userId).get(0));
            List<SysRole> role = roleService.findRoleByUser(userId);
            if (role != null && role.size() > 0)
                user.setRole(role.get(0));
            // 查询用户角色
            model.addAttribute("user", user);
        }
        model.addAttribute("roleList", roleList);
        return "admin/user/personal_set";
    }

    /***
     * 个人信息修改
     * 
     * @param request
     * @param model
     * @param userId
     * @return
     */
    @RequestMapping(value = "/toPassWord", method = RequestMethod.GET)
    public String toPassWord(HttpServletRequest request, Model model, @RequestParam(value = "userId", required = false) String userId) {
        super.toEdit(model, userId);
        return "admin/user/password";
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(HttpServletRequest request, Model model, SysUsers users) {
        if (StringUtil.isNotEmpty(users.getId()) && userService.isExist(users.getLoginName())) {
            return "exist";
        }
        BeanUtil.setBaseInfo(users, request.getSession(), users.getMark());
        userService.save(users);
        return SUCCESS;
    }

    /***
     * 删除方法
     * 
     * @param request
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(HttpServletRequest request, Model model, @RequestParam(value = "id", required = false) String id) {
        userService.remove(id);
        return SUCCESS;
    }

    @Override
    protected SysUsers findById(String id) {
        return userService.findById(id);
    }
}