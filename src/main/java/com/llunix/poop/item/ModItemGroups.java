package com.llunix.poop.item;

import com.llunix.poop.Poop;
import com.llunix.poop.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup POOP_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Poop.MOD_ID, "poop_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.POOP))
                    .displayName(Text.translatable("itemgroup.poop.poop_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.POOP);
                    }).build());
    public static final ItemGroup POOP_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Poop.MOD_ID, "poop_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.POOP_BLOCK))
                    .displayName(Text.translatable("itemgroup.poop.poop_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.POOP_BLOCK);
                        entries.add(ModBlocks.PILE);
                        entries.add(ModBlocks.TINY_PILE);

                    }).build());
    public static void registerItemGroups() {
        Poop.LOGGER.info("Registering Item Groups for " + Poop.MOD_ID);
    }

}
