package com.rokucraft.correctfalldamage;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public final class CorrectFallDamage extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler(ignoreCancelled = true)
    public void onEntityDamage(EntityDamageEvent event) {
        if (event.getCause() != EntityDamageEvent.DamageCause.FALL) {
            return;
        }
        PotionEffect effect = ((LivingEntity)event.getEntity()).getPotionEffect(PotionEffectType.JUMP);
        if (effect == null || effect.getAmplifier() > -1) {
            return;
        }
        // When Jump Boost is applied, Minecraft changes fall damage to be (originalDamage - (jumpEffectAmplifier + 1))
        // To reverse that when negative Jump Boost is applied, we simply add (jumpEffectAmplifier + 1) back
        double correctedDamage = event.getDamage() + effect.getAmplifier() + 1;
        if (correctedDamage < 1) {
            event.setCancelled(true);
        } else {
            event.setDamage(correctedDamage);
        }
    }
}
