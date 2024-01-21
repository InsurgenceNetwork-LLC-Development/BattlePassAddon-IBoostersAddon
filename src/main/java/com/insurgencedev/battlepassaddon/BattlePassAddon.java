package com.insurgencedev.battlepassaddon;

import com.insurgencedev.battlepassaddon.listeners.BattlePassEventListener;
import org.bukkit.Bukkit;
import org.insurgencedev.insurgenceboosters.api.addon.IBoostersAddon;
import org.insurgencedev.insurgenceboosters.api.addon.InsurgenceBoostersAddon;

@IBoostersAddon(name = "BattlePassAddon", version = "1.0.1", author = "InsurgenceDev", description = "BattlePass Support")
public class BattlePassAddon extends InsurgenceBoostersAddon {

    @Override
    public void onAddonReloadablesStart() {
        if (Bukkit.getPluginManager().isPluginEnabled("BattlePass")) {
            registerEvent(new BattlePassEventListener());
        }
    }
}
