package org.markframework.util;

import org.markframework.constant.ParamConstant;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * @author mark huang
 * @date 2019-05-18 20:15
 * @description：指数对数运算类
 * @modified By：
 */
public class PowLogUtil {
    /**
     * 计算a的b次方
     * @param a
     * @param b
     * @return
     */
    public static BigDecimal pow(BigDecimal a, BigDecimal b) {
        double pow = Math.pow(a.doubleValue(), b.doubleValue());
        return new BigDecimal(pow);
    }
    
    /**
     * 计算以y为底的x的对数值
     * @param x
     * @param y
     * @return
     */
    public static BigDecimal log(BigDecimal x, BigDecimal y) {
        double logx = Math.log(x.doubleValue());
        double logy = Math.log(y.doubleValue());
        BigDecimal divide = new BigDecimal(logy).divide(new BigDecimal(logx), ParamConstant.mathContext);
        return divide;
    }
    
    public static BigDecimal ln(BigDecimal mmr) {
        try{
            return log(new BigDecimal(Math.E),mmr );
        }catch (NumberFormatException e){
            System.out.println(mmr);
        }
        return new BigDecimal("0");
        
    }
}
