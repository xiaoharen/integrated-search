package com.xhr.service;

import com.xhr.model.entity.Book;
import com.xhr.model.entity.Essay;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xhr.model.vo.BookVO;
import com.xhr.model.vo.EssayVO;

import java.util.List;

/**
* @author Administrator
* @description 针对表【essay(essay)】的数据库操作Service
* @createDate 2023-12-07 20:30:21
*/
public interface EssayService extends IService<Essay> {
    EssayVO getEssayVO(Essay essay);

    List<EssayVO> getEssayVO(List<Essay> essayList);
}
