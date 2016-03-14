package com.gxkj.projects.myshopx.services;

import com.gxkj.common.exceptions.ValidateException;
import com.gxkj.common.utils.ListPager;
import com.gxkj.projects.myshopx.entitys.Category;
import com.gxkj.projects.myshopx.entitys.User;

/**
 * Created by xubaoyong on 2016/3/14.
 */
public interface CategoryService {

    public void doAddCategory(User user , Category entity) throws ValidateException;

    public void doUpdateCategory(User user , Category entity) throws ValidateException;

    public void doDeleteCategory(User user, String categoryId);

    public ListPager<Category> doPageHQL(int pagenNo, int pageSize, Category entity);

    public Category getById(String id);
}
