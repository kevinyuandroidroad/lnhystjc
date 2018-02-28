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
import com.hjkj.hyjc.model.rm.RmNotice;
import com.hjkj.hyjc.query.ResponsePage;
import com.hjkj.hyjc.query.rm.RmNoticeQuery;
import com.hjkj.hyjc.service.rm.IRmNoticeService;
/**
 * 公告表Controller
 * Table: T_RM_NOTICE - 公告表
 *
 * @since ${.now}11111
 */
@Controller
@RequestMapping("/rm/rmnotice")
public class RmNoticeController extends BaseController<RmNotice, String>{
	@Autowired
	IRmNoticeService rmNoticeService;
	
	/***
     * 公告表列表Table
     * @param request
     * @param model
     * @param query 查询条件
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResponsePage list(HttpServletRequest request, Model model,RmNoticeQuery queryModel) {
        ResponsePage responsePage = rmNoticeService.queryList(queryModel);
        return responsePage;
    }
	
	/***
     * 跳转到公告表列表页面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/tolist", method = RequestMethod.GET)
    public String tolist(HttpServletRequest request, Model model) {

        return "/rm/rmnotice/rmnotice_list";
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
        rmNoticeService.remove(id);
        return SUCCESS;
    }
	/***
     * 公告表编辑页面
     * @param request
     * @param model
     * @param roleId 公告表ID
     * @return
     */
    @RequestMapping(value = "/toEdit", method = RequestMethod.GET)
    public String toEdit(HttpServletRequest request, Model model, @RequestParam(value = "id", required = false)  String id) {
        super.toEdit(model, id);
        return "/rm/rmnotice/rmnotice_edit";
    }
	
	/***
     * 保存公告表信息
     * @param request
     * @param model
     * @param roles
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(HttpServletRequest request, Model model, RmNotice entity) {
        BeanUtil.setBaseInfo(entity, request.getSession(), entity.getMark());
        rmNoticeService.save(entity);
        return SUCCESS;
    }
	
	@Override
    protected RmNotice findById(String id) {
        return rmNoticeService.findById(id);
    }

}