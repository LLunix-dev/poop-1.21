package com.llunix.poop.datagen;

import com.llunix.poop.Poop;
import com.llunix.poop.block.ModBlocks;
import com.llunix.poop.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModItems.POOP, RecipeCategory.FOOD, ModBlocks.POOP_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.PILE)
                .pattern(" R ")
                .pattern("RRR")
                .input('R', ModItems.POOP)
                .criterion(hasItem(ModItems.POOP), conditionsFromItem(ModItems.POOP))
                .offerTo(recipeExporter);


        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.POOP, 4)
                .input(ModBlocks.PILE)
                .criterion(hasItem(ModBlocks.PILE), conditionsFromItem(ModBlocks.PILE))
                .offerTo(recipeExporter, Identifier.of(Poop.MOD_ID, "poop_from_pile"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.TINY_PILE)
                .pattern("R")
                .input('R', ModItems.POOP)
                .criterion(hasItem(ModItems.POOP), conditionsFromItem(ModItems.POOP))
                .offerTo(recipeExporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.POOP, 1)
                .input(ModBlocks.TINY_PILE)
                .criterion(hasItem(ModBlocks.TINY_PILE), conditionsFromItem(ModBlocks.TINY_PILE))
                .offerTo(recipeExporter, Identifier.of(Poop.MOD_ID, "poop_from_tiny_pile"));
    }
}