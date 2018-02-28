package com.hjkj.hyjc.service.rm.impl;
import com.hjkj.hyjc.comm.util.StringUtil;
import com.hjkj.hyjc.comm.util.BeanUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.*;
import com.hjkj.hyjc.dao.rm.IRmBulletinDao;
import com.hjkj.hyjc.service.rm.IRmBulletinService;
import com.hjkj.hyjc.model.rm.RmBulletin;
import com.hjkj.hyjc.query.ResponsePage;
import com.hjkj.hyjc.query.rm.RmBulletinQuery;
/**
 * 环境公报Service
 * Table: T_RM_BULLETIN - 环境公报
 *
 * @since ${.now}11111
 */
@Service
public class RmBulletinServiceImpl implements IRmBulletinService{
	@Autowired
	IRmBulletinDao rmBulletinDao;
	@Override
	public void remove(String id) {
        rmBulletinDao.remove(RmBulletin.class,id);
    }
	
	@Override
	 public RmBulletin findById(String id) {
        return rmBulletinDao.findById(RmBulletin.class,id);
    }
	@Override
    public ResponsePage queryList(RmBulletinQuery queryModel) {
        return rmBulletinDao.queryList(queryModel);
    }
	@Override
	public void save(RmBulletin entity) {
		if (StringUtil.isNotEmpty(entity.getBulletinId())) {		
			RmBulletin temp = rmBulletinDao.findById(RmBulletin.class, entity.getBulletinId());
            BeanUtil.copyBeans(entity, temp);		
            rmBulletinDao.update(temp);
        } else {
            rmBulletinDao.save(entity);
        }
    }
	@Override
	public List<RmBulletin> findAll() {
        return rmBulletinDao.findListAll(RmBulletin.class);
    }
}