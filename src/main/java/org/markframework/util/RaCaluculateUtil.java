package org.markframework.util;

import org.markframework.constant.ParamConstant;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * @author mark huang
 * @date 2019-05-17 23:22
 * @description：参数换算工具
 * @modified By：
 */
public class RaCaluculateUtil {
    
    
    private static final BigDecimal C1 = new BigDecimal("1.96673");
    private static final BigDecimal C2 = new BigDecimal("0.12441");
    private static final BigDecimal C3 = new BigDecimal("0.3068");
    
    
    /**
     * R_a=1.96673〖t_on〗^0.12441 〖I_p〗^0.3068
     * 根据粗糙度和Ip算Ton
     *
     * @param ton
     * @param requestRa
     * @return
     */
    public static BigDecimal getIpByTonAndRa(BigDecimal ton, BigDecimal requestRa) {
        
        
        BigDecimal result = requestRa.divide(C1, ParamConstant.mathContext);
        BigDecimal pow = PowLogUtil.pow(ton, C2);
        result = result.divide(pow, ParamConstant.mathContext);
        BigDecimal y = new BigDecimal("1").divide(C3, ParamConstant.mathContext);
        return PowLogUtil.pow(result,y).round(new MathContext(2,RoundingMode.HALF_DOWN));
    }
    
    /**
     * 根据Ton，Ip算Ra
     *
     * @param ton_min
     * @param ip_min
     * @return
     */
    public static BigDecimal getRaByTonAndIp(BigDecimal ton_min, BigDecimal ip_min) {
        BigDecimal ton = PowLogUtil.pow(ton_min, C2);
        BigDecimal multiply = C1.multiply(ton, ParamConstant.mathContext);
        BigDecimal ip = PowLogUtil.pow(ip_min, C3);
        
        return multiply.multiply(ip,new MathContext(2,RoundingMode.HALF_DOWN));
    }
}
