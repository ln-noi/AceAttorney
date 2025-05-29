

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class Settings extends JFrame implements MouseListener {
    MyWnd myWnd=null;
    Archive a = new Archive();
    Background bk3 = new Background(0, 0, 768, 512, "res/pic/back8.png");
    MyButton m1 = new MyButton(130, 140, 200, 83, "保存");
    MyButton m2 = new MyButton(440, 140, 200, 83, "退出");
    MyButton m3 = new MyButton(440, 330, 200, 83, "读取");
    MyButton m4 = new MyButton(130, 330, 200, 83, "关于");

    //含参构造函数，传入MyWnd类
    public Settings(MyWnd wnd) throws IOException {
        myWnd=wnd;
        init();
        addMouseListener(this);//绑定鼠标监听
        setVisible(true);
    }

    public void init() {
        setSize(768, 512);
        setLocationRelativeTo(null);
        setLayout(null);
        setTitle("设置");
        setDefaultCloseOperation(HIDE_ON_CLOSE);

    }
//绘制按钮和背景
    public void paint(Graphics g) {
        bk3.setBack(g);
        m1.setButton(g);
        m2.setButton(g);
        m3.setButton(g);
        m4.setButton(g);

    }

    @Override
    //通过鼠标点击进行保存，读档，退出，和浏览游戏信息
    public void mouseClicked(MouseEvent e) {
        //获取鼠标点击位置
        int[] arr = new int[2];
        arr[0] = e.getX();
        arr[1] = e.getY();
        boolean flag1 = m1.judge(arr);
        //若按键1被点击
        if (flag1) {
        //将当前场景索引写入文件，进行保存
            try {
                a.write(""+myWnd.scene_index);
                System.out.println("保存成功");
            } catch (Exception ex) {
            }

            }
            boolean flag2 = m2.judge(arr);
        //若按键2被点击，退出程序
            if (flag2) {
                System.exit(0);
            }
            boolean flag3 = m3.judge(arr);
            //若按键3被点击，从文件中读取存档，并跳转至存档对应的画面
            if (flag3) {
            try {
                myWnd.scene_index = a.read()-48;
                myWnd.com_index=0;
                this.hide();
                myWnd.repaint();
                System.out.println("读取存档");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            }
            boolean flag4 = m4.judge(arr);
            //若按键4被点击，弹出开发人员
            if (flag4) {
                JFrame frame = new JFrame("关于");
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

                // 创建标签并设置文字内容
                JLabel label = new JLabel("制作人员：朱林   庄馨怡   黄健枫   徐红雨");

                // 将标签添加到窗口的内容面板中
                frame.getContentPane().add(label);

                // 设置窗口的尺寸并显示
                frame.setSize(400, 200);
                frame.setVisible(true);
            }
        }


        @Override
        public void mousePressed (MouseEvent e){

        }

        @Override
        public void mouseReleased (MouseEvent e){

        }

        @Override
        public void mouseEntered (MouseEvent e){

        }

        @Override
        public void mouseExited (MouseEvent e){

        }
    }
