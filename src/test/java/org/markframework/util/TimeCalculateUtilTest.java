package org.markframework.util;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class TimeCalculateUtilTest {
    
    
    @Test
    public void getTotalTime() {
        BigDecimal pulseProcessTime = TimeCalculateUtil.getTotalTime(new BigDecimal("2"), new BigDecimal("3"), new BigDecimal("1"),new BigDecimal("30"), new BigDecimal("3000"),new BigDecimal("2"),new BigDecimal("5"));
        System.out.println(pulseProcessTime);
    }
    
    @Test
    public void getPulseProcessTime() {
        BigDecimal pulseProcessTime = TimeCalculateUtil.getPulseProcessTime(new BigDecimal("2"), new BigDecimal("3"), new BigDecimal("30"), new BigDecimal("3000"));
        System.out.println(pulseProcessTime);
    }
}
