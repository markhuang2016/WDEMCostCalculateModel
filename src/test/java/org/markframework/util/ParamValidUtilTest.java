package org.markframework.util;

import org.junit.runner.RunWith;
import org.markframework.constant.ParamConstant;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ParamValidUtilTest {
   
    
    @org.junit.Test
    public void validRa() {
    
//        BigDecimal bigDecimal = new BigDecimal("3.0");
//        BigDecimal[] bigDecimals = bigDecimal.divideAndRemainder(ParamConstant.MIN_RA_CHANGE);
//        System.out.println(bigDecimals[0]);
//        System.out.println(bigDecimals[1]);
//        assertTrue(bigDecimals[1].compareTo(ParamValidUtil.zero)==0);

        
        boolean validRa = ParamValidUtil.validRa("1.0");
        boolean b = ParamValidUtil.validRa("3.0");
        boolean c = ParamValidUtil.validRa("8.0");
        assertTrue(!validRa);
        assertTrue(b);
        assertTrue(!c);
        
    }
    
  
    
    @org.junit.Test
    public void validTime() {
        boolean a = ParamValidUtil.validTime("0.1");
        boolean b = ParamValidUtil.validTime("10");
        boolean c = ParamValidUtil.validTime("-12");
        
        assertTrue(!a);
        assertTrue(b);
        assertTrue(!c);
        
    }
    
    @org.junit.Test
    public void validMaterial() {
    }
    @org.junit.Test
    public void validPartHeight() {
        boolean a = ParamValidUtil.validPartHeight("0.1");
        boolean b = ParamValidUtil.validPartHeight("10");
        boolean c = ParamValidUtil.validPartHeight("-12");
        boolean d = ParamValidUtil.validPartHeight("501");
        
        assertTrue(!a);
        assertTrue(b);
        assertTrue(!c);
        assertTrue(!d);
        
        
    }
    @org.junit.Test
    public void validPartLength() {
        boolean a = ParamValidUtil.validPartLength("0.1");
        boolean b = ParamValidUtil.validPartLength("10");
        boolean c = ParamValidUtil.validPartLength("-12");
        
        assertTrue(!a);
        assertTrue(b);
        assertTrue(!c);
        
    }
}
