package com.jk.dao.impl;

import com.jk.dao.BookDao;
import com.jk.model.BookBean;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;


    public Long selectBootCount(String countHql, Map<String, Object> paramSql) {
        Query query = sessionFactory.getCurrentSession().createQuery(countHql);
        Iterator<Map.Entry<String, Object>> it = paramSql.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<String, Object> entry = it.next();
            query.setParameter(entry.getKey(), entry.getValue());
        }
        Long count = (Long)query.getSingleResult();
        return count;
    }

    public List<BookBean> selectBootList(String listHql, Map<String, Object> paramSql) {
        Query query = sessionFactory.getCurrentSession().createQuery(listHql);

        query.setFirstResult(Integer.parseInt(paramSql.get("start").toString()));
        query.setMaxResults(Integer.parseInt(paramSql.get("rows").toString()));

        paramSql.remove("start");
        paramSql.remove("rows");

        Iterator<Map.Entry<String, Object>> it = paramSql.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<String, Object> entry = it.next();
            // 只设置占位符参数
            query.setParameter(entry.getKey(), entry.getValue());
        }

        return query.getResultList();
    }

    public void addOrEditBoot(BookBean bookBean) {
        sessionFactory.getCurrentSession().saveOrUpdate(bookBean);
    }

    public BookBean queryBootById(Integer id) {
        return sessionFactory.getCurrentSession().get(BookBean.class,id);
    }
}
