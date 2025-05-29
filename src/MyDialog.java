

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyDialog {
    int x;
    int y;
    int width;
    int height;
//有参构造方法，实例化时设置位置大小
    public MyDialog(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    //添加对话
    void say(Graphics g, String str) {
        int x1;
        int y1;
        //设置文本位置
        x1 = x + 50;
        y1 = y + 80;
        //设置字体颜色大小
        g.setColor(Color.WHITE);
        Font font = new Font("Serif", Font.PLAIN, 24);
        // 将字体设置给Graphics对象
        g.setFont(font);
        // 使用修改过的字体绘制文本
        //设置字体间隔24，并令字体到文本框尽头时自动换行
        //设置行距为42
        for (int i = 0; i < str.length(); i++) {
            //文本绘制
            g.drawString("" + str.charAt(i), x1, y1);
            //文本间隔
            x1 = x1 + 24;
            if (x1 > x + width - 70) {
                //文本回到首列
                x1 = x + 50;
                //文本换行
                y1 = y1 + 40;
            }
        }
    }
}
