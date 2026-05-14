package org.example.managebook.service;

import org.example.managebook.constant.BookStatus;
import org.example.managebook.mapper.BookMapper;
import org.example.managebook.model.BookInfo;
import org.example.managebook.model.PageRequest;
import org.example.managebook.model.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;


    public Integer insertBook(BookInfo bookInfo) {
        return bookMapper.insertBook(bookInfo);
    }

    public PageResult<BookInfo> getBookListByPage(PageRequest pageRequest) {
        Integer count;
        count = bookMapper.count();
        List<BookInfo> bookInfos = bookMapper.queryBookByPage(pageRequest.getOffset(), pageRequest.getPageSize());

        for(BookInfo bookInfo:bookInfos) {
            bookInfo.setStatusCN(BookStatus.getDescByCode(bookInfo.getStatus()));
        }

        return new PageResult<>(bookInfos,count,pageRequest);
    }


    public BookInfo queryBookById(Integer bookId) {
        BookInfo bookInfo = bookMapper.queryBookById(bookId);
        bookInfo.setStatusCN(BookStatus.getDescByCode(bookInfo.getStatus()));
        return bookInfo;
    }

    public Integer updateBookById(BookInfo bookInfo) {
        return bookMapper.updateBookById(bookInfo);
    }

    public Integer deleteBookById(Integer bookId) {
        BookInfo bookInfo = new BookInfo();
        bookInfo.setId(bookId);
        bookInfo.setStatus(0);
        return bookMapper.updateBookById(bookInfo);
    }

    public Integer batchDeleteBookByIds(List<Integer> ids) {
        return bookMapper.batchDeleteBookByIds(ids);
    }
}
