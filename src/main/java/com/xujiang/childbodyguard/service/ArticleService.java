package com.xujiang.childbodyguard.service;

import com.xujiang.childbodyguard.domain.Result;
import com.xujiang.childbodyguard.domain.po.ArticlePO;

import java.util.List;

public interface ArticleService {

    Result<List<ArticlePO>> getArticleList(Integer pageNum, Integer pageSize, Long catId);
}
