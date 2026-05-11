package org.example.managebook.service;

import org.example.managebook.constant.BookStatus;
import org.example.managebook.dao.BookDao;
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
    private BookDao bookDao;

    @Autowired
    private BookMapper bookMapper;

    public List<BookInfo> getBookList(){
        //BookDao bookDao = new BookDao();
        List<BookInfo> bookInfos = bookDao.mockData();
        for (BookInfo bookInfo : bookInfos) {
            if(bookInfo.getStatus()==1){
                bookInfo.setStatusCN("可借阅");
            }else{
                bookInfo.setStatusCN("不可借阅");
            }
        }
        return bookInfos;
    }

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

        return new PageResult<>(bookInfos,count);
    }
}
