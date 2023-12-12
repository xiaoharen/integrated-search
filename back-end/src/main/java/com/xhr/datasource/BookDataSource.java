package com.xhr.datasource;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xhr.model.entity.Book;
import com.xhr.model.vo.BookVO;
import com.xhr.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class BookDataSource implements DataSource{
    @Resource
    BookService bookService;

    @Override
    public List<BookVO> doSearch(String searchText) {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("bookName", searchText).or().like("author", searchText);
        return bookService.getBookVO(bookService.list(queryWrapper));
    }
}
