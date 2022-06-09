package com.ssm.mty.dao;

import com.ssm.mty.po.Taccount;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * DAO层接口
 * @author: mty
 */
public interface TaccountDao {

    //获取列表
    public List<Taccount> getTaccountList(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize,@Param("category") String category,@Param("material") String material);

    //获取总条数
    public Integer totalCount(@Param("category") String category,@Param("material") String material);

    //根据ID获取列表
    public List<Taccount> getTaccountList1(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize,@Param("category") String category,@Param("material") String material,@Param("id") String id);

    //根据ID获取总条数
    public Integer totalCount1(@Param("category") String category,@Param("material") String material,@Param("id") String id);

    //添加
    public int addTaccount(Taccount taccount);

    //删除
    public int deleteTaccount(@Param("id") Integer id);

    //更改状态
    public int accountPut(@Param("id") String id,@Param("status") String status);

    //修改
    public int updateTaccount(Taccount taccount);

    //根据ID查询
    public Taccount findTaccountById(@Param("id") Integer id);

    //查询所有
    public List<Taccount> getAll();

}
