package write;
import java.util.Scanner;

public class cunchumulu {
	static void cun(){
		Scanner sc=new Scanner(write.td.getText());
		sc.nextLine();
		String o="";
		String s="";
		while(sc.hasNextLine()){
			s=sc.nextLine();
			if(s!=""){
				o+="\n";
				o+=s;
			}
			else break;
		}
		sc.close();
		write.td.setText(write.lj.getText()+o);
	}
}
