package in.momin5.autoupdate.impl;

import in.momin5.autoupdate.AutoUpdateMod;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.FMLLog;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

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

            /*String path = AutoUpdateMod.class.getProtectionDomain().getCodeSource().getLocation().  /**


             :troll:


             * /         getFile();

            Path modPath = Paths.get(path);

            //Files.copy(file.toPath(),modPath, StandardCopyOption.REPLACE_EXISTING);

            AutoUpdateMod.LOGGER.info(path);

            AutoUpdateMod.LOGGER.info(modPath);*/

        }catch (MalformedURLException E){
            FMLLog.log.info("Network problem, make sure you have a active internet connection!"); // chinese code will fix after debug
            FMLCommonHandler.instance().exitJava(0,true);
        } catch (IOException a){
            FMLLog.log.info("file exception");
            FMLCommonHandler.instance().exitJava(0,true);
        }
    }
}
