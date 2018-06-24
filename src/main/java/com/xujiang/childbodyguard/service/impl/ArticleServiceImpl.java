package com.xujiang.childbodyguard.service.impl;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.xujiang.childbodyguard.dao.mapper.ArticlePOMapper;
import com.xujiang.childbodyguard.domain.Result;
import com.xujiang.childbodyguard.domain.po.ArticlePO;
import com.xujiang.childbodyguard.domain.po.ArticlePOExample;
import com.xujiang.childbodyguard.service.ArticleService;
import jdk.nashorn.internal.parser.JSONParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    @Resource
    ArticlePOMapper articlePOMapper;

    @Override
    public Result<List<ArticlePO>> getArticleList(Integer pageNum, Integer pageSize, Long catId){


        if(pageNum == null){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        ArticlePOExample articlePOExample = new ArticlePOExample();
        articlePOExample.setOrderByClause("write_time desc");
        articlePOExample.or().andCatIdEqualTo(catId);
        PageHelper.startPage(pageNum, pageSize);
        List<ArticlePO> articlePOS = articlePOMapper.selectByExample(articlePOExample);
        log.info("res is {}", JSON.toJSON(articlePOS));
        return new Result<>(0,"", articlePOS);
    }
}
