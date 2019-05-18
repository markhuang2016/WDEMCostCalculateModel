package org.markframework.Pojo;

/**
 * @author mark huang
 * @date 2019-05-17 13:24
 * @description：计算结果
 * @modified By：
 */
public class CalculateResult {
    
    private String processdRa;
    private String totalTime;
    private String pulseTProcessTime;
    private String totalEenergy;
    private String pulseEnergy;
    private String totalCost;
    private String timeCost;
    private String energyCost;
    private String ton;
    private String toff;
    private String ip;
    
    
    public CalculateResult() {
    }
    
    public CalculateResult(String processdRa, String totalTime, String pulseTProcessTime, String totalEenergy, String pulseEnergy, String totalCost, String timeCost, String energyCost, String ton, String toff, String ip) {
        this.processdRa = processdRa;
        this.totalTime = totalTime;
        this.pulseTProcessTime = pulseTProcessTime;
        this.totalEenergy = totalEenergy;
        this.pulseEnergy = pulseEnergy;
        this.totalCost = totalCost;
        this.timeCost = timeCost;
        this.energyCost = energyCost;
        this.ton = ton;
        this.toff = toff;
        this.ip = ip;
    }
    
    public String getTon() {
        return ton;
    }
    
    public void setTon(String ton) {
        this.ton = ton;
    }
    
    public String getToff() {
        return toff;
    }
    
    public void setToff(String toff) {
        this.toff = toff;
    }
    
    public String getIp() {
        return ip;
    }
    
    public void setIp(String ip) {
        this.ip = ip;
    }
    
    public String getProcessdRa() {
        return processdRa;
    }
    
    public void setProcessdRa(String processdRa) {
        this.processdRa = processdRa;
    }
    
    public String getTotalTime() {
        return totalTime;
    }
    
    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }
    
    public String getPulseTProcessTime() {
        return pulseTProcessTime;
    }
    
    public void setPulseTProcessTime(String pulseTProcessTime) {
        this.pulseTProcessTime = pulseTProcessTime;
    }
    
    public String getTotalEenergy() {
        return totalEenergy;
    }
    
    public void setTotalEenergy(String totalEenergy) {
        this.totalEenergy = totalEenergy;
    }
    
    public String getPulseEnergy() {
        return pulseEnergy;
    }
    
    public void setPulseEnergy(String pulseEnergy) {
        this.pulseEnergy = pulseEnergy;
    }
    
    public String getTotalCost() {
        return totalCost;
    }
    
    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }
    
    public String getTimeCost() {
        return timeCost;
    }
    
    public void setTimeCost(String timeCost) {
        this.timeCost = timeCost;
    }
    
    public String getEnergyCost() {
        return energyCost;
    }
    
    public void setEnergyCost(String energyCost) {
        this.energyCost = energyCost;
    }
    
    @Override
    public String toString() {
        return "CalculateResult{" +
                "processdRa='" + processdRa + '\'' +
                ", totalTime='" + totalTime + '\'' +
                ", pulseTProcessTime='" + pulseTProcessTime + '\'' +
                ", totalEenergy='" + totalEenergy + '\'' +
                ", pulseEnergy='" + pulseEnergy + '\'' +
                ", totalCost='" + totalCost + '\'' +
                ", timeCost='" + timeCost + '\'' +
                ", energyCost='" + energyCost + '\'' +
                ", ton='" + ton + '\'' +
                ", toff='" + toff + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
