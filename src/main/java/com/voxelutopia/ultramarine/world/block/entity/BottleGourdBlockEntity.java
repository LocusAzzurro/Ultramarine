package com.voxelutopia.ultramarine.world.block.entity;

import com.voxelutopia.ultramarine.data.registry.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class BottleGourdBlockEntity extends BlockEntity {

    public static final int MAX_CHARGE = 6;

    private Potion potion;
    private int charges;

    public BottleGourdBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.BOTTLE_GOURD.get(), pos, state);
    }

    public void addCharge() {
        this.charges += 1;
        this.charges = Math.min(MAX_CHARGE, this.charges);
        setChanged();
    }

    public void shrinkCharge() {
        this.charges -= 1;
        if (charges <= 0) {
            this.charges = 0;
            this.potion = Potions.WATER.value();
        }
        setChanged();
    }

    public boolean canAddCharge(Potion potion) {
        if (hasCharges()) {
            return potion.equals(this.potion) && this.charges < MAX_CHARGE;
        } else {
            return true;
        }
    }

    public boolean hasCharges() {
        return (charges > 0 && !potion.equals(Potions.WATER.value()));
    }

    public int getCharges() {
        return this.charges;
    }

    public Potion getPotion() {
        return potion;
    }

    public void setPotion(Potion potion) {
        this.potion = potion;
    }

    @Override
    public void loadAdditional(@NotNull CompoundTag pTag, HolderLookup.@NotNull Provider provider) {
        super.loadAdditional(pTag, provider);
        this.potion = BuiltInRegistries.POTION.get(ResourceLocation.tryParse(pTag.getString("Potion")));
        this.charges = pTag.getInt("Charges");
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag pTag, HolderLookup.@NotNull Provider provider) {
        super.saveAdditional(pTag, provider);
        ResourceLocation potionId = BuiltInRegistries.POTION.getKey(this.potion);
        if (potionId != null) pTag.putString("Potion", potionId.toString());
        pTag.putInt("Charges", this.charges);
    }
}
