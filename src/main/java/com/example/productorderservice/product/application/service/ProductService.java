package com.example.productorderservice.product.application.service;

import com.example.productorderservice.product.application.port.ProductPort;
import com.example.productorderservice.product.domain.Product;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ProductService {
    private final ProductPort productPort;

    ProductService(ProductPort productPort) {
        this.productPort = productPort;
    }

    @Transactional
    public void addProduct(AddProductRequest request) {
        final Product product = new Product(request.name(), request.price(), request.discountPolicy());

        productPort.save(product);
    }

    public GetProductResponse getProduct(final Long productId) {
        final Product product = productPort.getProduct(productId);

        return new GetProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getDiscountPolicy());
    }

    public void updateProduct(Long productId, UpdateProductRequest request) {
        Product product = productPort.getProduct(productId);
        product.update(request.name(),request.price(),request.discountPolicy());

        productPort.save(product);
    }
}
