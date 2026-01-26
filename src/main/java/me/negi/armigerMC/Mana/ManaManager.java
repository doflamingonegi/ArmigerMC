package me.negi.armigerMC.Mana;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.bukkit.plugin.Plugin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ManaManager {

    private Map<UUID, Mana> ManaMap = new HashMap<>();
    private final Gson gson = new Gson();

    private Mana defaultMana()
    {
        Mana mana = new Mana();
        mana.setMANA(20);
        mana.setMANA_STRENGTH(1);
        mana.setMAX_MANA(20);
        return mana;
    }

    public int getMana(UUID uuid)
    {
        return ManaMap.computeIfAbsent(uuid,mana -> defaultMana()).getMANA();
    }

    public void saveData(Plugin plugin) throws IOException {
        String jsonData = gson.toJson(ManaMap);
        if(!Files.exists(plugin.getDataFolder().toPath())){
            Files.createDirectory(plugin.getDataFolder().toPath());
        }
        Files.writeString(Path.of(plugin.getDataFolder() + "/" + "manaList.json"), jsonData);
    }

    public void loadData(Plugin plugin) throws IOException {
        if (Files.exists(Path.of(plugin.getDataFolder() + "/" + "manaList.json"))) {
            String jsonData = Files.readString(Path.of(plugin.getDataFolder() + "/" + "manaList.json"));
            TypeToken<HashMap<String, Mana>> token = new TypeToken<>() {};
            ManaMap = gson.fromJson(jsonData, token.getType());
        }
    }
}
