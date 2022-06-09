package com.ssm.mty.dao;

import com.ssm.mty.po.Tuser;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * DAO层接口
 * @author: mty
 */
public interface TuserDao {

    //获取列表
    public List<Tuser> getTuserList(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize,@Param("username") String username,@Param("type") String type);

    //获取总条数
    public Integer totalCount(@Param("username") String username,@Param("type") String type);

    //添加
    public int addTuser(Tuser tuser);

    //删除
    public int deleteTuser(@Param("id") Integer id);

    //修改
    public int updateTuser(Tuser tuser);

    //根据ID查询
    public Tuser findTuserById(@Param("id") Integer id);

    //查询所有
    public List<Tuser> getAll();

    //根据用户名、密码、类型查询
    public Tuser findUser(@Param("username") String username,@Param("password") String password,@Param("type") String type);

    //查询所有
    public List<Tuser> getUserByType(@Param("type") String type);
}
