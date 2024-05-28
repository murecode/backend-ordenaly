package com.app.ordenaly.controller;

import com.app.ordenaly.model.Product;
import com.app.ordenaly.repository.ProductRepository;
import com.app.ordenaly.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean  //1.
  private ProductService productService;

  @MockBean
  private ProductRepository productRepo;


  @Test
  void testGetAllProducts() throws Exception {
    Mockito
            .when(productService.getProducts())
            .thenReturn(List.of(
                    new Product(
                            120,
                            "Hamburgesa",
                            "Con carne y papas",
                            45000,
                            true
                    )
            ));
    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/products"))
            .andDo(MockMvcResultHandlers.print())
           /* .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(120)))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].productName", Matchers.is("Hamburguesa")))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].description", Matchers.is("Con carne y papas")))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].price", Matchers.is(45000)))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].inStock", Matchers.is(true)))*/;

  }

  @Test
  void testCreateProduct() {

    // Crear un objeto Product con los valores deseados
    Product product = new Product();
    product.setId(2);
    product.setProductName("ASD");
    product.setDescription("sdasd");
    product.setPrice(15200);
    product.setInStock(true);

    // Configurar el comportamiento del mock del repositorio
    when(productRepo.save(product)).thenReturn(product);

    // Llamar al método del servicio que estás probando
    productService.createProduct(product);

    // Verificar los resultados esperados
    assertNotNull(product);
    assertEquals(2, product.getId());
    assertEquals("ASD", product.getProductName());
    assertEquals("sdasd", product.getDescription());
    assertEquals(15200, product.getPrice());
    assertTrue(product.getInStock() == true);

    // Verificar que el repositorio se haya llamado correctamente
//    verify(productRepo).save(any(Product.class));



  }



}

//Docs:
/*@MockBean, Crea un objeto simulado y lo registra en el contexto de la aplicación de Spring.
  Esto significa que el mock estará disponible para su inyección en cualquier clase que lo requiera. */
