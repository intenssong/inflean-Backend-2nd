package com.example.practice;

import com.example.practice.tobe.*;
import com.example.practice.tobe.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

class OrderTest {
@TestFactory

Collection<DynamicNode> validateOrder(){


    return Arrays.asList(
            DynamicTest.dynamicTest("유효한 값을 모두 입력한 경우", () -> {
                //given
                List<Item> items = List.of(new Item(5000), new Item(6000), new Item(7000));
                UserInfo userInfo = new UserInfo("Kim");
                com.example.practice.tobe.Order order = com.example.practice.tobe.Order.builder()
                        .items(items)
                        .userInfo(userInfo)
                        .build();
                OrderValidator orderValidator = new OrderValidator();

                //when
                boolean result = orderValidator.validateOrder(order);

                //then
                Assertions.assertThat(result).isTrue();
            }),
            DynamicTest.dynamicTest("사용자정 보가 없는 경우 ", () -> {
                List<Item> items = List.of(new Item(5000), new Item(6000), new Item(7000));

                com.example.practice.tobe.Order order = com.example.practice.tobe.Order.builder()
                        .items(items)
                        .build();
                OrderValidator orderValidator = new OrderValidator();

                //when //then
                Assertions.assertThatThrownBy(() -> orderValidator.validateOrder(order))
                        .isInstanceOf(OrderException.class)
                        .hasMessage("사용자 정보가 없습니다.");
            }),
            DynamicTest.dynamicTest("총 가격이 0이하인 경우", () -> {
                List<Item> items = List.of(new Item(0), new Item(0), new Item(0));
                UserInfo userInfo = new UserInfo("Kim");
                com.example.practice.tobe.Order order = com.example.practice.tobe.Order.builder()
                        .items(items)
                        .userInfo(userInfo)
                        .build();
                OrderValidator orderValidator = new OrderValidator();

                //when //then
                Assertions.assertThatThrownBy(() -> orderValidator.validateOrder(order))
                        .isInstanceOf(OrderException.class)
                        .hasMessage("올바르지 않은 총 가격입니다.");
            }),
            DynamicTest.dynamicTest("주문 아이템이 없는 경우", () -> {
                List<Item> items = List.of();
                UserInfo userInfo = new UserInfo("Kim");
                com.example.practice.tobe.Order order = Order.builder()
                        .items(items)
                        .userInfo(userInfo)
                        .build();
                OrderValidator orderValidator = new OrderValidator();

                //when //then
                Assertions.assertThatThrownBy(() -> orderValidator.validateOrder(order))
                        .isInstanceOf(OrderException.class)
                        .hasMessage("주문 항목이 없습니다.");
            })
    );
}


}