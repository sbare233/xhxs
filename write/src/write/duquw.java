package write;
import java.awt.Insets;
import java.io.File;
import javax.swing.JButton;

public class duquw {
	public static void duqu(){
		File file=new File(write.lj.getText());
		if(file.isFile()){
			file=file.getParentFile();
		}
		if(file.isDirectory()){
			//write.xz.setText("新建章节");
			for(int i=0;i<write.pb.length&&write.pb[i]!=null;i++){
				write.pb[i].setVisible(false);
				write.in1.remove(write.pb[i]);
		    }
		    String[] pss=file.list();
			for(int i=0;i<pss.length&&pss[i]!=null;i++){
				write.pb[i]=new JButton(String.valueOf(i));
				write.in1.add(write.pb[i]);
				write.pb[i].addActionListener(write.acf);
				write.pb[i].setText(pss[i]);
				write.pb[i].setMargin(new Insets(0,0,0,0));
				write.pb[i].setVisible(true);
			}
		}
	}
}
//迭代器