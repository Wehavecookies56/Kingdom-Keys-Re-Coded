package uk.co.wehavecookies56.kk.common.entity.mobs.multipart;

import net.minecraft.entity.Entity;
import net.minecraft.entity.IEntityMultiPart;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;

public class EntityPart extends Entity
{
    public final IMultiPartEntity parent;
    public final String partName;

    public EntityPart(IMultiPartEntity parent, String partName, float width, float height)
    {
        super(parent.getWorld());
        this.setSize(width, height);
        this.parent = parent;
        this.partName = partName;
    }

    public void onUpdate()
    {
    	//System.out.println(this.getPosition());
    	super.onUpdate();
    }
    
    protected void entityInit() {}

    protected void readEntityFromNBT(NBTTagCompound compound) {}

    protected void writeEntityToNBT(NBTTagCompound compound) {}

    public boolean canBeCollidedWith() 
    { 
    	return true; 
    }
    
    public String getPartName() { return this.partName; }

    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        return this.isEntityInvulnerable(source) ? false : this.parent.attackEntityFromPart(this, source, amount);
    }

    public boolean isEntityEqual(Entity entityIn)
    {
        return this == entityIn || this.parent == entityIn;
    }
    
}