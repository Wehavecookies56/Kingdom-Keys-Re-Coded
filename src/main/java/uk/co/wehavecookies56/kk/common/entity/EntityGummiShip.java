package uk.co.wehavecookies56.kk.common.entity;

import net.minecraft.entity.item.EntityBoat;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityGummiShip extends EntityBoat{

	public boolean leftInputDown;
	public boolean rightInputDown;
	public boolean forwardInputDown;
	public boolean backInputDown;

	public EntityGummiShip(World worldIn) {
		super(worldIn);
		// TODO Auto-generated constructor stub
	}

	@SideOnly(Side.CLIENT)
	@Override
    public void updateInputs(boolean p_184442_1_, boolean p_184442_2_, boolean p_184442_3_, boolean p_184442_4_)
    {
        this.leftInputDown = p_184442_1_;
        this.rightInputDown = p_184442_2_;
        this.forwardInputDown = p_184442_3_;
        this.backInputDown = p_184442_4_;
    }
	
}
