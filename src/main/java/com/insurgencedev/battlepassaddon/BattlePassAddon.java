package com.insurgencedev.battlepassaddon;

import com.insurgencedev.battlepassaddon.listeners.BattlePassEventListener;
import org.insurgencedev.insurgenceboosters.api.addon.IBoostersAddon;
import org.insurgencedev.insurgenceboosters.api.addon.InsurgenceBoostersAddon;
import org.insurgencedev.insurgenceboosters.libs.fo.Common;

@IBoostersAddon(name = "BattlePassAddon", version = "1.0.1", author = "InsurgenceDev", description = "BattlePass Support")
public class BattlePassAddon extends InsurgenceBoostersAddon {

    @Override
    public void onAddonReloadAblesStart() {
        if (Common.doesPluginExist("BattlePass")) {
            registerEvent(new BattlePassEventListener());
        }
    }
}
