package in.momin5.autoupdate.impl;

import net.minecraftforge.fml.common.FMLLog;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class FileManager {
    public static boolean downloaded = false;

    public static void downloadFile() {
        try {

            URL url = new URL(VersionManager.modURL);
            //File file = new File("/mods/UpdatedMod.jar");
            File file = new File(System.getProperty("user.home"), "Desktop/UpdatedMod.jar");

            if(!file.exists()){
                file.createNewFile();
            }

            InputStream in = url.openStream();
            ReadableByteChannel readableByteChannel = Channels.newChannel(in);
            FileOutputStream fi = new FileOutputStream(file);
            fi.getChannel().transferFrom(readableByteChannel,0,1 << 24);

            downloaded = true;
        }catch (MalformedURLException E){
            FMLLog.log.info("Network problem, make sure you have a active internet connection!");
        } catch (IOException a){
            FMLLog.log.info("file exception");
        }
    }
}
