package com.shopingcart.discountcalculator.plan;

import com.shopingcart.discountcalculator.calculation.Discount;

import java.util.ArrayList;
import java.util.List;

public class Premium implements IPlan {
    private final String customerType = "Premium";

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
        Double[][] discountMap = {{10.0,0.0,4000.0},
                {15.0,4000.0,8000.0},
                {20.0,8000.0,12000.0},
                {30.0, 12000.0,Double.MAX_VALUE}};
        return  discountMap;
    }
}
