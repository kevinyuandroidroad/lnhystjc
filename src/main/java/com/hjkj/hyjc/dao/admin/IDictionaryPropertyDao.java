package com.hjkj.hyjc.dao.admin;

import java.util.List;

import com.hjkj.hyjc.dao.IBaseDao;
import com.hjkj.hyjc.model.admin.SysDictionaryProperty;

public interface IDictionaryPropertyDao extends IBaseDao {

    public List<SysDictionaryProperty> getAllDictionaryProperty();

}