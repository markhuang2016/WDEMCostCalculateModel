package org.markframework.util;


import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PowLogUtilTest {
   
    
    @Test
    public void pow() {
    }
    
    @Test
    public void log() {
    }
    
    @Test
    public void ln() {
        BigDecimal ln = PowLogUtil.ln(new BigDecimal("0"));
        System.out.println(ln);
    }
}
