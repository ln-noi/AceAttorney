

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyButton {
    int x;
    int y;
    int width;
    int height;
    String name ;
    //无参构造方法
    public MyButton(){}
//有参构造方法，实例化时设定初始位置和按钮名称
    public MyButton(int x, int y, int width, int height,String name) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.name = name;
    }

    //画按钮
    void setButton(Graphics g) {
        //设置透明度
        float alpha = 0.3f;
        Color transparentColor = new Color(Color.BLACK.getRed(), Color.BLACK.getGreen(), Color.BLACK.getBlue(), (int) (alpha * 255));
        g.setColor(transparentColor);
        //画矩形
        g.drawRoundRect(x, y, width, height, 3, 3);
        g.setColor(transparentColor);
        g.fillRoundRect(x, y, width, height, 3, 3);
        g.setColor(Color.WHITE);
        //设置字体
        Font font = new Font("Serif", Font.PLAIN, 20);
        g.setFont(font);
        //文字绘制
        g.drawString(this.name, x + 15, y + 22);
    }

    //判断位置是否正确，如果是就将开关打开，不是就关上
    public boolean judge(int[] locations) {
        boolean flag = false;
        int x = locations[0];
        int y = locations[1];
        //判断是否在按钮范围内，是则返回true,开关打开，否则返回false,开关关闭
        if (x >= this.x && x <= this.x + this.width && y >= this.y && y <= this.y + this.height) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }
}



