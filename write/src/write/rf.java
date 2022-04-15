package write;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.Timer;
import javax.swing.JTextArea;

public class rf extends Thread{
	public static String pa;
	public static int toolongf=0,i=0,k=0;
	public static Timer timer=new Timer(200, new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(i<10) i++;}});;
	File file;
	JTextArea t;
	public rf(File file,JTextArea t){
		this.file=file;
		this.t=t;
	}
	public void run(){
		always.jf=1;
		if(write.jsf==1)
			write.jsf=2;
        String pa = null;
        t.setText("");
        pa=file.getAbsolutePath();
        //String suffix = pa.substring(pa.lastIndexOf("."));
        //System.out.println(suffix);
        rf.pa=pa;
        //if(suffix==".txt")
        if(file.isFile()){
        try{
        	InputStream fr=new FileInputStream(file);
        	BufferedReader br=new BufferedReader(new InputStreamReader(fr,"UTF-8"));
            String s=null;
            while ((s=br.readLine())!=null) {
            	if(i>9){
            		timer.stop();
            		br.close();
                    fr.close();
                    i=0;
                    toolongf=1;
                    tishi.haoda();
            	}
                t.append(s);
                t.append("\n");
            }
            br.close();
            fr.close();
            always.inif=0;
    		write.result=0;
            timer.stop();
            i=0;
            always.jf=2;
            if(write.jsf==2)
            	write.jsf=1;
        }catch (IOException e){
            if(toolongf==0)
            	tishi.baocuo(pa);
        }}
        
       
    }
	public static void readfrom(File file,JTextArea t){
		
		Thread rft=new rf(file,t);
		rft.start();
		toolongf=0;
		timer.start();
		
	}
	public static void pad(String p) {
		File file=new File(p);
		if(file.isFile()){
			String kt=write.tf.getText();
			if(write.path!=null&&write.sf==0&&write.ssf==1)
				if(kt!=null&&kt.length()>0)
					rt.writeto(write.path,kt);
			write.sf=0;
			readfrom(file,write.tf);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			write.path=rf.pa;
			write.lj.setText(write.path);
            cunchumulu.cun();
			}
		else{
			write.lj.setText(p);
			cunchumulu.cun();
			duquw.duqu();
		}
	}
}
