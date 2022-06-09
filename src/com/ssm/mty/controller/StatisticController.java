package com.ssm.mty.controller;

import com.ssm.mty.po.PageInfo;
import com.ssm.mty.po.QueryVO;
import com.ssm.mty.po.Tcategory;
import com.ssm.mty.po.Tuser;
import com.ssm.mty.service.TcategoryService;
import com.ssm.mty.service.TinputService;
import com.ssm.mty.service.TpurchaseService;
import com.ssm.mty.service.TuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 控制层
 * @author: mty
 */
@Controller
public class StatisticController {

    // 依赖注入
    @Autowired
    private TpurchaseService tpurchaseService;
    @Autowired
    private TinputService tinputService;

    /**
     * 统计
     */
    @RequestMapping(value = "/findDoc")
    public String findDoc(Model model,HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute("ad") == null){
            session.setAttribute("msg", "对不起，请登录！");
            return "login";
        }
        List<QueryVO> all = tpurchaseService.queryPur();
        List<String> nameArr = new ArrayList<String>();
        List<String> valueArr = new ArrayList<String>();
        for(int i=0;i<all.size();i++){
            nameArr.add("'"+all.get(i).getName()+"'");
            valueArr.add("'"+all.get(i).getQua()+"'");
        }
        List<QueryVO> queryStatistic = tinputService.queryStatistic();
        List<String> nameArr1 = new ArrayList<String>();
        List<String> valueArr1 = new ArrayList<String>();
        for(int i=0;i<queryStatistic.size();i++){
            nameArr1.add("'"+queryStatistic.get(i).getName()+"'");
            valueArr1.add("'"+queryStatistic.get(i).getQua()+"'");
        }
        model.addAttribute("nameArr", nameArr);
        model.addAttribute("valueArr",valueArr);
        model.addAttribute("nameArr1", nameArr1);
        model.addAttribute("valueArr1",valueArr1);
        return "statistic";
    }


}
