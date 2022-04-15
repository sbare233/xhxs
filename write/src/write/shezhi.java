package write;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.Scanner;

import javax.swing.*;

public class shezhi extends JFrame{
	private static final long serialVersionUID = 1L;
	static int zhongwenf=1,up;
	static int pzf=1,bjf=1,bsf=0;
	static JLabel tj,jg;
	static JTextField js;
	static JPanel s1,s2,s3;
	static JCheckBox zw,pz,bj,zymbxs;
	static JButton szz,help,bq;
	static String st1,st2;
	static File f=new File(write.cunchu+"/设置.txt");
	shezhi(){
		super("设置");
		setBounds(write.dim.width/4+300,write.dim.height/4+250,260,200);
		setLayout(new GridLayout(5,1));
		addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e)
		{write.shezhiyc=0;}});
		
		add(s3=new JPanel(new FlowLayout()));
		
		s3.add(szz=new JButton("设置座右铭"));
		szz.addActionListener(write.acf);
		s3.add(zymbxs=new JCheckBox("不显示座右铭"));
		zymbxs.addActionListener(write.acf);
		tj=new JLabel("计速间隔");
		js=new JTextField(3);
		js.setText("1");
		js.setFont(new Font("Dialog",write.zf,18));
		js.addCaretListener(write.caf);
		jg=new JLabel("秒    ");
		zw=new JCheckBox("只统计中文");
		zw.setSelected(true);
		zw.addActionListener(write.acf);
		add(s1=new JPanel(new FlowLayout()));
		s1.add(tj);
		s1.add(js);
		s1.add(jg);
		s1.add(zw);
		pz=new JCheckBox("保存配置              ");
		pz.setSelected(true);
		pz.addActionListener(write.acf);
		bj=new JCheckBox("保存背景");
		bj.setSelected(true);
		bj.addActionListener(write.acf);
		add(s2=new JPanel(new FlowLayout()));
		s2.add(pz);
		s2.add(bj);
		add(help=new JButton("帮助"));
		help.addActionListener(write.acf);
		add(bq=new JButton("版权"));
		bq.addActionListener(write.acf);
		duquw.duqu();
		try {
			FileInputStream s=new FileInputStream(f);
			Scanner sc=new Scanner(s);
			
			st1=sc.nextLine();
			st2=sc.nextLine();
			
			bsf=sc.nextInt();
			if(bsf==1)zymbxs.setSelected(true);
			else zymbxs.setSelected(false);
			if(bsf==0){
				write.hz.setText(st1);
				write.sd.setText(st2);
			}
			
			write.jsjg=sc.nextInt();
			js.setText(""+write.jsjg);
			
			zhongwenf=sc.nextInt();
			if(zhongwenf==1)zw.setSelected(true);
			else zw.setSelected(false);
			
			pzf=sc.nextInt();
			if(pzf==1)pz.setSelected(true);
			else pz.setSelected(false);
			
			write.jsf=sc.nextInt();
			if(write.jsf==1)write.zishu.setSelected(true);
			else write.zishu.setSelected(false);
			
			write.ssf=sc.nextInt();
			if(write.ssf==1){
				write.auto.setSelected(true);
				write.time.start();
			}
			else write.auto.setSelected(false);
			
			up=sc.nextInt();
			if(up==1)write.updown.setSelected(true);
			else write.updown.setSelected(false);
			
			
			write.gd=sc.nextInt();
			if(write.gd==1)write.gund.setSelected(true);
			else write.gund.setSelected(false);
			
			/*int r=sc.nextInt();
			if(r==1)write.rrggbb.setSelected(true);
			else write.rrggbb.setSelected(false);*/
			
			write.zf=sc.nextInt();
			if(write.zf==1)write.zicu.setSelected(true);
			else write.zicu.setSelected(false);
			
			bjf=sc.nextInt();
			if(bjf==1)bj.setSelected(true);
			else bj.setSelected(false);
			
			int r=sc.nextInt();
			int g=sc.nextInt();
			int b=sc.nextInt();
			if(bjf==1){
				write.color=new Color(r, g, b);
				write.tf.setBackground(new Color(255-r,255-g,255-b));
				write.td.setBackground(new Color(255-r,255-g,255-b));
				write.tf.setForeground(write.color);
				write.td.setForeground(write.color);
			}
			
			sc.close();
			s.close();
		} catch (Exception e1) {}
	}
	static void baocun(){
		if(st1==null)st1="";
		if(st2==null)st2="";
		rt.writeto(f.getPath(),st1+"\n"+st2+"\n"+bsf+"\n"+write.jsjg+" "+zhongwenf+"\n"+pzf+" "+write.jsf+" "+write.ssf+" "+up+" "+write.gd+" "+write.zf+"\n"+bjf+" "+write.color.getRed()+" "+write.color.getGreen()+" "+write.color.getBlue()
				+ "\n座右铭1"
				+ "\n座右铭2"
				+"\n"+"不显示座右铭"
				+"\n"+"计速间隔  只统计中文"
				+ "\n保存配置  开启统计  自动  向上  沉底  加粗"
				+ "\n保存背景  (文字)红度 绿度 蓝度");
	}
}
