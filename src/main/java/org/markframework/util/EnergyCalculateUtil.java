package org.markframework.util;

import org.markframework.constant.ParamConstant;
import org.markframework.constant.PowerConstant;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * @author mark huang
 * @date 2019-05-13 10:12
 * 封装能耗计算的相关方法
 */
public class EnergyCalculateUtil {
    private static final BigDecimal C1=new BigDecimal("-21.51422");
    private static final BigDecimal C2=new BigDecimal("612.95933");
    
    /**
     * 计算总时间
     * @param ip
     * @param toff
     * @param height
     * @param length
     * @param prepareTime
     * @param emptyWalkTime
     * @return
     */
    public static BigDecimal getTotalEnergy(BigDecimal ip, BigDecimal toff, BigDecimal height, BigDecimal length, BigDecimal prepareTime, BigDecimal emptyWalkTime) {
        BigDecimal prepareEnergy = prepareTime.multiply(PowerConstant.PREPARE_POWER,ParamConstant.mathContext);
        BigDecimal emptyWalkEnergy = emptyWalkTime.multiply(PowerConstant.DEFAULT_EMPTY_WALK_POWER,ParamConstant.mathContext);
        BigDecimal pulseEnergy = getPulseEnergy(ip, toff, height, length);
        
        return prepareEnergy.add(emptyWalkEnergy).add(pulseEnergy,new MathContext(1,RoundingMode.HALF_DOWN));
    }
    
    /**
     * 计算脉冲能耗
     * E_q=〖dhl（-21.51422ln〗⁡MMR+612.95933/MMR）
     * @param ipMin
     * @param toffMin
     * @param height
     * @param length
     * @return
     */
    public static BigDecimal getPulseEnergy(BigDecimal ipMin, BigDecimal toffMin, BigDecimal height, BigDecimal length) {
        BigDecimal result = ParamConstant.WIRE_D.multiply(height, ParamConstant.mathContext).multiply(length, ParamConstant.mathContext);
        BigDecimal mmr = MMRCalculatUtil.getMMR(ipMin, toffMin);
        BigDecimal lnMMR = PowLogUtil.ln(mmr);
        BigDecimal divide = C2.divide(mmr, ParamConstant.mathContext);
        
    
        return result.multiply(lnMMR.add(divide),new MathContext(1, RoundingMode.HALF_DOWN));
    }
   
    
}
