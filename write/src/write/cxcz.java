package write;

public class cxcz {
	static void chexiao(){
		if(always.i>1){
			always.chexiaof=1;
			always.i--;
			write.tf.setText(write.ss.get(always.i-1));
		}
	}
	static void chongzuo(){
		if(always.i<write.ss.size()){
			always.chexiaof=1;
			always.i++;
			write.tf.setText(write.ss.get(always.i-1));
		}
	}
}
