package com.gxkj.projects.myshopx.services.impl;

import com.gxkj.common.exceptions.ValidateException;
import com.gxkj.common.utils.ListPager;
import com.gxkj.common.utils.ValidatorUtil;
import com.gxkj.projects.myshopx.dao.BrandDaoImpl;
import com.gxkj.projects.myshopx.dao.CategoryDaoImpl;
import com.gxkj.projects.myshopx.entitys.Brand;
import com.gxkj.projects.myshopx.entitys.Category;
import com.gxkj.projects.myshopx.entitys.User;
import com.gxkj.projects.myshopx.enums.CategoryState;
import com.gxkj.projects.myshopx.services.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;

@Service
public class CategoryServiceImpl implements CategoryService {
    Logger LOG = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    private ValidatorUtil validatorUtil;

    @Autowired
    private CategoryDaoImpl categoryDao;

    public void doAddCategory(User user, Category entity) throws ValidateException {
        entity.setCreatedAt(new Date());
        entity.setUpdatedAt(new Date());
        entity.setStates(CategoryState.NORMAL);
        validatorUtil.validate(entity,true);
        categoryDao.insert(entity);
    }


    public void doUpdateCategory(User user, Category entity) throws ValidateException {
        Category dbentity = categoryDao.selectById((Serializable) entity.getId(),Category.class);

        entity.setCreatedAt(dbentity.getCreatedAt());
        entity.setUpdatedAt(new Date());
        validatorUtil.validate(entity,true);
        categoryDao.updateByMerge(entity);
    }


    public void doDeleteCategory(User user, String categoryId) {
        Category dbentity = categoryDao.selectById(categoryId,Category.class);
        dbentity.setStates(CategoryState.DEL);
        categoryDao.updateByMerge(dbentity);
    }


    public ListPager<Category> doPageHQL(int pagenNo, int pageSize, Category entity) {
        return categoryDao.doPageHQL(pagenNo,pageSize,entity);
    }


    public Category getById(String id) {
        Category dbentity = categoryDao.selectById(id,Category.class);
        return dbentity;
    }
}
