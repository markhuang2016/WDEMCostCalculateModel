/*
 * Created by JFormDesigner on Tue May 14 18:22:58 CST 2019
 */

package org.markframework.GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.jformdesigner.model.FormModel;
import com.jformdesigner.runtime.FormCreator;
import com.jformdesigner.runtime.FormLoader;
import com.sun.tools.internal.xjc.model.Model;
import net.miginfocom.swing.*;
import org.markframework.Pojo.CalculateInput;
import org.markframework.Pojo.CalculateResult;
import org.markframework.constant.ParamConstant;
import org.markframework.constant.TimeConstant;
import org.markframework.util.CostCalculateUtil;
import org.markframework.util.ParamValidUtil;

/**
 * @author huang zhiqiang
 */
public class Communicate extends JFrame {
    FormCreator formCreator;
    
    
    public Communicate() {
        initComponents();
        try {
            // 加载界面内容
            FormModel formModel = FormLoader.load(
                    "org/markframework/GUI/Communicate.jfd");
            
            formCreator = new FormCreator(formModel);
            formCreator.setTarget(this);
            formCreator.createAll();
            
            //创建可视化界面
            JFrame frame = formCreator.getFrame("成本计算模型");
            frame.setTitle("成本计算模型");
            
            //获取对象引用
            marterialBox = formCreator.getComboBox("marterialBox");
            requestedRa = formCreator.getTextField("requestedRa");
            partLength = formCreator.getTextField("partLength");
            partHeight = formCreator.getTextField("partHeight");
            preparedTime = formCreator.getTextField("preparedTime");
            emptyWalkTime = formCreator.getTextField("emptyWalkTime");
            processedRa = formCreator.getTextField("processedRa");
            totalProcessedTime = formCreator.getTextField("totalProcessedTime");
            pulseProcessedTime = formCreator.getTextField("pulseProcessedTime");
            totalProcessEnergy = formCreator.getTextField("totalProcessEnergy");
            pulseProcessEnergy = formCreator.getTextField("pulseProcessEnergy");
            totalCost = formCreator.getTextField("totalCost");
            energyCost = formCreator.getTextField("energyCost");
            timeCost = formCreator.getTextField("timeCost");
            ton = formCreator.getTextField("ton");
            toff = formCreator.getTextField("toff");
            ip = formCreator.getTextField("ip");
            
            message = formCreator.getLabel("message");
            
            
            //设置初始值
            marterialBox.setModel(new DefaultComboBoxModel<String>(ParamConstant.SUPPORTED_PROCESS_MATERIALS));
            preparedTime.setText(TimeConstant.DEFAULT_PREPARE_TIME.toString());
            emptyWalkTime.setText(TimeConstant.DEFAULT_EMPTY_WALK_TIME.toString());
            
            
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            
            
        } catch (Exception ex) {
        
        }
    }
    
    private boolean flag = true;
    
    private void StartActionPerformed(ActionEvent e) {
        flag = true;
        message.setText("");
        
        // 获取传入参数
        
        // 材料选择
        String material = (String) marterialBox.getSelectedItem();
        // 要求粗糙度
        String requestedRaText = requestedRa.getText();
        // 空走时间
        String emptyWalkTimeText = emptyWalkTime.getText();
        
        // 工件厚度
        String partHeightText = partHeight.getText();
        
        // 工件长度
        String partLengthText = partLength.getText();
        // 待机时间
        String preparedTimeText = preparedTime.getText();
        try {
            // 进行有效性验证
            if (!ParamValidUtil.validMaterial(material)) {
                message.setText("请选择下拉框中支持的材料");
                flag = false;
            }
            
            if (!ParamValidUtil.validRa(requestedRaText)) {
                message.setText("粗糙度要求不合法，请在2.0至6.0之间选择，最小精度0.1");
                flag = false;
            }
            if (!ParamValidUtil.validPartHeight(partHeightText)) {
                message.setText("工件厚度不合法，请在1至500之间选择，最小精度1");
                flag = false;
            }
            if (!ParamValidUtil.validPartLength(partLengthText)) {
                message.setText("工件长度不合法，请输入大于0的整数");
                flag = false;
            }
            
            if (!ParamValidUtil.validTime(preparedTimeText)) {
                message.setText("待机时间不合法，请输入大于0的整数");
                flag = false;
            }
            
            
            if (!ParamValidUtil.validTime(emptyWalkTimeText)) {
                message.setText("空走时间不合法，请输入大于0的整数");
                flag = false;
                
            }
            
        } catch (Exception e1) {
            message.setText("请传入正确完整的参数");
            flag = false;
        }
        
        if (flag) {
            CalculateInput calculateInput = new CalculateInput();
            calculateInput.setMaterial(material);
            calculateInput.setRequestRa(requestedRaText);
            calculateInput.setLength(partLengthText);
            calculateInput.setHeight(partHeightText);
            calculateInput.setPreparedTime(preparedTimeText);
            calculateInput.setEmptyWalkTime(emptyWalkTimeText);
            
            // 进行计算获得结果
            CalculateResult calculate = CostCalculateUtil.calculate(calculateInput);
            
            
            // 显示计算结果
            
            // 预期粗糙度
            processedRa.setText(calculate.getProcessdRa());
            
            // 总加工时间
            totalProcessedTime.setText(calculate.getTotalTime());
            
            // 脉冲加工时间
            pulseProcessedTime.setText(calculate.getPulseTProcessTime());
            
            // 总加工能耗
            totalProcessEnergy.setText(calculate.getTotalEenergy());
            
            // 脉冲加工能耗
            pulseProcessEnergy.setText(calculate.getPulseEnergy());
            
            // 总成本
            totalCost.setText(calculate.getTotalCost());
            
            // 时间成本
            timeCost.setText(calculate.getTimeCost());
            
            // 能源成本
            energyCost.setText(calculate.getEnergyCost());
            
            // 脉宽
            ton.setText(calculate.getTon());
            
            // 脉间距
            toff.setText(calculate.getToff());
            
            // 峰值电流
            ip.setText(calculate.getIp());
            
        } else {
            // 预期粗糙度
            processedRa.setText("");
            
            // 总加工时间
            totalProcessedTime.setText("");
            
            // 脉冲加工时间
            pulseProcessedTime.setText("");
            
            // 总加工能耗
            totalProcessEnergy.setText("");
            
            // 脉冲加工能耗
            pulseProcessEnergy.setText("");
            
            // 总成本
            totalCost.setText("");
            
            // 时间成本
            timeCost.setText("");
            
            // 能源成本
            energyCost.setText("");
    
            // 脉宽
            ton.setText("");
    
            // 脉间距
            toff.setText("");
    
            // 峰值电流
            ip.setText("");
        }
        
        
    }
    
    
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - markhuang
    private JFrame 成本计算模型;
    private JPanel 输入;
    private JLabel label1;
    private JLabel PartLength;
    private JComboBox marterialBox;
    private JLabel label3;
    private JTextField requestedRa;
    private JLabel label2;
    private JTextField partLength;
    private JLabel PartLength2;
    private JTextField partHeight;
    private JLabel label9;
    private JTextField preparedTime;
    private JLabel PartLength3;
    private JTextField emptyWalkTime;
    private JButton Start;
    private JLabel message;
    private JPanel 输出;
    private JLabel label13;
    private JLabel label4;
    private JTextField processedRa;
    private JLabel label5;
    private JTextField totalProcessedTime;
    private JLabel label6;
    private JTextField pulseProcessedTime;
    private JLabel label10;
    private JTextField totalProcessEnergy;
    private JLabel label12;
    private JTextField pulseProcessEnergy;
    private JLabel label7;
    private JTextField totalCost;
    private JLabel label11;
    private JTextField energyCost;
    private JLabel label8;
    private JTextField timeCost;
    private JLabel label14;
    private JTextField ton;
    private JLabel label15;
    private JTextField toff;
    private JLabel label16;
    private JTextField ip;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    
    
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - markhuang
        成本计算模型 = new JFrame();
        输入 = new JPanel();
        label1 = new JLabel();
        PartLength = new JLabel();
        marterialBox = new JComboBox();
        label3 = new JLabel();
        requestedRa = new JTextField();
        label2 = new JLabel();
        partLength = new JTextField();
        PartLength2 = new JLabel();
        partHeight = new JTextField();
        label9 = new JLabel();
        preparedTime = new JTextField();
        PartLength3 = new JLabel();
        emptyWalkTime = new JTextField();
        Start = new JButton();
        message = new JLabel();
        输出 = new JPanel();
        label13 = new JLabel();
        label4 = new JLabel();
        processedRa = new JTextField();
        label5 = new JLabel();
        totalProcessedTime = new JTextField();
        label6 = new JLabel();
        pulseProcessedTime = new JTextField();
        label10 = new JLabel();
        totalProcessEnergy = new JTextField();
        label12 = new JLabel();
        pulseProcessEnergy = new JTextField();
        label7 = new JLabel();
        totalCost = new JTextField();
        label11 = new JLabel();
        energyCost = new JTextField();
        label8 = new JLabel();
        timeCost = new JTextField();
        label14 = new JLabel();
        ton = new JTextField();
        label15 = new JLabel();
        toff = new JTextField();
        label16 = new JLabel();
        ip = new JTextField();
        
        //======== 成本计算模型 ========
        {
            Container 成本计算模型ContentPane = 成本计算模型.getContentPane();
            成本计算模型ContentPane.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[fill]",
                    // rows
                    "[]" +
                            "[]" +
                            "[]"));
            
            //======== 输入 ========
            {
                
                // JFormDesigner evaluation mark
                输入.setBorder(new javax.swing.border.CompoundBorder(
                        new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                                java.awt.Color.red), 输入.getBorder()));
                输入.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                    public void propertyChange(java.beans.PropertyChangeEvent e) {
                        if ("border".equals(e.getPropertyName())) throw new RuntimeException();
                    }
                });
                
                输入.setLayout(new MigLayout(
                        "hidemode 3",
                        // columns
                        "[150:150,fill]" +
                                "[100:100,fill]" +
                                "[100:100,fill]" +
                                "[150:150,fill]" +
                                "[100:100,fill]",
                        // rows
                        "[]" +
                                "[]" +
                                "[]" +
                                "[]" +
                                "[]" +
                                "[]" +
                                "[]"));
                
                //---- label1 ----
                label1.setText("\u8ba1\u7b97\u8f93\u5165");
                label1.setHorizontalAlignment(SwingConstants.CENTER);
                输入.add(label1, "cell 2 0");
                
                //---- PartLength ----
                PartLength.setText("\u5de5\u4ef6\u6750\u6599");
                输入.add(PartLength, "cell 0 1");
                输入.add(marterialBox, "cell 1 1");
                
                //---- label3 ----
                label3.setText("\u8868\u9762\u7c97\u7cd9\u5ea6\u8981\u6c42\uff08um\uff09");
                输入.add(label3, "cell 3 1");
                输入.add(requestedRa, "cell 4 1");
                
                //---- label2 ----
                label2.setText("\u5de5\u4ef6\u52a0\u5de5\u957f\u5ea6\uff08mm\uff09");
                输入.add(label2, "cell 0 2");
                输入.add(partLength, "cell 1 2");
                
                //---- PartLength2 ----
                PartLength2.setText("\u5de5\u4ef6\u539a\u5ea6\uff08mm\uff09");
                输入.add(PartLength2, "cell 3 2");
                输入.add(partHeight, "cell 4 2");
                
                //---- label9 ----
                label9.setText("\u5f85\u673a\u65f6\u95f4\uff08s\uff09");
                输入.add(label9, "cell 0 3");
                输入.add(preparedTime, "cell 1 3");
                
                //---- PartLength3 ----
                PartLength3.setText("\u7a7a\u8d70\u65f6\u95f4\uff08s\uff09");
                输入.add(PartLength3, "cell 3 3");
                输入.add(emptyWalkTime, "cell 4 3");
                
                //---- Start ----
                Start.setText("\u5f00\u59cb\u8ba1\u7b97");
                Start.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        StartActionPerformed(e);
                    }
                });
                输入.add(Start, "cell 2 4");
                输入.add(message, "cell 2 5");
            }
            成本计算模型ContentPane.add(输入, "cell 0 0 1 2");
            
            //======== 输出 ========
            {
                输出.setLayout(new MigLayout(
                        "hidemode 3",
                        // columns
                        "[150:150,fill]" +
                                "[100:100,fill]" +
                                "[100:100,fill]" +
                                "[150:150,fill]" +
                                "[100:100,fill]",
                        // rows
                        "[]" +
                                "[]" +
                                "[]" +
                                "[]" +
                                "[]" +
                                "[]" +
                                "[]" +
                                "[]" +
                                "[]" +
                                "[]"));
                
                //---- label13 ----
                label13.setText("\u8ba1\u7b97\u7ed3\u679c");
                label13.setHorizontalAlignment(SwingConstants.CENTER);
                输出.add(label13, "cell 2 0");
                
                //---- label4 ----
                label4.setText("\u5de5\u4ef6\u52a0\u5de5\u8d28\u91cf\uff08um\uff09");
                输出.add(label4, "cell 0 1");
                输出.add(processedRa, "cell 1 1");
                
                //---- label5 ----
                label5.setText("\u603b\u52a0\u5de5\u65f6\u95f4\uff08s\uff09");
                输出.add(label5, "cell 0 2");
                输出.add(totalProcessedTime, "cell 1 2");
                
                //---- label6 ----
                label6.setText("\u8109\u51b2\u52a0\u5de5\u65f6\u95f4\uff08s\uff09");
                输出.add(label6, "cell 3 2");
                输出.add(pulseProcessedTime, "cell 4 2");
                
                //---- label10 ----
                label10.setText("\u603b\u52a0\u5de5\u80fd\u8017\uff08J\uff09");
                输出.add(label10, "cell 0 3");
                输出.add(totalProcessEnergy, "cell 1 3");
                
                //---- label12 ----
                label12.setText("\u8109\u51b2\u5207\u5272\u80fd\u8017\uff08J\uff09");
                输出.add(label12, "cell 3 3");
                输出.add(pulseProcessEnergy, "cell 4 3");
                
                //---- label7 ----
                label7.setText("\u603b\u52a0\u5de5\u6210\u672c\uff08\u5143\uff09");
                输出.add(label7, "cell 0 4");
                输出.add(totalCost, "cell 1 4");
                
                //---- label11 ----
                label11.setText("\u80fd\u6e90\u6210\u672c\uff08\u5143\uff09");
                输出.add(label11, "cell 0 5");
                输出.add(energyCost, "cell 1 5");
                
                //---- label8 ----
                label8.setText("\u65f6\u95f4\u6210\u672c\uff08\u5143\uff09");
                输出.add(label8, "cell 3 5");
                输出.add(timeCost, "cell 4 5");
                
                //---- label14 ----
                label14.setText("\u63a8\u8350\u8109\u5bbd\uff08us\uff09");
                输出.add(label14, "cell 0 6");
                输出.add(ton, "cell 1 6");
                
                //---- label15 ----
                label15.setText("\u63a8\u8350\u8109\u95f4\u8ddd\uff08us\uff09");
                输出.add(label15, "cell 3 6");
                输出.add(toff, "cell 4 6");
                
                //---- label16 ----
                label16.setText("\u63a8\u8350\u5cf0\u503c\u7535\u6d41\uff08A\uff09");
                输出.add(label16, "cell 0 7");
                输出.add(ip, "cell 1 7");
            }
            成本计算模型ContentPane.add(输出, "cell 0 2");
            成本计算模型.pack();
            成本计算模型.setLocationRelativeTo(成本计算模型.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        
    }
}
