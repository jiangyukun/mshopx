package com.gxkj.projects.myshopx.controllers.admin;

import com.gxkj.common.exceptions.ValidateException;
import com.gxkj.common.utils.ListPager;
import com.gxkj.projects.myshopx.dto.ReturnData;
import com.gxkj.projects.myshopx.entitys.Brand;
import com.gxkj.projects.myshopx.enums.ErrorCodeEnum;
import com.gxkj.projects.myshopx.services.BrandService;
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
@RequestMapping("/admin/brand")
public class AdminBrandController {

    private static final Logger LOG = LoggerFactory.getLogger(AdminBrandController.class);

    @Autowired
    private BrandService brandService;

    @RequestMapping(value="")
    public String index(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
        String mv = "admin/admin_brand";
        return mv;
    }

    @RequestMapping(value="dopage",method= RequestMethod.GET)
    @ResponseBody
    public ReturnData<ListPager<Brand>> dopage(Brand entity,
                                               int pageno, int pagesize,
                                               HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){

        ReturnData<ListPager<Brand>> returnData = new ReturnData<ListPager<Brand>>();
        ListPager<Brand> pager =  brandService.doPageHQL(pageno,pagesize,entity);
        returnData.setEntity(pager);
        returnData.setStatusCode(ErrorCodeEnum.NORMAL.getCode());
        return returnData;

    }
    @RequestMapping(value="doadd",method= RequestMethod.POST)
    @ResponseBody
    public  ReturnData<Brand>doAdd(Brand entity,
                                  HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws ValidateException {

        ReturnData<Brand> returnData = new ReturnData<Brand>();
        brandService.doAddBrand(null,entity);
        returnData.setEntity(entity);
        returnData.setStatusCode(ErrorCodeEnum.NORMAL.getCode());
        return returnData;
    }

    @RequestMapping(value="get",method= RequestMethod.GET)
    @ResponseBody
    public  ReturnData<Brand>get(String id,
                                HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws ValidateException {

        ReturnData<Brand> returnData = new ReturnData<Brand>();
        Brand entity = brandService.getById(id);
        returnData.setEntity(entity);
        returnData.setStatusCode(ErrorCodeEnum.NORMAL.getCode());
        return returnData;
    }

    @RequestMapping(value="doupdate",method= RequestMethod.POST)
    @ResponseBody
    public  ReturnData<Brand>doupdate(Brand entity ,
                                     HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws ValidateException {

        ReturnData<Brand> returnData = new ReturnData<Brand>();
        brandService.doUpdateBrand(null,entity);
        returnData.setEntity(entity);
        returnData.setStatusCode(ErrorCodeEnum.NORMAL.getCode());
        return returnData;
    }
    @RequestMapping(value="dodel",method= RequestMethod.POST)
    @ResponseBody
    public  ReturnData<Boolean>dodel(String id,
                                 HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws ValidateException {

        ReturnData<Boolean> returnData = new ReturnData<Boolean>();
        brandService.doDeleteBrand(null,id);
        returnData.setEntity(true);
        returnData.setStatusCode(ErrorCodeEnum.NORMAL.getCode());
        return returnData;
    }


}
