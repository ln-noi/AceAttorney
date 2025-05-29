import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;


class MyWnd extends JFrame implements KeyListener,MouseListener{

    int scene_index ;//场景索引
    int com_index=0;//对话索引
    Archive a =new Archive();//实例化保存类
    Scenes s = new Scenes(this);//实例化场景类，并将自身作为参数传递给Scenesl类
    Music mus = new Music("res/mus/kt.wav");//设置音乐
    MyButton mb1 = new MyButton(1072, 728, 80, 35,"图鉴");//设置按钮1
    MyButton mb2 = new MyButton(0, 728, 80, 35,"设置");//设置按钮2
    boolean flag = false;

    //无参构造方法，实例化时自动调用
    public MyWnd()  {
        initJframe();
        setVisible(true);
        addKeyListener(this);// 窗口绑定键盘
        addMouseListener(this);//窗口绑定鼠标
        mus.play();
    }

    //初始化界面
    public void initJframe() {
        setSize(1152, 768);//设置大小
        setLocationRelativeTo(null);//窗口居中
        setLayout(null);//无排列
        setDefaultCloseOperation(EXIT_ON_CLOSE);//点“x”结束程序
    }

    //画图
    public void paint(Graphics g) {
        super.paint(g);
        //绘制文本：绘制s对象的scenes列表中，索引为scenes_index的场景中语句索引为com_index的语句
        s.scenes.get(scene_index).show(g,com_index);
        mb1.setButton(g);//画按钮
        mb2.setButton(g);
    }


    @Override
    //抽象接口的抽象方法，无用
    public void keyTyped(KeyEvent e) {
    }

    //按键控制对话进程，左退右进
    //按上键能弹出对话框，按下键弹出设置
    @Override
    public void keyPressed(KeyEvent e) {
        //按左键对话向前
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            //当对话索引大于0（该场景下为达到第一句对话时，按左键对话后退一句）
            if (com_index > 0) {
                com_index--;
            } //当该场景下对话以及到第一句话，且此场景非第一个场景，按左键回到上一个场景第一句话
            else if(com_index == 0&&scene_index>0){
                scene_index--;
                com_index=0;
            }
        } //按右键对话向后
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            // 当对话索引小于该场景下的对话数组最大索引（该场景下未达到最后一句话），按右键对话前进一句
            if (com_index < s.scenes.get(scene_index).str.length - 1) {
                com_index++;
            }// 当对话索引等于该场景下的对话数组最大索引（该场景下已经达到最后一句话）并且该场景非最后一个场景
            else if(com_index == s.scenes.get(scene_index).str.length - 1&&scene_index < s.scenes.size()-1){

                //当s对象的sl链表（每个场景的判断是否有选择框链表）在当下场景的索引下为true,则弹出选择框，
                //并依据选择的内容进行场景转换，并令对话为跳转后场景的第一句话
                if(s.sl.get(scene_index).equals("true")){
                    scene_index=s.ch.get(scene_index).choice();
                    com_index=0;
                }//若不为true,且该对话以及到达该场景下的最后一句话，则按右键跳转之下一个场景，对话为第一句话
                else {
                scene_index++;
                com_index=0;}
            }
        }

        //若按上键，弹出证物栏
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            new ToolBox();

        //若按下键，弹出设置
        }else if (e.getKeyCode()==KeyEvent.VK_DOWN) {
            try {
                new Settings(this);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        //按1直接使场景向前跳转一个
        if(e.getKeyCode()==KeyEvent.VK_1){
            //若场景不是第一个场景
            if (scene_index > 0) {
                scene_index--;
                com_index=0;     //使对话回到跳转后场景的第一个对话

            }
        //按2直接使场景向前后跳转一个
        }else if (e.getKeyCode()==KeyEvent.VK_2){
            //若场景不是最后一个场景
            if (scene_index < s.scenes.size()-1) {
                scene_index++;
                com_index=0;     //使对话回到跳转后场景的第一个对话
            }
        }
        //每进行一个操作，画面重新绘制
        repaint();

  }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    //得到鼠标点击位置并进行判断
    @Override
    public void mouseClicked(MouseEvent e) {
        int[] arr = new int[2];
        arr[0] = e.getX();
        arr[1] = e.getY();

        //判断按钮1是否被点击
        boolean flag1 = mb1.judge(arr);
        //若被点击则弹出图鉴窗口
        if(flag1){
            new ToolBox();
        }
        //判断按钮1是否被点击
        boolean flag2 = mb2.judge(arr);
        //若被点击则弹出设置窗口
            if(flag2){
                try {
                    new Settings(this);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
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






