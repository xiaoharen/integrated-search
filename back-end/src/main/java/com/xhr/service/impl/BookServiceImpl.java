package com.xhr.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhr.mapper.BookMapper;
import com.xhr.model.entity.Book;
import com.xhr.model.entity.Essay;
import com.xhr.model.vo.BookVO;
import com.xhr.model.vo.EssayVO;
import com.xhr.service.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author Administrator
* @description 针对表【book(book)】的数据库操作Service实现
* @createDate 2023-12-07 20:24:13
*/
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book>
    implements BookService {

    @Override
    public BookVO getBookVO(Book book) {
        if (book == null) {
            return null;
        }
        BookVO bookVO = new BookVO();
        BeanUtils.copyProperties(book, bookVO);
        return bookVO;
    }

    @Override
    public List<BookVO> getBookVO(List<Book> bookList) {
        if (CollectionUtils.isEmpty(bookList)) {
            return new ArrayList<>();
        }
        return bookList.stream().map(this::getBookVO).collect(Collectors.toList());
    }
}




