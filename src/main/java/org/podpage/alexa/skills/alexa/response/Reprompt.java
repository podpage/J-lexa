package org.podpage.alexa.skills.alexa.response;

/**
 * Created by Lino on 17.01.2017.
 */
public class Reprompt {

    private ResponseText outputSpeech;

    public Reprompt(ResponseText outputSpeech) {
        this.outputSpeech = outputSpeech;
    }

    public ResponseText getOutputSpeech() {
        return outputSpeech;
    }

    public void setOutputSpeech(ResponseText outputSpeech) {
        this.outputSpeech = outputSpeech;
    }
}
