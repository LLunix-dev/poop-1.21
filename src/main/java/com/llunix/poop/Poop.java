package com.llunix.poop;

import com.llunix.poop.block.ModBlocks;
import com.llunix.poop.item.ModItemGroups;
import com.llunix.poop.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Poop implements ModInitializer {
	public static final String MOD_ID = "poop";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
	}
}