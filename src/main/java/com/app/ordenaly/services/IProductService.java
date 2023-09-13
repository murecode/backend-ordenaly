package com.app.ordenaly.services;

import com.app.ordenaly.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IProductService {

//  newProduct

  void removeProduct(Integer id);

//  editProduct

  List<Product> listAllProducts();

}
