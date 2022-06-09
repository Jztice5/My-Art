package com.ssm.mty.controller;

import com.ssm.mty.po.Taccount;
import com.ssm.mty.po.PageInfo;
import com.ssm.mty.po.Tcategory;
import com.ssm.mty.po.Tuser;
import com.ssm.mty.service.TaccountService;
import com.ssm.mty.service.TcategoryService;
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
public class TaccountController {

    // 依赖注入
    @Autowired
    private TaccountService taccountService;
    @Autowired
    private TcategoryService tcategoryService;
    @Autowired
    private TuserService tuserService;

    /**
     * 分页查询
     * pageIndex 当前页码
     * pageSize  显示条数
     */
    @RequestMapping(value = "/findTaccount")
    public String findTaccount(Integer pageIndex, Integer pageSize, Model model,HttpServletRequest request,String category,String material) {
        HttpSession session = request.getSession();
        if(session.getAttribute("ad") == null){
            session.setAttribute("msg", "对不起，请登录！");
            return "login";
        }
        PageInfo<Taccount> pageList = taccountService.findPageInfo(pageIndex,pageSize,category,material);
        List<Tcategory> allCategory = tcategoryService.getAll();
        List<Tuser> userByType1 = tuserService.getUserByType("02");
        List<Tuser> userByType2 = tuserService.getUserByType("04");
        model.addAttribute("userByType1",userByType1);
        model.addAttribute("userByType2",userByType2);
        model.addAttribute("allCategory",allCategory);
        model.addAttribute("pageList",pageList);
        return "TaccountList";
    }

    /**
     * 根据采购员ID分页查询
     * pageIndex 当前页码
     * pageSize  显示条数
     */
    @RequestMapping(value = "/findTaccountPerson")
    public String findTaccountPerson(Integer pageIndex, Integer pageSize, Model model,HttpServletRequest request,String category,String material) {
        HttpSession session = request.getSession();
        if(session.getAttribute("ad") == null){
            session.setAttribute("msg", "对不起，请登录！");
            return "login";
        }
        Tuser tuser = (Tuser) session.getAttribute("ad");
        PageInfo<Taccount> pageList = taccountService.findTaccountPerson(pageIndex,pageSize,category,material,tuser.getId());
        List<Tcategory> allCategory = tcategoryService.getAll();
        List<Tuser> userByType1 = tuserService.getUserByType("02");
        List<Tuser> userByType2 = tuserService.getUserByType("04");
        model.addAttribute("userByType1",userByType1);
        model.addAttribute("userByType2",userByType2);
        model.addAttribute("allCategory",allCategory);
        model.addAttribute("pageList",pageList);
        return "TaccountList";
    }

    /**
     * 添加
     */
    @RequestMapping(value = "/addTaccount" ,method = RequestMethod.POST)
    @ResponseBody
    public String addTaccount( @RequestBody Taccount taccount) {
        int d = taccountService.addTaccount(taccount);
        return "TaccountList";
    }


    /**
     * 删除
     */
    @RequestMapping( "/deleteTaccount")
    @ResponseBody
    public String deleteTaccount(Integer id) {
        int d = taccountService.deleteTaccount(id);
        return "TaccountList";
    }

    /**
     * 更改状态
     */
    @RequestMapping( "/accountPut")
    @ResponseBody
    public String accountPut(String id,String status) {
        int d = taccountService.accountPut(id,status);
        return "ToutputList";
    }

    /**
     * 修改
     */
    @RequestMapping( "/updateTaccount")
    public String updateTaccount( Taccount taccount) {
        int d = taccountService.updateTaccount(taccount);
        return "redirect:/findTaccount";
    }


    /**
     * 按照ID查询
     */
    @RequestMapping( "/findTaccountById")
    public String findTaccountById(Integer id,Model model,HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute("ad") == null){
            session.setAttribute("msg", "对不起，请登录！");
            return "login";
        }
        Taccount taccount= taccountService.findTaccountById(id);
        model.addAttribute("taccount",taccount);
        List<Tcategory> allCategory = tcategoryService.getAll();
        List<Tuser> userByType1 = tuserService.getUserByType("02");
        List<Tuser> userByType2 = tuserService.getUserByType("03");
        model.addAttribute("userByType1",userByType1);
        model.addAttribute("userByType2",userByType2);
        model.addAttribute("allCategory",allCategory);
        return "TaccountEdit";
    }


}
