package com.example.productorderservice.product;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Void> addProduct(@RequestBody final AddProductRequest request) {
        productService.addProduct(request);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<GetProductResponse> getProduct(@PathVariable final Long productId) {
        GetProductResponse productResponse = productService.getProduct(productId);

        return ResponseEntity.status(HttpStatus.OK).body(productResponse);
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<Void> patchProduct(@PathVariable final Long productId,
                                                           @RequestBody UpdateProductRequest updateProductRequest) {
        productService.updateProduct(productId,updateProductRequest);

        return ResponseEntity.ok().build();
    }
}
