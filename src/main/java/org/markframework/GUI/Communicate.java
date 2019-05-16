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
import org.markframework.constant.ParamConstant;
import org.markframework.constant.TimeConstant;

/**
 * @author huang zhiqiang
 */
public class Communicate extends JFrame{
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
            marterialBox =formCreator.getComboBox("marterialBox");
            requestedRa = formCreator.getTextField("requestedRa");
            partLength = formCreator.getTextField("partLength");
            partHeight = formCreator.getTextField("partHeight");
            preparedTime = formCreator.getTextField("preparedTime");
            emptyWalkTime = formCreator.getTextField("emptyWalkTime");
            processedRa = formCreator.getTextField("requestedRa");
            totalProcessedTime = formCreator.getTextField("totalProcessedTime");
            pulseProcessedTime = formCreator.getTextField("pulseProcessedTime");
            totalProcessEnergy = formCreator.getTextField("totalProcessEnergy");
            pulseProcessEnergy = formCreator.getTextField("pulseProcessEnergy");
            totalCost = formCreator.getTextField("totalCost");
            energyCost = formCreator.getTextField("energyCost");
            timeCost = formCreator.getTextField("timeCost");
            message = formCreator.getLabel("message");
            
            
            //设置初始值
            marterialBox.setModel(new DefaultComboBoxModel<String>(ParamConstant.SUPPORTED_PROCESS_MATERIALS));
            preparedTime.setText(TimeConstant.DEFAULT_PREPARE_TIME.toString());
            emptyWalkTime.setText(TimeConstant.DEFAULT_EMPTY_WALK_TIME.toString());
            
            
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            
          
        } catch(Exception ex) {
        
        }
    }


    private void StartActionPerformed(ActionEvent e) {
       
        // 获取传入参数
    
        String selectedItem = (String) marterialBox.getSelectedItem();
        if(!selectedItem.equals("Q235")){
            message.setText("目前只支持Q235材料作为加工材料");
        }
        // 进行计算获得结果
        JTextField processedRa = formCreator.getTextField("processedRa");
        processedRa.setText("1");
        JTextField pulseProcessedTime = formCreator.getTextField("pulseProcessedTime");
        pulseProcessedTime.setText("2");
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
                        java.awt.Color.red), 输入.getBorder())); 输入.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

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
                label3.setText("\u8868\u9762\u7c97\u7cd9\u5ea6\u8981\u6c42(um)");
                输入.add(label3, "cell 3 1");
                输入.add(requestedRa, "cell 4 1");

                //---- label2 ----
                label2.setText("\u5de5\u4ef6\u52a0\u5de5\u957f\u5ea6(mm)");
                输入.add(label2, "cell 0 2");
                输入.add(partLength, "cell 1 2");

                //---- PartLength2 ----
                PartLength2.setText("\u5de5\u4ef6\u539a\u5ea6(mm)");
                输入.add(PartLength2, "cell 3 2");
                输入.add(partHeight, "cell 4 2");

                //---- label9 ----
                label9.setText("\u5f85\u673a\u65f6\u95f4(s)");
                输入.add(label9, "cell 0 3");
                输入.add(preparedTime, "cell 1 3");

                //---- PartLength3 ----
                PartLength3.setText("\u7a7a\u8d70\u65f6\u95f4(s)");
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
                    "[]"));

                //---- label13 ----
                label13.setText("\u8ba1\u7b97\u7ed3\u679c");
                label13.setHorizontalAlignment(SwingConstants.CENTER);
                输出.add(label13, "cell 2 0");

                //---- label4 ----
                label4.setText("\u5de5\u4ef6\u52a0\u5de5\u8d28\u91cf(um)");
                输出.add(label4, "cell 0 1");
                输出.add(processedRa, "cell 1 1");

                //---- label5 ----
                label5.setText("\u603b\u52a0\u5de5\u65f6\u95f4(s)");
                输出.add(label5, "cell 0 2");
                输出.add(totalProcessedTime, "cell 1 2");

                //---- label6 ----
                label6.setText("\u8109\u51b2\u52a0\u5de5\u65f6\u95f4(s)");
                输出.add(label6, "cell 3 2");
                输出.add(pulseProcessedTime, "cell 4 2");

                //---- label10 ----
                label10.setText("\u603b\u52a0\u5de5\u80fd\u8017(J)");
                输出.add(label10, "cell 0 3");
                输出.add(totalProcessEnergy, "cell 1 3");

                //---- label12 ----
                label12.setText("\u8109\u51b2\u5207\u5272\u80fd\u8017(J)");
                输出.add(label12, "cell 3 3");
                输出.add(pulseProcessEnergy, "cell 4 3");

                //---- label7 ----
                label7.setText("\u603b\u52a0\u5de5\u6210\u672c(\u5143)");
                输出.add(label7, "cell 0 4");
                输出.add(totalCost, "cell 1 4");

                //---- label11 ----
                label11.setText("\u80fd\u6e90\u6210\u672c(\u5143)");
                输出.add(label11, "cell 0 5");
                输出.add(energyCost, "cell 1 5");

                //---- label8 ----
                label8.setText("\u65f6\u95f4\u6210\u672c(\u5143)");
                输出.add(label8, "cell 3 5");
                输出.add(timeCost, "cell 4 5");
            }
            成本计算模型ContentPane.add(输出, "cell 0 2");
            成本计算模型.pack();
            成本计算模型.setLocationRelativeTo(成本计算模型.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

    }
}
