package org.podpage.alexa.skills.alexa.response;

/**
 * Created by Lino on 17.01.2017.
 */
public abstract class ResponseText {

    private String type;

    public ResponseText(String type) {
        this.type = type;
    }

    public abstract String toString();
}