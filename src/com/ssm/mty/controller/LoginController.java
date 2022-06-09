package com.ssm.mty.controller;


import com.ssm.mty.po.Tuser;
import com.ssm.mty.service.TuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 登录控制器
 */
@Controller
public class LoginController {

	// 依赖注入
	@Autowired
	private TuserService tuserService;

    /**
     * 去登录
     */
    @RequestMapping(value = "/gologin")
    public String gologin() {
        return "login";
    }

	/**
	 * 登录
	 * 将提交数据(username,password)写入Admin对象
	 */
	@RequestMapping(value = "/login")
	public String login(Tuser user, Model model, HttpSession session, HttpServletRequest request) {
		if(user.getUsername()==null || user.getUsername().length()<=0 ){
			model.addAttribute("msg", "请输入登录名！");
			return "login";
		}
		if(user.getPassword()==null || user.getPassword().length()<1){
			model.addAttribute("msg", "请输入密码！");
			return "login";
		}
		if(user.getType()==null || user.getType().length()<1){
			model.addAttribute("msg", "请选择人员类型！");
			return "login";
		}
		if(user.getType().equals("01")){
			Tuser ad = tuserService.findUser(user.getUsername(),user.getPassword(),"01");
			if(ad!=null){
				session.setAttribute("ad", ad);
				session.setAttribute("type", "01");
				return "homepage1";
			}else{
				model.addAttribute("msg", "请确定账户信息是否正确！");
				return "login";
			}
		}else if(user.getType().equals("02")){
			Tuser ad = tuserService.findUser(user.getUsername(),user.getPassword(),"02");
			if(ad!=null){
				session.setAttribute("ad", ad);
				session.setAttribute("type", "02");
				return "homepage2";
			}else{
				model.addAttribute("msg", "请确定账户信息是否正确！");
				return "login";
			}
		}else if(user.getType().equals("03")){
			Tuser ad = tuserService.findUser(user.getUsername(),user.getPassword(),"03");
			if(ad!=null){
				session.setAttribute("ad", ad);
				session.setAttribute("type", "03");
				return "homepage3";
			}else{
				model.addAttribute("msg", "请确定账户信息是否正确！");
				return "login";
			}
		}else{
			Tuser ad = tuserService.findUser(user.getUsername(),user.getPassword(),"04");
			if(ad!=null){
				session.setAttribute("ad", ad);
				session.setAttribute("type", "04");
				return "homepage4";
			}else{
				model.addAttribute("msg", "请确定账户信息是否正确！");
				return "login";
			}
		}
	}

	/**
	 * 退出登录
	 */
	@RequestMapping(value = "/loginOut")
	public String loginOut(HttpSession session) {
		session.invalidate();
		return "login";
	}


	/**
	 * 查询个人信息
	 */
	@RequestMapping(value = "/info")
	public String info(Tuser tuser, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("ad") == null){
			session.setAttribute("msg", "对不起，请登录！");
			return "login";
		}
		return "queryInfo";
	}



	/**
	 * 进入修改
	 */
	@RequestMapping(value = "/updateInfo")
	public String updateInfo(Tuser tuser, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("ad") == null){
			session.setAttribute("msg", "对不起，请登录！");
			return "login";
		}
		return "updateInfo";
	}



	/**
	 * 修改信息
	 */
	@RequestMapping( value = "/updateInfoAdmin", method = RequestMethod.POST)
	@ResponseBody
	public String updateInfoAdmin(Tuser tuser,Model model,HttpServletRequest request,HttpSession session1) {
		HttpSession session = request.getSession();
		if(session.getAttribute("ad") == null){
			session.setAttribute("msg", "对不起，请登录！");
			return "202";
		}
		if(tuser.getUsername().length()<1){
			return "203";
		}
		if(tuser.getPassword().length()<1){
			return "204";
		}
		if(!isMobile(tuser.getPhone())){
			return "205";
		}
		Tuser tuser1 = (Tuser) session.getAttribute("ad");
		if(!tuser1.getPassword().equals(tuser.getPassword())){
			return "201";
		}
		if(!"".equals(tuser.getPasswords())){
			tuser.setPassword(tuser.getPasswords());
		}
		int a = tuserService.updateTuser(tuser);
		return "200";
	}


	/**
	 * 前往注册
	 */
	@RequestMapping(value = "/register")
	public String register(Model model, HttpSession session) {
		return "register";
	}



	/**
	 * 注册校验
	 */
	@RequestMapping(value = "/registerSub")
	public String registerSub( Tuser tuser, Model model, HttpSession session, HttpServletRequest request) {
		List<Tuser> adminList = tuserService.getAll();
		for(int i = 0;i<adminList.size();i++){
			if(adminList.get(i).getUsername().equals(tuser.getUsername())){
				model.addAttribute("msg", "用户名重复，请重新输入！");
				return "register";
			}
		}
		if(tuser.getUsername()==null || tuser.getUsername().equals("")){
			model.addAttribute("msg", "用户名未填写！");
            return "register";
		}
		if(tuser.getPassword()==null || tuser.getPassword().length()<6){
			model.addAttribute("msg", "密码不能为空且大约6位！");
            return "register";
		}
		tuserService.addTuser(tuser);
		model.addAttribute("msg", "注册成功,请前往登录！");
		return "login";
	}

	/**
	 * 判断是否是手机号
	 *
	 * @param mobile
	 * @return
	 */
	public static boolean isMobile(String mobile) {
		String regex = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$";
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(mobile);
		return m.matches();
	}


}
