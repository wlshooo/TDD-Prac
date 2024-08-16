package com.example.productorderservice.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProductUpdateTest {

    @Autowired
    private ProductService productService;

    @Test
    void 상품수정() {
        productService.addProduct(ProductSteps.상품등록요청_생성());
        final Long productId = 1L;
        final UpdateProductRequest request = new UpdateProductRequest("상품 수정", 2000, DiscountPolicy.NONE);


        productService.updateProduct(productId, request);

        GetProductResponse product = productService.getProduct(productId);
        assertThat(product.name()).isEqualTo("상품 수정");
        assertThat(product.price()).isEqualTo(2000);
    }
}
