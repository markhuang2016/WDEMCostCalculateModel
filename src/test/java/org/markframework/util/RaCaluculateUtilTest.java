package org.markframework.util;


import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

import static org.junit.Assert.*;


public class RaCaluculateUtilTest {

  
    
    @Test
    public void getIpByTonAndRa() {
        BigDecimal ipByTonAndRa = RaCaluculateUtil.getIpByTonAndRa(new BigDecimal("2"), new BigDecimal("3.2"));
        System.out.println(ipByTonAndRa);
    }
    
    @Test
    public void getRaByTonAndIp() {
        BigDecimal raByTonAndIp = RaCaluculateUtil.getRaByTonAndIp(new BigDecimal(2), new BigDecimal(3.7));
        System.out.println(raByTonAndIp);
    }
}
