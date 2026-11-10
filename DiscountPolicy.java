package com.ecommerce;

public abstract class DiscountPolicy {
    public abstract double calculateDiscount(double orderAmount);
}

final class PercentageDiscountPolicy extends DiscountPolicy {
    private final double percentage;

    PercentageDiscountPolicy(double percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Скидка должна быть от 0 до 100 процентов");
        }
        this.percentage = percentage;
    }

    @Override
    public double calculateDiscount(double orderAmount) {
        if (orderAmount < 0) {
            throw new IllegalArgumentException("Сумма заказа не может быть отрицательной");
        }
        return orderAmount * percentage / 100.0;
    }
}
