package org.example.managebook.Controller;

import org.example.managebook.dao.BookDao;
import org.example.managebook.model.BookInfo;
import org.example.managebook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/getBookList")
    public List<BookInfo> getBookList() {
        //BookService bookService = new BookService();
        return bookService.getBookList();
    }
}
