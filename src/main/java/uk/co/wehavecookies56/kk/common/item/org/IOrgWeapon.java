package uk.co.wehavecookies56.kk.common.item.org;

import net.minecraft.item.Item;
import uk.co.wehavecookies56.kk.common.util.Utils;

/**
 * Created by Toby on 08/02/2017.
 */
public interface IOrgWeapon {
    public Utils.OrgMember getMember();
    public double getStrength();
    public double getMagic();
    public Item getItem();
    public void setDescription(String description);
    public String getDescription();
}
