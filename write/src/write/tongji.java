package write;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JFrame;

public class tongji extends JFrame{
	private static final long serialVersionUID = 1L;
	static File f=new File(write.cunchu+"/统计.txt");
	static int jinrijihua=0,jinrizishu=0,sczishu=0,pjsd=0;
	static int year,month,day;
	static int i;
	static int[] years=new int[2000],months=new int[2000],days=new int[2000],
			jinrijihuas=new int[2000],jinrizishus=new int[2000],pjsds=new int[2000],
			dazis=new int[2000],kongxians=new int[2000];
	static String bc;
	tongji(){
		super("统计字数");
		setBounds(write.dim.width/4,write.dim.height/4,800,400);
		addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e)
		{write.tongjiyc=0;}});
		Date d = new Date();
		SimpleDateFormat sbf = new SimpleDateFormat("yyyy");
		SimpleDateFormat sbf1 = new SimpleDateFormat("MM");
		SimpleDateFormat sbf2 = new SimpleDateFormat("dd");
		year=Integer.parseInt(sbf.format(d));
		month=Integer.parseInt(sbf1.format(d));
		day=Integer.parseInt(sbf2.format(d));
		try {
			FileInputStream s=new FileInputStream(f);
			Scanner sc=new Scanner(s);
			bc="\n"+sc.nextLine();
			Scanner sbc=new Scanner(bc);
			int y=sbc.nextInt();
			if(year==y){
				int m=sbc.nextInt();
				if(month==m){
					int d1=sbc.nextInt();
					if(day==d1){
						jinrijihua=sbc.nextInt();
						write.jhzsls.setText(""+jinrijihua);
						sczishu=sbc.nextInt();
						jinrizishu=sczishu;
						write.jtzsls.setText(""+sczishu);
						pjsd=sbc.nextInt();
						always.dazi=sbc.nextInt()*10000;
						always.kongxian=sbc.nextInt()*10000;
						bc="";
					}
				}
			}
			sbc.close();
			while(sc.hasNextLine()){
				String bi=sc.nextLine();
				bc+="\n";
				bc+=bi;
			}
			sc.close();
			s.close();
			Scanner si;
			
			si=new Scanner(bc);
			while(si.hasNextLine()){
				years[i]=si.nextInt();
				months[i]=si.nextInt();
				days[i]=si.nextInt();
				//System.out.println(days[i]);
				jinrijihuas[i]=si.nextInt();
				jinrizishus[i]=si.nextInt();
				pjsds[i]=si.nextInt();
				dazis[i]=si.nextInt();
				kongxians[i]=si.nextInt();
				i++;
			}
			si.close();
		} catch (Exception e1) {}
		
	}
	static void baocun(){
		rt.writeto(f.getPath(),year+" "+month+" "+day+" "+jinrijihua+" "+
	jinrizishu+" "+pjsd+" "+always.dazi/10000+" "+always.kongxian/10000+bc);
	}
}
