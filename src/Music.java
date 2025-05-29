

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Music {
    String musicFilePath ;//音乐所在路径
    int i=1;
//无参构造方法
    public Music(){}
    //有参构造方法
    public Music(String path){
    this.musicFilePath = path;
    }

    //进行音乐播放
    public void play(){
        if(i==1){
        try {
            File musicFile = new File(musicFilePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(musicFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start(); // 开始播放音乐

            // 如果需要等待音乐播放完毕，可以使用以下代码（但请注意，这可能会阻塞主线程）
            while (!clip.isRunning()) {
                Thread.sleep(10); // 等待直到音乐开始播放

            }

            while (clip.isRunning()) {
                Thread.sleep(10); // 等待直到音乐播放完毕
            }
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
    }
}