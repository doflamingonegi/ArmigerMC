package me.negi.armigerMC;

import me.negi.armigerMC.Listeners.WeaponsListener;
import me.negi.armigerMC.Mana.ManaManager;
import me.negi.armigerMC.Weapons.Weapons.MortalSpear;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class ArmigerMC extends JavaPlugin {

    ManaManager MM = new ManaManager();
    @Override
    public void onEnable() {
        try {
            MM.loadData(this);
            Logger.getLogger(this.getName()).log(Level.INFO, "Successfully loaded Mana to Cache!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        getServer().getPluginManager().registerEvents(new WeaponsListener(), this);

    }

    @Override
    public void onDisable() {
        try {
            MM.saveData(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
