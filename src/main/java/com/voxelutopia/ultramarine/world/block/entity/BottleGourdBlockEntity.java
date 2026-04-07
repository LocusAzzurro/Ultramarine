package com.voxelutopia.ultramarine.world.block.entity;

import com.voxelutopia.ultramarine.data.registry.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
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
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        this.charges = input.getIntOr("Charges", 0);

        String potionString = input.getStringOr("Potion", "");
        if (potionString.isEmpty()) {
            this.potion = Potions.WATER.value();
            return;
        }

        Identifier potionId = Identifier.tryParse(potionString);
        if (potionId == null) {
            this.potion = Potions.WATER.value();
            return;
        }

        this.potion = BuiltInRegistries.POTION.get(potionId)
                .map(Holder.Reference::value)
                .orElse(Potions.WATER.value());
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        output.putInt("Charges", this.charges);

        Identifier potionId = BuiltInRegistries.POTION.getKey(this.potion);
        if (potionId != null) {
            output.putString("Potion", potionId.toString());
        }
    }
}
