package com.gxkj.common.hibernate;


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
import java.util.List;
import java.util.Map;

/**
 * 泛型知识参考：http://qiemengdao.iteye.com/blog/1525624
 */
@Component
public class HibernateBaseRepositoryImpl {
    Logger LOG = LoggerFactory.getLogger(HibernateBaseRepositoryImpl.class);
    @Autowired
    public SessionFactory sessionFactory;


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public <T> T selectById(Serializable id, T t) {
        return (T) sessionFactory.getCurrentSession().get(t.getClass(), id);
    }

    public <T> void insert(final T entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    public <T> void delete(T entity)   {
        sessionFactory.getCurrentSession().delete(entity);
    }

    public <T> void update(T entity)   {
        //sessionFactory.getCurrentSession().clear();
        sessionFactory.getCurrentSession().update(entity);
    }

    public <T> T selectFirstOneByHQL(String hql, Map<String, Object> parameters)   {
        Query q = sessionFactory.getCurrentSession().createQuery(hql);
        if (parameters != null) {
            for (String key : parameters.keySet()) {
                q.setParameter(key, parameters.get(key));
            }
        }
        q.setFirstResult(0);
        q.setMaxResults(1);
        List<T> entitys = q.list();
        return entitys == null ? null : entitys.size() >= 1 ? entitys.get(0) : null;
    }
    public <T> T selectLastOneByHQL(String hql, Map<String, Object> parameters)   {
        Query q = sessionFactory.getCurrentSession().createQuery(hql);
        if (parameters != null) {
            for (String key : parameters.keySet()) {
                q.setParameter(key, parameters.get(key));
            }
        }
        q.setFirstResult(0);
        q.setMaxResults(1);
        List<T> entitys = q.list();
        return entitys == null ? null : entitys.size() >= 1 ? entitys.get(entitys.size()-1) : null;
    }

    public <T> T selectFirstOneBySQL(String sql, T t, Map<String, Object> parameters)  {
        Session session = sessionFactory.getCurrentSession();
        SQLQuery query = session.createSQLQuery(sql);
        if (parameters != null) {
            for (String key : parameters.keySet()) {
                query.setParameter(key, parameters.get(key));
            }
        }
        if (t != null) {
            this._transFormResult(query, t.getClass());
        } else {
            query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        }
        query.setFirstResult(0);
        query.setMaxResults(1);
        List<T> entitys = query.list();
        return entitys == null ? null : (entitys.size() >= 1 ? entitys.get(0) : null);
    }
    public <T> T selectLastOneBySQL(String sql, T t, Map<String, Object> parameters)   {
        Session session = sessionFactory.getCurrentSession();
        SQLQuery query = session.createSQLQuery(sql);
        if (parameters != null) {
            for (String key : parameters.keySet()) {
                query.setParameter(key, parameters.get(key));
            }
        }
        if (t != null) {
            this._transFormResult(query, t.getClass());
        } else {
            query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        }
        query.setFirstResult(0);
        query.setMaxResults(1);
        List<T> entitys = query.list();
        return entitys == null ? null : (entitys.size() >= 1 ? entitys.get(entitys.size()-1) : null);
    }

    public int executeUpdateBySql(String sql, Map<String, Object> parameters) {
        Session session = sessionFactory.getCurrentSession();
        Query q = session.createSQLQuery(sql);
        if (parameters != null) {
            for (String key : parameters.keySet()) {
                q.setParameter(key, parameters.get(key));
            }
        }
        return q.executeUpdate();
    }

    public int executeUpdateByHql(String sql, Map<String, Object> parameter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(sql);
        if (parameter != null) {
            for (String key : parameter.keySet()) {
                query.setParameter(key, parameter.get(key));
            }
        }
        return query.executeUpdate();
    }

    /**
     * 查询列表
     * @param hql
     * @param parameters
     * @param <T>
     * @return
     */
    public <T> List<T> selectListByHQL(String hql, Map<String, Object> parameters) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        if (parameters != null) {
            for (String key : parameters.keySet()) {
                query.setParameter(key, parameters.get(key));
            }
        }
        return query.list();
    }
    public <T> List<T> selectListBySQL(String sql, Map<String, Object> parameters,T t) {
        Session session = sessionFactory.getCurrentSession();
        SQLQuery query = session.createSQLQuery(sql);
        if (parameters != null) {
            for (String key : parameters.keySet()) {
                query.setParameter(key, parameters.get(key));
            }
        }
        if (t != null) {
            this._transFormResult(query, t.getClass());
        } else {
            query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        }
        return query.list();
    }
    /**
     * 分页查询1
     * @param hql
     * @param startNo
     * @param limit
     * @param <T>
     * @return
     * @throws SQLException
     */
    public <T> List<T> selectLimitPageByHQL(String hql,Map<String, Object> parameters, int startNo,int limit) {
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setFirstResult(startNo);
        query.setMaxResults(startNo+limit);
        if (parameters != null) {
            for (String key : parameters.keySet()) {
                query.setParameter(key, parameters.get(key));
            }
        }
        return query.list();
    }

    public <T> List<T> selectLimitPageBySQL(String sql, Map<String, Object> param,
                                       int startNo, int limit, Class<T> clazz)  {
        Session session = sessionFactory.getCurrentSession();
        SQLQuery query = session.createSQLQuery(sql);
        if (param != null) {
            for (String key : param.keySet()) {
                query.setParameter(key, param.get(key));
            }
        }
        query.setFirstResult(startNo);
        query.setMaxResults(limit);

        if(clazz != null  ){
            this._transFormResult(query, clazz);
        }else{
            query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        }
        return query.list();
    }

    public <T> ListPager<T> selectPageByHql(String hql, Map<String, Object> param,  ListPager<T> pager) {
        Session session = sessionFactory.getCurrentSession();
        Query countQuery = session.createQuery(getCounthql(hql));
        if (param != null) {
            for (String key : param.keySet()) {
                countQuery.setParameter(key, param.get(key));
            }
        }

        Long totalRows = (Long) countQuery.uniqueResult();
        pager.setTotalRows(totalRows.longValue());
        if (totalRows.intValue() == 0) {
            pager.setPageData(null);
            return pager;
        }
        List<T> pageData = this.selectLimitPageByHQL(hql, param,
                (pager.getPageNo() - 1) * pager.getRowsPerPage(), pager.getRowsPerPage());
        pager.setPageData(pageData);
        return pager;
    }
    public <T> void selectPageBySQL(String sql, Map<String, Object> param, ListPager<T> pager, Class<T> t) {
        Session session = sessionFactory.getCurrentSession();
        String countSql = this.getCounthql(sql);
        SQLQuery countQuery = session.createSQLQuery(countSql);
        if (param != null) {
            for (String key : param.keySet()) {
                countQuery.setParameter(key, param.get(key));
            }
        }
        BigInteger totalRows = (BigInteger) countQuery.uniqueResult();
        pager.setTotalRows(totalRows.longValue());
        if (totalRows.intValue() == 0) {
            pager.setPageData(null);
            return ;
        }
        List pageData = this.selectLimitPageBySQL(sql, param,
                (pager.getPageNo() - 1) * pager.getRowsPerPage(), pager.getRowsPerPage(), t);
        pager.setPageData(pageData);
        return ;

    }


    protected String getCounthql(String hql) {
        StringBuffer counthql = new StringBuffer("");
        if (hql.indexOf("distinct") > 0 && hql.indexOf(",") <= 0)
            counthql.append("select count(" + hql.substring(hql.indexOf("distinct"), hql.indexOf("from")) + ") as _count " + hql.substring(hql.indexOf("from"), hql.length()));
        else
            counthql.append("select count(*) as _count " + hql.substring(hql.indexOf("from"), hql.length()));
        return counthql.toString();
    }



    public <T> void deleteById(Serializable id, T t)  {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.get(t.getClass(), id));
    }



    private <T> void _transFormResult(SQLQuery query, Class<T> clazz) {
        if (clazz.getName().equals("java.util.HashMap")) {
            query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        } else {
            //  query.setResultTransformer(new HibernateResultTransformer(clazz));
            //Transformers.aliasToBean(UserEntity.class)
            query.setResultTransformer(new HibernateToBeanResultTransformer(clazz));
        }
    }





}
