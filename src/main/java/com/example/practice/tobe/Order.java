package com.example.practice.tobe;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Item> items = new ArrayList<>();
    private UserInfo userInfo;

    public Order() {}
    @Builder
    public Order(List<Item> items, UserInfo userInfo) {
        this.items = items;
        this.userInfo = userInfo;
    }


    public boolean itemsIsEmpty() {
        return items.isEmpty();
    }


    public boolean hasCustomerInfo() {
        if (userInfo == null) {
            return false;
        }
        return true;
    }

    public int getTotalPrice() {
        return items.stream()
                .mapToInt(item -> item.getPrice())
                .sum();
    }
}
