package com.ssm.mty.service;

import com.ssm.mty.po.Tuser;
import com.ssm.mty.po.PageInfo;
import java.util.List;

/**
 * 用户Service层接口
 * @author: mty
 */
public interface TuserService {

    //分页查询
    public PageInfo<Tuser> findPageInfo(Integer pageIndex, Integer pageSize,String username,String type);

    //添加
    public int addTuser(Tuser tuser);

    //删除
    public int deleteTuser(Integer id);

    //修改
    public int updateTuser(Tuser tuser);

    //根据ID查询
    public Tuser findTuserById(Integer id);

    //查询所有
    public List<Tuser> getAll();

    //根据用户名、密码、类型查询
    public Tuser findUser(String username,String password,String type);

    //根据人员类型查询
    public List<Tuser> getUserByType(String type);

}
