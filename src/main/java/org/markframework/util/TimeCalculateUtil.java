package org.markframework.util;

import com.sun.xml.internal.bind.v2.TODO;
import org.markframework.constant.ParamConstant;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * @author mark huang
 * @date 2019-05-13 10:11
 */
public class TimeCalculateUtil {
    
    
    public static BigDecimal getTotalTime(BigDecimal tonMin, BigDecimal toffMin, BigDecimal ip_min, BigDecimal height, BigDecimal length, BigDecimal preparedTime, BigDecimal emptyWalkTime) {
        BigDecimal pulseProcessTime = getPulseProcessTime(ip_min, toffMin, height, length);
        BigDecimal add = pulseProcessTime.add(preparedTime).add(emptyWalkTime);
        return add;
    }
    
    public static BigDecimal getPulseProcessTime(BigDecimal ip_min, BigDecimal toff_min, BigDecimal height, BigDecimal length) {
        //dhl/mmr
        BigDecimal result = height.multiply(length, ParamConstant.mathContext);
        result = result.multiply(ParamConstant.WIRE_D);
        BigDecimal mmr = MMRCalculatUtil.getMMR(ip_min, toff_min);
        
        return result.divide(mmr,new MathContext(1, RoundingMode.HALF_DOWN));
    }
}
