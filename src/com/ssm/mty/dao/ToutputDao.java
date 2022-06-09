package com.ssm.mty.dao;

import com.ssm.mty.po.Toutput;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * DAO层接口
 * @author: mty
 */
public interface ToutputDao {

    //获取列表
    public List<Toutput> getToutputList(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize,@Param("category") String category,@Param("material") String material);

    //获取总条数
    public Integer totalCount(@Param("category") String category,@Param("material") String material);

    //添加
    public int addToutput(Toutput toutput);

    //删除
    public int deleteToutput(@Param("id") Integer id);

    //更改状态
    public int closePut(@Param("id") String id,@Param("status") String status);

    //修改
    public int updateToutput(Toutput toutput);

    //根据ID查询
    public Toutput findToutputById(@Param("id") Integer id);

    //查询所有
    public List<Toutput> getAll();

}
