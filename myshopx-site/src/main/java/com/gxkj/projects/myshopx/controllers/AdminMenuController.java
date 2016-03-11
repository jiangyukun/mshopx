package com.gxkj.projects.myshopx.controllers;

import com.gxkj.common.exceptions.ValidateException;
import com.gxkj.projects.myshopx.dto.ReturnData;
import com.gxkj.projects.myshopx.entitys.AdminMenu;
import com.gxkj.projects.myshopx.enums.ErrorCodeEnum;
import com.gxkj.projects.myshopx.services.AdminMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

 

@Controller
@RequestMapping("/admin/menu")
public class AdminMenuController {
	private static final Logger LOG = LoggerFactory.getLogger(AdminMenuController.class);
	@Autowired
	private AdminMenuService adminMenuService;
	
	@RequestMapping(value="")
	public String index(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
		String mv = "admin/adminmenu";
		return mv;
	}

	@RequestMapping(value="my",method= RequestMethod.GET)
	@ResponseBody
	public ReturnData<List<AdminMenu>> mymenu(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
		ReturnData<List<AdminMenu>> returnData = new ReturnData<List<AdminMenu>>();
		List<AdminMenu> myAdminMenu = adminMenuService.getAllAdminMenu();
		returnData.setEntity(myAdminMenu);
		returnData.setStatusCode(ErrorCodeEnum.NORMAL.getCode());
		return returnData;
	}
	
	@ResponseBody
	@RequestMapping("/list")
	public ReturnData<List<AdminMenu>>   getList( HttpServletRequest request,
			HttpServletResponse response,
    		ModelMap modelMap)  {
		ReturnData<List<AdminMenu>> returnData = new ReturnData<List<AdminMenu>>();
		List<AdminMenu> myAdminMenu = adminMenuService.getAllAdminMenu();
		returnData.setEntity(myAdminMenu);
		returnData.setStatusCode(ErrorCodeEnum.NORMAL.getCode());
		return returnData;
	}
	
	@ResponseBody
	@RequestMapping("/doadd")
	public ReturnData<AdminMenu>  doAdd( HttpServletRequest request,
			HttpServletResponse response,
										  AdminMenu entity,
    		ModelMap modelMap) throws ValidateException {
		ReturnData<AdminMenu> returnData = new ReturnData<AdminMenu>();


		adminMenuService.doAddAdminMenu( null,entity);
		returnData.setEntity(entity);
		returnData.setStatusCode(ErrorCodeEnum.NORMAL.getCode());
		return returnData;
	}
	@ResponseBody
	@RequestMapping("/doupdate")
	public ReturnData<AdminMenu>  doUpdate( HttpServletRequest request,
			HttpServletResponse response,
			AdminMenu entity, 
    		ModelMap modelMap) throws ValidateException {
		ReturnData<AdminMenu> returnData = new ReturnData<AdminMenu>();
		adminMenuService.doUpdateAdminMenu( null,entity);
		returnData.setEntity(entity);
		returnData.setStatusCode(ErrorCodeEnum.NORMAL.getCode());
		return returnData;
	}
	@ResponseBody
	@RequestMapping("/dodel")
	public ReturnData<Boolean>  dodel( HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("id") String id,
    		ModelMap modelMap)  {
		ReturnData<Boolean> returnData = new ReturnData<Boolean>();
		adminMenuService.doDeleteAdminMenu(null,id);
		returnData.setEntity(true);
		returnData.setStatusCode(ErrorCodeEnum.NORMAL.getCode());
		return returnData;
	}

}
