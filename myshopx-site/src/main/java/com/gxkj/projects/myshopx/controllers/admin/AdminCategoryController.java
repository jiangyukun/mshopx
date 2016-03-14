package com.gxkj.projects.myshopx.controllers.admin;

import com.gxkj.common.exceptions.ValidateException;
import com.gxkj.common.utils.ListPager;
import com.gxkj.projects.myshopx.dto.ReturnData;
import com.gxkj.projects.myshopx.entitys.Brand;
import com.gxkj.projects.myshopx.entitys.Category;
import com.gxkj.projects.myshopx.enums.ErrorCodeEnum;
import com.gxkj.projects.myshopx.services.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/admin/category")
public class AdminCategoryController {

    private static final Logger LOG = LoggerFactory.getLogger(AdminCategoryController.class);

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value="")
    public String index(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
        String mv = "admin/admin_brand";
        return mv;
    }

    @RequestMapping(value="dopage",method= RequestMethod.GET)
    @ResponseBody
    public ReturnData<ListPager<Category>> dopage(Category entity,
                                                  int pageno, int pagesize,
                                                  HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){

        ReturnData<ListPager<Category>> returnData = new ReturnData<ListPager<Category>>();
        ListPager<Category> pager =  categoryService.doPageHQL(pageno,Integer.MAX_VALUE,entity);
        returnData.setEntity(pager);
        returnData.setStatusCode(ErrorCodeEnum.NORMAL.getCode());
        return returnData;

    }
    @RequestMapping(value="doadd",method= RequestMethod.POST)
    @ResponseBody
    public  ReturnData<Category>doAdd(Category entity,
                                   HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws ValidateException {

        ReturnData<Category> returnData = new ReturnData<Category>();
        categoryService.doAddCategory(null,entity);
        returnData.setEntity(entity);
        returnData.setStatusCode(ErrorCodeEnum.NORMAL.getCode());
        return returnData;
    }

    @RequestMapping(value="get",method= RequestMethod.GET)
    @ResponseBody
    public  ReturnData<Category>get(String id,
                                 HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws ValidateException {

        ReturnData<Category> returnData = new ReturnData<Category>();
        Category entity = categoryService.getById(id);
        returnData.setEntity(entity);
        returnData.setStatusCode(ErrorCodeEnum.NORMAL.getCode());
        return returnData;
    }

    @RequestMapping(value="doupdate",method= RequestMethod.POST)
    @ResponseBody
    public  ReturnData<Category>doupdate(Category entity ,
                                      HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws ValidateException {

        ReturnData<Category> returnData = new ReturnData<Category>();
        categoryService.doUpdateCategory(null,entity);
        returnData.setEntity(entity);
        returnData.setStatusCode(ErrorCodeEnum.NORMAL.getCode());
        return returnData;
    }
    @RequestMapping(value="dodel",method= RequestMethod.POST)
    @ResponseBody
    public  ReturnData<Boolean>dodel(String id,
                                     HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws ValidateException {

        ReturnData<Boolean> returnData = new ReturnData<Boolean>();
        categoryService.doDeleteCategory(null,id);
        returnData.setEntity(true);
        returnData.setStatusCode(ErrorCodeEnum.NORMAL.getCode());
        return returnData;
    }
}
