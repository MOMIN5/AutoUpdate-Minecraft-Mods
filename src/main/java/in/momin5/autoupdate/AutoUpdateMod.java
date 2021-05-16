package in.momin5.autoupdate;

import in.momin5.autoupdate.impl.FileManager;
import in.momin5.autoupdate.impl.PanelManager;
import in.momin5.autoupdate.impl.VersionManager;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = AutoUpdateMod.MODID, name = AutoUpdateMod.NAME, version = AutoUpdateMod.VERSION)
public class AutoUpdateMod {

    public static final String MODID = "autoupdate";
    public static final String NAME = "AutoUpdateMod";
    public static final String VERSION = "0.1";


    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // PanelManager.UpdateFrame e = new PanelManager.UpdateFrame();
        checkForUpdates();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    }


    public static void checkForUpdates(){
        try {
            PanelManager.UpdateFrame updateFrame = new PanelManager.UpdateFrame();
            updateFrame.dispose();
            if(!VersionManager.getVersion().equals(AutoUpdateMod.VERSION)){
                PanelManager.FoundUpdate foundUpdate = new PanelManager.FoundUpdate();
                FileManager.downloadFile();
                foundUpdate.dispose();
                if(FileManager.downloaded = true){
                    PanelManager.Updated frame = new PanelManager.Updated();
                    frame.dispose();
                    FMLCommonHandler.instance().exitJava(0,true);
                }
            }
        }catch (Exception ignored){
        }
    }
}
