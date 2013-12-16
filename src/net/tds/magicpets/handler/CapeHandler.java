package net.tds.magicpets.handler;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.TextureObject;
import net.minecraft.util.ResourceLocation;

public class CapeHandler{
	
	/**
	 * Adds a new cape for a list of users
	 * @param list: List of usernames in form of string.
	 * @param url: The url of the cape given to the player.
	 */
	public static void registerCapesFromList(String[] list, String url){
		
		for (String playerName : list) {
			
			ThreadDownloadImageData object = new ThreadDownloadImageData(url, null, null);
			Minecraft.getMinecraft().renderEngine.loadTexture(new ResourceLocation("cloaks/" + playerName), (TextureObject) object);
		}
	}
	
	//Not implemented
	public static void registerCapeForEveryone(String url) {
		
	}
}