package com.shopingcart.discountcalculator.plan;

import com.shopingcart.discountcalculator.calculation.Discount;

import java.util.ArrayList;
import java.util.List;

public class Regular implements IPlan {
    private final String customerType = "Regular";

    @Override
    public String getCustomerType() {
        return this.customerType ;
    }

    @Override
    public List<Discount> getDiscountRanges() {
        List<Discount> discountRanges = new ArrayList<>();

        for (Double [] discountMap : this.getDiscountMaps()) {
            Discount discount = new Discount(discountMap[0], discountMap[1],discountMap[2]);
            discountRanges.add(discount);
        }

        return discountRanges ;
    }

    private Double [][] getDiscountMaps() {
        Double[][] discountMap = {{0.0,0.0,5000.0},
                {10.0,5000.0,10000.0},
                {20.0, 10000.0,Double.MAX_VALUE}};
        return  discountMap;
    }
}
