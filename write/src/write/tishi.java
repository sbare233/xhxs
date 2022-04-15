package write;
import javax.swing.JOptionPane;

public class tishi {
	static void banquan(){
		JOptionPane.showMessageDialog(null,"                   2022 王叙皓 版权所有"+"\n"+"                   QQ:1615285361","©版权信息", JOptionPane.PLAIN_MESSAGE);}
	static void baocuo(String path){
		JOptionPane.showMessageDialog(null,path+" 存取失败，可能是系统文件，如需存取请尝试以管理员权限运行本程序","存取失败", JOptionPane.PLAIN_MESSAGE);}
	static void baocuo1(String path){
		JOptionPane.showMessageDialog(null,path+" 存取失败，是不是有同名文件？","存取失败", JOptionPane.PLAIN_MESSAGE);}
	static void beifen(String path){
		JOptionPane.showMessageDialog(null,"已保存至"+path+"\n"+"注意：软件每隔参数第六行毫秒数自动备份一次","备份", JOptionPane.PLAIN_MESSAGE);}
	static void weishixian(){
		JOptionPane.showMessageDialog(null,"此功能暂未实现","未实现", JOptionPane.PLAIN_MESSAGE);}
	static void haoda(){
		JOptionPane.showMessageDialog(null,"太大了，不要什么东西都塞进来啊啊啊啊！","哇啊啊啊啊啊", JOptionPane.PLAIN_MESSAGE);}
	public static void beifencuowu() {
		JOptionPane.showMessageDialog(null,"啥也没写，无字天书？","错误", JOptionPane.PLAIN_MESSAGE);}
	static String jihua(){
		return JOptionPane.showInputDialog(null,"你今天想打多少字？（请填纯数字）","");}
	static String zuoyoumin1(){
		return JOptionPane.showInputDialog(null,"输入座右铭第一句，可以留空","");}
	static String zuoyoumin2(){
		return JOptionPane.showInputDialog(null,"输入座右铭第二句，可以留空","");}
	static String rename(){
		return JOptionPane.showInputDialog(null,"输入章节名称","");}
}
