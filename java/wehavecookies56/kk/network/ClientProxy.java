package wehavecookies56.kk.network;

import wehavecookies56.kk.item.ModItems;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenders(){
		ModItems.registerRenders();
	}
	
}
