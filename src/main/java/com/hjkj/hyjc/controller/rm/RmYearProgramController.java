package com.hjkj.hyjc.controller.rm;
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
import com.hjkj.hyjc.model.rm.RmYearProgram;
import com.hjkj.hyjc.query.ResponsePage;
import com.hjkj.hyjc.query.rm.RmYearProgramQuery;
import com.hjkj.hyjc.service.rm.IRmYearProgramService;
/**
 * 年度方案 表Controller
 * Table: T_RM_YEARPROGRAM - 年度方案 表
 *
 * @since ${.now}11111
 */
@Controller
@RequestMapping("/rm/rmyearprogram")
public class RmYearProgramController extends BaseController<RmYearProgram, String>{
	@Autowired
	IRmYearProgramService rmYearProgramService;
	
	/***
     * 年度方案 表列表Table
     * @param request
     * @param model
     * @param query 查询条件
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResponsePage list(HttpServletRequest request, Model model,RmYearProgramQuery queryModel) {
        ResponsePage responsePage = rmYearProgramService.queryList(queryModel);
        return responsePage;
    }
	
	/***
     * 跳转到年度方案 表列表页面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/tolist", method = RequestMethod.GET)
    public String tolist(HttpServletRequest request, Model model) {

        return "/rm/rmyearprogram/rmyearprogram_list";
    }
	 /***
     * 删除方法
     * @param request
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(HttpServletRequest request, Model model, @RequestParam(value = "id", required = false) String id) {
        rmYearProgramService.remove(id);
        return SUCCESS;
    }
	/***
     * 年度方案 表编辑页面
     * @param request
     * @param model
     * @param roleId 年度方案 表ID
     * @return
     */
    @RequestMapping(value = "/toEdit", method = RequestMethod.GET)
    public String toEdit(HttpServletRequest request, Model model, @RequestParam(value = "id", required = false)  String id) {
        super.toEdit(model, id);
        return "/rm/rmyearprogram/rmyearprogram_edit";
    }
	
	/***
     * 保存年度方案 表信息
     * @param request
     * @param model
     * @param roles
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(HttpServletRequest request, Model model, RmYearProgram entity) {
        BeanUtil.setBaseInfo(entity, request.getSession(), entity.getMark());
        rmYearProgramService.save(entity);
        return SUCCESS;
    }
	
	@Override
    protected RmYearProgram findById(String id) {
        return rmYearProgramService.findById(id);
    }

}