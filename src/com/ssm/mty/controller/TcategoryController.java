package com.ssm.mty.controller;

import com.ssm.mty.po.Tcategory;
import com.ssm.mty.po.PageInfo;
import com.ssm.mty.service.TcategoryService;
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
public class TcategoryController {

    // 依赖注入
    @Autowired
    private TcategoryService tcategoryService;


    /**
     * 分页查询
     * pageIndex 当前页码
     * pageSize  显示条数
     */
    @RequestMapping(value = "/findTcategory")
    public String findTcategory(Integer pageIndex, Integer pageSize, Model model,HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute("ad") == null){
            session.setAttribute("msg", "对不起，请登录！");
            return "login";
        }
        PageInfo<Tcategory> pageList = tcategoryService.findPageInfo(pageIndex,pageSize);
        model.addAttribute("pageList",pageList);
        return "TcategoryList";
    }


    /**
     * 添加
     */
    @RequestMapping(value = "/addTcategory" ,method = RequestMethod.POST)
    @ResponseBody
    public String addTcategory( @RequestBody Tcategory tcategory) {
        List<Tcategory> all = tcategoryService.getAll();
        for(int i=0;i<all.size();i++){
            if(all.get(i).getCode().equals(tcategory.getCode())){
                return "400";
            }
        }
        int d = tcategoryService.addTcategory(tcategory);
        return "TcategoryList";
    }


    /**
     * 删除
     */
    @RequestMapping( "/deleteTcategory")
    @ResponseBody
    public String deleteTcategory(Integer id) {
        int d = tcategoryService.deleteTcategory(id);
        return "TcategoryList";
    }


    /**
     * 修改
     */
    @RequestMapping( "/updateTcategory")
    public String updateTcategory( Tcategory tcategory) {
        int d = tcategoryService.updateTcategory(tcategory);
        return "redirect:/findTcategory";
    }


    /**
     * 按照ID查询
     */
    @RequestMapping( "/findTcategoryById")
    public String findTcategoryById(Integer id,Model model,HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute("ad") == null){
            session.setAttribute("msg", "对不起，请登录！");
            return "login";
        }
        Tcategory tcategory= tcategoryService.findTcategoryById(id);
        model.addAttribute("tcategory",tcategory);
        return "TcategoryEdit";
    }


}
