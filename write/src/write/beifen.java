package write;
import java.text.SimpleDateFormat;
import java.util.Date;

public class beifen {
	static String b(){
		Date d = new Date();
		SimpleDateFormat sbf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
		String time=sbf.format(d);
		String s=write.cunchu+"/备份/"+time+".txt";
		String t=write.tf.getText();
		if(t!=null&&t.length()>0){
			rt.writeto(s,t);
			return s;
			}
		return null;
	}
}
