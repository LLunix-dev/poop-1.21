package com.llunix.poop.effect;

import com.llunix.poop.block.ModBlocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;


public class DiarrheaEffect extends StatusEffect {
    public DiarrheaEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    Random rand = new Random();

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        final BlockPos pos = entity.getBlockPos();
        final World world = entity.getWorld();
        int n = rand.nextInt(250);
        if(n == 1) {
            world.setBlockState(pos.offset(entity.getHorizontalFacing().getOpposite()), ModBlocks.POOP_BLOCK.getDefaultState());
        }

        return super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
