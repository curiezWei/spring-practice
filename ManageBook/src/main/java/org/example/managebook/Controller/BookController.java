package org.example.managebook.Controller;

import org.example.managebook.dao.BookDao;
import org.example.managebook.model.BookInfo;
import org.example.managebook.service.BookService;
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
        BookService bookService = new BookService();
        return bookService.getBookList();
    }
}
