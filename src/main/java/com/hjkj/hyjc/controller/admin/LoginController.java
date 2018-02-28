package com.hjkj.hyjc.controller.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hjkj.hyjc.comm.cons.Constant;
import com.hjkj.hyjc.comm.util.Encrypt;
import com.hjkj.hyjc.model.admin.SysDepartment;
import com.hjkj.hyjc.model.admin.SysFunctions;
import com.hjkj.hyjc.model.admin.SysRole;
import com.hjkj.hyjc.model.admin.SysUsers;
import com.hjkj.hyjc.service.admin.IDepartmentService;
import com.hjkj.hyjc.service.admin.IFunctionsService;
import com.hjkj.hyjc.service.admin.IRoleService;
import com.hjkj.hyjc.service.admin.IUserService;

/***
 * 登录用@Controller
 * 
 * @author Min
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IFunctionsService functionsService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IDepartmentService departmentService;

    @RequestMapping(value = "/loginByPassword", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam(value = "loginName", required = true) String loginName,
            @RequestParam(value = "password", required = true) String password, HttpSession httpSession, Model model) {
        // 密码MD5加密
        SysUsers user = this.userService.login(loginName, Encrypt.encodeByMD5(password));
        // 如果用户不为空则加载菜单
        if (user != null) {
            List<SysRole> roles = roleService.findRoleByUser(user.getId());
            System.out.println();
            if (roles.size() > 0) {
                user.setRole(roles.get(0));
                Map<String, SysFunctions> funMap = functionsService.findFunctionsByRole(roles.get(0).getRoleId());
                httpSession.setAttribute("funMap", funMap);
                // 设置默认活动的一级菜单funMap.entrySet().iterator().next().getValue()
                httpSession.setAttribute("firstFuns", funMap.entrySet().iterator().next().getValue());
            }
            // 获取部门信息
            List<SysDepartment> depts = departmentService.getDeptByUserId(user.getId());

            if (depts != null && depts.size() > 0) {
                user.setDepartment(depts.get(0));
                // 查询下级部门信息
                List<SysDepartment> deptsCh = departmentService.getChildDeptByUserId(depts.get(0).getDeptId());
                deptsCh.add(depts.get(0));
                StringBuffer depsChidIds = new StringBuffer();
                for (int i = 0; i < deptsCh.size(); i++) {
                    depsChidIds.append(deptsCh.get(i).getDeptId() + ",");
                }
                if (depsChidIds.length() > 0) {
                    depsChidIds.deleteCharAt(depsChidIds.length() - 1);
                }
                httpSession.setAttribute("childDept", depsChidIds.toString());
            }
            httpSession.setAttribute("currentUser", user);

            return new ModelAndView("redirect:/index/index.htm");
        }
        return new ModelAndView("redirect:/login.jsp");
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpSession httpSession) {
        httpSession.invalidate();
        return new ModelAndView("redirect:/login.jsp");
    }

    /**
     * 菜单跳转
     * 
     * @param model
     * @param httpSession
     * @param funId
     * @return
     */
    @RequestMapping(value = "/activeFunction", method = RequestMethod.GET)
    public ModelAndView activeFunction(Model model, HttpSession httpSession, @RequestParam(value = "funId", required = true) String funId) {
        @SuppressWarnings("unchecked")
        Map<String, SysFunctions> funMap = (Map<String, SysFunctions>) httpSession.getAttribute("funMap");
        SysFunctions functions = funMap.get(funId);
        if (functions != null) {
            // 判断点击的是否是一级菜单,更新左侧菜单
            // 如果是URL直接跳转
            if (Constant.FUN_TYPE_URL.equals(functions.getFunType())) {
                if (functions.getFunLevel() == 1) {
                    httpSession.setAttribute("firstFuns", functions);
                    httpSession.removeAttribute("secondFun");
                    httpSession.removeAttribute("thirdFun");
                } else if (functions.getFunLevel() == 2) {
                    httpSession.setAttribute("secondFun", functions);
                    httpSession.removeAttribute("thirdFun");
                }
                if (functions.getFunLevel() == 3) {
                    SysFunctions secondFun = functionsService.findById(functions.getParentFunId());
                    httpSession.setAttribute("secondFun", secondFun);
                    httpSession.setAttribute("thirdFun", functions);
                }
                return new ModelAndView("redirect:" + functions.getLinkPage());
            }
        }
        return new ModelAndView("redirect:/404.jsp");
    }
}
