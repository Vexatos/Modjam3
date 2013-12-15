package net.tds.magicpets.entity.boss;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public abstract class EntityMagicalBoss extends EntityWaterMob implements IBossDisplayData {

    public EntityMagicalBoss(World par1World) {

        super(par1World);

        this.setSize(1.0F, 1.0F);

        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, 0.4D, false));
        this.tasks.addTask(2, new EntityAIWander(this, 0.4D));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(3, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.experienceValue = 120;
    }

    protected boolean isAIEnabled() {

        return true;
    }

    @SideOnly(Side.CLIENT)
    public void onLivingUpdate() {

        getBossDisplay(this, true);
        super.onLivingUpdate();
    }

    @SideOnly(Side.CLIENT)
    public void getBossDisplay(IBossDisplayData display, boolean par1) {

        BossStatus.setBossStatus(display, par1);
    }
}
