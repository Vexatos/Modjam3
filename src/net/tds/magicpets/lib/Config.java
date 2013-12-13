package net.tds.magicpets.lib;

import net.minecraftforge.common.Configuration;

import java.io.File;

public class Config {

	public static Configuration conf;
	
	public static boolean playerMessage;
	public static boolean event;
	
	public static int crystalID;
    public static int essenceID;

    public Config(File file) {
		
		conf = new Configuration(file);
		
		conf.load();
		
		playerMessage = conf.get(conf.CATEGORY_GENERAL, "Should messages sent to the player also be sent to the server/console", false).getBoolean(false);
		event = conf.get(conf.CATEGORY_GENERAL, "Changing this to False will disable the event notice", true).getBoolean(true);
		
		crystalID = conf.get(conf.CATEGORY_ITEM, "Item ID for Summoning Crystal", 24380).getInt();
        essenceID = conf.get(conf.CATEGORY_ITEM, "Item ID for Essences", 24381).getInt();
		
		conf.save();
	}
}
