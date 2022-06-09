package com.ssm.mty.service.impl;

import com.ssm.mty.dao.TcategoryDao;
import com.ssm.mty.po.Tcategory;
import com.ssm.mty.po.PageInfo;
import com.ssm.mty.service.TcategoryService;
import com.ssm.mty.util.uuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


/**
 * 用户Service接口实现类
 * @author: mty
 */
@Service("tcategoryService")
@Transactional
public class TcategoryServiceImpl implements TcategoryService {

    @Autowired
    private TcategoryDao tcategoryDao;


    //分页查询
    @Override
    public PageInfo<Tcategory> findPageInfo(Integer pageIndex, Integer pageSize) {
        PageInfo<Tcategory> pi = new PageInfo<Tcategory>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = tcategoryDao.totalCount();
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            //按条件查询
            List<Tcategory> tcategoryList =	tcategoryDao.getTcategoryList((pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(tcategoryList);
        }
        return pi;
    }


    //添加
    @Override
    public int addTcategory(Tcategory tcategory) {
        tcategory.setId(uuid.getRandomIdByUUID());
        return tcategoryDao.addTcategory(tcategory);
    }


    //根据id删除
    @Override
    public int deleteTcategory(Integer id) {
        return tcategoryDao.deleteTcategory(id);
    }


    //修改宿舍信息
    @Override
    public int updateTcategory(Tcategory tcategory) {
        return tcategoryDao.updateTcategory(tcategory);
    }

    //根据ID查询
    @Override
    public Tcategory findTcategoryById (Integer id){
        Tcategory d = tcategoryDao.findTcategoryById(id);
        return  d;
    }

    //查询所有
    @Override
    public List<Tcategory> getAll(){
        List<Tcategory> tcategoryList = tcategoryDao.getAll();
        return tcategoryList;
    }


}
