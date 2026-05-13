package org.example.managebook.Controller;

import lombok.extern.slf4j.Slf4j;
import org.example.managebook.model.BookInfo;
import org.example.managebook.model.PageRequest;
import org.example.managebook.model.PageResult;
import org.example.managebook.model.UserInfo;
import org.example.managebook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/addBook")
    public String addBook(BookInfo bookInfo)throws Exception {
        log.info("添加图书，接收到参数：bookInfo:{}",bookInfo);
        if(!StringUtils.hasLength(bookInfo.getBookName())||
                !StringUtils.hasLength(bookInfo.getAuthor())||
                !StringUtils.hasLength(bookInfo.getPublish())||
                bookInfo.getCount()==null||
                bookInfo.getPrice()==null||
                bookInfo.getStatus()==null
        ) {
            log.info("添加图书的参数有误");
            return "添加图书的参数有误";
        }

        Integer result = bookService.insertBook(bookInfo);
        if(result>0) {
            return "";
        }else {
            return "添加失败";
        }
    }

    @RequestMapping("/getBookListByPage")
    public PageResult<BookInfo> getBookListByPage(PageRequest pageRequest) {
        log.info("查询图书页数 "+pageRequest);
        return bookService.getBookListByPage(pageRequest);
    }

    @RequestMapping("/queryBookById")
    public BookInfo queryBookById(Integer bookId) {
        log.info("查询图书信息" +bookId);
        return bookService.queryBookById(bookId);
    }

    @RequestMapping("/updateBook")
    public String updateBook(BookInfo bookInfo) {
        log.info("更新图书"+bookInfo);
        try {
            Integer result =  bookService.updateBookById(bookInfo);
            if(result>0) {
                return "";
            }
            return "内部错误，请联系我";
        }catch (Exception e) {
            log.error("更新失败，e：",e);
            return "内部错误，请联系我";
        }
    }

    @RequestMapping("/deleteBook")
    public String deleteBook(Integer bookId) {
        log.info("更新图书" + bookId);
        try {
            Integer result = bookService.deleteBookById(bookId);
            if (result > 0) {
                return "";
            }
            return "内部错误，请联系我";
        } catch (Exception e) {
            log.error("更新失败，e：", e);
            return "内部错误，请联系我";
        }
    }

    public String batchDeleteBookByIds(List<Integer> ids) {
        log.info("批量删除图书");
    }
}
