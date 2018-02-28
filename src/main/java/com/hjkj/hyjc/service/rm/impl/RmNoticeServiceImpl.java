package com.hjkj.hyjc.service.rm.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hjkj.hyjc.comm.util.BeanUtil;
import com.hjkj.hyjc.comm.util.StringUtil;
import com.hjkj.hyjc.dao.rm.IRmNoticeDao;
import com.hjkj.hyjc.model.rm.RmNotice;
import com.hjkj.hyjc.query.ResponsePage;
import com.hjkj.hyjc.query.rm.RmNoticeQuery;
import com.hjkj.hyjc.service.rm.IRmNoticeService;
/**
 * 公告表Service
 * Table: T_RM_NOTICE - 公告表
 *
 * @since ${.now}11111
 */
@Service
public class RmNoticeServiceImpl implements IRmNoticeService{
	@Autowired
	IRmNoticeDao rmNoticeDao;
	@Override
	public void remove(String id) {
        rmNoticeDao.remove(RmNotice.class,id);
    }
	
	@Override
	 public RmNotice findById(String id) {
        return rmNoticeDao.findById(RmNotice.class,id);
    }
	@Override
    public ResponsePage queryList(RmNoticeQuery queryModel) {
        return rmNoticeDao.queryList(queryModel);
    }
	@Override
	public void save(RmNotice entity) {
		if (StringUtil.isNotEmpty(entity.getNoticeId())) {		
			RmNotice temp = rmNoticeDao.findById(RmNotice.class, entity.getNoticeId());
            BeanUtil.copyBeans(entity, temp);		
            rmNoticeDao.update(temp);
        } else {
            rmNoticeDao.save(entity);
        }
    }
	@Override
	public List<RmNotice> findAll() {
        return rmNoticeDao.findListAll(RmNotice.class);
    }
}