package com.example.cms_application.service;

import com.example.cms_application.model.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getArticles();
    Article getArticleById(int id);
    Article createArticle(Article article);
    Article updateArticle(int id, Article article);
    void deleteArticle(int id);
}
