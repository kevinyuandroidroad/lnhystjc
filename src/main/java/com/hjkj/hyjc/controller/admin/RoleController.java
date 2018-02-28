package com.hjkj.hyjc.controller.admin;

import java.util.ArrayList;
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
import com.hjkj.hyjc.controller.BaseController;
import com.hjkj.hyjc.model.admin.SysFunctions;
import com.hjkj.hyjc.model.admin.SysRole;
import com.hjkj.hyjc.model.admin.SysTreeNode;
import com.hjkj.hyjc.query.ResponsePage;
import com.hjkj.hyjc.query.admin.RoleQuery;
import com.hjkj.hyjc.service.admin.IFunctionsService;
import com.hjkj.hyjc.service.admin.IRoleService;

/***
 * 角色管理
 * 
 * @author Min
 */
@Controller
@RequestMapping("/admin/role")
public class RoleController extends BaseController<SysRole, String> {
    @Autowired
    IRoleService roleService;
    @Autowired
    IFunctionsService functionsService;

    /***
     * 角色列表Table
     * 
     * @param request
     * @param model
     * @param query 用户查询条件
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResponsePage list(HttpServletRequest request, Model model, RoleQuery query) {
        ResponsePage responsePage = roleService.queryList(query);
        return responsePage;
    }

    /***
     * 跳转到角色列表页面
     * 
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/tolist", method = RequestMethod.GET)
    public String tolist(HttpServletRequest request, Model model) {

        return "admin/role/role_list";
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
        roleService.remove(id);
        return SUCCESS;
    }

    /***
     * 角色编辑页面
     * 
     * @param request
     * @param model
     * @param roleId 角色ID
     * @return
     */
    @RequestMapping(value = "/toEdit", method = RequestMethod.GET)
    public String toEdit(HttpServletRequest request, Model model, @RequestParam(value = "id", required = false) String id) {
        super.toEdit(model, id);
        return "admin/role/role_edit";
    }

    /***
     * 角色菜单编辑页面
     * 
     * @param request
     * @param model
     * @param roleId 角色ID
     * @return
     */
    @RequestMapping(value = "/toRoleFuncEdit", method = RequestMethod.GET)
    public String toRoleFuncEdit(HttpServletRequest request, Model model, @RequestParam(value = "id", required = false) String id) {
        super.toEdit(model, id);
        return "admin/role/role_func_edit";
    }

    /***
     * 保存角色信息
     * 
     * @param request
     * @param model
     * @param roles
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(HttpServletRequest request, Model model, SysRole role) {
        BeanUtil.setBaseInfo(role, request.getSession(), role.getMark());
        roleService.save(role);
        return SUCCESS;
    }

    /***
     * 获取菜单树
     * 
     * @param request
     * @param model
     * @param roles
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findTree", method = RequestMethod.POST)
    public List<SysTreeNode> findTree(HttpServletRequest request, Model model, @RequestParam(value = "id", required = false) String id) {
        List<SysFunctions> funRoles = functionsService.findFuncListByRole(id);
        List<SysFunctions> funAll = functionsService.findAllFunctions();
        List<SysTreeNode> treeNodeList = new ArrayList<SysTreeNode>();
        for (int i = 0; i < funAll.size(); i++) {
            SysFunctions fun = funAll.get(i);
            SysTreeNode node = new SysTreeNode();
            node.setId(fun.getFunId().toString());
            node.setName(fun.getFunName());
            node.setOpen(true);
            if (fun.getParentFunId() != null)
                node.setpId(fun.getParentFunId().toString());
            // 判断是否存在该权限
            if (funRoles.contains(fun)) {
                node.setChecked(true);
            }
            treeNodeList.add(node);
        }
        return treeNodeList;
    }

    /***
     * 保存权限菜单
     * 
     * @param request
     * @param model
     * @param roles
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/saveRoleFunc", method = RequestMethod.POST)
    public String saveRoleFunc(HttpServletRequest request, Model model, @RequestParam(value = "id", required = false) String id,
            @RequestParam(value = "funIds", required = false) String funIds) {
        functionsService.saveRoleFunc(id, funIds);
        return SUCCESS;
    }

    @Override
    protected SysRole findById(String id) {
        return roleService.findById(id);
    }
}
