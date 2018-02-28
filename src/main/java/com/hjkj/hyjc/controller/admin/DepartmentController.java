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
import com.hjkj.hyjc.model.admin.SysDepartment;
import com.hjkj.hyjc.model.admin.SysTreeNode;
import com.hjkj.hyjc.service.admin.IDepartmentService;

@Controller
@RequestMapping("/admin/dept")
public class DepartmentController extends BaseController<SysDepartment, String> {
    @Autowired
    IDepartmentService departmentService;

    /***
     * 跳转到部门页面
     * 
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/tolist", method = RequestMethod.GET)
    public String tolist(HttpServletRequest request, Model model) {

        return "admin/dept/dept_list";
    }

    /***
     * 获取所有部门
     * 
     * @param request
     * @param model
     * @param roles
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findTree", method = RequestMethod.POST)
    public List<SysTreeNode> findTree() {
        List<SysDepartment> deptAll = departmentService.findAll();
        List<SysTreeNode> treeNodeList = new ArrayList<SysTreeNode>();
        for (int i = 0; i < deptAll.size(); i++) {
            SysDepartment dept = deptAll.get(i);
            SysTreeNode node = new SysTreeNode();
            node.setId(dept.getDeptId().toString());
            node.setName(dept.getDeptName());
            node.setOpen(true);
            if (dept.getParentDeptId() != null)
                node.setpId(dept.getParentDeptId().toString());
            treeNodeList.add(node);
        }
        return treeNodeList;
    }

    /***
     * 保存部门信息
     * 
     * @param dept
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(SysDepartment dept, HttpServletRequest request) {
        BeanUtil.setBaseInfo(dept, request.getSession(), dept.getMark());
        departmentService.save(dept);
        return SUCCESS;
    }

    /***
     * 删除部门
     * 
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam(value = "id", required = false) String id) {
        departmentService.remove(id);
        return SUCCESS;
    }

    /***
     * 根据ID获取部门
     * 
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    @Override
    public SysDepartment findById(@RequestParam(value = "id", required = false) String id) {
        SysDepartment department = departmentService.findById(id);
        return department;
    }
}
