package org.markframework.util;

import org.markframework.constant.ParamConstant;

import java.math.BigDecimal;

/**
 * @author mark huang
 * @date 2019-05-18 20:51
 * @description：计算MMR
 * @modified By：
 */
public class MMRCalculatUtil {
    
    private static final BigDecimal C1 =new BigDecimal("12.89519");
    private static final BigDecimal C2 =new BigDecimal("1.81502");
    private static final BigDecimal C3 =new BigDecimal("3.4559");
    private static final BigDecimal C4 =new BigDecimal("16.5421");
    
    /**
     * 计算MMR
     * MRR=12.89519I_p-1.81502〖I_p〗^2-3.4559t_off+16.5421
     * @param ip_min
     * @param toff_min
     * @return
     */
    public static BigDecimal getMMR(BigDecimal ip_min, BigDecimal toff_min) {
        BigDecimal result = C1.multiply(ip_min, ParamConstant.mathContext);
        BigDecimal pow = ip_min.pow(2);
        BigDecimal multiply = C2.multiply(pow, ParamConstant.mathContext);
        result = result.subtract(multiply, ParamConstant.mathContext);
        BigDecimal multiply1 = C3.multiply(toff_min, ParamConstant.mathContext);
        result = result.subtract(multiply1);
        result=result.add(C4,ParamConstant.mathContext);
        if (result.compareTo(ParamConstant.zero)==-1){
            throw new NumberFormatException("MMR为负");
        }
        return result;
    }
    
}
