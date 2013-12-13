package net.tds.magicpets.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;


/**
 * Author: ShadowChild.
 */
public abstract class EntityBossBase extends EntityMob implements IBossDisplayData {

    public EntityBossBase(World par1World) {

        super(par1World);

        this.setSize(1.5F, 2.0F);
        this.isImmuneToFire = true;

        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
        this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(3, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.experienceValue = 380;
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

    public abstract EnumCreatureAttribute getCreatureAttribute();

}