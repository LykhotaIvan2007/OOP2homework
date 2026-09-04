package com.nhlstenden.kingdomsandquests;

public class Attribute
{
    private String name;

    public Attribute(String name)
    {
        this.setName(name);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        if (name == null || name.isBlank())
        {
            throw new IllegalArgumentException("name can not be null or empty");
        }
        this.name = name;
    }
}
