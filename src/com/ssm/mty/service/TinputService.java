package com.ssm.mty.service;

import com.ssm.mty.po.QueryVO;
import com.ssm.mty.po.Tinput;
import com.ssm.mty.po.PageInfo;
import java.util.List;

/**
 * 用户Service层接口
 * @author: mty
 */
public interface TinputService {

    //分页查询
    public PageInfo<Tinput> findPageInfo(Integer pageIndex, Integer pageSize,String category,String material);

    //添加
    public int addTinput(Tinput tinput);

    //删除
    public int deleteTinput(Integer id);

    //修改
    public int updateTinput(Tinput tinput);

    //根据ID查询
    public Tinput findTinputById(Integer id);

    //查询所有
    public List<Tinput> getAll();

    //入库数量统计
    public List<QueryVO> queryStatistic();

}
