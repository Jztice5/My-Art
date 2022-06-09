package com.ssm.mty.controller;

import com.ssm.mty.po.Tuser;
import com.ssm.mty.po.PageInfo;
import com.ssm.mty.service.TuserService;
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
public class TuserController {

    // 依赖注入
    @Autowired
    private TuserService tuserService;


    /**
     * 分页查询
     * pageIndex 当前页码
     * pageSize  显示条数
     */
    @RequestMapping(value = "/findTuser")
    public String findTuser(Integer pageIndex, Integer pageSize,String username,String type, Model model,HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute("ad") == null){
            session.setAttribute("msg", "对不起，请登录！");
            return "login";
        }
        PageInfo<Tuser> pageList = tuserService.findPageInfo(pageIndex,pageSize,username,type);
        model.addAttribute("pageList",pageList);
        return "TuserList";
    }


    /**
     * 添加
     */
    @RequestMapping(value = "/addTuser" ,method = RequestMethod.POST)
    @ResponseBody
    public String addTuser( @RequestBody Tuser tuser) {
        int d = tuserService.addTuser(tuser);
        return "TuserList";
    }


    /**
     * 删除
     */
    @RequestMapping( "/deleteTuser")
    @ResponseBody
    public String deleteTuser(Integer id) {
        int d = tuserService.deleteTuser(id);
        return "TuserList";
    }


    /**
     * 修改
     */
    @RequestMapping( "/updateTuser")
    public String updateTuser( Tuser tuser) {
        int d = tuserService.updateTuser(tuser);
        return "redirect:/findTuser";
    }


    /**
     * 按照ID查询
     */
    @RequestMapping( "/findTuserById")
    public String findTuserById(Integer id,Model model,HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute("ad") == null){
            session.setAttribute("msg", "对不起，请登录！");
            return "login";
        }
        Tuser tuser= tuserService.findTuserById(id);
        model.addAttribute("tuser",tuser);
        return "TuserEdit";
    }


}
