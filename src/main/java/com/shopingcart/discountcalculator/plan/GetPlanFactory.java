package com.shopingcart.discountcalculator.plan;

public class GetPlanFactory {

    public IPlan getCustomer(String customerType) {
        switch (customerType) {
            case "Premium":
                return new Premium();
            case "Regular":
                return new Regular();
            default:
                return null ;
        }
    }
}
