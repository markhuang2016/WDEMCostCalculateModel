package org.markframework.constant;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mark huang
 * @date 2019-05-16 09:27
 * @description：封装参数阈值的常量类
 * @modified By：
 */
public class ParamConstant {
    
    /**
     * 脉宽最大值（us）
     */
    public static final BigDecimal MAX_TON =  new BigDecimal("512");
    /**
     * 脉宽最小值（us）
     */
    public static final BigDecimal MIN_TON =  new BigDecimal("1");
    /**
     * 脉宽最小变化量（us）
     */
    public static final BigDecimal MIN_TON_CHANGE =  new BigDecimal("1");
    /**
     * 脉间距最大值（us）
     */
    public static final BigDecimal MAX_TOFF =  new BigDecimal("32");
    /**
     * 脉间距最小值（us）
     */
    public static final BigDecimal MIN_TOFF =  new BigDecimal("1");
    /**
     * 脉间距最小变化量（us）
     */
    public static final BigDecimal MIN_TOFF_CHANGE =  new BigDecimal("1");
    /**
     * 峰值电流最大值（A）
     */
    public static final BigDecimal MAX_IP = new BigDecimal("15");
    /**
     * 峰值电流最小值（A）
     */
    public static final BigDecimal MIN_IP = new BigDecimal("0.1");
    /**
     * 峰值电流最小变化量（A）
     */
    public static final BigDecimal MIN_IP_CHANGE = new BigDecimal("0.1");
    /**
     * 工件厚度最大值（mm）
     */
    public static final BigDecimal PART_MAX_HEIGHT = new BigDecimal("500");
    /**
     * 工件厚度最小值（mm）
     */
    public static final BigDecimal PART_MIN_HEIGHT =  new BigDecimal("1");
    /**
     * 工件加工长度最小值（mm）
     */
    public static final BigDecimal PART_MIN_PROCESS_LENGTH =  new BigDecimal("1");
    /**
     * 工件尺寸最小变化量（mm）
     */
    public static final BigDecimal MIN_PART_SIZE_CHANGE =  new BigDecimal("1");
    /**
     * 表面粗糙度最大值（us）
     */
    public static final BigDecimal MAX_RA = new BigDecimal("6.0");
    /**
     * 表面粗糙度最小值（us）
     */
    public static final BigDecimal MIN_RA = new BigDecimal("2.0");
    /**
     * 峰值电流最小变化值（A）
     */
    public static final BigDecimal MIN_RA_CHANGE = new BigDecimal("0.1");
    /**
     * 时间最小值（s）
     */
    public static final BigDecimal MIN_TIME = new BigDecimal("1");
    /**
     * 时间最小变化量（s）
     */
    public static final BigDecimal MIN_TIME_CHANGE =  new BigDecimal("1");
    /**
     * 支持加工的材料
     */
    public static final String[] SUPPORTED_PROCESS_MATERIALS = new String[]{"Q235"};
    
    
}
