package org.podpage.alexa.skills.alexa.response.ssml;

/**
 * Created by Lino on 17.01.2017.
 */
public class Break extends Speak.SSMLObject {

    private double time;

    public Break(double time) {
        this.time = time;
    }

    public String toSSML() {
        return "<break time=\"" + Math.round(time * 10) / 10 + "s\"/>";
    }
}
