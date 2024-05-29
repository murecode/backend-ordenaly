package com.app.ordenaly.service;

import com.app.ordenaly.repository.OrderCartRepository;
import com.app.ordenaly.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderCartService {
  @Autowired
  private OrderCartRepository orderCartRepo;
  @Autowired
  private ProductRepository productRepo;


  // +addProduct(productId, quantity, order)
  // +removeProduct(productId, order)
  // +updateQuantity(productId, quantity, order)

}
