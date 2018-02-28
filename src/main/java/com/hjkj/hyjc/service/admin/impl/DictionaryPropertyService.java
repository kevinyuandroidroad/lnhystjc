package com.hjkj.hyjc.service.admin.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hjkj.hyjc.comm.util.DictionaryUtil;
import com.hjkj.hyjc.dao.admin.IDictionaryPropertyDao;
import com.hjkj.hyjc.model.admin.SysDictionaryProperty;
import com.hjkj.hyjc.service.admin.IDictionaryPropertyService;

@Service
public class DictionaryPropertyService implements IDictionaryPropertyService {

    @Autowired
    IDictionaryPropertyDao dictionaryPropertyDao;

    public void persist(SysDictionaryProperty transientInstance) {

    }

    public void remove(SysDictionaryProperty persistentInstance) {

    }

    public SysDictionaryProperty merge(SysDictionaryProperty detachedInstance) {
        return null;
    }

    public SysDictionaryProperty findById(Long id) {
        return null;
    }

    public List<SysDictionaryProperty> getAllDictionaryProperty() {
        return dictionaryPropertyDao.getAllDictionaryProperty();
    }

    public void initDicMap() {
        List<SysDictionaryProperty> list = dictionaryPropertyDao.getAllDictionaryProperty();
        for (SysDictionaryProperty property : list) {
            // 字典ID
            String dicCode = property.getDictionary().getDicCode();
            // 判断是否存在这个字典表
            if (!DictionaryUtil.dicMap.containsKey(dicCode)) {
                DictionaryUtil.dicMap.put(dicCode, new ArrayList<SysDictionaryProperty>());
            }
            // 判断是否已经存在字典表项
            if (!DictionaryUtil.dicMap.get(dicCode).contains(property)) {
                DictionaryUtil.dicMap.get(dicCode).add(property);
            }
        }
    }
}
