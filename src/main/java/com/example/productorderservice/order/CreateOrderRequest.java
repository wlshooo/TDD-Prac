package com.example.productorderservice.order;

import org.springframework.util.Assert;

import java.util.Objects;

final class CreateOrderRequest {
    private final Long productId;
    private final int quantity;

    public CreateOrderRequest(Long productId, int quantity) {
        Assert.notNull(productId, "상품 ID는 필수입니다.");
        Assert.isTrue(quantity > 0, "수량은 0보다 커야 합니다.");
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long productId() {
        return productId;
    }

    public int quantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (CreateOrderRequest) obj;
        return Objects.equals(this.productId, that.productId) &&
                this.quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, quantity);
    }

    @Override
    public String toString() {
        return "CreateOrderRequest[" +
                "productId=" + productId + ", " +
                "quantity=" + quantity + ']';
    }

}
