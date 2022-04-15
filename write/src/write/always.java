package write;

public class always extends Thread {//每200毫秒运行一次，计时和计数等
	static write e;
	static long kongxian=0,dazi=0;
	static int i = 0,si=0,zs=0,sd=0,tx=0,k=0,kxx=0,dzz=0,yszs=0,k1=0,jssd=0;
	static int chexiaof = 0,dzf=0,cdf=0,inif=0,jf=0,bf=0;
	public always(write e) {
		always.e = e;
	}
	
	static Runnable alwayss() throws InterruptedException{
		
		while(true){
			//String tft=write.tf.getText();
			//System.out.println(write.cunchu);
			//System.out.println(write.path);
			//System.out.println(write.path1);
			int tfi=write.tf.getText().length();
			sleep(200);
			String tft1=write.tf.getText();
			int tfi1=write.tf.getText().length();
			if(write.tsf==1){
				try {
					sleep(10);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			if(write.yc==0){
				write.create.setVisible(false);
				write.index.setVisible(false);
			}
			if(write.yc==1){
				write.create.setVisible(true);
				write.index.setVisible(true);
			}
			if(write.yc==2){
				write.create.setVisible(true);
				write.index.setVisible(false);
			}
			if(write.yc==3){
				write.create.setVisible(false);
				write.index.setVisible(true);
			}
			if(write.sxycf==0){
				write.cmdpanel.setVisible(true);
				write.oth.setVisible(true);
			}
			if(write.sxycf==1){
				write.cmdpanel.setVisible(false);
				write.oth.setVisible(false);
			}
			if(write.plf==0){
				write.chexiao.setVisible(false);
				write.chongzuo.setVisible(false);
				write.ycsx.setVisible(false);
				write.yingcang.setVisible(false);
				write.shuaxing.setVisible(false);
				write.mingan.setVisible(true);
				write.qumin.setVisible(true);
				write.beifen.setVisible(true);
				write.dagang.setVisible(true);
				write.renwu.setVisible(true);
			}
			if(write.plf==1){
				write.chexiao.setVisible(true);
				write.chongzuo.setVisible(true);
				write.ycsx.setVisible(true);
				write.yingcang.setVisible(true);
				write.shuaxing.setVisible(true);
				write.mingan.setVisible(false);
				write.qumin.setVisible(false);
				write.beifen.setVisible(false);
				write.dagang.setVisible(false);
				write.renwu.setVisible(false);
			}
			if(write.yn==1){
				System.exit(0);
			}
			if(write.yn==2){
				write.closesave.setVisible(false);
				sleep(10);
				e.setVisible(true);
				
				write.yn=9;
			}
			if(write.yn==3){
				write.shanchud.setVisible(false);
				e.setVisible(true);
				write.yn=9;
			}
			if(write.gd==1){
				write.scr.getVerticalScrollBar().setValue(write.scr.getVerticalScrollBar().getMaximum());
				write.tf.repaint();
			}
			boolean tn=tfi!=tfi1;
			if(tn&&chexiaof==0){	
				write.ss.add(tft1);
				i++;
				if(i>9){
					write.ss.remove(0);
					i--;
				}	
			}
			else if(tn&&chexiaof==1){
				chexiaof=0;
			}
			if(bf<write.beifenjiange/200){bf++;}
			else{bf=0;beifen.b();}
			if(tx<51)
				tx++;
			if(tx==10){
				jssd++;
				if(sd!=0)
					tongji.pjsd=(tongji.pjsd*(jssd-1)+sd)/jssd;
			}
			if(tx>50&&dzf==1){
				tx=0;
				dzf=0;
				if(shezhi.bsf==0){
					write.hz.setText(shezhi.st1);
					write.sd.setText(shezhi.st2);
				}
			}
			if(write.result!=zs){
				dzf=1;
				tx=0;
			}
			//System.out.print(dzf);
			String Reg="^[\u4e00-\u9fa5]{1}$";
	       /*if(inif<3)inif++;
	        if(inif==3){
	        	write.jsf=1;
	        	write.zishu.setSelected(true);
	        }*/
			if(write.jsf==0)
				write.jinri.setVisible(false);
			if(write.jsf==1){
				write.jinri.setVisible(true);
				if(tn){
					write.result=0;
					for(int i=0;i<tft1.length();i++){
						if(shezhi.zhongwenf==1){
							String b=Character.toString(tft1.charAt(i));
							if(b.matches(Reg)){
								write.result++;
								
							}
						}
						else write.result++;
					}
					if(shezhi.zhongwenf==1)
						write.hz.setText("汉字数"+write.result);
					else write.hz.setText("字数"+write.result);
					if(jf==1){}
					else if(jf==2){jf=0;k1=k;yszs=write.result;}
					else {
						if(write.result-yszs>0)
							k=write.result-yszs+k1;
						else 
							k=write.result-yszs;
						}
					tongji.jinrizishu=tongji.sczishu+k;
					write.jtzsls.setText(""+tongji.jinrizishu);
					write.bczsls.setText(""+k);
				}
			}
			int sj=5;
			int js=3600;
			if(write.jsjg>0){
				sj=write.jsjg*5;
				js=3600/write.jsjg;
			}	
			if(si<sj&&write.jsf==1){
				if(si==0){
					zs=write.result;
				}
				si++;
			}
			if(dzf==1&&si>=sj){
				int v=write.result-zs;
				//if(inif==0){inif++;yszs=write.result;k+=write.result-yszs;}
				//else k+=write.result-zs;
				//if(tfi>tfi1)k++;
				//write.bczsls.setText(""+k);
				if(write.jsf==1){
					si=0;
					
					int sds=(v)*js;
					if(sds>-30000&&sds<30000){
						write.sd1.add(String.valueOf(sds));
						cdf++;
						if(cdf>100){
							write.sd1.remove(1);
							cdf--;
						}
						int sum=(v)*js;
						for(int i=0;i<cdf;i++){
							//System.out.print(write.sd1.get(i)+"  ");
							sum+=Integer.parseInt(write.sd1.get(i));
						}
						//System.out.print(cdf);
						//System.out.print("\n");
						sd=sum/cdf;
					}
					if(sd>0&&sd<30000){
						if(shezhi.zhongwenf==1)
							write.sd.setText("每小时汉字"+sd);
						else write.sd.setText("每小时字数"+sd);
					}
				}
			}
			if(always.dzf==0){
				kongxian+=200;
				int kx=(int)(kongxian/60000);
				if(kx!=kxx){
					kxx=kx;
					if(kx>59){
						int kxx=(int)kx/60;
						kx=kx%60;
						write.kongxian.setText("空闲时间："+kxx+"时"+kx+"分");
					}
					else write.kongxian.setText("空闲时间："+kx+"分钟");
				}
			}
			if(always.dzf==1){
				dazi+=200;
				int dz=(int)(dazi/60000);
				if(dz!=dzz){
					dzz=dz;
					if(dz>59){
						int dzx=(int)dz/60;
						dz=dz%60;
						write.dazi.setText("打字时间："+dzx+"时"+dz+"分");
					}
					else write.dazi.setText("打字时间："+dz+"分钟");
				}
			}
		}
	}
}
// 外观模式 在write最后调用