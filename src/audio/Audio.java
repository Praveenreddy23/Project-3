package audio;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/*
Rules-> Download the song from youtube audio library
     -> Convert song to wav file from  wav file convert
     -> Then add wav file to u r project
 */
public class Audio {
    public static  void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        Scanner scanner = new Scanner(System.in);

        File file = new File("Mastaru_Mastaru.wav");

        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);

        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);


        String response = "";


        while (!response.equals("Q")){
            System.out.println("P = play, S = stop, R = restart, Q = Quit");
            System.out.println("Enter your choice: ");

            response = scanner.next();
            response = response.toUpperCase();

            switch (response){
                case ("P"): clip.start();break;
                case ("S"): clip.stop();break;
                case ("R"): clip.setMicrosecondPosition(1);break;
                case ("Q"): clip.close();break;
                default:
                    System.out.println("Not a valid responce");
            }
        }

    }
}
