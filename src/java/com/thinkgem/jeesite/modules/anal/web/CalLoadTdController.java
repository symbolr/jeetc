/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.anal.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.anal.entity.CalLoadTd;
import com.thinkgem.jeesite.modules.anal.service.CalLoadTdService;

/**
 * 负荷分析Controller
 * @author 沈波
 * @version 2017-06-02
 */
@Controller
@RequestMapping(value = "${adminPath /anal/calLoadTd")
public class CalLoadTdController extends BaseController {

	@Autowired
	private CalLoadTdService calLoadTdService;
	
	@ModelAttribute
	public CalLoadTd get(@RequestParam(required=false) String id) {
		CalLoadTd entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = calLoadTdService.get(id);
		}
		if (entity == null){
			entity = new CalLoadTd();
		}
		return entity;
	}
	
	@RequiresPermissions("anal:calLoadTd:view")
	@RequestMapping(value = {"list", ""})
	public String list(CalLoadTd calLoadTd, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CalLoadTd> page = calLoadTdService.findPage(new Page<CalLoadTd>(request, response), calLoadTd); 
		model.addAttribute("page", page);
		return "modules/anal/calLoadTdList";
	}

	@RequiresPermissions("anal:calLoadTd:view")
	@RequestMapping(value = "form")
	public String form(CalLoadTd calLoadTd, Model model) {
		model.addAttribute("calLoadTd", calLoadTd);
		return "modules/anal/calLoadTdForm";
	}

	@RequiresPermissions("anal:calLoadTd:edit")
	@RequestMapping(value = "save")
	public String save(CalLoadTd calLoadTd, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, calLoadTd)){
			return form(calLoadTd, model);
		}
		calLoadTdService.save(calLoadTd);
		addMessage(redirectAttributes, "保存负荷成功");
		return "redirect:"+Global.getAdminPath()+"/anal/calLoadTd/?repage";
	}
	
	@RequiresPermissions("anal:calLoadTd:edit")
	@RequestMapping(value = "delete")
	public String delete(CalLoadTd calLoadTd, RedirectAttributes redirectAttributes) {
		calLoadTdService.delete(calLoadTd);
		addMessage(redirectAttributes, "删除负荷成功");
		return "redirect:"+Global.getAdminPath()+"/anal/calLoadTd/?repage";
	}

}