package write;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
public class write extends JFrame
{
private static final long serialVersionUID = 1L;
static int[] n=new int[9],ync={0,1,2,3};
static int yc=1,yn=9,sxycf=0,jsjg=1,tihuanyc=0,suijiyc=0,renwuyc=0,dagangyc=0,tongjiyc=0,
shezhiyc=0;
//以上分别是yc隐藏左右面板旗帜，yn隐藏提示旗帜，sxyc隐藏上下面板旗帜，jsjg统计间隔（默认一秒），tihuanyc敏感词替换面板隐藏旗帜，suijiyc随机取名面板隐藏旗帜，后三个面板没写

static int red=255,green=0,blue=0,alpha=0,result=0,baocunjiange=5000,beifenjiange=300000;
//result是字数统计，其他为颜色，保存间隔，备份间隔

static int sf=0,ssf=0,zf=0,tsf=0,gd=0,jsf=1,plf=0;
//以上flag旗帜，分别是sf保存旗帜，ssf自动保存旗帜，zf加粗旗帜，tsf关闭动作旗帜，gd文本框翻到底部旗帜，jsf开启统计旗帜，plf下方切换面板切换按钮

static String[] shapes=font.font;
//字体
static JTextArea td,tf;
//主要文本区    就是中间和右侧的文本区域

static JButton duqu,shangyiji,xz,open,open1,saveb,save1,shanchu,find,bc,shuaxing,dagang,renwu,
yingcang,yes,no,cancel,yes1,no1,wye,chexiao,chongzuo,ycsx,plus,mingan,qumin,beifen,
tongjimore,jihuazs,re,setting,help;
//按钮duqu读取目录,shangyiji上一级,xz新建章节,open打开,open1右侧打开,save保存,save1右侧保存,shanchu删除,find查找,bc背景色,shuaxing刷新右侧字体,dagang大纲,renwu人物,
//yingcang隐藏左右,yes是,no不保存,cancel取消,yes1是,no1不删除,wye打开网页,chexiao撤销,chongzuo重做,ycsx隐藏上下,plus加号,mingan敏感词替换,qumin随机取名,beifen备份,
//tongjimore更多,jihuazs计划,re,setting设置,help帮助;

static JTextField lj,zihao,lj1,wy,hz,sd,cz;
//lj左上目录框 ，zihao右上字号框，lj1右上目录框，wy右下网址框，hz左下字数统计，sd下方速度统计，cz上方查找框

static JCheckBox auto,updown,gund,rrggbb,zicu,zishu;
//auto左上自动保存选框，updown上方向上选框，gund上方沉底选框，rrggbb右上呼吸灯选框，zicu右上加粗选框，zishu左下开启统计选框

static Color color;//背景色
static JComboBox<String> shape;//选字体下拉框
static JScrollPane scr,scr1,scr2;//scr中部文本域tf的滚动条，scr1文本域td的滚动条，scr2左侧目录in1的滚动条
static JDialog closesave,shanchud;//保存并退出对话框，确认删除对话框
static JLabel zihao1,jhzsl,bczsl,jtzsl,dazi,kongxian,jhzsls,bczsls,jtzsls;//界面上的文字
static JFileChooser opensave=new JFileChooser();//文件选择器

static JPanel cmdpanel,create,create1,create2,index,oth,
//cmdpanel北方控制面板，create东方参数面板，index西方目录面板，oth南方功能面板

jtjh,jinri,jinri2,jinri3,jinri4;
static Box in,in1;
static String path,path1,tfs,cunchu;
//path td文本域的文件目录,path1 文本域tf的文件目录,tfs存储tf文本域内容，cunchu主要保存目录

static JButton[] pb=new JButton[10000];//用来表示文件的按钮，读取目录会放置若干个到in1里
static Dimension dim;//屏幕分辨率
static Timer time;//保存计时器
static ArrayList<String> ss,sd1;//ss保存一些可以撤销的步骤，sd1存储瞬时打字速度
static JFrame tihuan,suiji;//tihuan敏感词替换界面，suiji随机取名界面
static acf acf;//主要事件监听器
static caf caf;//文本监听器
static key key;//按键监听器
static shezhi shezhi;//设置
static tongji tongji;//统计
static rw rw;

public write(){//主界面构造方法
	super("文本编辑器");
	acf=new acf(this);
	caf=new caf(this);
	key=new key(this);
	ss=new ArrayList<String>();
	sd1=new ArrayList<String>();
	JPopupMenu.setDefaultLightWeightPopupEnabled(false);
	dim=this.getToolkit().getScreenSize();
	setBounds(dim.width/4,dim.height/4,1050,550);
	tihuan=new tihuan();
	suiji=new suiji();
	final JSplitPane ver=new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	final JSplitPane ver1=new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	
	closesave =new JDialog(this,"保存并关闭？");
	JPanel close=new JPanel();
	closesave.add(close);
	yes=new JButton("是");
	yes.addActionListener(acf);
	close.add(yes);
	no=new JButton("不保存");
	no.addActionListener(acf);
	close.add(no);
	cancel=new JButton("取消");
	cancel.addActionListener(acf);
	close.add(cancel);
	closesave.setModal(true);
	closesave.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	addWindowListener(new WindowAdapter(){
	@SuppressWarnings("static-access")
	public void windowClosing(WindowEvent e)
		{tsf=1;if(shezhi.pzf==1)shezhi.baocun();tongji.baocun();closesave.setVisible(true);}});//关闭软件前会保存设置参数和统计参数
	closesave.setBounds(dim.width/2+300,dim.height/4-80,250,80);
	
	shanchud =new JDialog(this,"是否删除？");
	JPanel s1=new JPanel();
	shanchud.add(s1);
	shanchud.setBounds(dim.width/4+140,dim.height/4,250,80);
	yes1=new JButton("是");
	yes1.addActionListener(acf);
	s1.add(yes1);
	no1=new JButton("不删除");
	no1.addActionListener(acf);
	s1.add(no1);
	shanchud.setModal(true);
	shanchud.setDefaultCloseOperation(HIDE_ON_CLOSE);
	add(ver);
	ver.setDividerLocation(dim.width/8);
	ver.setDividerSize(0);
	
	cmdpanel=new JPanel(new FlowLayout(FlowLayout.CENTER,2,4));//组合模式，树枝节点
	oth=new JPanel(new FlowLayout(FlowLayout.CENTER,2,4));//组合模式，树枝节点
	create=new JPanel(new BorderLayout());
	index=new JPanel(new BorderLayout(10,5));
	final JSplitPane hor=new JSplitPane();
	final JSplitPane hor1=new JSplitPane();
	ver.setRightComponent(cmdpanel);
	ver.setLeftComponent(ver1);
	ver1.setDividerLocation(dim.width/8);
	ver1.setDividerSize(0);
	ver1.setRightComponent(oth);
	ver1.setLeftComponent(hor);
	
	hor.setRightComponent(create);
	hor.setLeftComponent(hor1);
	hor1.setDividerSize(0);
	hor.setDividerSize(0);
	hor1.setLeftComponent(index);
	
	getContentPane().add(ver,BorderLayout.CENTER);
	getContentPane().add(cmdpanel,"North");//组合模式，添加叶子节点
	getContentPane().add(create,"East");
	getContentPane().add(index,"West");
	getContentPane().add(oth,"South");
	
	
	cmdpanel.setBackground(Color.LIGHT_GRAY);
	lj=new JTextField(8);
	cmdpanel.add(lj);
	cmdpanel.add(open=new JButton("打开"));
	open.addActionListener(acf);
	cmdpanel.add(auto=new JCheckBox("自动"));
	auto.setBackground(Color.LIGHT_GRAY);
	auto.addActionListener(acf);
	cmdpanel.add(saveb=new JButton("保存"));
	saveb.addActionListener(acf);
	cmdpanel.add(shanchu=new JButton("删除"));
	shanchu.addActionListener(acf);
	cmdpanel.add(updown=new JCheckBox("向上"));
	updown.addActionListener(acf);
	updown.setBackground(Color.LIGHT_GRAY);
	cmdpanel.add(find=new JButton("查找"));
	find.addActionListener(acf);
	cz=new JTextField(8);
	cz.addCaretListener(caf);
	cmdpanel.add(cz);
	cmdpanel.add(gund=new JCheckBox("沉底"));
	gund.setBackground(Color.LIGHT_GRAY);
	gund.addActionListener(acf);
	bc=new JButton("背景色");
	cmdpanel.add(bc);
	bc.addActionListener(acf);
	rrggbb=new JCheckBox("呼吸灯");
	rrggbb.addActionListener(acf);
	cmdpanel.add(rrggbb);
	rrggbb.setBackground(Color.LIGHT_GRAY);
	cmdpanel.add(new JLabel("字体:"));
	shape=new JComboBox<String>(shapes);
	cmdpanel.add(shape);
	shape.addActionListener(acf);
	shape.setPreferredSize(new Dimension(130,25));
	zihao1=new JLabel("字号");
	cmdpanel.add(zihao1);
	zihao=new JTextField("35",2);
	cmdpanel.add(zihao);
	zihao.addCaretListener(caf);
	zicu=new JCheckBox("加粗");
	cmdpanel.add(zicu);
	zicu.setBackground(Color.LIGHT_GRAY);
	zicu.addActionListener(acf);
	color=Color.black;
	
	
	in=Box.createHorizontalBox();
	in1=Box.createVerticalBox();
	scr2 = new JScrollPane(in1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	shangyiji=new JButton("↑");
	shangyiji.setMargin(new Insets(0,3,0,3));
	duqu=new JButton("读目录");
	duqu.setMargin(new Insets(0,0,0,0));
	xz=new JButton("新建章节");
	xz.setMargin(new Insets(0,0,0,0));
	re=new JButton("Re");
	re.setMargin(new Insets(0,0,0,0));
	shangyiji.addActionListener(acf);
	duqu.addActionListener(acf);
	xz.addActionListener(acf);
	re.addActionListener(acf);
	index.add(in,BorderLayout.NORTH);
	index.setPreferredSize(new Dimension(150,400));
	in.add(shangyiji);
	in.add(duqu);
	in.add(xz);
	in.add(re);
	index.add(scr2,BorderLayout.CENTER);
	index.add(jinri=new JPanel(),BorderLayout.SOUTH);
	jinri.setPreferredSize(new Dimension(150,120));
	jinri2=new JPanel(new GridLayout(1,3));
	jinri2.setPreferredSize(new Dimension(150,13));
	jinri.add(jinri2);
	jinri2.add(jhzsl=new JLabel("  计划"));
	jinri2.add(jtzsl=new JLabel("  今日"));
	jinri2.add(bczsl=new JLabel("  本次"));
	jinri3=new JPanel(new GridLayout(1,3));
	jinri3.setPreferredSize(new Dimension(150,13));
	jinri.add(jinri3);
	jinri3.add(jhzsls=new JLabel("0"));
	jinri3.add(jtzsls=new JLabel("0"));
	jinri3.add(bczsls=new JLabel("0"));
	jinri4=new JPanel(new FlowLayout(FlowLayout.LEFT,2,4));
	jinri4.setPreferredSize(new Dimension(150,100));
	jinri.add(jinri4);
	jinri4.add(tongjimore=new JButton("更多"));
	tongjimore.setMargin(new Insets(0,10,0,10));
	tongjimore.addActionListener(acf);
	jinri4.add(jihuazs=new JButton("计划"));
	jihuazs.setMargin(new Insets(0,10,0,10));
	jihuazs.addActionListener(acf);
	jinri4.add(dazi=new JLabel("打字时间：0分钟"));
	dazi.setFont(new Font("Dialog",Font.BOLD,16));
	jinri4.add(kongxian=new JLabel("空闲时间：0分钟"));
	kongxian.setFont(new Font("Dialog",Font.BOLD,16));
	
	
	create.setPreferredSize(new Dimension(110,200));
	create.add(create1=new JPanel(new FlowLayout(FlowLayout.CENTER,2,4)),BorderLayout.NORTH);
	create1.setPreferredSize(new Dimension(100,50));
	create.add(create2=new JPanel(new FlowLayout(FlowLayout.CENTER,2,4)),BorderLayout.SOUTH);
	create2.setPreferredSize(new Dimension(100,50));
	create1.add(open1=new JButton("打开"));
	open1.setMargin(new Insets(0,2,0,2));
	open1.addActionListener(acf);
	create1.add(save1=new JButton("保存"));
	save1.setMargin(new Insets(0,2,0,2));
	save1.addActionListener(acf);
	lj1=new JTextField(8);
	create1.add(lj1);
	td=new JTextArea();
	td.setBackground(Color.white);
	td.setEditable(true);

	
	scr1 = new JScrollPane(td, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	create.add(scr1,BorderLayout.CENTER);
	wy=new JTextField(8);
	create2.add(wy);
	wye=new JButton("    打开网页     ");
	wye.setMargin(new Insets(0,0,0,0));
	wye.addActionListener(acf);
	create2.add(wye);
	
	
	oth.add(setting=new JButton("   设置   "));
	setting.addActionListener(acf);
	zishu=new JCheckBox("开启统计");
	zishu.addActionListener(acf);
	//zishu.setSelected(true);
	oth.add(zishu);
	hz=new JTextField(10);
	hz.setPreferredSize(new Dimension(50,25));
	hz.setFont(new Font("Dialog",write.zf,23));
	oth.add(hz);
	sd=new JTextField(11);
	sd.setPreferredSize(new Dimension(50,25));
	sd.setFont(new Font("Dialog",write.zf,23));
	oth.add(sd);
	

	chexiao=new JButton("撤销");
	chexiao.addActionListener(acf);
	oth.add(chexiao);
	chongzuo=new JButton("重做");
	chongzuo.addActionListener(acf);
	oth.add(chongzuo);
	oth.add(ycsx=new JButton("隐藏上下"));
	oth.add(yingcang=new JButton("隐藏两侧"));
	yingcang.setVisible(true);
	ycsx.addActionListener(acf);
	yingcang.addActionListener(acf);
	oth.add(shuaxing=new JButton("字体应用右侧"));
	shuaxing.setMargin(new Insets(2,0,2,0));
	shuaxing.addActionListener(acf);
	
	oth.add(mingan=new JButton("敏感词替换"));
	mingan.addActionListener(acf);
	oth.add(qumin=new JButton("随机取名"));
	qumin.addActionListener(acf);
	oth.add(renwu=new JButton("人物"));
	renwu.addActionListener(acf);
	oth.add(dagang=new JButton("大纲"));
	dagang.addActionListener(acf);
	oth.add(beifen=new JButton("备份"));
	beifen.setMargin(new Insets(2,20,2,19));
	beifen.addActionListener(acf);
	
	oth.add(plus=new JButton("功能切换"));
	plus.addActionListener(acf);
	
	tf=new JTextArea();
    tf.setBackground(Color.white);
    tf.setWrapStyleWord(true);
    tf.setEditable(true);
    tf.setLineWrap(true);
    tf.addCaretListener(caf);
    tf.addKeyListener(key);
    scr = new JScrollPane(tf, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
    		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    hor1.setRightComponent(scr);
	this.setVisible(true);
	initial.in();
	time=new Timer(write.baocunjiange,new ActionListener(){
		public void actionPerformed(ActionEvent e){
			//System.out.print(0);
			save.sa();
		}});
	shezhi=new shezhi();
	tongji=new tongji();
	rw=new rw();
	opensave.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	shape.setSelectedItem("Dialog");
	tf.grabFocus();
	repaint();
	
	new always(this);
	Thread ays = null;
	try {
		ays = new Thread(always.alwayss());
	} catch (InterruptedException e1) {
	}
	ays.start();
	
}
}//外观模式


