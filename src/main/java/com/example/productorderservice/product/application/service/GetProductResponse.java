package com.example.productorderservice.product.application.service;

import com.example.productorderservice.product.domain.DiscountPolicy;
import org.springframework.util.Assert;

public record GetProductResponse(
        long id,
        String name,
        int price,
        DiscountPolicy disCountPolicy
) {
    public GetProductResponse {
        Assert.notNull(id, "상품 ID는 필수입니다.");
        Assert.hasText(name, "상품명은 필수입니다.");
        Assert.notNull(disCountPolicy, "할인 정책은 필수입니다.");
    }
}
