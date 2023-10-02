package com.voxelutopia.ultramarine.world.block.entity;

import com.voxelutopia.ultramarine.data.registry.BlockEntityRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Optional;

public class BottleGourdBlockEntity extends TileEntity {

    public static final int MAX_CHARGE = 6;

    private Potion potion;
    private int charges;
    private boolean filled;

    public BottleGourdBlockEntity() {
        super(BlockEntityRegistry.BOTTLE_GOURD.get());
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
        if (!filled || charges <= 0 || this.potion.equals(Potions.EMPTY)) return Optional.empty();
        else {
            Potion charge = this.potion;
            this.charges--;
            if (charges <= 0) {
                filled = false;
                this.potion = Potions.EMPTY;
            }
            return Optional.of(charge);
        }
    }

    public boolean hasCharges() {
        return (filled && charges > 0 && !potion.equals(Potions.EMPTY));
    }

    public int getCharges() {
        return this.charges;
    }

    public Potion getPotion() {
        return potion;
    }

    @Override
    public void load(BlockState state, CompoundNBT pTag) {
        super.load(state, pTag);
        this.potion = Potion.byName(pTag.getString("Potion"));
        this.charges = pTag.getInt("Charges");
        this.filled = pTag.getBoolean("Filled");
    }

    @Override
    public CompoundNBT save(CompoundNBT pTag) {
        super.save(pTag);
        pTag.putString("Potion", ForgeRegistries.POTION_TYPES.getKey(this.potion).toString());
        pTag.putInt("Charges", this.charges);
        pTag.putBoolean("Filled", this.filled);
        return pTag;
    }

}
