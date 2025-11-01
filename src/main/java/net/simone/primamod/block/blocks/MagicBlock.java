package net.simone.primamod.block.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.simone.primamod.item.items.ModItems;

public class MagicBlock extends Block {
    public MagicBlock(Settings settings) {
        super(settings);
    }
    
    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, 
                                 PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient()) {
            world.playSound(null, pos, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, 
                          SoundCategory.BLOCKS, 1f, 1f);
            
            // Aggiungi particelle - NOTA: DefaultParticleType non ha parametri aggiuntivi
            ((ServerWorld) world).spawnParticles(ParticleTypes.END_ROD, 
                pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, 
                10, 0.5, 0.5, 0.5, 0.1);
        }
        
        return ActionResult.SUCCESS;
    }
    
    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity itemEntity && !world.isClient()) {
            if (itemEntity.getStack().getItem() == ModItems.RAW_PINK_GARNET) {
                int count = itemEntity.getStack().getCount();
                itemEntity.setStack(new ItemStack(Items.DIAMOND, count));
                
                // Effetti visivi e sonori - usa ENCHANT invece di DRAGON_BREATH
                world.playSound(null, pos, SoundEvents.BLOCK_AMETHYST_BLOCK_BREAK, 
                              SoundCategory.BLOCKS, 1f, 1f);
                ((ServerWorld) world).spawnParticles(ParticleTypes.ENCHANT, 
                    pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 
                    20, 0.3, 0.3, 0.3, 0.05);
            }
        }

        super.onSteppedOn(world, pos, state, entity);
    }
}