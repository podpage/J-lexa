package org.podpage.alexa.skills.alexa.response;

/**
 * Created by Lino on 17.01.2017.
 */
public class Response {

    private ResponseText outputSpeech;
    private Reprompt reprompt;
    private boolean shouldEndSession = true;

    public Response(ResponseText outputSpeech, Reprompt reprompt) {
        this.outputSpeech = outputSpeech;
        this.reprompt = reprompt;
    }

    public ResponseText getOutputSpeech() {
        return outputSpeech;
    }

    public void setOutputSpeech(ResponseText outputSpeech) {
        this.outputSpeech = outputSpeech;
    }

    public Reprompt getReprompt() {
        return reprompt;
    }

    public void setReprompt(Reprompt reprompt) {
        this.reprompt = reprompt;
    }

    public boolean isShouldEndSession() {
        return shouldEndSession;
    }

    public void setShouldEndSession(boolean shouldEndSession) {
        this.shouldEndSession = shouldEndSession;
    }
}
