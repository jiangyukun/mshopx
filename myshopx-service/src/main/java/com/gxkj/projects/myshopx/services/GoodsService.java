package com.gxkj.projects.myshopx.services;

import com.gxkj.common.utils.ListPager;
import com.gxkj.projects.myshopx.entitys.Goods;
import com.gxkj.projects.myshopx.entitys.User;

/**
 * Created by dell on 2016/3/5.
 */
public interface GoodsService {

    public void doAddGoods(User user , Goods goods);

    public void doUpdateGoods(User user , Goods goods);

    public void doDeleteGoods(User user, String goodsId);

    public ListPager<Goods> doPageHQL(Goods goods, int pagenNo, int pageSize);
}
