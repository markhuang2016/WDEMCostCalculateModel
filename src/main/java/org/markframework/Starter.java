package org.markframework;

import com.jformdesigner.model.FormModel;
import com.jformdesigner.runtime.FormCreator;
import com.jformdesigner.runtime.FormLoader;
import org.markframework.GUI.Communicate;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * @author mark huang
 * @date 2019-05-16 09:21
 * @description：有主函数的启动入口类
 * @modified By：
 */
public class Starter {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Communicate();
            }
        });
    }
   
}
