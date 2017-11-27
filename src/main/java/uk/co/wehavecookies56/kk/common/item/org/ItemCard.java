package uk.co.wehavecookies56.kk.common.item.org;

import uk.co.wehavecookies56.kk.common.item.base.ItemOrgWeapon;
import uk.co.wehavecookies56.kk.common.util.Utils;
import uk.co.wehavecookies56.kk.common.util.Utils.OrgMember;

public class ItemCard extends ItemOrgWeapon implements IOrgWeapon{

    public ItemCard (String name, double[] stats)  {
        super(name, stats);
        setMaxStackSize(1);
    }

    @Override
    public OrgMember getMember() {
        return Utils.OrgMember.LUXORD;
    }
}
