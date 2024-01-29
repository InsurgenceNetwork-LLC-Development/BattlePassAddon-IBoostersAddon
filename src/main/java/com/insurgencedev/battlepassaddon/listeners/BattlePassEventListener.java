package com.insurgencedev.battlepassaddon.listeners;

import io.github.battlepass.api.events.user.UserQuestProgressionEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.insurgencedev.insurgenceboosters.api.IBoosterAPI;
import org.insurgencedev.insurgenceboosters.data.BoosterFindResult;

import java.math.BigInteger;

public final class BattlePassEventListener implements Listener {

    @EventHandler
    private void onProgress(UserQuestProgressionEvent event) {
        final String TYPE = "Pass";
        final String NAMESPACE = "BPASS_QUESTS";
        final double[] totalMulti = {0};

        BoosterFindResult pResult = IBoosterAPI.INSTANCE.getCache(event.getUser().getPlayer()).getBoosterDataManager().findActiveBooster(TYPE, NAMESPACE);
        if (pResult instanceof BoosterFindResult.Success boosterResult) {
            totalMulti[0] += boosterResult.getBoosterData().getMultiplier();
        }

        IBoosterAPI.INSTANCE.getGlobalBoosterManager().findGlobalBooster(TYPE, NAMESPACE, globalBooster -> {
            totalMulti[0] += globalBooster.getMultiplier();
            return null;
        }, () -> null);

        if (totalMulti[0] > 0) {
            event.setAddedProgress(event.getAddedProgress().multiply(new BigInteger(String.valueOf(totalMulti[0]))));
        }
    }
}
