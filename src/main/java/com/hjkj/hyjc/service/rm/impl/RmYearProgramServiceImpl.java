package com.hjkj.hyjc.service.rm.impl;
import com.hjkj.hyjc.comm.util.StringUtil;
import com.hjkj.hyjc.comm.util.BeanUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.*;
import com.hjkj.hyjc.dao.rm.IRmYearProgramDao;
import com.hjkj.hyjc.service.rm.IRmYearProgramService;
import com.hjkj.hyjc.model.rm.RmYearProgram;
import com.hjkj.hyjc.query.ResponsePage;
import com.hjkj.hyjc.query.rm.RmYearProgramQuery;
/**
 * 年度方案 表Service
 * Table: T_RM_YEARPROGRAM - 年度方案 表
 *
 * @since ${.now}11111
 */
@Service
public class RmYearProgramServiceImpl implements IRmYearProgramService{
	@Autowired
	IRmYearProgramDao rmYearProgramDao;
	@Override
	public void remove(String id) {
        rmYearProgramDao.remove(RmYearProgram.class,id);
    }
	
	@Override
	 public RmYearProgram findById(String id) {
        return rmYearProgramDao.findById(RmYearProgram.class,id);
    }
	@Override
    public ResponsePage queryList(RmYearProgramQuery queryModel) {
        return rmYearProgramDao.queryList(queryModel);
    }
	@Override
	public void save(RmYearProgram entity) {
		if (StringUtil.isNotEmpty(entity.getProgramId())) {		
			RmYearProgram temp = rmYearProgramDao.findById(RmYearProgram.class, entity.getProgramId());
            BeanUtil.copyBeans(entity, temp);		
            rmYearProgramDao.update(temp);
        } else {
            rmYearProgramDao.save(entity);
        }
    }
	@Override
	public List<RmYearProgram> findAll() {
        return rmYearProgramDao.findListAll(RmYearProgram.class);
    }
}