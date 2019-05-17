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
    
    
    public static CalculateResult calculate(CalculateInput calculateInput) {
        
        //未判断材料
        BigDecimal requestRa = new BigDecimal(calculateInput.getRequestRa());
        BigDecimal height = new BigDecimal(calculateInput.getHeight());
        BigDecimal length = new BigDecimal(calculateInput.getLength());
        BigDecimal preparedTime = new BigDecimal(calculateInput.getPreparedTime());
        BigDecimal emptyWalkTime = new BigDecimal(calculateInput.getEmptyWalkTime());
        
        // R_a=1.96673〖t_on〗^0.12441 〖I_p〗^0.3068
        // 从小遍历所有有效ton
        BigDecimal ton = ParamConstant.MIN_TON;
        BigDecimal toff;
        BigDecimal ip;
        
        for (; ton.compareTo(ParamConstant.MAX_TON) != 1; ton = ton.add(ParamConstant.MIN_TON_CHANGE)) {
            
            // 根据Ra求Ip
            ip = ParamCaluculateUtil.getIpByTonAndRa(ton, requestRa);
            
            // 判读Ip是否有效
            if (ParamValidUtil.validIp()) {
                
                // 如果有效则遍历所有有效toff
                for (toff = ParamConstant.MIN_TOFF; toff.compareTo(ParamConstant.MAX_TOFF) != 1; toff = toff.add(ParamConstant.MIN_TOFF_CHANGE)) {
                    // 计算总成本并保留最小成本
                    calculateTotalCost(ton, toff, ip, height, length,preparedTime,emptyWalkTime);
                    
                }
            }
        }
        
        // 根据参数计算要求结果
        BigDecimal processedRa = ParamCaluculateUtil.getRaByTonAndIp(ton_min, ip_min);
        BigDecimal totalTime = TimeCalculateUtil.getTotalTime(ip_min, toff_min, height, length,preparedTime,emptyWalkTime);
        BigDecimal pulseProcessTime = TimeCalculateUtil.getPulseProcessTime(ip_min, toff_min, height, length);
        BigDecimal totalEnergy = EnergyCalculateUtil.getTotalEnergy(ip_min, toff_min, height, length,preparedTime,emptyWalkTime);
        BigDecimal pulseEnergy = EnergyCalculateUtil.getPulseEnergy(ip_min, toff_min, height, length);
        BigDecimal totalCost = calculateTotalCost(ton_min, toff_min, ip_min, height, length, preparedTime, emptyWalkTime);
        BigDecimal timeCost = calculateTimeCost(ton_min, toff_min, ip_min, height, length,preparedTime,emptyWalkTime);
        BigDecimal energyCost = calculateEnergyCost(ton_min, toff_min, ip_min, height, length,preparedTime,emptyWalkTime);
    
    
        CalculateResult calculateResult = new CalculateResult(processedRa.toString(),
                totalTime.toString(), pulseProcessTime.toString(),
                totalEnergy.toString(), pulseEnergy.toString(),
                totalCost.toString(), timeCost.toString(), energyCost.toString());
        return calculateResult;
        
        
    }
    
    /**
     * 计算时间成本
     */
    private static BigDecimal calculateTimeCost(BigDecimal tonMin, BigDecimal toffMin, BigDecimal ton_min, BigDecimal toff_min, BigDecimal ip_min, BigDecimal height, BigDecimal length) {
        return null;
    }
    /**
     * 计算能源成本
     */
    private static BigDecimal calculateEnergyCost(BigDecimal tonMin, BigDecimal toffMin, BigDecimal ton_min, BigDecimal toff_min, BigDecimal ip_min, BigDecimal height, BigDecimal length) {
        return null;
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
    private static BigDecimal calculateTotalCost(BigDecimal ton, BigDecimal toff, BigDecimal ip, BigDecimal height, BigDecimal length, BigDecimal preparedTime, BigDecimal emptyWalkTime) {
        //TODO
        // 计算总成本
        
        
        // 如果成本是目前最少
        
        // 则保留最小成本和电参数
        return null;
    }
}
