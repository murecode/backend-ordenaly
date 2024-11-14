package com.app.ordenaly.service;

import com.app.ordenaly.repository.ProductCategoryRepository;
import com.app.ordenaly.model.entity.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepo;

    public ProductCategory createProductCategory() {

        ProductCategory productCategory = new ProductCategory();
        productCategory.setTitle("Bandejas");
        productCategory.setDescription("Contiene lo basico");
        productCategory.setImageUrl("httt888");

        return productCategoryRepo.save(productCategory);
    }
}
