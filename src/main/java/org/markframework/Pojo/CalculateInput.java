package org.markframework.Pojo;

/**
 * @author mark huang
 * @date 2019-05-17 13:20
 * @description：计算输入
 * @modified By：
 */
public class CalculateInput {
   
   
   private String length;
   private String height;
   private String material;
   private String requestRa;
   private String preparedTime;
   private String emptyWalkTime;
    
    public CalculateInput() {
    }
    
    public CalculateInput(String length, String height, String material, String requestRa, String preparedTime, String emptyWalkTime) {
        this.length = length;
        this.height = height;
        this.material = material;
        this.requestRa = requestRa;
        this.preparedTime = preparedTime;
        this.emptyWalkTime = emptyWalkTime;
    }
    
    public String getLength() {
        return length;
    }
    
    public void setLength(String length) {
        this.length = length;
    }
    
    public String getHeight() {
        return height;
    }
    
    public void setHeight(String height) {
        this.height = height;
    }
    
    public String getMaterial() {
        return material;
    }
    
    public void setMaterial(String material) {
        this.material = material;
    }
    
    public String getPreparedTime() {
        return preparedTime;
    }
    
    public void setPreparedTime(String preparedTime) {
        this.preparedTime = preparedTime;
    }
    
    public String getEmptyWalkTime() {
        return emptyWalkTime;
    }
    
    public void setEmptyWalkTime(String emptyWalkTime) {
        this.emptyWalkTime = emptyWalkTime;
    }
    
    public String getRequestRa() {
        return requestRa;
    }
    
    public void setRequestRa(String requestRa) {
        this.requestRa = requestRa;
    }
    
    @Override
    public String toString() {
        return "CalculateInput{" +
                "length='" + length + '\'' +
                ", height='" + height + '\'' +
                ", material='" + material + '\'' +
                ", requestRa='" + requestRa + '\'' +
                ", preparedTime='" + preparedTime + '\'' +
                ", emptyWalkTime='" + emptyWalkTime + '\'' +
                '}';
    }
}
