package de.jumpdrive.customtime.tasks;

import de.jumpdrive.customtime.CustomTimeMain;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * @author lucas
 */
public class StopDaylightTask implements Runnable{
    
    private CustomTimeMain plugin;
    private final String STOP_DAYLIGHT_CMD = "gamerule doDaylightCycle false";
    
    public StopDaylightTask(CustomTimeMain pluginMain){
        plugin = pluginMain;
    }
    
    @Override
    public void run() {
        boolean daylightCycleStopped = false;
        daylightCycleStopped = stopDaylightCycleCmd();
        
        while (!daylightCycleStopped) {
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){}
            daylightCycleStopped = stopDaylightCycleCmd();
        }
        
        plugin.startCustomTimeTask();
    }
    
    private boolean stopDaylightCycleCmd(){
        return Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), STOP_DAYLIGHT_CMD);
    }
    
}
