package org.podpage.alexa.skills.alexa.response.ssml;

/**
 * Created by D064954 on 23.01.2017.
 */
public class Text extends SSMLObject {

    private String text;

    public Text(String text) {
        this.text = text;
    }

    public String toSSML() {
        return text;
    }
}
