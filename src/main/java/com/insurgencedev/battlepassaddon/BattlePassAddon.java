package com.insurgencedev.battlepassaddon;

import com.insurgencedev.battlepassaddon.listeners.BattlePassEventListener;
import org.insurgencedev.insurgenceboosters.api.addon.IBoostersAddon;
import org.insurgencedev.insurgenceboosters.api.addon.InsurgenceBoostersAddon;

@IBoostersAddon(name = "BattlePassAddon", version = "1.0.0", author = "InsurgenceDev", description = "BattlePass Support")
public class BattlePassAddon extends InsurgenceBoostersAddon {

    @Override
    public void onAddonReloadablesStart() {
        registerEvent(new BattlePassEventListener());
    }
}
