/**
 * 
 */
package pet;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年8月21日 下午3:38:46
 */
import java.awt.*;
import java.awt.event.*;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;

import sun.java2d.d3d.D3DGraphicsConfig;
 
 
//这个代表扫雷窗口
class button1 extends JFrame {
    public button1() {
        getContentPane().setBackground(Color.BLUE);
        setTitle("新建游戏");
        setSize(MenuFrame.W, MenuFrame.H);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
 
        
        
        
        
    }
}
//这个代表围棋窗口
class button2 extends JFrame {
    public button2() {
        getContentPane().setBackground(Color.ORANGE);
        setTitle("继续游戏");
        setSize(MenuFrame.W, MenuFrame.H);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}

//这个代表菜单选择窗口
public class MenuFrame extends JFrame implements ActionListener {
    public static final int W = 600;
    public static final int H = 400;
    
    JButton jb1, jb2,jb3;
 
    public MenuFrame() {
 
    	
    	
        JPanel jp = new JPanel();
        BoxLayout box = new BoxLayout(jp, BoxLayout.Y_AXIS);//垂直方向的布局
        jp.setLayout(box);
        JLabel label = new JLabel("菜单",JLabel.RIGHT);
        
        jp.add(label);

    	
    	setVisible(true);
        
        jb1 = new JButton("继续游戏");
        jb1.addActionListener(this);
        jb2 = new JButton("新建游戏");
        jb2.addActionListener(this);
        jb3 = new JButton("测试");
        jb3.addActionListener(this);
        
        jp.add(jb1);
        jp.add(jb2);
        jp.add(jb3);
        
        add(jp);
        setLayout(new FlowLayout());
        setTitle("java Game Center");
        setSize(W, H);
        setLocationRelativeTo(null);//窗口居中
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
 
    public static void main(String[] args) {
 
        SwingUtilities.invokeLater(() -> {
            new MenuFrame().setVisible(true);//启动菜单窗口
        });
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jb = (JButton) e.getSource();
        if (jb == jb1) {
            //隐藏关闭菜单窗口
            this.setVisible(false);
            this.dispose();
            //打开扫雷窗口
            new button1().setVisible(true);
 
        } else if (jb == jb2) {
            this.setVisible(false);
            this.dispose();
            new button2().setVisible(true);
        }
 
    }
}