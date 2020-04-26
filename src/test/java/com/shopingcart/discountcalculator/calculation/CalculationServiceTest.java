package com.shopingcart.discountcalculator.calculation;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class CalculationServiceTest {
    private Double purchaseAmount ;
    private String planType ;
    private Double expectedAmount ;

    private CalculationService calculationService ;

    public CalculationServiceTest(Double purchaseAmount, String planType , Double expectedAmount)
    {
        super();
        this.purchaseAmount = purchaseAmount ;
        this.planType = planType ;
        this.expectedAmount = expectedAmount ;
    }

    @Before
    public void initialize()
    {
        CalculationService calculationService = new CalculationService();
    }

    @Parameterized.Parameters
    public static Collection input()
    {
        return Arrays.asList(new Object[][] {
                {5000.0, "Regular", 5000.0},
                {10000.0, "Regular", 9500.0},
                {15000.0, "Regular", 13500.0},
                {4000.0, "Perimum", 3600.0},
                {8000.0, "Perimum", 7000.0},
                {12000.0, "Perimum", 10200.0},
                {20000.0, "Perimum", 15800.0}});
    }

    @Test
    public void testCalculationTest()
    {
       // CalculationService calculationService = new CalculationService();
        assertEquals(expectedAmount,
                calculationService.getBillAmount(purchaseAmount, planType));
    }
}
