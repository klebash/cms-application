package com.example.cms_application.service;

import com.example.cms_application.model.Image;

public interface  ImageService {
    Image getImageById(int id);
    Image uploadImage(Image image);
}
