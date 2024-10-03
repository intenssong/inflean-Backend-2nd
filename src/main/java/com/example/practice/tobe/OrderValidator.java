package com.example.practice.tobe;

public class OrderValidator {
    public boolean validateOrder(Order order) {
        validItems(order);
        validTotalPrice(order);
        validCustomerInfo(order);
        return true;
    }

    private static void validCustomerInfo(Order order) {
        if (doesNotExistCustomerInfo(order)) {
            throw new OrderException("사용자 정보가 없습니다.");
        }
    }

    private static void validTotalPrice(Order order) {
        if (totalPriceLessThenZero(order)) {
            throw new OrderException("올바르지 않은 총 가격입니다.");
        }
    }

    private static void validItems(Order order) {
        if (doesNotExistItem(order)) {
            throw new OrderException("주문 항목이 없습니다.");

        }
    }

    private static boolean doesNotExistItem(Order order) {
        return order.itemsIsEmpty();
    }

    private static boolean doesNotExistCustomerInfo(Order order) {
        return !order.hasCustomerInfo();
    }

    private static boolean totalPriceLessThenZero(Order order) {
        return !(order.getTotalPrice() > 0);
    }
}