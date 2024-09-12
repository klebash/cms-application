package com.example.cms_application.controller;

import com.example.cms_application.model.Article;
import com.example.cms_application.model.Image;
import com.example.cms_application.service.ArticleService;
import com.example.cms_application.service.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final ArticleService articleService;
    private final ImageService imageService;

    public ApiController(ArticleService articleService, ImageService imageService) {
        this.articleService = articleService;
        this.imageService = imageService;
    }
    @GetMapping("/articles")
    public ResponseEntity<List<Article>> getArticles() {
        List<Article> articles = articleService.getArticles();
        return  ResponseEntity.ok(articles);
    }

    @PostMapping("/articles")
    public ResponseEntity<Article> createArticle(@RequestBody Article article) {
        try {
            Article newArticle = articleService.createArticle(article);
            return new ResponseEntity<>(newArticle, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/articles/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable int id) {
        try {
            Article article = articleService.getArticleById(id);
            return new ResponseEntity<>(article, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable int id, @RequestBody Article article) {
        try {
            Article updatedArticle = articleService.updateArticle(id, article);
            return new ResponseEntity<>(updatedArticle, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/articles/{id}")
    public ResponseEntity<HttpStatus> deleteArticle(@PathVariable int id) {
        try {
            articleService.deleteArticle(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/images")
    public ResponseEntity<Image> uploadImage(@RequestBody Image image) {
        try {
            Image uploadedImage = imageService.uploadImage(image);
            return new ResponseEntity<>(uploadedImage, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/images/{id}")
    public ResponseEntity<Image> getImageById(@PathVariable int id) {
        try {
            Image image = imageService.getImageById(id);
            return new ResponseEntity<>(image, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
