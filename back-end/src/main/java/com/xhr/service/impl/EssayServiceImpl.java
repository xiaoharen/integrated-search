package com.xhr.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhr.model.entity.Book;
import com.xhr.model.entity.Essay;
import com.xhr.model.vo.BookVO;
import com.xhr.model.vo.EssayVO;
import com.xhr.service.EssayService;
import com.xhr.mapper.EssayMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author Administrator
* @description 针对表【essay(essay)】的数据库操作Service实现
* @createDate 2023-12-07 20:30:21
*/
@Service
public class EssayServiceImpl extends ServiceImpl<EssayMapper, Essay>
    implements EssayService{

    @Override
    public EssayVO getEssayVO(Essay essay) {
        if (essay == null) {
            return null;
        }
        EssayVO essayVO = new EssayVO();
        BeanUtils.copyProperties(essay, essayVO);
        return essayVO;
    }

    @Override
    public List<EssayVO> getEssayVO(List<Essay> essayList) {
        if (CollectionUtils.isEmpty(essayList)) {
            return new ArrayList<>();
        }
        return essayList.stream().map(this::getEssayVO).collect(Collectors.toList());
    }
}




