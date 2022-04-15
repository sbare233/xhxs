package write;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
public class rrgb {
	static int red=255,green=0,blue=0,cf=0;
	static Color c1,c2;
	static Timer rgb=new Timer(30,new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(green<255&&blue<255&&cf==0)green+=1;
			if(green>254&&red>1&&blue<255)red-=1;
			if(red<2&&blue<255)blue+=1;
			if(blue>254&&green>1)green-=1;
			if(green<2&&red<255)red+=1;
			if(red>254&&green<2&&blue>1){blue-=1;cf=1;}
			if(red>254&&blue<2)cf=0;
			c1=new Color(red,green,blue);
			c2=new Color(255-red,255-green,255-blue);
			
			if(write.rrggbb.isSelected()){
				write.tf.setBackground(c1);
				write.tf.setForeground(c2);
				write.td.setBackground(c1);
				write.td.setForeground(c2);
				
				}
			else{
				write.rrggbb.setBackground(c1);
				write.rrggbb.setForeground(c2);
			}
			}
		}
	);
}
//状态模式，见acf 84行，write 127行