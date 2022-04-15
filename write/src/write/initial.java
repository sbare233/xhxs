package write;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.regex.Pattern;

public class initial {
	static Pattern np=Pattern.compile("-?\\d+(\\.\\d+)?");
	static String ppp;
	static void in(){
		String usr=System.getenv("USERNAME");
		ppp="C:/Users/"+usr+"/Documents/序号小说编辑器三";
		File dic=new File(ppp);
		if(!dic.exists()){
			dic.mkdir();
		}
		String cs=ppp+"/参数.txt";
		write.lj1.setText(cs);
		File ins=new File(cs);
		if(!ins.exists()||ins.length()==0){
			rt.writeto(ins.getAbsolutePath(),ppp+"\n"+ppp+"\n"+cs+"\n"+"www.baidu.com"+"\n"+"5000"+"\n"+"300000"+"\n"+"(此处开始可删)"+"\n"+"本处存储参数，"
		+"\n"+"第二行是本软件"+"\n"+"默认存储数据的"+"\n"+"目录，第三行是"+"\n"+"这个参数的目录"+"\n"+"第四行存一网址"+
					"\n"+"左上自动选框可"+"\n"+"每隔第五行毫秒"+"\n"+"保存文本和参数"+"\n"
					+"撤销重做ctrl+z/d"+"\n"+"隐藏alt+a/s/d"+"\n"+"其他看帮助文档");
			 try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
				}
			 }
		try{
			FileReader fr=new FileReader(ins);
			BufferedReader br=new BufferedReader(fr);
	        String s=null;
	        if((s=br.readLine())!=null){
	        	File f=new File(s);
	        	write.path=s;
	        	rf.readfrom(f,write.tf);
	        	write.lj.setText(s);
	        	duquw.duqu();
	        }
	        if((s=br.readLine())!=null){
	        	
	        	write.cunchu=s;
	        	shezhi.f=new File(write.cunchu+"/设置.txt");
	        	tongji.f=new File(write.cunchu+"/统计.txt");
	        	String mgc=s+"/敏感词库(一个词占一行，修改后下次打开软件生效).txt";
	        	File cik=new File(mgc);
	        	if(!cik.exists()||cik.length()==0){
	        		OutputStream fw=new FileOutputStream(cik);
	                BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(fw,"UTF-8"));
	                for(int i=0;i<ciku.ciku.length;i++){
	                	bw.append(ciku.ciku[i]);
	                	bw.append("\n");
	                }
	                bw.close();
	                fw.close();
	        	}
	        	else{
	        		FileReader fr1=new FileReader(cik);
	    			BufferedReader br1=new BufferedReader(fr1);
					String[] ci=new String[100000];
	    			String s1=null;
					int i=0;
	    	        while ((s1=br1.readLine())!=null) { 	
	    	        	ci[i]=s1;
	                    i++;
	                }
	    	        br1.close();
	    	        fr1.close();
	    	        ciku.ciku=ci;
	        	}
	        	String bf=s+"/备份";
	    		File d=new File(bf);
	    		if(!d.exists()){
	    			d.mkdir();
	    		}
	        	String dg=s+"/大纲";
	    		File d1=new File(dg);
	    		if(!d1.exists()){
	    			d1.mkdir();
	    		}
	    		String rw=s+"/人物";
	    		File d2=new File(rw);
	    		if(!d2.exists()){
	    			d2.mkdir();
	    		}
	    		String sz=s+"/设置.txt";
	    		File f=new File(sz);
	    		if(!f.exists()){
	    			rt.writeto(sz,"笔落惊风雨\n诗成泣鬼神\n"+"0\n"+"1 1"+"\n"+"1 1 0 0 0 0 "+"\n"+"1 0 0 0"
	    					+ "\n座右铭1"
	    					+ "\n座右铭2"
	    					+ "\n不显示座右铭"
	    					+"\n"+"计速间隔  只统计中文"
	    					+ "\n保存配置  开启统计  自动  向上  沉底  加粗"
	    					+ "\n保存背景  (文字)红度 绿度 蓝度");
	    		}
	    		String tj=s+"/统计.txt";
	    		File f1=new File(tj);
	    		if(!f1.exists()){
	    			rt.writeto(tj,"");
	    		}
	        }
	        if((s=br.readLine())!=null){
	        	write.lj1.setText(s);
	        	File f=new File(s);
	        	rf.readfrom(f,write.td);
	        }
	        if((s=br.readLine())!=null){
	        	write.wy.setText(s);
	        }
	        if((s=br.readLine())!=null&&np.matcher(s).matches()){
	        	write.baocunjiange=Integer.parseInt(s);
	        }
	        if((s=br.readLine())!=null&&np.matcher(s).matches()){
	        	write.beifenjiange=Integer.parseInt(s);
	        }
	        br.close();
	        fr.close();
	        //rf.readfrom(ins,write.td);
	        try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	        
	        write.path1=write.lj1.getText();
		}catch(IOException e){}
		
	}
}//装饰模式
