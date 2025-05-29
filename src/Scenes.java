

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Scenes {
    String txt = "";
    String[] sc;//将脚本进行场景切割，将不同场景脚本按顺序存到数组中
    int sc_length;//场景的个数
    List<Scene> scenes = new ArrayList<>();//将场景存到场景链表当中
    MyWnd myWnd=null;
    List<Choice> ch = new ArrayList<>();//将不同场景的对话框按顺序存到链表中
    List<String> sl=new ArrayList<>();//将不同场景的对话框是否要弹出存到链表中
//构造方法，且参数为主窗口
    public Scenes(MyWnd my) {
        readTxt();
        myWnd=my;
        spl();
    }

//从文件中读取脚本
    void readTxt() {
        try {
            //读取文本
            File file = new File("res/list2.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            //将所有场景脚本按行存入一个字符串中
            while ((line = br.readLine()) != null) {
                txt = txt + line;
            }
            br.close();
        } catch (Exception e) {
        }
    }

//场景切割
    void spl() {
        //将txt字符串，以！为表示，切割成不同的场景脚本，并存入字符串列表sc中
        sc = txt.split("!");
        sc_length=sc.length;
        //表示在第i个场景下进行赋值
        for (int i = 0; i < sc.length; i++) {
            Character c = null;
            MyDialog m = null;
            Background b1 = null;
            Background b2 = null;
            Background b3 = null;
            Background b4 = null;
            Music ms1 = null;
            String[] str1 = null;

            String[] str = sc[i].split(";");//将每一个场景脚本中，以“；”为分割符，分成描述人物，对话，背景等不同的语句，索引为j
            //从第i个场景的第j句话开始进行赋值
            for (int j = 0; j < str.length; j++) {
                if (j == 0) {//j==0,是第1句话，脚本描述人物
                    String[] st1 = str[j].split(",");//将第一句话按“，”分隔开，装入数组st1，不同所以代表不同的参数
                    c = new Character(Integer.parseInt(st1[0]), Integer.parseInt(st1[1]), Integer.parseInt(st1[2]),
                            Integer.parseInt(st1[3]), st1[4]);//人物1
                }
                if (j == 1) {//j==1,是第2句话，脚本描述对话
                    String[] st1 = str[j].split(",");
                    m = new MyDialog(Integer.parseInt(st1[0]), Integer.parseInt(st1[1]), Integer.parseInt(st1[2]),
                            Integer.parseInt(st1[3]));
                }
                if (j == 2) {//j==2,是第3句话，脚本描述背景1
                    String[] st1 = str[j].split(",");
                    b1 = new Background(Integer.parseInt(st1[0]), Integer.parseInt(st1[1]), Integer.parseInt(st1[2]),
                            Integer.parseInt(st1[3]), st1[4]);//人物1
                }
                if (j == 3) {//j==3,是第4句话，脚本描述背景2
                    String[] st1 = str[j].split(",");
                    b2 = new Background(Integer.parseInt(st1[0]), Integer.parseInt(st1[1]), Integer.parseInt(st1[2]),
                            Integer.parseInt(st1[3]), st1[4]);
                }
                if (j == 4) {//j==4,是第5句话，脚本描述背景3
                    String[] st1 = str[j].split(",");
                    b3 = new Background(Integer.parseInt(st1[0]), Integer.parseInt(st1[1]), Integer.parseInt(st1[2]),
                            Integer.parseInt(st1[3]), st1[4]);
                }
                if (j == 5) {//j==5,是第6句话，脚本描述背景4
                    String[] st1 = str[j].split(",");
                    b4 = new Background(Integer.parseInt(st1[0]), Integer.parseInt(st1[1]), Integer.parseInt(st1[2]),
                            Integer.parseInt(st1[3]), st1[4]);
                }
                if (j == 6) {//j==6,是第7句话，脚本描述音乐
                    String[] st1 = str[j].split(",");
                    ms1 = new Music(st1[0]);
                }
                if (j == 7) {//j==7,是第8句话，脚本描述对话
                    String[] st1 = str[j].split("。");
                    str1 = st1;
                }
                if (j == 8) {//j==8,是第9句话，脚本描述是否需要弹出对话框
                    String[] st1 = str[j].split(",");
                    sl.add(st1[0]);//将不同场景的对话框是否要弹出存到链表中
                        int length = st1.length;//第9句话分割后的数组长度
                            Object[] opt = new Object[(length-1)/2];//创建选项的对象数组
                            int [] arr=new int[(length-1)/2];//创建不同选项的跳转的场景的索引的数组
                            //表示有几个选项
                            for (int k = 1; k<=(length-1)/2 ; k++) {
                                opt[k-1] = st1[k];//选项
                                arr[k-1] = Integer.parseInt(st1[k+(length-1)/2]);//选项对应的跳转的场景的索引的值
                            }

                            ch.add(new Choice(opt,arr));//将每个场景的对话框存入链表当中


                    }
                }
                Scene scene = new Scene(c, m, b1, b2,b3,b4, ms1, str1);//创建场景对象，将上面设置好的内容放入场景当中
                scenes.add(scene);//将所有场景添加到场景链表当中
            }
        }
    }




