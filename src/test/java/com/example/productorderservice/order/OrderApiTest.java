package com.example.productorderservice.order;

import com.example.productorderservice.ApiTest;
import com.example.productorderservice.order.application.service.CreateOrderRequest;
import com.example.productorderservice.product.ProductSteps;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static com.example.productorderservice.order.OrderSteps.상품주문요청;
import static com.example.productorderservice.order.OrderSteps.상품주문요청_생성;


public class OrderApiTest extends ApiTest {

    @Test
    void 상품주문() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        final CreateOrderRequest request = 상품주문요청_생성();

        ExtractableResponse<Response> response = 상품주문요청(request);

        Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }
}
