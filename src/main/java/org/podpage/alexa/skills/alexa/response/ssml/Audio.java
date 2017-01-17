package org.podpage.alexa.skills.alexa.response.ssml;

/**
 * Created by Lino on 17.01.2017.
 */
public class Audio {

    private String audio;

    public Audio(String src) {
        this.audio = "<audio src=\"" + src + "\"/>";
    }
}
