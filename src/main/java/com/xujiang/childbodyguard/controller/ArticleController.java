package com.xujiang.childbodyguard.controller;

import com.xujiang.childbodyguard.domain.Result;
import com.xujiang.childbodyguard.domain.po.ArticlePO;
import com.xujiang.childbodyguard.service.ArticleService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @RequestMapping("")
    @ResponseBody
    public Result<List<ArticlePO>> getArticles(Integer pageNum, Integer pageSize, Long catId) {
        return articleService.getArticleList(pageNum, pageSize, catId);
    }

    @RequestMapping("/{articleId}")
    @ResponseBody
    public Result<ArticlePO> getArticles(@PathVariable("articleId") Long articleId) {
        return articleService.getArticle(articleId);
    }
}
