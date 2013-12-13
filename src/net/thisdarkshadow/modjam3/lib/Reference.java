package net.thisdarkshadow.modjam3.lib;

import java.util.logging.Logger;

import cpw.mods.fml.common.FMLLog;

public class Reference {

	public static final String MOD_ID = "TDS_JAM";
	public static final String MOD_NAME = "ThisDarkShadow - Modjam3";
	public static final String VERSION = "1.0.0"; 
	public static final String PROXY_CLIENT = "net.thisdarkshadow.modjam3.proxy.ClientProxy";
	public static final String PROXY_SERVER = "net.thisdarkshadow.modjam3.proxy.CommonProxy";
	
	public static Logger logger = Logger.getLogger(MOD_NAME);
	
	static {
		
		logger.setParent(FMLLog.getLogger());
	}
}
