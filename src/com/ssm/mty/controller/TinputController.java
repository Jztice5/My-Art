package com.ssm.mty.controller;

import com.ssm.mty.po.Tcategory;
import com.ssm.mty.po.Tinput;
import com.ssm.mty.po.PageInfo;
import com.ssm.mty.po.Tuser;
import com.ssm.mty.service.TcategoryService;
import com.ssm.mty.service.TinputService;
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
public class TinputController {

    // 依赖注入
    @Autowired
    private TinputService tinputService;
    @Autowired
    private TcategoryService tcategoryService;
    @Autowired
    private TuserService tuserService;

    /**
     * 分页查询
     * pageIndex 当前页码
     * pageSize  显示条数
     */
    @RequestMapping(value = "/findTinput")
    public String findTinput(Integer pageIndex, Integer pageSize, Model model,HttpServletRequest request,String category,String material) {
        HttpSession session = request.getSession();
        if(session.getAttribute("ad") == null){
            session.setAttribute("msg", "对不起，请登录！");
            return "login";
        }
        PageInfo<Tinput> pageList = tinputService.findPageInfo(pageIndex,pageSize,category,material);
        List<Tcategory> allCategory = tcategoryService.getAll();
        List<Tuser> userByType = tuserService.getUserByType("02");
        model.addAttribute("allCategory",allCategory);
        model.addAttribute("userByType",userByType);
        model.addAttribute("pageList",pageList);
        return "TinputList";
    }


    /**
     * 添加
     */
    @RequestMapping(value = "/addTinput" ,method = RequestMethod.POST)
    @ResponseBody
    public String addTinput( @RequestBody Tinput tinput,HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute("ad") == null){
            session.setAttribute("msg", "对不起，请登录！");
            return "login";
        }
        Tuser tuser = (Tuser) session.getAttribute("ad");
        tinput.setRegisterId(tuser.getId());
        int d = tinputService.addTinput(tinput);
        return "TinputList";
    }


    /**
     * 删除
     */
    @RequestMapping( "/deleteTinput")
    @ResponseBody
    public String deleteTinput(Integer id) {
        int d = tinputService.deleteTinput(id);
        return "TinputList";
    }


    /**
     * 修改
     */
    @RequestMapping( "/updateTinput")
    public String updateTinput( Tinput tinput) {
        int d = tinputService.updateTinput(tinput);
        return "redirect:/findTinput";
    }


    /**
     * 按照ID查询
     */
    @RequestMapping( "/findTinputById")
    public String findTinputById(Integer id,Model model,HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute("ad") == null){
            session.setAttribute("msg", "对不起，请登录！");
            return "login";
        }
        List<Tcategory> allCategory = tcategoryService.getAll();
        List<Tuser> userByType = tuserService.getUserByType("02");
        model.addAttribute("allCategory",allCategory);
        model.addAttribute("userByType",userByType);
        Tinput tinput= tinputService.findTinputById(id);
        model.addAttribute("tinput",tinput);
        return "TinputEdit";
    }


}
