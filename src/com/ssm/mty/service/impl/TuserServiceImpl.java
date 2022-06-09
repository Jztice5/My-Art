package com.ssm.mty.service.impl;

import com.ssm.mty.dao.TuserDao;
import com.ssm.mty.po.Tuser;
import com.ssm.mty.po.PageInfo;
import com.ssm.mty.service.TuserService;
import com.ssm.mty.util.uuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


/**
 * 用户Service接口实现类
 * @author: mty
 */
@Service("tuserService")
@Transactional
public class TuserServiceImpl implements TuserService {

    @Autowired
    private TuserDao tuserDao;


    //分页查询
    @Override
    public PageInfo<Tuser> findPageInfo(Integer pageIndex, Integer pageSize,String username,String type) {
        PageInfo<Tuser> pi = new PageInfo<Tuser>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = tuserDao.totalCount(username,type);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            //按条件查询
            List<Tuser> tuserList =	tuserDao.getTuserList((pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize(),username,type);
            pi.setList(tuserList);
        }
        return pi;
    }


    //添加
    @Override
    public int addTuser(Tuser tuser) {
        tuser.setId(uuid.getRandomIdByUUID());
        return tuserDao.addTuser(tuser);
    }


    //根据id删除
    @Override
    public int deleteTuser(Integer id) {
        return tuserDao.deleteTuser(id);
    }


    //修改宿舍信息
    @Override
    public int updateTuser(Tuser tuser) {
        return tuserDao.updateTuser(tuser);
    }

    //根据ID查询
    @Override
    public Tuser findTuserById (Integer id){
        Tuser d = tuserDao.findTuserById(id);
        return  d;
    }

    //查询所有
    @Override
    public List<Tuser> getAll(){
        List<Tuser> tuserList = tuserDao.getAll();
        return tuserList;
    }

    //根据用户名、密码、类型查询
    @Override
    public Tuser findUser (String username,String password,String type){
        Tuser d = tuserDao.findUser(username,password,type);
        return  d;
    }

    //根据人员类型查询
    @Override
    public List<Tuser> getUserByType(String type){
        List<Tuser> tuserList = tuserDao.getUserByType(type);
        return tuserList;
    }
}
