package org.podpage.alexa.skills.alexa.response.ssml;

/**
 * Created by Lino on 17.01.2017.
 */
public class Audio extends SSMLObject {

    private String src;

    public Audio(String src) {
        this.src = src;
    }

    public String toSSML() {
        return "<audio src=\"" + src + "\"/>";
    }
}
