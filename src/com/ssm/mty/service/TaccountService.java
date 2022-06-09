package com.ssm.mty.service;

import com.ssm.mty.po.Taccount;
import com.ssm.mty.po.PageInfo;
import java.util.List;

/**
 * 用户Service层接口
 * @author: mty
 */
public interface TaccountService {

    //根据ID分页查询
    public PageInfo<Taccount> findPageInfo(Integer pageIndex, Integer pageSize,String category,String material);

    //分页查询
    public PageInfo<Taccount> findTaccountPerson(Integer pageIndex, Integer pageSize,String category,String material,String id);

    //添加
    public int addTaccount(Taccount taccount);

    //删除
    public int deleteTaccount(Integer id);

    //更改状态
    public int accountPut(String id,String status);

    //修改
    public int updateTaccount(Taccount taccount);

    //根据ID查询
    public Taccount findTaccountById(Integer id);

    //查询所有
    public List<Taccount> getAll();

}
