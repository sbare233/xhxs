package write;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JFileChooser;

public class acf implements ActionListener{//职责链模式
	write e;
	public acf(write e){
		this.e=e;
	}
	public void actionPerformed(ActionEvent event){
		always.dzf=0;
		for(int i=0;i<write.pb.length;i++){
			if(event.getSource()==write.pb[i]){
				String n=write.lj.getText();
				File nf=new File(n);
				String p=null;
				if(nf.isFile())p=nf.getParent()+"/"+write.pb[i].getText();	
				else p=nf.getPath()+"/"+write.pb[i].getText();
				rf.pad(p);
			}
		}
		if(event.getSource()==write.duqu){
			duquw.duqu();
		}
		else if(event.getSource()==write.shangyiji){
			File file=new File(write.lj.getText());
			if(file.isFile()){
				File file1=new File(file.getParent());
				write.lj.setText(file1.getParent());
				cunchumulu.cun();
			}
			else{
				write.lj.setText(file.getParent());
				cunchumulu.cun();
			}
			duquw.duqu();
		}
		else if(event.getSource()==write.xz){
			if(write.path!=null&&write.sf==0&&write.ssf==1)
				rt.writeto(write.path,write.tf.getText());
			NumberFormat f=new DecimalFormat("00000");
			int p=write.in1.getComponentCount()+1;
			File f0=new File(write.lj.getText());
			if(f0.isFile())
				write.lj.setText(f0.getParent());
			File xzj=new File(write.lj.getText()+"/"+f.format(p)+".txt");
			String xzjs=xzj.getPath();
			rt.writeto(xzjs,"");
			write.lj.setText(xzj.getParent());
			duquw.duqu();
			write.lj.setText(xzj.getPath());
			rf.pad(xzj.getPath());
		}
		else if(event.getSource()==write.re){
			File f0=new File(write.lj.getText());
			if(f0.isFile()){
				String s=null;
				String tx=write.tf.getText();
				try{
					s=tishi.rename();
					if(f0.isFile()&&s!=null){
						String s1=f0.getPath();
						File f1=new File(f0.getParent()+"/"+s+".txt");
						f0.renameTo(f1);
						write.lj.setText(f1.getParent());
						duquw.duqu();
						write.lj.setText(f1.getPath());
						File f2=new File(s1);
						f2.delete();
						rt.writeto(f1.getPath(), tx);
						rf.pad(f1.getPath());
					}
				}
				catch(Exception e){}
			}
			//System.out.print(s);
		}
		else if(event.getSource()==write.shape){
			write.tf.setFont(new Font((String) write.shape.getSelectedItem(),write.zf,Integer.parseInt(write.zihao.getText())));
		}
		else if(event.getSource()==write.zicu){
			if(write.zicu.isSelected())write.zf=1;
			else write.zf=0;
			write.tf.setFont(new Font((String) write.shape.getSelectedItem(),write.zf,Integer.parseInt(write.zihao.getText())));
			}
		else if(event.getSource()==write.auto){
			if (write.auto.isSelected()){
				write.ssf=1;
				//System.out.println(write.baocunjiange);
				
				write.time.start();
			}
			else{write.ssf=0;write.time.stop();} 
		}
		else if(event.getSource()==write.gund){
			if (write.gund.isSelected())write.gd=1;
			else write.gd=0;
		}
		else if(event.getSource()==write.bc)
		{
			new setcolor();
		}
		else if(event.getSource()==write.rrggbb){
			if(write.rrggbb.isSelected()){rrgb.rgb.start();}
			else rrgb.rgb.stop();
			write.rrggbb.setBackground(Color.LIGHT_GRAY);
			write.tf.setBackground(Color.WHITE);
			write.tf.setForeground(Color.BLACK);
			write.td.setBackground(Color.WHITE);
			write.td.setForeground(Color.BLACK);
		}//作为环境维护文本区域默认状态
		else if(event.getSource()==write.chexiao){
			cxcz.chexiao();
		}
		else if(event.getSource()==write.chongzuo){
			cxcz.chongzuo();
		}
		else if(event.getSource()==write.ycsx){
			write.sxycf=1;}
		else if(event.getSource()==write.yingcang){
			if(write.yc==1)write.yc=write.ync[0];
			else write.yc=write.ync[1];}
		else if(event.getSource()==write.yes){
			int ss=save.sa();
			if(ss==0)tishi.beifencuowu();
			else System.exit(0);
		}
		else if(event.getSource()==write.no){
			write.yn=write.ync[1];}
		else if(event.getSource()==write.cancel){
			write.yn=write.ync[2];
			write.tsf=0;}
		else if(event.getSource()==write.yes1){
			if(write.path!=null){
				File file=new File(write.path);
				if (file.exists() && file.isFile()){
					file.delete();
					write.sf=1;
					write.path=file.getParent();
					write.lj.setText(write.path);
				}
				duquw.duqu();}
			write.yn=write.ync[3];}
		else if(event.getSource()==write.no1){
			write.yn=write.ync[3];}
		else if(event.getSource()==write.shuaxing){
			String n=write.zihao.getText();
			if(n!=null&&n.length()>0)
				write.td.setFont(new Font((String) write.shape.getSelectedItem(),write.zf,Integer.parseInt(n)));
			}
		else if(event.getSource()==write.open){
			int status=write.opensave.showOpenDialog(null);
			if(status!=JFileChooser.APPROVE_OPTION){	
			}
			else
			{
				File file=write.opensave.getSelectedFile();
				rf.readfrom(file,write.tf);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				write.path=rf.pa;
				cunchumulu.cun();
				write.lj.setText(file.getPath());
				cunchumulu.cun();
				duquw.duqu();
			}
		}
		else if(event.getSource()==write.saveb){
			//System.out.println(write.path);
			//System.out.println(write.path1);
			int ss=save.sa();
			if(ss==0)tishi.beifencuowu();
		}
		
		else if(event.getSource()==write.open1){
			String l=write.lj1.getText();
			if(l.length()>2){
				File file=new File(l);
				rf.readfrom(file,write.td);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				write.path1=rf.pa;
			}
			else{
				int status1=write.opensave.showOpenDialog(null);
				if(status1!=JFileChooser.APPROVE_OPTION){	
				}
				else
				{
					File file=write.opensave.getSelectedFile();
					rf.readfrom(file,write.td);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					write.path1=rf.pa;
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
					write.lj1.setText(write.path1);
				}
			}
		}
		else if(event.getSource()==write.save1){
			String l=write.lj1.getText();
			if(l.length()>2){
				rt.writeto(l,write.td.getText());
			}
			else{
				int re1=write.opensave.showSaveDialog(null);
				if(re1==JFileChooser.APPROVE_OPTION)
				{
					rt.writeto(null,write.td.getText());
				}
				if(write.yn==0){System.exit(0);};
			}
		}
		else if(event.getSource()==write.shanchu){
			write.shanchud.setVisible(true);
		}
		else if(event.getSource()==write.find){
			find.f();
		}
		else if(event.getSource()==write.zishu){
			if(write.zishu.isSelected()){
				write.tfs=write.tf.getText();
				String Reg="^[\u4e00-\u9fa5]{1}$";
				write.result=0;
				for(int k=0;k<write.tfs.length();k++){
					if(shezhi.zhongwenf==1){
					String b=Character.toString(write.tfs.charAt(k));
					if(b.matches(Reg))
						write.result++;
					}
					else write.result++;
				}
				if(shezhi.zhongwenf==1)write.hz.setText("汉字数"+write.result);
				else write.hz.setText("字数"+write.result);
				write.jsf=1;
				}
			else {
				write.jsf=0;
				write.hz.setText(shezhi.st1);
				write.sd.setText(shezhi.st2);
			}
		}
		else if(event.getSource()==write.plus){
			if(write.plf==0)
				write.plf=1;
			else write.plf=0;
		}
		else if(event.getSource()==write.wye){
			wangye.wang();
		}
		else if(event.getSource()==write.mingan){
			if(write.tihuanyc==0){
				write.tihuanyc=1;
				write.tihuan.setVisible(true);
			}
			else{
				write.tihuanyc=0;
				write.tihuan.setVisible(false);
			}
		}
		else if(event.getSource()==write.qumin){
			if(write.suijiyc==0){
				write.suijiyc=1;
				write.suiji.setVisible(true);
			}
			else{
				write.suijiyc=0;
				write.suiji.setVisible(false);
			}
		}
		else if(event.getSource()==write.renwu){
			if(write.renwuyc==0){
				write.renwuyc=1;
				write.rw.setVisible(true);
			}
			else{
				write.renwuyc=0;
				write.rw.setVisible(false);
			}
		}
		else if(event.getSource()==write.dagang){
			tishi.weishixian();
		}
		else if(event.getSource()==write.beifen){
			String s=beifen.b();
			if(s!=null)
				tishi.beifen(s);
			else
				tishi.beifencuowu();
		}
		else if(event.getSource()==write.tongjimore){
			/*if(write.tongjiyc==0){
				write.tongjiyc=1;
				write.tongji.setVisible(true);
			}
			else{
				write.tongjiyc=0;
				write.tongji.setVisible(false);
			}*/
			tishi.weishixian();
		}
		else if(event.getSource()==write.jihuazs){
			try{
				tongji.jinrijihua=Integer.parseInt(tishi.jihua());}
			catch(NumberFormatException e){}
			write.jhzsls.setText(""+tongji.jinrijihua);
		}
		else if(event.getSource()==write.setting){
			if(write.shezhiyc==0){
				write.shezhiyc=1;
				write.shezhi.setVisible(true);
			}
			else{
				write.shezhiyc=0;
				write.shezhi.setVisible(false);
			}
		}
		else if(event.getSource()==shezhi.zymbxs){
			if(shezhi.zymbxs.isSelected()){
				shezhi.bsf=1;
			}
			else{
				shezhi.bsf=0;
			}
		}
		else if(event.getSource()==shezhi.zw){
			if(shezhi.zw.isSelected()){
				shezhi.zhongwenf=1;
			}
			else{
				shezhi.zhongwenf=0;
			}
		}
		else if(event.getSource()==shezhi.pz){
			if(shezhi.pz.isSelected()){
				shezhi.pzf=1;
			}
			else{
				shezhi.pzf=0;
				shezhi.baocun();
			}
		}
		else if(event.getSource()==shezhi.bj){
			if(shezhi.bj.isSelected()){
				shezhi.bjf=1;
			}
			else{
				shezhi.bjf=0;
			}
		}
		else if(event.getSource()==shezhi.szz){
			shezhi.st1=tishi.zuoyoumin1();
			write.hz.setText(shezhi.st1);
			shezhi.st2=tishi.zuoyoumin2();
			write.sd.setText(shezhi.st2);
		}
		else if(event.getSource()==shezhi.help){
			tishi.weishixian();
		}
		else if(event.getSource()==shezhi.bq){
			tishi.banquan();
		}
	}
}
