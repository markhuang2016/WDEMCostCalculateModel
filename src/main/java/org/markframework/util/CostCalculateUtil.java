package org.markframework.util;

import org.markframework.Pojo.CalculateInput;
import org.markframework.Pojo.CalculateResult;
import org.markframework.constant.ParamConstant;

import java.math.BigDecimal;

/**
 * @author mark huang
 * @date 2019-05-13 10:14
 */
public class CostCalculateUtil {
    
    private static BigDecimal ton_min = ParamConstant.zero;
    private static BigDecimal toff_min = ParamConstant.zero;
    private static BigDecimal ip_min = ParamConstant.zero;
    private static BigDecimal totalCost = ParamConstant.zero;
    private static final BigDecimal kt = new BigDecimal("94.744");
    private static final BigDecimal ke = new BigDecimal("0.869");
    
    
    
    public static CalculateResult calculate(CalculateInput calculateInput) {
        totalCost = ParamConstant.zero;
        //未判断材料
        BigDecimal requestRa = new BigDecimal(calculateInput.getRequestRa());
        BigDecimal height = new BigDecimal(calculateInput.getHeight());
        BigDecimal length = new BigDecimal(calculateInput.getLength());
        BigDecimal preparedTime = new BigDecimal(calculateInput.getPreparedTime());
        BigDecimal emptyWalkTime = new BigDecimal(calculateInput.getEmptyWalkTime());
        
       
        // 从小遍历所有有效ton
        BigDecimal ton = ParamConstant.MIN_TON;
        BigDecimal toff;
        BigDecimal ip;
        
        for (; ton.compareTo(ParamConstant.MAX_TON) != 1; ton = ton.add(ParamConstant.MIN_TON_CHANGE)) {
            
            // 根据Ra求Ip
            ip = RaCaluculateUtil.getIpByTonAndRa(ton, requestRa);
            
            // 判读Ip是否有效
            if (ParamValidUtil.validIp(ip)) {
                
                // 如果有效则遍历所有有效toff
                for (toff = ParamConstant.MIN_TOFF; toff.compareTo(ParamConstant.MAX_TOFF) != 1;
                     toff = toff.add(ParamConstant.MIN_TOFF_CHANGE)) {
                    // 计算总成本并保留最小成本
                    calculateTotalCost(ton, toff, ip, height, length,preparedTime,emptyWalkTime);
                    
                    
                }
            }
        }
        
        // 根据参数计算要求结果
        BigDecimal processedRa = RaCaluculateUtil.getRaByTonAndIp(ton_min, ip_min);
        BigDecimal totalTime = TimeCalculateUtil.getTotalTime(ip_min, toff_min,ip_min, height, length,preparedTime,emptyWalkTime);
        BigDecimal pulseProcessTime = TimeCalculateUtil.getPulseProcessTime(ip_min, toff_min, height, length);
        BigDecimal totalEnergy = EnergyCalculateUtil.getTotalEnergy(ip_min, toff_min, height, length,preparedTime,emptyWalkTime);
        BigDecimal pulseEnergy = EnergyCalculateUtil.getPulseEnergy(ip_min, toff_min, height, length);
        BigDecimal totalCost = calculateTotalCost(ton_min, toff_min, ip_min, height, length, preparedTime, emptyWalkTime);
        BigDecimal timeCost = calculateTimeCost(ton_min, toff_min, ip_min, height, length,preparedTime,emptyWalkTime);
        BigDecimal energyCost = calculateEnergyCost(ton_min, toff_min, ip_min, height, length,preparedTime,emptyWalkTime);
    
    
        CalculateResult calculateResult = new CalculateResult(processedRa.toString(),
                totalTime.toString(), pulseProcessTime.toString(),
                totalEnergy.toString(), pulseEnergy.toString(),
                totalCost.toString(), timeCost.toString(), energyCost.toString(),
                ton_min.toString(),toff_min.toString(),ip_min.toString());
        return calculateResult;
        
        
    }
    
    /**
     * 计算时间成本
     */
    public static BigDecimal calculateTimeCost(BigDecimal tonMin, BigDecimal toffMin, BigDecimal ip_min, BigDecimal height, BigDecimal length, BigDecimal preparedTime, BigDecimal emptyWalkTime) {
    
        BigDecimal totalTime = TimeCalculateUtil.getTotalTime(tonMin, toffMin, ip_min, height, length, preparedTime, emptyWalkTime);
        BigDecimal multiply = totalTime.multiply(kt);
        return multiply;
    }
    /**
     * 计算能源成本
     */
    public static BigDecimal calculateEnergyCost(BigDecimal tonMin, BigDecimal toffMin, BigDecimal ip_min, BigDecimal height, BigDecimal length, BigDecimal preparedTime, BigDecimal emptyWalkTime) {
    
        BigDecimal totalEnergy = EnergyCalculateUtil.getTotalEnergy(ip_min, toff_min, height, length,preparedTime,emptyWalkTime);
        BigDecimal multiply = totalEnergy.multiply(ke);
        return multiply;
    }
    
    /**
     * 计算总成本并记录目前最小成本
     * @param ton
     * @param toff
     * @param ip
     * @param height
     * @param length
     * @param preparedTime
     * @param emptyWalkTime
     * @return
     */
    public static BigDecimal calculateTotalCost(BigDecimal ton, BigDecimal toff, BigDecimal ip, BigDecimal height, BigDecimal length, BigDecimal preparedTime, BigDecimal emptyWalkTime) {
        // 计算总成本
    
        BigDecimal add;
        try {
            BigDecimal timeCost = calculateTimeCost(ton, toff, ip, height, length, preparedTime, emptyWalkTime);
            BigDecimal energyCost = calculateEnergyCost(ton, toff, ip, height, length, preparedTime, emptyWalkTime);
            add = timeCost.add(energyCost);
    
        }catch (NumberFormatException e){
            return null;
        }
       
        
        //赋初始值
        if (totalCost.compareTo(ParamConstant.zero)==0){
            ton_min=ton;
            toff_min=toff;
            ip_min=ip;
            totalCost=add;
        }
        // 如果成本是目前最少
        if (add.compareTo(totalCost)==-1){
            // 则保留最小成本和电参数
            ton_min=ton;
            toff_min=toff;
            ip_min=ip;
            totalCost=add;
        }
        
        return add;
    }
}
