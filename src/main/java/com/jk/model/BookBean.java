package com.jk.model;

import javax.persistence.*;


@Entity
@Table(name = "t_boot")
public class BookBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;//主鍵
    private String name;//图书名
    private String author;//作者
    private String createTime;//出版时间
    private Double price;//价格

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", createTime='" + createTime + '\'' +
                ", price=" + price +
                '}';
    }
}
