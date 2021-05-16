package in.momin5.autoupdate.impl;

import in.momin5.autoupdate.AutoUpdateMod;

import javax.swing.*;
import java.awt.*;

public class PanelManager {


    public static class UpdateFrame extends JFrame {

        public UpdateFrame(){
            this.setTitle(AutoUpdateMod.NAME);
            this.setLocationRelativeTo(null);
            this.setAlwaysOnTop(true);
            this.setSize(400,300);

            ImageIcon loadingGif = new ImageIcon("assets/ajax-loader.gif");
            String message = "Checking for updates! PLEASE DONT SHUT DOWN";

            this.add(new JLabel(message,loadingGif,JLabel.CENTER));
            this.setVisible(true);

        }
    }

    public static class FoundUpdate extends JFrame{

        public FoundUpdate(){

            this.setTitle(AutoUpdateMod.NAME);
            this.setLocationRelativeTo(null);
            this.setAlwaysOnTop(true);
            this.setSize(400,300);

            JLabel j = new JLabel("Found the update! Please wait while we download it",JLabel.CENTER);

            this.add(j);

            while (FileManager.downloaded = false){
                this.remove(j);
                this.add(new JLabel("Downloading the files"),JLabel.CENTER);
            }
            this.setVisible(true);
        }
    }

    public static class Updated extends JFrame {
        public Updated(){

            this.setTitle(AutoUpdateMod.NAME);
            this.setLocationRelativeTo(null);
            this.setAlwaysOnTop(true);
            this.setSize(400,300);
            this.setVisible(true);
            this.setBackground(new Color(116, 30, 30,255));


            JOptionPane.showMessageDialog(null,"Downloaded Updated loader in your desktop! Replace it with this one");
        }
    }
}
