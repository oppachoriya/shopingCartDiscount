package com.shopingcart.discountcalculator.calculation;

import com.shopingcart.discountcalculator.plan.GetPlanFactory;
import com.shopingcart.discountcalculator.plan.IPlan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CalculationService {

    private Double getDiscountedValue(Double purchaseAmount , Double discountPercent)
    {
        Double discount = (Double)(purchaseAmount * (discountPercent/100.0));
        return discount ;
    }

    private Double calculateDiscount(Double purchasedAmount, IPlan plan) {
        Double billAmount = purchasedAmount ;
        List<Discount> discountRanges = new ArrayList<>();
        discountRanges = plan.getDiscountRanges();
        Collections.reverse(discountRanges);
        Double discountAmount = 0.0;
        for (Discount current:discountRanges) {
            Double discount = 0.0 ;
            Double amountToCalculateDiscount = 0.0 ;
            if(billAmount > 0.0 && billAmount > current.getStartVal() && billAmount <= current.getEndVal()) {
                amountToCalculateDiscount = billAmount - current.getStartVal() ;
            }

            discount = this.getDiscountedValue(amountToCalculateDiscount, current.getDiscountPercent());
            discountAmount = discountAmount + discount;
            billAmount = billAmount - amountToCalculateDiscount ;

        }
        return purchasedAmount - discountAmount  ;
    }



    public Double getBillAmount(Double purchasedAmount, String planType) {
        GetPlanFactory planFactory = new GetPlanFactory();
        IPlan plan = planFactory.getCustomer(planType);
        Double billingAmount = this.calculateDiscount(purchasedAmount,plan);
        return billingAmount ;
    }
}
