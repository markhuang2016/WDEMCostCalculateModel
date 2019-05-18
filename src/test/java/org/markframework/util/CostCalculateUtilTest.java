package org.markframework.util;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CostCalculateUtilTest {
  
    
    @Test
    public void calculate() {
        BigDecimal bigDecimal = CostCalculateUtil.calculateTotalCost(new BigDecimal("1"), new BigDecimal("1"), new BigDecimal("4.9"), new BigDecimal("23"), new BigDecimal("223"), new BigDecimal("25"), new BigDecimal("30"));
        System.out.println(bigDecimal);
    }
    
    @Test
    public void calculateTimeCost() {
    }
    
    @Test
    public void calculateEnergyCost() {
    }
}
