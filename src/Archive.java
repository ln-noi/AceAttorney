

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Archive {
    int index;
    public Archive()  {
    }

    //将场景索引保存到"archive\\a.txt"文件中
    public void write(String str)
    {
        try {

        FileWriter fw = new FileWriter("archive\\a.txt");
        fw.write(str);
        fw.close();
        }catch (Exception e){}
    }

    //从"archive\\a.txt"文件中读取场景索引的ASCII码
    public int read() throws IOException {
        FileReader fr = new FileReader("archive\\a.txt");
        int index_re= fr.read();
        fr.close();
        return index_re;
    }

}