package net.tds.magicpets.enums;

public enum EnumElement {

    FIRE("fire", 0x680000),
    WATER("water", 0x0066FF),
    EARTH("earth", 0x336600),
    AIR("air", 0x66CCFF),
    LIGHT("light", 0xFFFF33),
    UNDEAD("undead", 0x606060); //Iluminati

    private EnumElement(String type, int colour) {

    	this.type = type;
        this.colour = colour;
    }

    public String type;
    public int colour;

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
