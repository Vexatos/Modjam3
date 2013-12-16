package net.tds.magicpets.enums;

import javax.swing.text.html.parser.Element;

import net.tds.magicpets.entity.passive.*;
import net.tds.magicpets.lib.Config;


public enum EnumElement {

    FIRE("fire", 0x680000, EntityBabyFirePet.class, Config.firePetID),
    WATER("water", 0x0066FF, EntityBabyWaterPet.class, Config.waterPetID),
    EARTH("earth", 0x336600, EntityBabyEarthPet.class, Config.earthPetID),
    AIR("air", 0x66CCFF, EntityBabyAirPet.class, Config.airPetID),
    LIGHT("light", 0xFFFF33, EntityBabyLightPet.class, Config.lightPetID),
    UNDEAD("undead", 0x606060, EntityBabyUndeadPet.class, Config.undeadPetID); //Iluminati

    private EnumElement(String type, int colour, Class<? extends EntityMagicalPet> pet, int id) {

    	this.type = type;
        this.colour = colour;
        this.pet = pet;
        this.id = id;
    }

    public String type;
    public int colour;
    public Class<? extends EntityMagicalPet> pet;
    public int id;

    /**
     * Get an element from the list of enums.
     * @param type: identifier/type of element.
     * @return: Instance of the Enum being used.
     */
    public static EnumElement getType(String type) {

        for(EnumElement element : values()) {

            if(element.type.equalsIgnoreCase(type)) {

                return element;
            }
        }

        return null;
    }

    /**
     * Get a hex color code from the enum
     * @param type: enum being searched.
     * @return: hex color value
     */
    public static int getColour(String type) {

        EnumElement element = getType(type);
        
        if(element != null) {

            return element.colour;
        }
        return -1;
    }
    
    public static Class<? extends EntityMagicalPet> getPet(String type) {
    	
    	EnumElement element = getType(type);
    	
    	if(element != null) {
    		
    		return element.pet;
    	}
    	
    	return null;
    }
    
    /**
     * Gets an entity id from the enum
     * @param type: enum being searched.
     * @return: the entity id.
     */
    public static int getID(String type) {
    	
    	EnumElement element = getType(type);
    	
        if(element != null) {
        	
        	return Element.ID;
        }
        
        return -1;
    }
}