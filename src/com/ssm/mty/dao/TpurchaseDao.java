package com.ssm.mty.dao;

import com.ssm.mty.po.QueryVO;
import com.ssm.mty.po.Tpurchase;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * DAO层接口
 * @author: mty
 */
public interface TpurchaseDao {

    //获取列表
    public List<Tpurchase> getTpurchaseList(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize,@Param("material") String material,@Param("category") String category);

    //获取总条数
    public Integer totalCount(@Param("material") String material,@Param("category") String category);

    //添加
    public int addTpurchase(Tpurchase tpurchase);

    //删除
    public int deleteTpurchase(@Param("id") Integer id);

    //修改
    public int updateTpurchase(Tpurchase tpurchase);

    //根据ID查询
    public Tpurchase findTpurchaseById(@Param("id") Integer id);

    //查询所有
    public List<Tpurchase> getAll();

    //对采购分组统计
    public List<QueryVO> queryPur();

}
