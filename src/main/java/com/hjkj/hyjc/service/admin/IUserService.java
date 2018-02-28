package com.hjkj.hyjc.service.admin;

import com.hjkj.hyjc.model.admin.SysUsers;
import com.hjkj.hyjc.query.ResponsePage;
import com.hjkj.hyjc.query.admin.UserQuery;

public interface IUserService {
    /***
     * 用户新增
     * 
     * @param transientInstance
     */
    public void save(SysUsers transientInstance);

    /***
     * 删除用户
     * 
     * @param id
     */
    public void remove(String id);


    /***
     * 根据ID获取用户
     * 
     * @param id
     * @return
     */
    public SysUsers findById(String id);

    /***
     * 用户登录方法
     * 
     * @param loginName
     * @param password
     * @return
     */
    public SysUsers login(String loginName, String password);

    /**
     * 分页查询用户
     * 
     * @param query
     * @return
     */
    public ResponsePage queryList(UserQuery query);

    /***
     * 根据登录名判断用户是否存在
     * 
     * @param loginName
     * @return
     */
    public boolean isExist(String loginName);
}
