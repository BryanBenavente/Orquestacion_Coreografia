package com.vallegrande.order.domain.sales.order;

import com.vallegrande.order.domain.common.Money;

public class DiscountService {

    public static Money applyDiscount(Money unitPrice, int amount) {
        if (amount >= 3)
            return unitPrice.multiply(0.9);

        return unitPrice;
    }

}
