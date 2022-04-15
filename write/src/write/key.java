package write;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class key implements KeyListener{
	write e;
	public key(write e){
		this.e=e;
	}
	int k=0;
	public void keyPressed(KeyEvent e) {
		if(e.isControlDown()==true&&e.getKeyCode()==KeyEvent.VK_Z){
			cxcz.chexiao();
		}
		if(e.isControlDown()==true&&e.getKeyCode()==KeyEvent.VK_D){
			cxcz.chongzuo();
		}
		if(e.isControlDown()&&e.getKeyCode()==KeyEvent.VK_S){
			save.sa();
		}
		if(e.isAltDown()==true&&e.getKeyCode()==KeyEvent.VK_S){
			if(write.sxycf==0)write.sxycf=1;
			else write.sxycf=0;
		}
		if(e.isAltDown()==true&&e.getKeyCode()==KeyEvent.VK_A){
			if(write.yc==0)write.yc=3;
			else if(write.yc==1)write.yc=2;
			else if(write.yc==2)write.yc=1;
			else if(write.yc==3)write.yc=0;
		}
		if(e.isAltDown()==true&&e.getKeyCode()==KeyEvent.VK_D){
			if(write.yc==0)write.yc=2;
			else if(write.yc==1)write.yc=3;
			else if(write.yc==2)write.yc=0;
			else if(write.yc==3)write.yc=1;
		}
	}
	public void keyReleased(KeyEvent e) {
		
	}
	public void keyTyped(KeyEvent e) {
		
	}
}
