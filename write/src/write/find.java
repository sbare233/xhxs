package write;

public class find {
	static int s=-1;
	static String sss=null;
	static void f(){
		
			String n=write.tf.getText();
			String ss=write.cz.getText();
			if(write.updown.isSelected()){
				if(n!=null&&ss!=null&&n.length()>0&&ss.length()>0){
					n=new StringBuilder(n).reverse().toString();
					ss=new StringBuilder(ss).reverse().toString();
					s=n.indexOf(ss,s+1);
					if(s!=-1){
						write.tf.requestFocus();
						write.tf.setSelectionStart(n.length()-s-ss.length());
						write.tf.setSelectionEnd(n.length()-s);
					}
					//System.out.println(s);
				}
			}
			else if(n!=null&&ss!=null&&n.length()>0&&ss.length()>0){
				s=n.indexOf(ss,s+1);
				if(s!=-1){
					write.tf.requestFocus();
					write.tf.setSelectionStart(s);
					write.tf.setSelectionEnd(s+ss.length());
				}
			}
			//System.out.println(s);
	}
}
