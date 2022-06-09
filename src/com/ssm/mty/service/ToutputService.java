package com.ssm.mty.service;

import com.ssm.mty.po.Toutput;
import com.ssm.mty.po.PageInfo;
import java.util.List;

/**
 * 用户Service层接口
 * @author: mty
 */
public interface ToutputService {

    //分页查询
    public PageInfo<Toutput> findPageInfo(Integer pageIndex, Integer pageSize,String category,String material);

    //添加
    public int addToutput(Toutput toutput);

    //删除
    public int deleteToutput(Integer id);

    //更改状态
    public int closePut(String id,String status);

    //修改
    public int updateToutput(Toutput toutput);

    //根据ID查询
    public Toutput findToutputById(Integer id);

    //查询所有
    public List<Toutput> getAll();

}
