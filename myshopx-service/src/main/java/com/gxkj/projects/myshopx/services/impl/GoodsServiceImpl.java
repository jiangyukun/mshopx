package com.gxkj.projects.myshopx.services.impl;

import com.gxkj.common.utils.ListPager;
import com.gxkj.projects.myshopx.dao.GoodsDaoImpl;
import com.gxkj.projects.myshopx.entitys.Goods;
import com.gxkj.projects.myshopx.entitys.User;
import com.gxkj.projects.myshopx.services.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl  implements GoodsService {

    @Autowired
    private  GoodsDaoImpl goodsDao;

    public void doAddGoods(User user, Goods goods) {
        goodsDao.insert(goods);
    }


    public void doUpdateGoods(User user, Goods goods) {
        goodsDao.update(goods);
    }


    public void doDeleteGoods(User user, String goodsId) {
        goodsDao.deleteById(goodsId,Goods.class);
    }


    public ListPager<Goods> doPageHQL(Goods goods, int pagenNo, int pageSize) {
        return goodsDao.doPageHQL(goods, pagenNo, pageSize);
    }
}
