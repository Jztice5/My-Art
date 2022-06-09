package com.ssm.mty.controller;

import com.ssm.mty.po.Tcategory;
import com.ssm.mty.po.Tpurchase;
import com.ssm.mty.po.PageInfo;
import com.ssm.mty.po.Tuser;
import com.ssm.mty.service.TcategoryService;
import com.ssm.mty.service.TpurchaseService;
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
public class TpurchaseController {

    // 依赖注入
    @Autowired
    private TpurchaseService tpurchaseService;

    @Autowired
    private TcategoryService tcategoryService;


    /**
     * 分页查询
     * pageIndex 当前页码
     * pageSize  显示条数
     */
    @RequestMapping(value = "/findTpurchase")
    public String findTpurchase(Integer pageIndex, Integer pageSize,String material,String category, Model model,HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute("ad") == null){
            session.setAttribute("msg", "对不起，请登录！");
            return "login";
        }
        PageInfo<Tpurchase> pageList = tpurchaseService.findPageInfo(pageIndex,pageSize,material,category);
        List<Tcategory> allCategory = tcategoryService.getAll();
        model.addAttribute("pageList",pageList);
        model.addAttribute("allCategory",allCategory);
        return "TpurchaseList";
    }


    /**
     * 添加
     */
    @RequestMapping(value = "/addTpurchase" ,method = RequestMethod.POST)
    @ResponseBody
    public String addTpurchase( @RequestBody Tpurchase tpurchase,HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute("ad") == null){
            session.setAttribute("msg", "对不起，请登录！");
            return "login";
        }
        Tuser tuser = (Tuser) session.getAttribute("ad");
        tpurchase.setPurseId(tuser.getId());
        int d = tpurchaseService.addTpurchase(tpurchase);
        return "TpurchaseList";
    }


    /**
     * 删除
     */
    @RequestMapping( "/deleteTpurchase")
    @ResponseBody
    public String deleteTpurchase(Integer id) {
        int d = tpurchaseService.deleteTpurchase(id);
        return "TpurchaseList";
    }


    /**
     * 修改
     */
    @RequestMapping( "/updateTpurchase")
    public String updateTpurchase( Tpurchase tpurchase) {
        int d = tpurchaseService.updateTpurchase(tpurchase);
        return "redirect:/findTpurchase";
    }


    /**
     * 按照ID查询
     */
    @RequestMapping( "/findTpurchaseById")
    public String findTpurchaseById(Integer id,Model model,HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute("ad") == null){
            session.setAttribute("msg", "对不起，请登录！");
            return "login";
        }
        Tpurchase tpurchase= tpurchaseService.findTpurchaseById(id);
        List<Tcategory> allCategory = tcategoryService.getAll();
        model.addAttribute("allCategory",allCategory);
        model.addAttribute("tpurchase",tpurchase);
        return "TpurchaseEdit";
    }


}
