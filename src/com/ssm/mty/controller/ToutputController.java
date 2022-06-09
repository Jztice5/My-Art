package com.ssm.mty.controller;

import com.ssm.mty.po.Tcategory;
import com.ssm.mty.po.Toutput;
import com.ssm.mty.po.PageInfo;
import com.ssm.mty.po.Tuser;
import com.ssm.mty.service.TcategoryService;
import com.ssm.mty.service.ToutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @description: 控制层
 * @author: mty
 */
@Controller
public class ToutputController {

    // 依赖注入
    @Autowired
    private ToutputService toutputService;
    @Autowired
    private TcategoryService tcategoryService;

    /**
     * 分页查询
     * pageIndex 当前页码
     * pageSize  显示条数
     */
    @RequestMapping(value = "/findToutput")
    public String findToutput(Integer pageIndex, Integer pageSize, Model model,HttpServletRequest request,String category,String material) {
        HttpSession session = request.getSession();
        if(session.getAttribute("ad") == null){
            session.setAttribute("msg", "对不起，请登录！");
            return "login";
        }
        PageInfo<Toutput> pageList = toutputService.findPageInfo(pageIndex,pageSize,category,material);
        List<Tcategory> allCategory = tcategoryService.getAll();
        model.addAttribute("allCategory",allCategory);
        model.addAttribute("pageList",pageList);
        return "ToutputList";
    }


    /**
     * 添加
     */
    @RequestMapping(value = "/addToutput" ,method = RequestMethod.POST)
    @ResponseBody
    public String addToutput( @RequestBody Toutput toutput,HttpServletRequest request) {
        int d = toutputService.addToutput(toutput);
        return "ToutputList";
    }


    /**
     * 删除
     */
    @RequestMapping( "/deleteToutput")
    @ResponseBody
    public String deleteToutput(Integer id) {
        int d = toutputService.deleteToutput(id);
        return "ToutputList";
    }


    /**
     * 更改状态
     */
    @RequestMapping( "/closePut")
    @ResponseBody
    public String closePut(String id,String status) {
        int d = toutputService.closePut(id,status);
        return "ToutputList";
    }

    /**
     * 修改
     */
    @RequestMapping( "/updateToutput")
    public String updateToutput( Toutput toutput) {
        int d = toutputService.updateToutput(toutput);
        return "redirect:/findToutput";
    }


    /**
     * 按照ID查询
     */
    @RequestMapping( "/findToutputById")
    public String findToutputById(Integer id,Model model,HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute("ad") == null){
            session.setAttribute("msg", "对不起，请登录！");
            return "login";
        }
        Toutput toutput= toutputService.findToutputById(id);
        model.addAttribute("toutput",toutput);
        List<Tcategory> allCategory = tcategoryService.getAll();
        model.addAttribute("allCategory",allCategory);
        return "ToutputEdit";
    }


}
