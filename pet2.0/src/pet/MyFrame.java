/**
 * 
 */
package pet;

import java.awt.Button;
/**
 * @author 性感渣渣傲在线打bug
 * 2019年8月21日 上午11:35:15
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

	 
	public class MyFrame {
	 
		public static void main(String[] args) {
			
			
			JFrame frame = new JFrame("My Frame");//new一个窗体
			frame.setSize(500 , 500);//窗体大小
			frame.getContentPane().setBackground(Color.white);//背景颜色
			
			Menu(frame);
			
			
			
//			frame.add(contentPane);//显示布局管理器
			frame.setVisible(true); //显示JFrame
			
			
			
			
			BufferedReader intemp = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Press return key to exit.");
			try{
				String s = intemp.readLine();
			} catch(IOException e){
				System.out.println("IOException");
			}
			System.exit(0);
		}
		//主菜单
		public static void Menu(Frame frame) {
			
			JPanel panel1 = new JPanel();
			panel1.setBackground(Color.white);
			frame.add(panel1);
			panel1.setLayout(new GridLayout(4,1,5,5));
			Button button1 = new Button("1");
			Button button2 = new Button("2");
			Button button3 = new Button("3");
			
			
			button1.setBounds(5,1,50,50);
			panel1.add(button1);
			panel1.add(button2);
			panel1.add(button3);
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}