
import java.awt.*;

public class Scene {
    //人物
    Character c;
    //对话
    MyDialog m;
    //背景
    Background b1;
    Background b2;
    Background b3;
    Background b4;
    //音乐
    Music ms;
    //文本
    String[] str;
//有参构造方法，创建Scene对象，为其加上参数里的物品
    public Scene(Character c, MyDialog m, Background b1, Background b2,Background b3,Background b4,
                 Music ms, String[] str) {


        this.c = c;
        this.m = m;
        this.b1 = b1;
        this.b2 = b2;
        this.b3 = b3;
        this.b4 = b4;
        this.ms = ms;
        this.str = str;
    }
//无参构造方法，未使用
    public Scene(){
    }
//绘制Scenen里的物品
    void show(Graphics g,int com_index) {
        b1.setBack(g);
        b2.setBack(g);
        b3.setBack(g);
        b4.setBack(g);
        c.show(g);
        m.say(g, str[com_index]);

    }
}
