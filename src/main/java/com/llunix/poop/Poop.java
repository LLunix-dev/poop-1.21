package com.llunix.poop;

import com.llunix.poop.block.ModBlocks;
import com.llunix.poop.effect.ModEffects;
import com.llunix.poop.event.ModEvents;
import com.llunix.poop.item.ModItemGroups;
import com.llunix.poop.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Poop implements ModInitializer {
	public static final String MOD_ID = "poop";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    int tick = 1;
	@Override
	public void onInitialize() {
        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModEffects.registerEffects();
        ModEvents.registerModEvents();


        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
                tick += 1;
                final BlockPos pos = player.getBlockPos();
                final World world = player.getWorld();

                if(tick % (60 * 20) == 0) {
                    //ItemStack stack = new ItemStack(ModItems.POOP, 1);

                    //ItemEntity entity = new ItemEntity(player.getWorld(), player.getX(), player.getY(), player.getZ(), stack);
                    world.setBlockState(pos.offset(player.getHorizontalFacing().getOpposite()), ModBlocks.TINY_PILE.getDefaultState());

                    // In die Welt spawnen
                    player.getWorld().spawnEntity(player);
                }

            }
        });
	}
}