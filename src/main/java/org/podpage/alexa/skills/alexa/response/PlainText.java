package org.podpage.alexa.skills.alexa.response;

/**
 * Created by Lino on 17.01.2017.
 */
public class PlainText extends ResponseText {

    private String text;

    public PlainText(String text) {
        super("PlainText");
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
