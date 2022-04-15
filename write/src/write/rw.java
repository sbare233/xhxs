package write;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

public class rw extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	static JLabel mingzi,xingbie,lichang,gexing,jiban,diwei,jinli,wupin;
	static JTextField mz,xb,lc,gx,jb,dw;
	static JTextArea jl;
	static JButton save,delete,lichangs,gexings,xingjian,xingwp,yes1,no1;
	static JButton[] w=new JButton[2000];
	static JPanel g0,g1,g2,g3,g4,g5,o1,wp;
	static JScrollPane jls,wps;
	static JComboBox<String> rwlb;
	static JDialog shanchud;
	static ArrayList<wupin> ws=new ArrayList<wupin>();
	static String wpss;
	static String[] rws;
	static int si=-1,qji=0;
	rw(){
		super("人物卡");
		setBounds(write.dim.width/4+150,write.dim.height/4+150,400,550);
		addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e)
		{write.renwuyc=0;}});
		add(o1=new JPanel(new GridLayout(6,1)),BorderLayout.NORTH);
		jl=new JTextArea("经历：");
		jl.setWrapStyleWord(true);
		jl.setFont(new Font("Dialog",Font.BOLD,15));
		jl.setLineWrap(true);
		
		jls=new JScrollPane(jl, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
	    		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jls.setPreferredSize(new Dimension(400,120));
		add(jls,BorderLayout.SOUTH);
		wp=new JPanel(new FlowLayout(FlowLayout.LEFT,2,4));
		
		
		wps=new JScrollPane(wp, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
	    		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		add(wps,BorderLayout.CENTER);
		wp.setPreferredSize(new Dimension(360,3000));
		wps.setPreferredSize(new Dimension(400,200));
		
		wp.add(wupin=new JLabel("物品栏"));
		wp.add(xingwp=new JButton("新物品"));
		xingwp.addActionListener(this);
		
		o1.add(g0=new JPanel(new FlowLayout(FlowLayout.LEFT,10,4)));
		
		File file=new File(write.cunchu+"/人物");
		rws=file.list();
		g0.add(rwlb=new JComboBox<String>(rws));
		rwlb.setSelectedIndex(si);
		rwlb.addActionListener(this);
		
		g0.add(save=new JButton("保存"));
		save.setMargin(new Insets(2,0,2,0));
		save.addActionListener(this);
		g0.add(delete=new JButton("删除"));
		delete.setMargin(new Insets(2,0,2,0));
		delete.addActionListener(this);
		g0.add(xingjian=new JButton("新人物"));
		xingjian.setMargin(new Insets(2,0,2,0));
		xingjian.addActionListener(this);
		o1.add(g1=new JPanel(new FlowLayout(FlowLayout.LEFT,2,4)));
		
		g1.add(mingzi=new JLabel("名字"));
		g1.add(mz=new JTextField(15));
		mz.setFont(new Font("Dialog",write.zf,15));
		g1.add(xingbie=new JLabel("性别"));
		g1.add(xb=new JTextField(5));
		xb.setFont(new Font("Dialog",write.zf,15));
		
		o1.add(g2=new JPanel(new FlowLayout(FlowLayout.LEFT,2,4)));
		g2.add(lichang=new JLabel("立场"));
		g2.add(lc=new JTextField(20));
		lc.setFont(new Font("Dialog",write.zf,15));
		g2.add(lichangs=new JButton("选择立场"));
		lichangs.setMargin(new Insets(2,0,2,0));
		lichangs.addActionListener(this);
		o1.add(g3=new JPanel(new FlowLayout(FlowLayout.LEFT,2,4)));
		g3.add(gexing=new JLabel("个性"));
		g3.add(gx=new JTextField(20));
		gx.setFont(new Font("Dialog",write.zf,15));
		g3.add(gexings=new JButton("选择个性"));
		gexings.setMargin(new Insets(2,0,2,0));
		gexings.addActionListener(this);
		o1.add(g4=new JPanel(new FlowLayout(FlowLayout.LEFT,2,4)));
		g4.add(jiban=new JLabel("羁绊"));
		g4.add(jb=new JTextField(25));
		jb.setFont(new Font("Dialog",write.zf,15));
		o1.add(g5=new JPanel(new FlowLayout(FlowLayout.LEFT,2,4)));
		g5.add(diwei=new JLabel("地位"));
		g5.add(dw=new JTextField(25));
		dw.setFont(new Font("Dialog",write.zf,15));

		shanchud =new JDialog(this,"是否删除？");
		JPanel s1=new JPanel();
		shanchud.add(s1);
		shanchud.setBounds(write.dim.width/4+140,write.dim.height/4,250,80);
		yes1=new JButton("是");
		yes1.addActionListener(this);
		s1.add(yes1);
		no1=new JButton("不删除");
		no1.addActionListener(this);
		s1.add(no1);
		shanchud.setModal(true);
		shanchud.setDefaultCloseOperation(HIDE_ON_CLOSE);
		readfrom(write.cunchu+"/人物"+rwlb.getSelectedItem());
	}
	
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<w.length;i++){
			if(e.getSource()==w[i]){
				new wpsz(i);
			}
		}
		if(e.getSource()==xingwp){
			new wpsz(-1);
		}
		if(e.getSource()==save){
			writeto();
			String k=mz.getText()+".txt";
			if(rwlb.getSelectedIndex()<0)rwlb.addItem(k);
			else if(k.indexOf(rwlb.getSelectedItem().toString())==-1)rwlb.addItem(k);
		}
		if(e.getSource()==delete){
			shanchud.setVisible(true);
		}
		if(e.getSource()==yes1){
			delete(write.cunchu+"/人物/"+rwlb.getSelectedItem());
			shanchud.setVisible(false);
			for(int i=ws.size();i>0;i--){
				ws.remove(i-1);
			}
			si=-1;
			write.rw=new rw();
			write.rw.setVisible(true);
			dispose();
		}
		if(e.getSource()==no1){
			shanchud.setVisible(false);
		}
		if(e.getSource()==xingjian){
			for(int i=ws.size();i>0;i--){
				ws.remove(i-1);
			}
			si=-1;
			write.rw=new rw();
			write.rw.setVisible(true);
			dispose();
		}
		if(e.getSource()==rwlb){
			if(rwlb.getSelectedIndex()!=si){
				for(int i=ws.size();i>0;i--){
					ws.remove(i-1);
				}
				for(int i=0;w[i]!=null;i++){
					wp.remove(w[i]);
					w[i]=null;
					wp.repaint();
				}
				readfrom(write.cunchu+"/人物/"+rwlb.getSelectedItem());
				refresh();
				si=rwlb.getSelectedIndex();
			}
		}
		if(e.getSource()==lichangs){
			new xzlc();
		}
		if(e.getSource()==gexings){
			new xzgx();
		}
	}
	void readwp(){
		Scanner sc1=new Scanner(wpss);
		while(sc1.hasNext()){
			String name=sc1.next();
			String amount=sc1.next();
			String intro=sc1.next();
			ws.add(new wupin(name,amount,intro));
			w[qji]=new JButton(amount+" "+name);
			w[qji].setMargin(new Insets(0,0,0,0));
			wp.add(w[qji]);
			//System.out.println(ws.get(qji).getName());
			w[qji].addActionListener(this);
			qji++;
		}
		qji=0;
		sc1.close();
		wps.getVerticalScrollBar().setValue(1);
		wps.getVerticalScrollBar().setValue(0);
	}
	void readfrom(String path){
		File rf=new File(path);
		try {
			FileInputStream i=new FileInputStream(rf);
			Scanner sc=new Scanner(i);
			mz.setText(sc.nextLine());
			xb.setText(sc.nextLine());
			lc.setText(sc.nextLine());
			gx.setText(sc.nextLine());
			jb.setText(sc.nextLine());
			dw.setText(sc.nextLine());
			wpss=sc.nextLine();
			jl.setText("");
			while(sc.hasNextLine()){
				jl.append(sc.nextLine());
			}
			sc.close();
			i.close();
			readwp();
		} catch (Exception e) {}
		
	}
	
	void writeto(){
		if(mz.getText().length()>0){
			String path=write.cunchu+"/人物/"+mz.getText()+".txt";
			wpss="";
			for(int i=0;i<ws.size();i++){
				wpss+=ws.get(i).getName()+" ";
				wpss+=ws.get(i).getAmount()+" ";
				wpss+=ws.get(i).getIntro()+" ";
			}
			rt.writeto(path,
							mz.getText()+"\n"+
							xb.getText()+"\n"+
							lc.getText()+"\n"+
							gx.getText()+"\n"+
							jb.getText()+"\n"+
							dw.getText()+"\n"+
							wpss+"\n"+
							jl.getText()
					);
		}
		if(rwlb.getItemCount()>=si&&si>-1)
			rwlb.remove(si);
	}
	void delete(String path){
		File d=new File(path);
		d.delete();
			if(rwlb.getItemCount()>=si&&si>-1)
				rwlb.remove(si);
	}
	void refresh(){
		for(int i=ws.size();i>-1;i--){
			if(w[i]!=null){
				w[i].setVisible(false);
				wp.remove(w[i]);
			}
		}
		for(int i=0;i<ws.size();i++){
			//System.out.print(ws.get(i).getName());
			wp.add(w[i]=new JButton(ws.get(i).getAmount()+" "+ws.get(i).getName()));
			w[i].addActionListener(this);
			w[i].setVisible(true);
		}
		wps.getVerticalScrollBar().setValue(1);
		wps.getVerticalScrollBar().setValue(0);
	}
	class wpsz extends JFrame implements ActionListener{
		private static final long serialVersionUID = 1L;
		int a;
		JLabel namel,amountl,introl;
		JTextField name,amount;
		JTextArea intro;
		JButton yes,del,no;
		wpsz(int as){
			super("物品详情");
			this.a=as;
			setBounds(write.dim.width/4+150,write.dim.height/4+300,300,170);
			setLayout(new FlowLayout(FlowLayout.CENTER,4,4));
			add(namel=new JLabel("名字"));
			add(name=new JTextField(12));
			add(amountl=new JLabel("数量"));
			add(amount=new JTextField(5));
			add(introl=new JLabel("简介"));
			add(intro=new JTextArea(4,20));
			if(a!=-1){
				name.setText(ws.get(a).getName());
				amount.setText(ws.get(a).getAmount());
				intro.setText(ws.get(a).getIntro());
			}
			add(yes=new JButton("确定"));
			yes.addActionListener(this);
			add(del=new JButton("删除"));
			del.addActionListener(this);
			add(no=new JButton("取消"));
			no.addActionListener(this);
			setVisible(true);
			if(a==-1){
				del.setVisible(false);
			}
		}
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==this.yes){
				String na="无",am="1",in="无";
				if(name.getText().length()>0)
				na=name.getText();
				if(amount.getText().length()>0)
				am=amount.getText();
				if(intro.getText().length()>0)
				in=intro.getText();
				if(a==-1){
					
					ws.add(0,new wupin(na,am,in));
					refresh();
				}
				else{
					ws.set(a,new wupin(na,am,in));
					refresh();
				}
				this.dispose();
			}
			if(e.getSource()==this.del){
				ws.remove(a);
				refresh();
				this.dispose();
			}
			if(e.getSource()==this.no){
				this.dispose();
			}
		}
	}
	class xzlc extends JFrame implements ActionListener{
		private static final long serialVersionUID = 1L;
		JPanel xz1;
		JButton[] lcsb=new JButton[100];
		String[] lcs={"守序善良","中立善良","混乱善良","守序中立","绝对中立","混乱中立","守序邪恶","中立邪恶","混乱邪恶"};
		xzlc(){
			setBounds(write.dim.width/4+150,write.dim.height/4+150,300,300);
			add(xz1=new JPanel(new GridLayout(3,3)));
			for(int i=0;i<9;i++){
				xz1.add(lcsb[i]=new JButton(lcs[i]));
				lcsb[i].setMargin(new Insets(0,0,0,0));
				lcsb[i].addActionListener(this);
			}
			this.setVisible(true);
		}
		public void actionPerformed(ActionEvent e) {
			for(int i=0;i<9;i++){
				if(e.getSource()==lcsb[i]){
					lc.setText(lcs[i]);
					this.dispose();
				}
			}
		}
	}
	class xzgx extends JFrame implements ActionListener{
		private static final long serialVersionUID = 1L;
		JPanel xz2,s,x;
		JLabel x1,x2,x3,x4;
		JButton[] gxsb=new JButton[100];
		String[] gxs={"ISTJ检查官","ISFJ护卫者","INFJ咨询师","INFP治疗师/化解者","ESTJ监督者","ESFJ供给者/销售员","ENFJ教导者","ENFP倡导者",
				"ISTP操作者/演奏者","ISFP艺术家","INTJ科学家/策划","INTP设计师","ESTP创业者","ESFP/示范者/表演者","ENTJ统帅/调度员","ENTP发明家"};
		xzgx(){
			setBounds(write.dim.width/4+150,write.dim.height/4+150,500,500);
			add(s=new JPanel(new GridLayout(1,2)),BorderLayout.NORTH);
			s.setPreferredSize(new Dimension(400,50));
			s.add(x1=new JLabel("  SJ  教条型，护卫者"));
			s.add(x2=new JLabel("  NF  友善型，理想主义者"));
			add(xz2=new JPanel(new GridLayout(4,4)));
			add(x=new JPanel(new GridLayout(1,2)),BorderLayout.SOUTH);
			x.setPreferredSize(new Dimension(400,50));
			x.add(x3=new JLabel("  SP  探索型，艺术创造者"));
			x.add(x4=new JLabel("  NT  坚定型，理性者"));
			for(int i=0;i<16;i++){
				xz2.add(gxsb[i]=new JButton(gxs[i]));
				gxsb[i].setMargin(new Insets(0,0,0,0));
				gxsb[i].addActionListener(this);
			}
			this.setVisible(true);
		}
		public void actionPerformed(ActionEvent e) {
			for(int i=0;i<16;i++){
				if(e.getSource()==gxsb[i]){
					gx.setText(gxs[i]);
					this.dispose();
				}
			}
		}
	}
}
