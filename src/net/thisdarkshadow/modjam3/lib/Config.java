package net.thisdarkshadow.modjam3.lib;

import java.io.File;

import net.minecraftforge.common.Configuration;

public class Config {

	public static Configuration conf;
	
	public Config(File file) {
		
		conf = new Configuration(file);
	}
	
	//General
	public static boolean playerMessage = conf.get(conf.CATEGORY_GENERAL, "Should messages sent to the player also be sent to the server/consol", false).getBoolean(false);
	
	//Item ID
	public static int crystalID = conf.get(conf.CATEGORY_ITEM, "Item ID for Summoning Crystal", 24380).getInt();
}
