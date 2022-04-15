package write;
import java.awt.Font;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class caf implements CaretListener{
	write e;
	public caf(write e){
		this.e=e;
	}
	public void caretUpdate(CaretEvent e) {
		if(e.getSource()==write.zihao){
			try{
				String i=write.zihao.getText();
				if(i!=null&&i.length()>0)
					write.tf.setFont(new Font((String) write.shape.getSelectedItem(),write.zf,Integer.parseInt(i)));
			}catch(NumberFormatException e1){};
		}
		if(e.getSource()==shezhi.js){
			try{
				String i=shezhi.js.getText();
				if(i!=null&&i.length()>0)
					write.jsjg=Integer.parseInt(i);
			}catch(NumberFormatException e1){};
		}
		if(e.getSource()==write.cz){
			try{
				String i=write.cz.getText();
				if(i!=null&&i.length()>0)
					if(i!=find.sss){
						find.sss=i;
						find.s=-1;
					}
			}catch(NumberFormatException e1){};
		}
	}
}