package com.app.ordenaly.test;

import com.app.ordenaly.model.entity.ProductCategory;
import com.app.ordenaly.repository.ProductCategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepo;

    @Test
    void createProductCategory() {

        ProductCategory productCategory = new ProductCategory();
        productCategory.setTitle("Panaderia");
        productCategory.setDescription("Panes, Bolleria, Pasteles");
        productCategory.setImageUrl("HttpsImagenPan");

        productCategoryRepo.save(productCategory);

    }

}