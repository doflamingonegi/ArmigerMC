package me.negi.armigerMC.Weapons;

import me.negi.armigerMC.Weapons.Weapons.DarkLance;
import me.negi.armigerMC.Weapons.Weapons.MortalSpear;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WeaponManager {

    private final Map<WeaponType, Weapon> WEAPONLIST = Map.of(WeaponType.MELEE, new MortalSpear(), WeaponType.MAGIC, new DarkLance());


    public void executeWeapon(Player player, Entity entity, WeaponType type)
    {

    }

}
