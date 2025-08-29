package com.llunix.poop.item;

import com.llunix.poop.Poop;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item POOP = registerItem("poop", new Item(new Item.Settings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Poop.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Poop.LOGGER.info("Registering Mod Items for " + Poop.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(POOP);
        });
    }
}
