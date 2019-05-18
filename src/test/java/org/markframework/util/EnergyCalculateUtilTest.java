package org.markframework.util;


import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

import static org.junit.Assert.*;
public class EnergyCalculateUtilTest {

    
    @Test
    public void getTotalEnergy() {
    }
    
    @Test
    public void getPulseEnergy() {
        BigDecimal pulseEnergy = EnergyCalculateUtil.getPulseEnergy(new BigDecimal("2"), new BigDecimal("3"), new BigDecimal("300"), new BigDecimal("300"));
        System.out.println(pulseEnergy);
    
    
    }
}
