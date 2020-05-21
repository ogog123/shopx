package com.jk.dao;

import com.jk.model.BookBean;

import java.util.List;
import java.util.Map;

public interface BookDao {
    Long selectBootCount(String countHql, Map<String, Object> paramSql);

    List<BookBean> selectBootList(String listHql, Map<String, Object> paramSql);

    void addOrEditBoot(BookBean bookBean);

    BookBean queryBootById(Integer id);
}
