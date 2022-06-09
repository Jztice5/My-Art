package com.ssm.mty.service;

import com.ssm.mty.po.Tcategory;
import com.ssm.mty.po.PageInfo;
import java.util.List;

/**
 * 用户Service层接口
 * @author: mty
 */
public interface TcategoryService {

    //分页查询
    public PageInfo<Tcategory> findPageInfo(Integer pageIndex, Integer pageSize);

    //添加
    public int addTcategory(Tcategory tcategory);

    //删除
    public int deleteTcategory(Integer id);

    //修改
    public int updateTcategory(Tcategory tcategory);

    //根据ID查询
    public Tcategory findTcategoryById(Integer id);

    //查询所有
    public List<Tcategory> getAll();

}
