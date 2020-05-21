package com.jk.action;

import com.jk.model.BookBean;
import com.jk.service.impl.BookService;
import com.jk.utils.BaseAction;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;


@Results(
        {
        @Result(name = "success", location = "BookList.html"),
        @Result(name = "bootInfo", location = "../orderAddOrEdit.html")
        }
)
@Namespace("/user")
public class BookAction extends BaseAction {

    @Autowired
    private BookService bookService;

    private BookBean bookBean = new BookBean();
    private Integer page;
    private Integer rows;
    private String ids;


    @Action(value = "toUserListPage")
    public String toUserListPage() {

        return SUCCESS;
    }

    @Action(value = "toUpdateBoot")
    public String toUpdateBoot(){
        System.out.println(bookBean.getId());
        return "bootInfo";
    }

    //查询分页
    @Action(value = "findBookList")
    public void findBookList(){
        Map<String,Object> book= bookService.findBookList(page,rows,bookBean);
        outJson(book);
    }

    /**
     * 新增与修改
     */
    @Action(value = "/addOrEditBoot")
    public void addOrEditOrder(){
        bookService.addOrEditBoot(bookBean);
        outJson(1);
    }

    /**
     * 回显
     */
    @Action(value = "queryBootById")
    public void queryBootById(){
        bookBean = bookService.queryBootById(bookBean.getId());

        outJson(bookBean);
    }


    public BookService getBookService() {
        return bookService;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    public BookBean getBookBean() {
        return bookBean;
    }

    public void setBookBean(BookBean bookBean) {
        this.bookBean = bookBean;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }


    @Override
    public String toString() {
        return "BookAction{" +
                "bookService=" + bookService +
                ", bookBean=" + bookBean +
                ", page=" + page +
                ", rows=" + rows +
                ", ids='" + ids + '\'' +
                '}';
    }
}
