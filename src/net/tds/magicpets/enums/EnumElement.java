package net.tds.magicpets.enums;

import net.tds.magicpets.entity.passive.*;


public enum EnumElement {

    FIRE("fire", 0x680000, EntityBabyFirePet.class),
    WATER("water", 0x0066FF, EntityBabyWaterPet.class),
    EARTH("earth", 0x336600, EntityBabyEarthPet.class),
    AIR("air", 0x66CCFF, EntityBabyAirPet.class),
    LIGHT("light", 0xFFFF33, EntityBabyLightPet.class),
    UNDEAD("undead", 0x606060, EntityBabyUndeadPet.class); //Iluminati

    private EnumElement(String type, int colour, Class<? extends EntityMagicalPet> pet) {

    	this.type = type;
        this.colour = colour;
        this.pet = pet;
    }

    public String type;
    public int colour;
    public Class<? extends EntityMagicalPet> pet;

    public static EnumElement getType(String type) {

        for(EnumElement element : values()) {

            if(element.type.equalsIgnoreCase(type)) {

                return element;
            }
        }

        return null;
    }

    public static int getColour(String type) {

        EnumElement element = getType(type);
        
        if(element != null) {

            return element.colour;
        }

        return -1;
    }
}
