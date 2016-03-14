package com.gxkj.projects.myshopx.services;

import com.gxkj.common.exceptions.ValidateException;
import com.gxkj.common.utils.ListPager;
import com.gxkj.projects.myshopx.entitys.Brand;
import com.gxkj.projects.myshopx.entitys.User;

/**
 * Created by xubaoyong on 2016/3/14.
 */
public interface BrandService {

    public void doAddBrand(User user , Brand entity) throws ValidateException;

    public void doUpdateBrand(User user , Brand entity) throws ValidateException;

    public void doDeleteBrand(User user, String brandId);

    public ListPager<Brand> doPageHQL(int pagenNo, int pageSize, Brand brand);

    public Brand getById(String id);
}
