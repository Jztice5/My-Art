package com.ssm.mty.service.impl;

import com.ssm.mty.dao.TpurchaseDao;
import com.ssm.mty.po.QueryVO;
import com.ssm.mty.po.Tpurchase;
import com.ssm.mty.po.PageInfo;
import com.ssm.mty.service.TpurchaseService;
import com.ssm.mty.util.uuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


/**
 * 用户Service接口实现类
 * @author: mty
 */
@Service("tpurchaseService")
@Transactional
public class TpurchaseServiceImpl implements TpurchaseService {

    @Autowired
    private TpurchaseDao tpurchaseDao;


    //分页查询
    @Override
    public PageInfo<Tpurchase> findPageInfo(Integer pageIndex, Integer pageSize,String material,String category) {
        PageInfo<Tpurchase> pi = new PageInfo<Tpurchase>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = tpurchaseDao.totalCount(material,category);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            //按条件查询
            List<Tpurchase> tpurchaseList =	tpurchaseDao.getTpurchaseList((pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize(),material,category);
            pi.setList(tpurchaseList);
        }
        return pi;
    }


    //添加
    @Override
    public int addTpurchase(Tpurchase tpurchase) {
        tpurchase.setId(uuid.getRandomIdByUUID());
        return tpurchaseDao.addTpurchase(tpurchase);
    }


    //根据id删除
    @Override
    public int deleteTpurchase(Integer id) {
        return tpurchaseDao.deleteTpurchase(id);
    }


    //修改宿舍信息
    @Override
    public int updateTpurchase(Tpurchase tpurchase) {
        return tpurchaseDao.updateTpurchase(tpurchase);
    }

    //根据ID查询
    @Override
    public Tpurchase findTpurchaseById (Integer id){
        Tpurchase d = tpurchaseDao.findTpurchaseById(id);
        return  d;
    }

    //查询所有
    @Override
    public List<Tpurchase> getAll(){
        List<Tpurchase> tpurchaseList = tpurchaseDao.getAll();
        return tpurchaseList;
    }

    //对采购分组统计
    @Override
    public List<QueryVO> queryPur(){
        List<QueryVO> tpurchaseList = tpurchaseDao.queryPur();
        return tpurchaseList;
    }

}
