

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ToolBox extends JFrame implements MouseListener
{
    int flag=-1;
//物品的属性
    int x1=80;//物品图片初始位置
    int x11=180;//物品介绍初始位置
    int width1=70;
    int width11=500;
    int height=70;
    int y=50;
    //物品介绍文本
    String[] str1 = {"律师徽章：如果没有这个东西，就不会有人承认我是律师。",
            "安眠药：案发前由被害人服用。瓶身上沾有被告指纹。",
            "茶杯：被害人吞服安眠药时使用。检测出少剂量镇静剂残留。",
            "香水：被告在案发当晚赠予被害人的生日礼物。" + "闻起来似乎有股特别的香味。",
            "丝巾：被害人妹妹兼经纪人在案发当晚赠予被害人的生日礼物。被害人很珍惜。",
            "化验报告：丝巾上检测出荧光剂成分。案发后为部分血迹所覆盖。"};
//人物的属性
    int x2=80;//人物图片x轴位置
    int x22=180;//人物介绍x轴位置
    int y2=30;//初始y
    int width2=50;//图片宽
    int width22=500;//介绍宽
    int height2=50;//高
    //人物介绍文本
    String[] str2 = {"579：宠物医院的一名普通兽医，是本案的被告，同时也是你本次的辩护对象。",
            "ABAB：现役明星，是本案的被害人。在高中时已小有名气。案发时位于自己的卧室内。",
            "ccdd：ABAB的妹妹，同时也是她的经纪人。作为第一目击者出庭。",
            "汪酱：被害人家中饲养的宠物。案发时，突然发狂并扑咬被害人，致其死亡。",
            "律师：名如其名，是一位律师。同时，这也是你第一次出庭。",
            "搭档律师：是你的前辈，经验丰富。会在恰当的时机巧妙给予你帮助。",
            "检察官：咄咄逼人。好好想想怎么应对他的虚张声势！",
            "法官：和善的老头。最后案件的审判结果由他宣布。",
            "刑警：虽然看起来不太靠谱，但其实是侦查本案的警方负责人。"};
    MyButton mb = new MyButton(700,460,60,40,"切换");

    Tool[] tool_artical = new Tool[12];//物品数组
    Tool[] tool_role = new Tool[18];//人物数组

    Background bk = new Background(0, 0, 768, 512, "res/pic/back8.png");


//有参构造函数
    public ToolBox() {
        init();
        add();
        addMouseListener(this);
        setVisible(true);
    }

    //将物品图鉴加入物品数组，人物图鉴加入人物数组
    public void add() {
        for (int j = 0; j < tool_artical.length; j++) {
            if (j < 6) {
                tool_artical[j] = new Tool(x1, y + 75 * j, width1, height,"res/pic/artical/a"+(j+1)+".png",null);
            } else if (j >= 6) {
                tool_artical[j] = new Tool(x11, y + 75 * (j - 6), width11, height,null,str1[j-6]);
            }
        }
        for (int k = 0; k < tool_role.length; k++) {
            if (k < 9) {
                tool_role[k] = new Tool(x2, y2 + 53 * k, width2, height2,"res/pic/role/r"+(k+1)+".png",null);
            } else if (k >= 9) {
                tool_role[k] = new Tool(x22, y2 + 53 * (k - 9), width22, height2,null,str2[k-9]);
            }
        }
    }
    //初始化窗口位置
    public void init() {
        setSize(768, 512);
        setLocationRelativeTo(null);
        setLayout(null);
        setTitle("设置");
        setDefaultCloseOperation(HIDE_ON_CLOSE);

    }
    //绘制总人物图鉴和物品图鉴
    public void paint(Graphics g) {
        bk.setBack(g);
        mb.setButton(g);//设置切换按钮
        if(flag==1){
            //当flag为1时，绘制物品图片
            for(int index=0;index<tool_artical.length/2;index++){
                tool_artical[index].draw(g,"");
            }//绘制物品介绍
            for(int index=tool_artical.length/2;index<tool_artical.length;index++){
                tool_artical[index].draw(g,str1[index-6]);
            }
        }else if(flag==-1){
            //当flag为-1时，绘制人物图片
            for(int index=0;index<tool_role.length/2;index++){
                tool_role[index].draw(g,"");
            }//绘制人物介绍
            for(int index=tool_role.length/2;index<tool_role.length;index++){
                tool_role[index].draw(g,str2[index-9]);
            }
        }

    }



    @Override
    //点击按钮切换人物和物品图鉴
    public void mouseClicked(MouseEvent e) {
        //获取鼠标点击位置
        int[] arr = new int[2];
        arr[0] = e.getX();
        arr[1] = e.getY();
        boolean flag1 = mb.judge(arr);
        //当按键被点击时，切换展示的图鉴
        if(flag1){
            flag=flag*-1;
            repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
