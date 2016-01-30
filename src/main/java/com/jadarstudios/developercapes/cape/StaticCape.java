/**
 * DeveloperCapes by Jadar
 * License: MIT License
 * (https://raw.github.com/jadar/DeveloperCapes/master/LICENSE)
 * version 4.0.0.x
 */
package com.jadarstudios.developercapes.cape;

import java.lang.reflect.Field;
import java.net.URL;

import com.jadarstudios.developercapes.DevCapes;
import com.jadarstudios.developercapes.HDImageBuffer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

/**
 * Default Cape implementation
 *
 * @author jadar
 */
public class StaticCape extends AbstractCape {

	public StaticCape(String name, URL url) {
		setName(name);
		setURL(url);
	}

	public StaticCape(String name) {
		this(name, null);
	}

	@Override
	public void loadTexture(AbstractClientPlayer player) {
		ResourceLocation location = getLocation();

		// mmdanggg2: using reflection to modify the private locationCape, hacky
		// but it works.
		// Wehavecookies56: Added obfuscated field names for reflection
		try {
			Field playerInfoF = ReflectionHelper.findField(AbstractClientPlayer.class, "playerInfo", "field_175157_a");
			playerInfoF.setAccessible(true);
			NetworkPlayerInfo nci = (NetworkPlayerInfo) playerInfoF.get(player);

			Field locationCapeF = ReflectionHelper.findField(NetworkPlayerInfo.class, "locationCape", "field_178862_f");
			locationCapeF.setAccessible(true);
			locationCapeF.set(nci, location);

			playerInfoF.setAccessible(false);
			locationCapeF.setAccessible(false);

		} catch (Exception e) {
			e.printStackTrace();
			DevCapes.getInstance();
			DevCapes.logger.error("Setting cape ResourceLocation failed!");
		}

		Minecraft.getMinecraft().renderEngine.loadTexture(location, getTexture());
	}

	@Override
	public boolean isTextureLoaded(AbstractClientPlayer player) {
		ResourceLocation cape = player.getLocationCape();
		return cape != null;
	}

	public void setURL(URL url) {
		if (url == null) {
			this.texture = null;
			return;
		}
		this.texture = new ThreadDownloadImageData(null, url.toString(), null, new HDImageBuffer());
	}

	public void setName(String name) {
		this.name = name;
		this.location = new ResourceLocation("DevCapes/" + name);
	}
}