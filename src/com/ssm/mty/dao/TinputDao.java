package com.ssm.mty.dao;

import com.ssm.mty.po.QueryVO;
import com.ssm.mty.po.Tinput;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * DAO层接口
 * @author: mty
 */
public interface TinputDao {

    //获取列表
    public List<Tinput> getTinputList(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize,@Param("category") String category,@Param("material") String material);

    //获取总条数
    public Integer totalCount(@Param("category") String category,@Param("material") String material);

    //添加
    public int addTinput(Tinput tinput);

    //删除
    public int deleteTinput(@Param("id") Integer id);

    //修改
    public int updateTinput(Tinput tinput);

    //根据ID查询
    public Tinput findTinputById(@Param("id") Integer id);

    //查询所有
    public List<Tinput> getAll();

    //入库数量统计
    public List<QueryVO> queryStatistic();
}
