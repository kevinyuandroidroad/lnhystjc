package com.hjkj.hyjc.service.admin.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hjkj.hyjc.dao.admin.IFunctionsDao;
import com.hjkj.hyjc.dao.admin.IRoleFunctionDao;
import com.hjkj.hyjc.model.admin.SysFunctions;
import com.hjkj.hyjc.service.admin.IFunctionsService;

@Service
public class FunctionsServiceImpl implements IFunctionsService {
    @Autowired
    IFunctionsDao functionsDao;
    @Autowired
    IRoleFunctionDao roleFunctionDao;

    @Transactional(readOnly = false)
    public void remove(String id) {
        functionsDao.remove(SysFunctions.class, id);
    }

    public SysFunctions findById(String id) {
        return functionsDao.findById(SysFunctions.class, id);
    }

    public Map<String, SysFunctions> findFunctionsByRole(String roleId) {
        List<SysFunctions> funList = functionsDao.findFunctionsByRole(roleId);
        Map<String, SysFunctions> funMap = new HashMap<String, SysFunctions>();
        // 分子菜单
        for (int i = 0; i < funList.size(); i++) {
            if (funList.get(i).getFunLevel() == 1) {
                subList(funList, funList.get(i));
            }
            funMap.put(funList.get(i).getFunId(), funList.get(i));
        }
        return funMap;
    }

    private void subList(List<SysFunctions> funList, SysFunctions functions) {
        for (int i = 0; i < funList.size(); i++) {
            SysFunctions fun = funList.get(i);
            String funId = functions.getFunId();
            if (fun.getParentFunId() != null && funId.equals(fun.getParentFunId())) {
                subList(funList, fun);
                functions.getSubList().add(fun);
            }
        }
    }

    public List<SysFunctions> findFuncListByRole(String roleId) {
        List<SysFunctions> funList = functionsDao.findFunctionsByRole(roleId);
        return funList;
    }

    public List<SysFunctions> findAllFunctions() {
        List<SysFunctions> funAllList = functionsDao.findAllFunctions();
        return funAllList;
    }

    @Transactional(readOnly = false)
    public void saveRoleFunc(String id, String funList) {
        // 删除现有权限
        roleFunctionDao.deleteFuncByRoleId(id);
        roleFunctionDao.saveRoleFunc(id, funList);
    }
}
