package org.podpage.alexa.skills.alexa.response;

import java.util.HashMap;

/**
 * Created by Lino on 16.01.2017.
 */
public class Intent {

    private String name;
    private HashMap<String, Slot> slots;

    public String getName() {
        return name;
    }

    public HashMap<String, Slot> getSlots() {
        return slots;
    }

    @Override
    public String toString() {
        return "Intent{" +
                "name='" + name + '\'' +
                ", slots=" + slots +
                '}';
    }
}
