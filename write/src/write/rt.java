package write;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class rt extends Thread{
	String path,t;
	public rt(String path,String t){
		this.path=path;
		this.t=t;
	}
	public void run() {
		if(path==null)
			path = write.opensave.getSelectedFile().getPath()+".txt"; 
		try {
			File file=new File(path);
            OutputStream fw=new FileOutputStream(file);
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(fw,"UTF-8"));
            bw.write(t);
            bw.close();
            fw.close();
        } 
		catch (IOException e1) {
        	e1.printStackTrace();
        	if(write.ssf==0)
        		tishi.baocuo(path);
        }
	}
	public static void writeto(String path,String t){
		Thread rtt=new rt(path,t);
		rtt.start();
	}
}
