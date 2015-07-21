package wehavecookies56.kk.materials;

import static wehavecookies56.kk.api.materials.MaterialRegistry.*;

import wehavecookies56.kk.lib.Strings;

public class ModMaterials {

	public static void init(){
		registerMaterial(new MaterialBlazingShard(Strings.SM_BlazingShard));
	}
}
