package com.llunix.poop.datagen;

import com.llunix.poop.block.ModBlocks;
import com.llunix.poop.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.POOP_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PILE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TINY_PILE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.POOP, Models.GENERATED);
    }
}
