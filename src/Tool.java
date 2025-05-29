

import javax.swing.*;
import java.awt.*;

public class Tool {
    int x;
    int y;
    int width;
    int height;
    String path;//需要添加的图片路径
    String str;//对人物或物品的描述
    //无参构造函数
    public Tool(){}
//有参构造函数，实例化时设定初始位置，图片所在位置，以及对的描述语句
    public Tool(int x, int y, int width, int height,String path,String str) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.path=path;
        this.str=str;
    }

    //画图像框
    void draw(Graphics g,String str) {
        //设置透明度，并画出矩形
        float alpha = 0.1f;
        Color transparentColor = new Color(Color.BLACK.getRed(), Color.BLACK.getGreen(), Color.BLACK.getBlue(), (int) (alpha * 255));
        g.setColor(transparentColor);
        g.drawRoundRect(x, y, width, height, 3, 3);
        g.setColor(transparentColor);
        g.fillRoundRect(x, y, width, height, 3, 3);
        g.setColor(Color.WHITE);
        g.setColor(transparentColor);
        //画出图像
        Image image1 = new ImageIcon(this.path).getImage();
        g.drawImage(image1, x, y, width, height, null);
        MyDialog my = new MyDialog(x,y,width,height);
        g.setColor(Color.WHITE);
        Font font = new Font("楷体", Font.ITALIC, 20);
        // 将字体设置给Graphics对象
        g.setFont(font);
        // 使用修改过的字体绘制文本
        int x1 = x+10;
        int y1=  y+26;
        for (int i = 0; i < str.length(); i++) {
            g.drawString("" + str.charAt(i), x1, y1);
            x1 = x1 + 21;
            if (x1 > x + width - 70) {
                x1 = x + 10;
                y1 = y1 + 24;
            }
        }
    }
}
