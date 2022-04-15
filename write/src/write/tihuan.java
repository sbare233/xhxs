package write;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
public class tihuan extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	static JRadioButton rb1,rb2,rb3,rb4;
	static ButtonGroup bg=new ButtonGroup();
	static JButton tihuanqueding;
	tihuan(){
		super("替换敏感词");
		setBounds(write.dim.width/4+300,write.dim.height/4+250,260,200);
		setLayout(new GridLayout(5,1));
		addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e)
		{write.tihuanyc=0;}});
		rb1=new JRadioButton("将“黄色电影”换成“黄.色.电.影”");
		rb2=new JRadioButton("将“黄色电影”换成“黄|色|电|影”");
		rb3=new JRadioButton("将“黄色电影”换成“黄-色-电-影”");
		rb4=new JRadioButton("将“黄色电影”换成“****”");
		add(rb1);
		add(rb2);
		add(rb3);
		add(rb4);
		bg.add(rb1);
		bg.add(rb2);
		bg.add(rb3);
		bg.add(rb4);
		rb1.setSelected(true);
		add(tihuanqueding=new JButton("确认替换  (可以撤销)"));
		tihuanqueding.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==tihuanqueding&&(rb1.isSelected()||rb2.isSelected()||rb3.isSelected()||rb4.isSelected())){
			String th=write.tf.getText();
			//System.out.print(th);
			for(int i=0;i<ciku.ciku.length&&ciku.ciku[i]!=null;i++){
				String s=null;
				StringBuffer sb=new StringBuffer(20);
				sb.append(ciku.ciku[i]);
				
				if(rb1.isSelected()){
					if(th.indexOf(ciku.ciku[i])!=-1){
						for(int j=1;j<(int)(ciku.ciku[i].length()*1.5);j+=2)
							sb.insert(j,'.');
						s=sb.toString();
						if(ciku.ciku[i].length()==1){
							s=ciku.ciku[i+1];
						}
					}
				}
				if(rb2.isSelected()){
					if(th.indexOf(ciku.ciku[i])!=-1){
						for(int j=1;j<(int)(ciku.ciku[i].length()*1.5);j+=2)
							sb.insert(j,'|');
						s=sb.toString();
						if(ciku.ciku[i].length()==1){
							s=ciku.ciku[i+1];
						}
					}
				}
				if(rb3.isSelected()){
					if(th.indexOf(ciku.ciku[i])!=-1){
						for(int j=1;j<(int)(ciku.ciku[i].length()*1.5);j+=2)
							sb.insert(j,'-');
						s=sb.toString();
						if(ciku.ciku[i].length()==1){
							s=ciku.ciku[i+1];
						}
					}
				}
				if(rb4.isSelected()){
					if(th.indexOf(ciku.ciku[i])!=-1){
						s="";
						for(int j=0;j<ciku.ciku[i].length();j++)
							s+='*';
					}
				}
				if(s!=null)
					th=th.replaceAll(ciku.ciku[i],s);
			}
			write.tf.setText(th);
		}
	}
}
