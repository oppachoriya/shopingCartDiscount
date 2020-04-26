package com.shopingcart.discountcalculator.plan;

import com.shopingcart.discountcalculator.calculation.Discount;

import java.util.List;

public interface IPlan {
    public String getCustomerType();
    public List<Discount> getDiscountRanges();
}
