package org.example.managebook;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @RequestMapping("/getBookList")
    public List<BookInfo> getBookList(){
        List<BookInfo> bookInfoList = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            //没有数据库先写死
            BookInfo bookInfo = new BookInfo();
            bookInfo.setId(i);
            bookInfo.setBookName("图书"+i);
            bookInfo.setAuthor("作者"+i);
            bookInfo.setQuantity(i*2+2);
            bookInfo.setPrice(new BigDecimal(i*3));
            bookInfo.setPublisherName("出版社"+i);
            if(i%7==0){
                bookInfo.setStatus(1);
                bookInfo.setStatusCN("可借阅");
            }else{
                bookInfo.setStatus(2);
                bookInfo.setStatusCN("不可借阅");
            }
            bookInfoList.add(bookInfo);
        }
        return bookInfoList;
    }
}
