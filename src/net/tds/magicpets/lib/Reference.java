package net.tds.magicpets.lib;

import java.util.logging.Logger;

import cpw.mods.fml.common.FMLLog;

public class Reference {

	public static final String MOD_ID = "TDS_MP";
	public static final String MOD_NAME = "Magic Pets";
	public static final String VERSION = "1.0.0"; 
	public static final String PROXY_CLIENT = "net.tds.magicpets.proxy.ClientProxy";
	public static final String PROXY_SERVER = "net.tds.magicpets.proxy.CommonProxy";
	
	public static Logger logger = Logger.getLogger(MOD_NAME);
	
	static {
		
		logger.setParent(FMLLog.getLogger());
	}
}
