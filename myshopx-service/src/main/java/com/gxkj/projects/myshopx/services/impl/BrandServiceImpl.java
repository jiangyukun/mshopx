package com.gxkj.projects.myshopx.services.impl;

import com.gxkj.common.exceptions.ValidateException;
import com.gxkj.common.utils.ListPager;
import com.gxkj.common.utils.ValidatorUtil;
import com.gxkj.projects.myshopx.dao.BrandDaoImpl;
import com.gxkj.projects.myshopx.entitys.Brand;
import com.gxkj.projects.myshopx.entitys.User;
import com.gxkj.projects.myshopx.services.BrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;

@Service
public class BrandServiceImpl implements BrandService {
    Logger LOG = LoggerFactory.getLogger(BrandServiceImpl.class);

    @Autowired
    private ValidatorUtil validatorUtil;

    @Autowired
    private BrandDaoImpl brandDao;

    @Override
    public void doAddBrand(User user, Brand entity) throws ValidateException {

        entity.setCreatedAt(new Date());
        entity.setUpdatedAt(new Date());

        validatorUtil.validate(entity,true);
        brandDao.insert(entity);
    }


    public void doUpdateBrand(User user, Brand entity) throws ValidateException {
        Brand dbentity = brandDao.selectById((Serializable) entity.getId(),Brand.class);

        entity.setCreatedAt(dbentity.getCreatedAt());
        entity.setUpdatedAt(new Date());
        validatorUtil.validate(entity,true);
        brandDao.updateByMerge(entity);
    }


    public void doDeleteBrand(User user, String brandId) {

            brandDao.deleteById(brandId,Brand.class);
    }


    public ListPager<Brand> doPageHQL(int pagenNo, int pageSize, Brand brand) {
        return brandDao.doPageHQL(pagenNo,pageSize,brand);
    }


    public Brand getById(String id) {
        Brand dbentity = brandDao.selectById(id,Brand.class);
        return dbentity;
    }
}
