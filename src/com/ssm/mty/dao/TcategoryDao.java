package com.ssm.mty.dao;

import com.ssm.mty.po.Tcategory;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * DAO层接口
 * @author: mty
 */
public interface TcategoryDao {

    //获取列表
    public List<Tcategory> getTcategoryList(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    //获取总条数
    public Integer totalCount();

    //添加
    public int addTcategory(Tcategory tcategory);

    //删除
    public int deleteTcategory(@Param("id") Integer id);

    //修改
    public int updateTcategory(Tcategory tcategory);

    //根据ID查询
    public Tcategory findTcategoryById(@Param("id") Integer id);

    //查询所有
    public List<Tcategory> getAll();

}
