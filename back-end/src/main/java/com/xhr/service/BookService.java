package com.xhr.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhr.model.entity.Book;
import com.xhr.model.vo.BookVO;

import java.util.List;

/**
* @author Administrator
* @description 针对表【book(book)】的数据库操作Service
* @createDate 2023-12-07 20:24:13
*/
public interface BookService extends IService<Book> {
    BookVO getBookVO(Book book);

    List<BookVO> getBookVO(List<Book> bookList);
}
