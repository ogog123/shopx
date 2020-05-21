package com.jk.service.impl;


import com.jk.dao.BookDao;
import com.jk.model.BookBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.druid.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    public Map<String, Object> findBookList(Integer page, Integer rows, BookBean bookBean) {
        //封装条查sql带有占位符参数
        Map<String, Object> paramSql = searchSql(bookBean);

        String searchSql = paramSql.get("sql").toString();

        paramSql.remove("sql");

        //查询总记录数
        String countHql = "select count(1) from BookBean where 1=1 " + searchSql;
        Long orderCount = bookDao.selectBootCount(countHql, paramSql);

        //查询列表
        String listHql = "from BookBean where 1=1 " + searchSql;

        paramSql.put("start", (page-1)*rows);
        paramSql.put("rows", rows);
        List<BookBean> bootList = bookDao.selectBootList(listHql, paramSql);

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("total", orderCount);
        resultMap.put("rows", bootList);

        return resultMap;
    }

    public void addOrEditBoot(BookBean bookBean) {
        bookDao.addOrEditBoot(bookBean);
    }

    public BookBean queryBootById(Integer id) {
        return bookDao.queryBootById(id);
    }

    private Map<String, Object> searchSql(BookBean bookBean){
        StringBuffer sb = new StringBuffer("");
        Map<String, Object> paramMap = new HashMap<String, Object>();
        if(bookBean != null){
            if(!StringUtils.isEmpty(bookBean.getName())){
                sb.append(" and name = :aaa ");
                paramMap.put("aaa", bookBean.getName());
            }
        }
        paramMap.put("sql", sb.toString());
        return paramMap;
    }

    }