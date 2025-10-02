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

import java.util.Optional;

public class BottleGourdBlockEntity extends BlockEntity {

    public static final int MAX_CHARGE = 6;

    private Potion potion;
    private int charges;
    private boolean filled;

    public BottleGourdBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.BOTTLE_GOURD.get(), pos, state);
    }

    public boolean addPotionCharge(Potion potion) {
        if (!filled) {
            this.potion = potion;
            this.charges = 1;
            this.filled = true;
            return true;
        } else if (potion.equals(this.potion) && this.charges < MAX_CHARGE) {
            this.charges++;
            return true;
        }
        return false;
    }

    public Optional<Potion> takePotionCharge() {
        if (!filled || charges <= 0 || this.potion.equals(Potions.WATER.value())) return Optional.empty();
        else {
            Potion charge = this.potion;
            this.charges--;
            if (charges <= 0) {
                filled = false;
                this.potion = Potions.WATER.value();
            }
            return Optional.of(charge);
        }
    }

    public boolean hasCharges() {
        return (filled && charges > 0 && !potion.equals(Potions.WATER.value()));
    }

    public int getCharges() {
        return this.charges;
    }

    public Potion getPotion() {
        return potion;
    }

    @Override
    public void loadAdditional(@NotNull CompoundTag pTag, HolderLookup.@NotNull Provider provider) {
        super.loadAdditional(pTag, provider);
        this.potion = BuiltInRegistries.POTION.get(ResourceLocation.tryParse(pTag.getString("Potion")));
        this.charges = pTag.getInt("Charges");
        this.filled = pTag.getBoolean("Filled");
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag pTag, HolderLookup.@NotNull Provider provider) {
        super.saveAdditional(pTag, provider);
        ResourceLocation potionId = BuiltInRegistries.POTION.getKey(this.potion);
        if (potionId != null) pTag.putString("Potion", potionId.toString());
        pTag.putInt("Charges", this.charges);
        pTag.putBoolean("Filled", this.filled);
    }
}
