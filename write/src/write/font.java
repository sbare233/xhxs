package write;
import java.awt.GraphicsEnvironment;

public class font {
	static final String[] font=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	public static String[] getfont(){
		return font;
	}
}
//单例