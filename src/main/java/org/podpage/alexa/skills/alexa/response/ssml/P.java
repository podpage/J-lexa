package org.podpage.alexa.skills.alexa.response.ssml;

/**
 * Created by Lino on 17.01.2017.
 */
public class P extends SSMLObject {

    private String paragraph;

    public P(String paragraph) {
        this.paragraph = "<p>" + paragraph + "</p>";
    }

    public String toSSML() {
        return "";
    }
}
