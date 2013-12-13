package net.tds.magicpets.enums;

import net.tds.magicpets.lib.Format;


/**
 * Author: ShadowChild.
 */
public enum EnumElement {

    FIRE("fire", Format.RED),
    WATER("water", Format.DARK_AQUA),
    EARTH("earth", Format.GREEN),
    AIR("air", Format.AQUA),
    LIGHT("light", Format.YELLOW),
    UNDEAD("undead", Format.DARK_GRAY);

    private EnumElement(String name, String colour) {

        this.name = name;
        this.colour = colour;
    }

    public String name, colour;

    public EnumElement getElement(String name) {

        for(EnumElement element : values()) {

            if(element.name.equalsIgnoreCase(name)) {

                return element;
            }
        }

        return null;
    }

    public String getColour(EnumElement element) {

        if(element != null) {

            return element.colour;
        }

        return null;
    }
}
