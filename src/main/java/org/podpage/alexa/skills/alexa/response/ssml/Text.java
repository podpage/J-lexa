package org.podpage.alexa.skills.alexa.response.ssml;

public class Text extends SSMLObject {

    private String text;

    public Text(String text) {
        this.text = text;
    }

    public String toSSML() {
        return text;
    }
}
