package com.ssm.mty.service;

import com.ssm.mty.po.Tpurchase;
import com.ssm.mty.po.PageInfo;
import com.ssm.mty.po.QueryVO;

import java.util.List;

/**
 * 用户Service层接口
 * @author: mty
 */
public interface TpurchaseService {

    //分页查询
    public PageInfo<Tpurchase> findPageInfo(Integer pageIndex, Integer pageSize,String material,String category);

    //添加
    public int addTpurchase(Tpurchase tpurchase);

    //删除
    public int deleteTpurchase(Integer id);

    //修改
    public int updateTpurchase(Tpurchase tpurchase);

    //根据ID查询
    public Tpurchase findTpurchaseById(Integer id);

    //查询所有
    public List<Tpurchase> getAll();

    //对采购分组统计
    public List<QueryVO> queryPur();

}
