package com.ssm.mty.service.impl;

import com.ssm.mty.dao.ToutputDao;
import com.ssm.mty.po.Toutput;
import com.ssm.mty.po.PageInfo;
import com.ssm.mty.service.ToutputService;
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
@Service("toutputService")
@Transactional
public class ToutputServiceImpl implements ToutputService {

    @Autowired
    private ToutputDao toutputDao;


    //分页查询
    @Override
    public PageInfo<Toutput> findPageInfo(Integer pageIndex, Integer pageSize,String category,String material) {
        PageInfo<Toutput> pi = new PageInfo<Toutput>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = toutputDao.totalCount(category,material);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            //按条件查询
            List<Toutput> toutputList =	toutputDao.getToutputList((pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize(),category,material);
            pi.setList(toutputList);
        }
        return pi;
    }


    //添加
    @Override
    public int addToutput(Toutput toutput) {
        toutput.setId(uuid.getRandomIdByUUID());
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(date);
        toutput.setApplyTime(time);
        toutput.setApplyStatus("01");
        return toutputDao.addToutput(toutput);
    }


    //根据id删除
    @Override
    public int deleteToutput(Integer id) {
        return toutputDao.deleteToutput(id);
    }

    //更改状态
    @Override
    public int closePut(String id,String status) {
        return toutputDao.closePut(id,status);
    }

    //修改宿舍信息
    @Override
    public int updateToutput(Toutput toutput) {
        return toutputDao.updateToutput(toutput);
    }

    //根据ID查询
    @Override
    public Toutput findToutputById (Integer id){
        Toutput d = toutputDao.findToutputById(id);
        return  d;
    }

    //查询所有
    @Override
    public List<Toutput> getAll(){
        List<Toutput> toutputList = toutputDao.getAll();
        return toutputList;
    }


}
