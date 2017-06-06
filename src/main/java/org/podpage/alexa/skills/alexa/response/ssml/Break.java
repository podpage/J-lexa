package org.podpage.alexa.skills.alexa.response.ssml;

public class Break extends SSMLObject {

    private double time;

    public Break(double time) {
        this.time = time;
    }

    public String toSSML() {
        return "<break time=\"" + ((double) Math.round(time * 10) / 10) + "s\"/>";
    }
}
