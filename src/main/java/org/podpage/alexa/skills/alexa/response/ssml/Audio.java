package org.podpage.alexa.skills.alexa.response.ssml;

public class Audio extends SSMLObject {

    private String src;

    public Audio(String src) {
        this.src = src;
    }

    public String toSSML() {
        return "<audio src=\"" + src + "\"/>";
    }
}
