package org.markframework.util;

import org.markframework.constant.ParamConstant;

import java.math.BigDecimal;

/**
 * @author mark huang
 * @date 2019-05-17 12:56
 * @description：判断传入参数是否是有效值
 * @modified By：
 */
public class ParamValidUtil {
    
    private static final BigDecimal zero = new BigDecimal(0);
    
    public static boolean validRa(String requestedRaText) {
        BigDecimal ra = new BigDecimal(requestedRaText);
        if (isNotBetween(ra,ParamConstant.MAX_RA,ParamConstant.MIN_RA)) {
            return false;
        }
        if (isNotTimes(ra,ParamConstant.MIN_RA_CHANGE)) {
            return false;
        }
        return true;
    }
    
    public static boolean validTime(String timeText) {
        BigDecimal bigDecimal = new BigDecimal(timeText);
        if(isNotTimes(bigDecimal,ParamConstant.MIN_TIME_CHANGE)){
            return false;
        }
        if(isNotPositive(bigDecimal)){
            return false;
        }
        return true;
    }
    
    public static boolean validMaterial(String material) {
        return true;
    }
    
    public static boolean validPartHeight(String partHeightText) {
        BigDecimal bigDecimal = new BigDecimal(partHeightText);
        if (isNotBetween(bigDecimal,ParamConstant.PART_MAX_HEIGHT,ParamConstant.PART_MIN_HEIGHT)) {
            return false;
        }
        if (isNotTimes(bigDecimal,ParamConstant.MIN_PART_SIZE_CHANGE)) {
            return false;
        }
        return true;
    }
    
    public static boolean validPartLength(String partLengthText) {
        BigDecimal bigDecimal = new BigDecimal(partLengthText);
        if (isNotPositive(bigDecimal)) {
            return false;
        }
        if (isNotTimes(bigDecimal,ParamConstant.MIN_PART_SIZE_CHANGE)) {
            return false;
        }
        return true;
    
    }
    
    private static boolean isNotTimes(BigDecimal param , BigDecimal minChange) {
        BigDecimal[] bigDecimals = param.divideAndRemainder(minChange);
        BigDecimal bigDecimal = bigDecimals[1];
        if (bigDecimal.compareTo(zero) != 0) {
            return true;
        }
        return false;
    }
    
    private static boolean isNotBetween(BigDecimal param, BigDecimal max, BigDecimal min) {
        if (param.compareTo(max)==1){
            return true;
        }
        if (param.compareTo(min)==-1){
            return true;
        }
        return false;
    }
    
    private static boolean isNotPositive(BigDecimal bigDecimal) {
        
        if(bigDecimal.compareTo(zero)==1){
            return false;
        }
        return true;
    }
    
    public static boolean validIp() {
        //TODO
        return false;
    }
}
