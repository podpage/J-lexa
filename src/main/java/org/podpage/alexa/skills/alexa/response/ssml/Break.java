package org.podpage.alexa.skills.alexa.response.ssml;

/**
 * Created by Lino on 17.01.2017.
 */
public class Break {

    private String breakstring;

    public Break(double time) {
        this.breakstring = "<break time=\"" + Math.round(time * 10) / 10 + "s\"/>";
    }
}
