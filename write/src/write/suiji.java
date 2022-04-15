package write;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
public class suiji extends JFrame implements ActionListener{
	static JPanel j1,j2,j3;
	static JTextArea mz;
	static JButton roll;
	static JTextField sd1,sd2,sjs,cdl;
	static ButtonGroup b;
	static JRadioButton dg,xg;
	static JLabel sdl1,sdl2,cd,sc,zw4,zw5,zw6;
	static JScrollPane jsp;
	static GridLayout gl;
	private static final long serialVersionUID = 1L;
	suiji(){
		super("随机取名");
		setBounds(write.dim.width/4+150,write.dim.height/4+150,500,400);
		setLayout(new BorderLayout());
		addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e)
		{write.suijiyc=0;}});
		add(j1=new JPanel(),BorderLayout.WEST);
		add(j2=new JPanel(gl=new GridLayout(8,0)),BorderLayout.EAST);
		add(j3=new JPanel(new FlowLayout(FlowLayout.RIGHT)),BorderLayout.SOUTH);
		mz=new JTextArea();
		mz.setWrapStyleWord(true);
		mz.setFont(new Font("Dialog",Font.BOLD,20));
		mz.setLineWrap(true);
		
		jsp=new JScrollPane(mz, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
	    		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		j1.add(jsp);
		jsp.setPreferredSize(new Dimension(397,307));
		j2.add(cd=new JLabel("名字长度"));
		j2.add(cdl=new JTextField());
		cdl.setFont(new Font("Dialog",Font.BOLD,20));
		cdl.setPreferredSize(new Dimension(25,25));
		cdl.setText("1");
		j2.add(sc=new JLabel("生成数"));
		sc.setFont(new Font("Dialog",Font.BOLD,20));
		j2.add(sjs=new JTextField());
		sjs.setFont(new Font("Dialog",Font.BOLD,20));
		sjs.setPreferredSize(new Dimension(25,25));
		sjs.setText("10");
		j2.add(zw5=new JLabel());
		j2.add(zw6=new JLabel());
		j2.add(xg=new JRadioButton("西国"));
		xg.setFont(new Font("Dialog",Font.BOLD,20));
		j2.add(dg=new JRadioButton("东国"));
		dg.setFont(new Font("Dialog",Font.BOLD,20));
		b=new ButtonGroup();
		b.add(dg);
		b.add(xg);
		dg.setSelected(true);
		j3.add(sdl1=new JLabel("锁定姓"));
		sdl1.setFont(new Font("Dialog",Font.BOLD,20));
		j3.add(sd1=new JTextField(5));
		sd1.setPreferredSize(new Dimension(50,25));
		sd1.setFont(new Font("Dialog",Font.BOLD,20));
		j3.add(sdl2=new JLabel("锁定名"));
		sdl2.setFont(new Font("Dialog",Font.BOLD,20));
		j3.add(sd2=new JTextField(5));
		sd2.setPreferredSize(new Dimension(50,25));
		sd2.setFont(new Font("Dialog",Font.BOLD,20));
		j3.add(roll=new JButton("生成"));
		roll.setFont(new Font("Dialog",Font.BOLD,20));
		roll.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==roll){
			mz.setText("");
			int l=10,ll=1,r=0;
			String sjss=sjs.getText();
			String cdls=cdl.getText();
			try{
				l=Integer.parseInt(sjss);
				ll=Integer.parseInt(cdls);
			}catch(NumberFormatException e1){}
			for(int i=0;i<l;i++){
				String s1=sd1.getText();
				String sy1="";
				if(s1.length()>0){}
				else{
					if(dg.isSelected()){
						r=(int)(Math.random()*xxg.xxg.length);
						s1=xdg.xdg[r];
					}
					else{
						r=(int)(Math.random()*xxg.xxg.length);
						s1=xxg.xxgc[r];
						sy1=xxg.xxg[r];
					}
				}
				String s2=sd2.getText();
				String sy2="";
				if(s2.length()>0){}
				else{
					for(int c=0;c<ll;c++){
						if(dg.isSelected()){
							r=(int)(Math.random()*mxg.mxg.length);
							s2+=mdg.mdg[r];
						}
						else{
							r=(int)(Math.random()*mxg.mxg.length);
							s2+=mxg.mxgc[r]+"·";
							sy2+=mxg.mxg[r]+"·";
						}
					}
				}
				if(dg.isSelected()){
					mz.append(s1);
					mz.append(s2);
					mz.append("\n");	
				}
				else{
					mz.append(s2);
					mz.append(s1);
					mz.append("  ");
					mz.append(sy2);
					mz.append(sy1);
					mz.append("\n");	
				}
			}
		}
	}
}
