package com.gxkj.projects.myshopx.dao;


import com.gxkj.common.utils.ListPager;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2016/1/23.
 */
@Component
public class BaseRepositoryImpl     {
    Logger LOG = LoggerFactory.getLogger(BaseRepositoryImpl.class);
    @Autowired
    public SessionFactory sessionFactory;


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public SessionFactory getSessionFactory() {

        return sessionFactory;
    }

    public <T> T selectById(Serializable id, Class<?> clazz)  {
        return (T) sessionFactory.getCurrentSession().get(clazz, id);
    }

    public   void insert(final Object entity)   {
        sessionFactory.getCurrentSession().save(entity);
    }

    public   void delete(Object entity) throws SQLException {
        sessionFactory.getCurrentSession().delete(entity);

    }

    public  void update(Object entity) throws SQLException {
        //sessionFactory.getCurrentSession().clear();
        sessionFactory.getCurrentSession().update(entity);
    }

    public <T> List<T> selectByHQL(String hql) throws SQLException {
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    public  <T>List<T> selectPage(String hql, ListPager pager)
            throws SQLException {

        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setFirstResult((pager.getPageNo() - 1) * pager.getRowsPerPage());
        query.setMaxResults(pager.getRowsPerPage());
        return query.list();
    }




    public Object selectOneByHQL(String hql) throws SQLException {
        Query q = sessionFactory.getCurrentSession().createQuery(hql);
        q.setFirstResult(0);
        q.setMaxResults(1);
        List<Object> entitys = q.list();
        return entitys == null?null:entitys.size()>=1?entitys.get(0):null;
    }


    public int executeUpdateBySql(String sql) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        Query q = session.createSQLQuery(sql);
        return q.executeUpdate();
    }


    public int executeUpdateByHql(String hql) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(hql).executeUpdate();
    }

    protected  String getCounthql(String hql){
        StringBuffer counthql = new StringBuffer("") ;
        if(hql.indexOf("distinct")>0 && hql.indexOf(",")<=0)
            counthql.append("select count("+hql.substring(hql.indexOf("distinct"), hql.indexOf("from"))+") as _count "+hql.substring(hql.indexOf("from"), hql.length()));
        else
            counthql.append("select count(*) as _count "+hql.substring(hql.indexOf("from"), hql.length()));
        return counthql.toString();
    }
    public <T> T selectOneBySQL(String sql,Class<?> clazz, Map<String, Object> parameters) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        SQLQuery query = session.createSQLQuery(sql);
        if(parameters != null){
            for (String key : parameters.keySet()) {
                query.setParameter(key, parameters.get(key));
            }
        }
        if(clazz != null  ){
            this._transFormResult(query, clazz);
        }else{
            query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        }
        query.setFirstResult(0);
        query.setMaxResults(1);
        List<T> entitys = query.list();
        return entitys == null?null:  (entitys.size() >= 1 ? entitys.get(0) : null);
    }

    public void deleteById(Serializable  id,Class<?> clazz) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.get(clazz, id) );
    }


    public <T> List<T> selectByHQL(String hql, Map<String, Object> parameters)  {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        if (parameters != null){
            for (String key : parameters.keySet()) {
                query.setParameter(key, parameters.get(key));
            }
        }
        return query.list();
    }


    public <T> ListPager selectPageByHql(String hql, Map<String, Object> param,
                                     ListPager pager) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        Query countQuery = session.createQuery(getCounthql(hql));
        if (param != null){
            for (String key : param.keySet()) {
                countQuery.setParameter(key, param.get(key));
            }
        }
        List<Long> temp = countQuery.list();
        long totalRows = temp!=null&&temp.size()>0?temp.get(0):0L;
        pager.setTotalRows(totalRows);
        if(totalRows == 0){
            pager.setPageData(null);
            return pager;
        }
        List<T> pageData = this.selectPageByHQL(hql,param,
                (pager.getPageNo()-1)*pager.getRowsPerPage(),pager.getRowsPerPage());
        pager.setPageData(pageData);
        return pager;
    }


    public <T> List<T> selectPageByHQL(String hql, Map<String, Object> param,
                                   int from, int to) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        if(param != null){
            for (String key : param.keySet()) {
                query.setParameter(key, param.get(key));
            }
        }
        query.setFirstResult(from);
        query.setMaxResults(to);
        return query.list();
    }

    public int executeUpdateByHql(String hql, Map<String, Object> parameter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        if(parameter != null){
            for (String key : parameter.keySet()) {
                query.setParameter(key, parameter.get(key));
            }
        }

        return query.executeUpdate();

    }

    private void _transFormResult(SQLQuery query,Class<?> clazz){
        if(clazz.getName().equals("java.util.HashMap")){
            query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        }else{
          //  query.setResultTransformer(new HibernateResultTransformer(clazz));
            query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        }
    }

    public static void main(String[] args) {
//		Map n = new HashMap();
//		System.out.println(n.getClass().getName());
    }



    public  ListPager selectPageBySQL(String sql, Map<String, Object> param,
                                     Class<?> clazz, ListPager pager) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        String countSql = this.getCounthql(sql);
        SQLQuery countQuery = session.createSQLQuery(countSql);
        if(param != null){
            for (String key : param.keySet()) {
                countQuery.setParameter(key, param.get(key));
            }
        }
        BigInteger totalRows = (BigInteger) countQuery.uniqueResult();
        pager.setTotalRows(totalRows.longValue());
        if(totalRows.intValue() == 0){
            pager.setPageData(null);
            return pager;
        }
         List  pageData = this.selectPageBySQL(sql,param,
                (pager.getPageNo()-1)*pager.getRowsPerPage(),pager.getRowsPerPage(),clazz);
        pager.setPageData(pageData);
        return pager;

    }
    public <T>List<T> selectPageBySQL(String sql, Map<String, Object> param,
                                   int from, int limit, Class<T> clazz) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        SQLQuery query = session.createSQLQuery(sql);
        if(param != null){
            for (String key : param.keySet()) {
                query.setParameter(key, param.get(key));
            }
        }
        query.setFirstResult(from);
        query.setMaxResults(limit);
        if(clazz != null  ){
            this._transFormResult(query, clazz);
        }else{
            query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        }
        return query.list();
    }



    public <T> T selectOneByHQL(String hql, Map<String, Object> parameters)
            throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        if(parameters != null){
            for (String key : parameters.keySet()) {
                query.setParameter(key, parameters.get(key));
            }
        }
        query.setFirstResult(0);
        query.setMaxResults(1);
        List<T> entitys = query.list();
        return entitys == null?null:entitys.size()>=1?entitys.get(0):null;
    }


}
