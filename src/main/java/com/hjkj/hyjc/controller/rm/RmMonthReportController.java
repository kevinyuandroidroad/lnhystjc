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
import com.hjkj.hyjc.model.rm.RmMonthReport;
import com.hjkj.hyjc.query.ResponsePage;
import com.hjkj.hyjc.query.rm.RmMonthReportQuery;
import com.hjkj.hyjc.service.rm.IRmMonthReportService;
/**
 * Controller
 * Table: T_RM_MONTHREPORT - 
 *
 * @since ${.now}11111
 */
@Controller
@RequestMapping("/rm/rmmonthreport")
public class RmMonthReportController extends BaseController<RmMonthReport, String>{
	@Autowired
	IRmMonthReportService rmMonthReportService;
	
	/***
     * 列表Table
     * @param request
     * @param model
     * @param query 查询条件
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResponsePage list(HttpServletRequest request, Model model,RmMonthReportQuery queryModel) {
        ResponsePage responsePage = rmMonthReportService.queryList(queryModel);
        return responsePage;
    }
	
	/***
     * 跳转到列表页面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/tolist", method = RequestMethod.GET)
    public String tolist(HttpServletRequest request, Model model) {

        return "/rm/rmmonthreport/rmmonthreport_list";
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
        rmMonthReportService.remove(id);
        return SUCCESS;
    }
	/***
     * 编辑页面
     * @param request
     * @param model
     * @param roleId ID
     * @return
     */
    @RequestMapping(value = "/toEdit", method = RequestMethod.GET)
    public String toEdit(HttpServletRequest request, Model model, @RequestParam(value = "id", required = false)  String id) {
        super.toEdit(model, id);
        return "/rm/rmmonthreport/rmmonthreport_edit";
    }
	
	/***
     * 保存信息
     * @param request
     * @param model
     * @param roles
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(HttpServletRequest request, Model model, RmMonthReport entity) {
        BeanUtil.setBaseInfo(entity, request.getSession(), entity.getMark());
        rmMonthReportService.save(entity);
        return SUCCESS;
    }
	
	@Override
    protected RmMonthReport findById(String id) {
        return rmMonthReportService.findById(id);
    }

}