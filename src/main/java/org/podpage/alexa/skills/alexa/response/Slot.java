package org.podpage.alexa.skills.alexa.response;

/**
 * Created by Lino on 16.01.2017.
 */
public class Slot {

    private String name;
    private String value;

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
