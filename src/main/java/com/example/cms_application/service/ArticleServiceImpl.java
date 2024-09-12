package com.example.cms_application.service;

import com.example.cms_application.model.Article;
import com.example.cms_application.repository.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{
    @Autowired
    private ArticleRepo articleRepo;


    @Override
    public List<Article> getArticles() {
        return articleRepo.findAll();
    }

    @Override
    public Article getArticleById(int id) {
        return articleRepo.findById(id).orElseThrow(() -> new RuntimeException("Article not found"));
    }

    @Override
    public Article createArticle(Article article) {
        if (article == null) {
            throw new RuntimeException( "Article cannot be null");
        }
        return articleRepo.save(article);
    }

    @Override
    public Article updateArticle(int id, Article article) {
        Article articleToUpdate = getArticleById(id);
        if (articleToUpdate != null) {
            articleToUpdate.setTitle(article.getTitle());
            articleToUpdate.setContent(article.getContent());
            articleToUpdate.setImage(article.getImage());
            return articleRepo.save(articleToUpdate);
        }
        else
            throw new IllegalArgumentException("Article not found");
    }

    @Override
    public void deleteArticle(int id) {
        Article article = getArticleById(id);
        if (article == null) {
            throw new IllegalArgumentException("Article not found");
        }
        articleRepo.deleteById(id);
    }
}
