package org.markframework.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mark huang
 * @date 2019-05-16 09:27
 * @description：封装参数阈值的常量类
 * @modified By：
 */
public class ParamConstant {
    
//    /**
//     * 脉宽最大值（us）
//     */
//    public static final Integer MAX_TON =;
//    /**
//     * 脉宽最小值（us）
//     */
//    public static final Integer MIN_TON =;
//    /**
//     * 脉间距最大值（us）
//     */
//    public static final Integer MAX_TOFF =;
//    /**
//     * 脉间距最小值（us）
//     */
//    public static final Integer MIN_TOFF =;
//    /**
//     * 峰值电流最大值（A）
//     */
//    public static final Integer MAX_IP =;
//    /**
//     * 峰值电流最小值（A）
//     */
//    public static final Integer MIN_IP =;
    /**
     * 工件厚度最大值（mm）
     */
    public static final Integer PART_MAX_HEIGHT = 500;
    /**
     * 工件厚度最小值（mm）
     */
    public static final Integer PART_MIN_HEIGHT = 1;
    /**
     * 工件加工长度最小值（mm）
     */
    public static final Integer PART_MIN_PROCESS_LENGTH =1;
    /**
     * 表面粗糙度最大值（us）
     */
    public static final Double MAX_RA = 6.0;
    /**
     * 表面粗糙度最小值（us）
     */
    public static final Double MIN_RA = 2.0;
    /**
     * 支持加工的材料
     */
    public static final String[] SUPPORTED_PROCESS_MATERIALS = new String[]{"Q235","45"};
   
    
}
