package com.hjkj.hyjc.service.rm.impl;
import com.hjkj.hyjc.comm.util.StringUtil;
import com.hjkj.hyjc.comm.util.BeanUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.*;
import com.hjkj.hyjc.dao.rm.IRmMonthReportDao;
import com.hjkj.hyjc.service.rm.IRmMonthReportService;
import com.hjkj.hyjc.model.rm.RmMonthReport;
import com.hjkj.hyjc.query.ResponsePage;
import com.hjkj.hyjc.query.rm.RmMonthReportQuery;
/**
 * Service
 * Table: T_RM_MONTHREPORT - 
 *
 * @since ${.now}11111
 */
@Service
public class RmMonthReportServiceImpl implements IRmMonthReportService{
	@Autowired
	IRmMonthReportDao rmMonthReportDao;
	@Override
	public void remove(String id) {
        rmMonthReportDao.remove(RmMonthReport.class,id);
    }
	
	@Override
	 public RmMonthReport findById(String id) {
        return rmMonthReportDao.findById(RmMonthReport.class,id);
    }
	@Override
    public ResponsePage queryList(RmMonthReportQuery queryModel) {
        return rmMonthReportDao.queryList(queryModel);
    }
	@Override
	public void save(RmMonthReport entity) {
		if (StringUtil.isNotEmpty(entity.getReportId())) {		
			RmMonthReport temp = rmMonthReportDao.findById(RmMonthReport.class, entity.getReportId());
            BeanUtil.copyBeans(entity, temp);		
            rmMonthReportDao.update(temp);
        } else {
            rmMonthReportDao.save(entity);
        }
    }
	@Override
	public List<RmMonthReport> findAll() {
        return rmMonthReportDao.findListAll(RmMonthReport.class);
    }
}