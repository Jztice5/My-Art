package com.ssm.mty.service.impl;

import com.ssm.mty.dao.TinputDao;
import com.ssm.mty.po.QueryVO;
import com.ssm.mty.po.Tinput;
import com.ssm.mty.po.PageInfo;
import com.ssm.mty.service.TinputService;
import com.ssm.mty.util.uuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * 用户Service接口实现类
 * @author: mty
 */
@Service("tinputService")
@Transactional
public class TinputServiceImpl implements TinputService {

    @Autowired
    private TinputDao tinputDao;


    //分页查询
    @Override
    public PageInfo<Tinput> findPageInfo(Integer pageIndex, Integer pageSize,String category,String material) {
        PageInfo<Tinput> pi = new PageInfo<Tinput>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = tinputDao.totalCount(category,material);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            //按条件查询
            List<Tinput> tinputList =	tinputDao.getTinputList((pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize(),category,material);
            pi.setList(tinputList);
        }
        return pi;
    }


    //添加
    @Override
    public int addTinput(Tinput tinput) {
        tinput.setId(uuid.getRandomIdByUUID());
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(date);
        tinput.setRegisterTime(time);
        return tinputDao.addTinput(tinput);
    }


    //根据id删除
    @Override
    public int deleteTinput(Integer id) {
        return tinputDao.deleteTinput(id);
    }


    //修改宿舍信息
    @Override
    public int updateTinput(Tinput tinput) {
        return tinputDao.updateTinput(tinput);
    }

    //根据ID查询
    @Override
    public Tinput findTinputById (Integer id){
        Tinput d = tinputDao.findTinputById(id);
        return  d;
    }

    //查询所有
    @Override
    public List<Tinput> getAll(){
        List<Tinput> tinputList = tinputDao.getAll();
        return tinputList;
    }

    //入库数量统计
    @Override
    public List<QueryVO> queryStatistic(){
        List<QueryVO> queryStatistic = tinputDao.queryStatistic();
        return queryStatistic;
    }
}
