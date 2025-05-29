import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Choice {
    Object[] options;
    int opt ;
    int []arr;
    int index;

//构造方法，实例化时，传入对象数组（选项）和数字数组（不同选项跳转的不同索引），（在Scenes中使用）
    public Choice(Object[] options,int []arr){
        this.options=options;
        this.arr=arr;
    }
    public int choice(){
        //设置一个对话框，提供选项(跟据脚本来设置选项数目)，并对不同的选项返回不同的值
            opt = JOptionPane.showOptionDialog(null,"选择你的选项","选择",
                    JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);

            if(opt==0)
            {
                index=arr[0];
            }else if (opt==1)
            {
                index=arr[1];
            }else if (opt==2)
            {
                index=arr[2];
            }else if (opt==3)
            {
                index=arr[3];
            }
            return index;
    }

}


