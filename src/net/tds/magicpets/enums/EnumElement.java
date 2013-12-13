package net.tds.magicpets.enums;

/**
 * Author: ShadowChild.
 */
public enum EnumElement {

    FIRE("fire", 0x680000),
    WATER("water", 0x0066FF),
    EARTH("earth", 0x333300),
    AIR("air", 0x66CCFF),
    LIGHT("light", 0xFFFF33),
    UNDEAD("undead", 0x606060);

    private EnumElement(String name, int colour) {

        this.name = name;
        this.colour = colour;
    }

    public String name;
    public int colour;

    public static EnumElement getElement(String name) {

        for(EnumElement element : values()) {

            if(element.name.equalsIgnoreCase(name)) {

                return element;
            }
        }

        return null;
    }

    public static int getColour(String name) {

        EnumElement element = getElement(name);
        if(element != null) {

            return element.colour;
        }

        return -1;
    }
}
