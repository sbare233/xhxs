package write;

public class wupin {
	String name="无";
	String amount="无";
	String intro="无";
	wupin(String name,String amount,String intro){
		this.name=name;
		this.amount=amount;
		this.intro=intro;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	
}
