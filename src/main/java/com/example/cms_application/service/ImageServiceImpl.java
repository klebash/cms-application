package com.example.cms_application.service;

import com.example.cms_application.model.Image;
import com.example.cms_application.repository.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageRepo imageRepo;


    @Override
    public Image getImageById(int id) {
        return  imageRepo.findById(id).orElseThrow(() -> new RuntimeException("Image not found"));
    }

    @Override
    public Image uploadImage(Image image) {
        if (image == null) {
            throw new IllegalArgumentException("Cannot upload image please check the provided image");
        }
        return imageRepo.save(image);
    }
}
