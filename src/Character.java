

import javax.swing.*;
import java.awt.*;

public class Character {
    int x;
    int y;
    int width;
    int height;
    String name;

//构造方法，实例化时设置大小，位置和姓名
    public Character(int x, int y, int width, int height,String name) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.name=name;
    }

    //画一个框并添加人物
    void show(Graphics g) {
        //设置透明度
        float alpha = 0.0f;
        Color transparentColor = new Color(Color.BLACK.getRed(), Color.BLACK.getGreen(), Color.BLACK.getBlue(), (int) (alpha * 255));
        g.setColor(transparentColor);
        //画一个矩形
        g.fillRoundRect(x, y, width, height, 13, 13);
        g.drawRoundRect(x, y, width, height, 13, 13);
        g.setColor(Color.WHITE);
        //设置字体
        Font font = new Font("Serif", Font.PLAIN, 24);
        g.setFont(font);
        //绘制姓名
        g.drawString(this.name,155, 545);
    }
}

