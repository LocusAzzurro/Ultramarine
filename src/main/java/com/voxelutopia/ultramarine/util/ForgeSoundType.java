package com.voxelutopia.ultramarine.util;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.SoundType;
import org.jetbrains.annotations.NotNull;

/**
 * Name: Ultramarine / ForgeSoundType
 * Author: cnlimiter
 * CreateTime: 2023/10/3 9:23
 * Description:
 */

public class ForgeSoundType extends SoundType
{
    private final SoundEvent breakSound;
    private final SoundEvent stepSound;
    private final SoundEvent placeSound;
    private final SoundEvent hitSound;
    private final SoundEvent fallSound;

    public ForgeSoundType(float volumeIn, float pitchIn, SoundEvent breakSoundIn, SoundEvent stepSoundIn, SoundEvent placeSoundIn, SoundEvent hitSoundIn, SoundEvent fallSoundIn)
    {
        super(volumeIn, pitchIn, null, null, null, null, null);
        this.breakSound = breakSoundIn;
        this.stepSound = stepSoundIn;
        this.placeSound = placeSoundIn;
        this.hitSound = hitSoundIn;
        this.fallSound = fallSoundIn;
    }

    @NotNull
    @Override
    public SoundEvent getBreakSound()
    {
        return breakSound;
    }

    @NotNull
    @Override
    public SoundEvent getStepSound()
    {
        return stepSound;
    }

    @NotNull
    @Override
    public SoundEvent getPlaceSound()
    {
        return placeSound;
    }

    @NotNull
    @Override
    public SoundEvent getHitSound()
    {
        return hitSound;
    }

    @NotNull
    @Override
    public SoundEvent getFallSound()
    {
        return fallSound;
    }
}
