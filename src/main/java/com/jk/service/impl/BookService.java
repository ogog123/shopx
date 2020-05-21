package com.jk.service.impl;

import com.jk.model.BookBean;

import java.util.Map;

public interface BookService {
    Map<String, Object> findBookList(Integer page, Integer rows, BookBean bookBean);

    void addOrEditBoot(BookBean bookBean);

    BookBean queryBootById(Integer id);
}
