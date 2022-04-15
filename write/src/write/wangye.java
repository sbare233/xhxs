package write;

import java.awt.Desktop;
import java.io.IOException;
import java.net.*;

public class wangye{
	public static void wang() {
		try {
			String site = write.wy.getText();
			Desktop desktop = Desktop.getDesktop();
			if (Desktop.isDesktopSupported()
					&& desktop.isSupported(Desktop.Action.BROWSE)) {
				URI uri = new URI(site);
				desktop.browse(uri);
			}
		} catch (IOException ex) {
		} catch (URISyntaxException ex) {
		}
	}
}

