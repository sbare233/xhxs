package write;
import java.io.File;
import javax.swing.JFileChooser;

public class save {
	static int sa() {
		
		String t=write.tf.getText();
		if(t==null||t.length()==0){
			return 0;
		}
		if (write.path != null) {
			File f = new File(write.path);
			if (f.isFile()) {
				rt.writeto(write.path, t);
				if (write.path1 != null) {
					File f1 = new File(write.path1);
					if (f1.isFile())
						rt.writeto(write.path1, write.td.getText());
				}
			}
		}
		else {
			int re = write.opensave.showSaveDialog(null);
			if (re == JFileChooser.APPROVE_OPTION) {
				rt.writeto(null, write.tf.getText());
				rt.writeto(write.lj1.getText(), write.td.getText());
			}
		}
		if (write.yn == 0) {
			System.exit(0);
		}
		return 1;
		
	}
}
