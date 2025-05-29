

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.nio.file.Path;

public class Background {
    int x = 0;
    int y = 0;
    int width = 1152;
    int height = 768;
    String path;

    //构造方法，实例化时设置背景的大小位置和路径
    public Background(int x, int y, int width, int height, String path) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.path = path;
    }

    //设置背景添加图片
    void setBack(Graphics g) {
        //设置透明度
        float alpha = 0.5f;
        Color transparentColor = new Color(Color.BLACK.getRed(), Color.BLACK.getGreen(), Color.BLACK.getBlue(), (int) (alpha * 255));
        g.setColor(transparentColor);
        //图片绘制
        Image image1 = new ImageIcon(this.path).getImage();
        g.drawImage(image1, 0, 0, width, height, null);

    }
}

