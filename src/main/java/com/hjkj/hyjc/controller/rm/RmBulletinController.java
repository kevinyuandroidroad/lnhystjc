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
import com.hjkj.hyjc.model.rm.RmBulletin;
import com.hjkj.hyjc.query.ResponsePage;
import com.hjkj.hyjc.query.rm.RmBulletinQuery;
import com.hjkj.hyjc.service.rm.IRmBulletinService;
/**
 * 环境公报Controller
 * Table: T_RM_BULLETIN - 环境公报
 *
 * @since ${.now}11111
 */
@Controller
@RequestMapping("/rm/rmbulletin")
public class RmBulletinController extends BaseController<RmBulletin, String>{
	@Autowired
	IRmBulletinService rmBulletinService;
	
	/***
     * 环境公报列表Table
     * @param request
     * @param model
     * @param query 查询条件
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResponsePage list(HttpServletRequest request, Model model,RmBulletinQuery queryModel) {
        ResponsePage responsePage = rmBulletinService.queryList(queryModel);
        return responsePage;
    }
	
	/***
     * 跳转到环境公报列表页面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/tolist", method = RequestMethod.GET)
    public String tolist(HttpServletRequest request, Model model) {

        return "/rm/rmbulletin/rmbulletin_list";
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
        rmBulletinService.remove(id);
        return SUCCESS;
    }
	/***
     * 环境公报编辑页面
     * @param request
     * @param model
     * @param roleId 环境公报ID
     * @return
     */
    @RequestMapping(value = "/toEdit", method = RequestMethod.GET)
    public String toEdit(HttpServletRequest request, Model model, @RequestParam(value = "id", required = false)  String id) {
        super.toEdit(model, id);
        return "/rm/rmbulletin/rmbulletin_edit";
    }
	
	/***
     * 保存环境公报信息
     * @param request
     * @param model
     * @param roles
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(HttpServletRequest request, Model model, RmBulletin entity) {
        BeanUtil.setBaseInfo(entity, request.getSession(), entity.getMark());
        rmBulletinService.save(entity);
        return SUCCESS;
    }
	
	@Override
    protected RmBulletin findById(String id) {
        return rmBulletinService.findById(id);
    }

}