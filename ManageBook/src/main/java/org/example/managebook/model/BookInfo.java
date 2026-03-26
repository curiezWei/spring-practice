package org.example.managebook.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookInfo {
    private Integer id;
    private String bookName;
    private String author;
    private Integer quantity;
    private BigDecimal price;
    private String publisherName;
    private Integer status;//1可借阅，2不可借阅
    private String statusCN;
}
