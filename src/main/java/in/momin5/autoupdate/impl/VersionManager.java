package in.momin5.autoupdate.impl;

import net.minecraftforge.fml.common.FMLLog;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class VersionManager {

    public static String versionURL = "https://pastebin.com/raw/pVPg66xe"; // for template / example
    public static String modURL = "https://yourwebsite.com/myclient.jar"; // this can also be dont with heroku, if you cant afford a vps

    public static String getVersion() {
        String versionNumber = null;
        try {
            final URL url = new URL(versionURL);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputText = bufferedReader.readLine();

            String[] rawString = inputText.split("=");
            versionNumber = rawString[1];
        }catch (Exception exception){
            FMLLog.log.info("There was a error getting the version Number");
        }
        return versionNumber;
    }

 /*   public static void checkForUpdates(){
        try {
            PanelManager.UpdateFrame updateFrame = new PanelManager.UpdateFrame();
            updateFrame.dispose();
            if(!getVersion().equals(AutoUpdateMod.VERSION)){
                PanelManager.FoundUpdate foundUpdate = new PanelManager.FoundUpdate();
                FileManager.downloadFile();
                foundUpdate.dispose();
            }
            if(FileManager.downloaded = true){
                PanelManager.Updated frame = new PanelManager.Updated();
                frame.dispose();
                FMLCommonHandler.instance().exitJava(0,true);
            }
        }catch (Exception ignored){
        }
    }*/
}

