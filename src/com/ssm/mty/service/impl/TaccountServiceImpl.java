package com.ssm.mty.service.impl;

import com.ssm.mty.dao.TaccountDao;
import com.ssm.mty.po.Taccount;
import com.ssm.mty.po.PageInfo;
import com.ssm.mty.service.TaccountService;
import com.ssm.mty.util.uuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


/**
 * 用户Service接口实现类
 * @author: mty
 */
@Service("taccountService")
@Transactional
public class TaccountServiceImpl implements TaccountService {

    @Autowired
    private TaccountDao taccountDao;


    //分页查询
    @Override
    public PageInfo<Taccount> findPageInfo(Integer pageIndex, Integer pageSize,String category,String material) {
        PageInfo<Taccount> pi = new PageInfo<Taccount>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = taccountDao.totalCount(category,material);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            //按条件查询
            List<Taccount> taccountList =	taccountDao.getTaccountList((pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize(),category,material);
            pi.setList(taccountList);
        }
        return pi;
    }

    //根据ID分页查询
    @Override
    public PageInfo<Taccount> findTaccountPerson(Integer pageIndex, Integer pageSize,String category,String material,String id) {
        PageInfo<Taccount> pi = new PageInfo<Taccount>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = taccountDao.totalCount1(category,material,id);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            //按条件查询
            List<Taccount> taccountList =	taccountDao.getTaccountList1((pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize(),category,material,id);
            pi.setList(taccountList);
        }
        return pi;
    }

    //添加
    @Override
    public int addTaccount(Taccount taccount) {
        taccount.setId(uuid.getRandomIdByUUID());
        taccount.setStatus("01");
        return taccountDao.addTaccount(taccount);
    }


    //根据id删除
    @Override
    public int deleteTaccount(Integer id) {
        return taccountDao.deleteTaccount(id);
    }

    //更改状态
    @Override
    public int accountPut(String id,String status) {
        return taccountDao.accountPut(id,status);
    }

    //修改宿舍信息
    @Override
    public int updateTaccount(Taccount taccount) {
        return taccountDao.updateTaccount(taccount);
    }

    //根据ID查询
    @Override
    public Taccount findTaccountById (Integer id){
        Taccount d = taccountDao.findTaccountById(id);
        return  d;
    }

    //查询所有
    @Override
    public List<Taccount> getAll(){
        List<Taccount> taccountList = taccountDao.getAll();
        return taccountList;
    }


}
