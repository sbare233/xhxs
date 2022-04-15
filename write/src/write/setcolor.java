package write;
import java.awt.Color;

import javax.swing.JColorChooser;

public class setcolor {
	setcolor(){
		rrgb.rgb.start();
		Color color=JColorChooser.showDialog( null, "选择颜色", write.color);
		if(color!=null)
		{
			write.color=new Color(255-color.getRed(), 255-color.getGreen(), 255-color.getBlue(),255);
			write.tf.setBackground(color);
			write.tf.setForeground(write.color);
			write.td.setBackground(color);
			write.td.setForeground(write.color);
			write.rrggbb.setSelected(false);
		}
		if(!write.rrggbb.isSelected())
			rrgb.rgb.stop();
		write.rrggbb.setBackground(Color.LIGHT_GRAY);
		write.rrggbb.setForeground(Color.BLACK);
	}
}
