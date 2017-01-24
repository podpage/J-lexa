package org.podpage.alexa.skills.alexa.response.ssml;

/**
 * Created by D064954 on 18.01.2017.
 */
public class Speak extends SSMLObject {

    private SSMLObject[] ssml;

    public Speak(SSMLObject... ssml) {
        this.ssml = ssml;
    }

    public Speak(String text) {
        this.ssml = new SSMLObject[]{new Text(text)};
    }

    public String toSSML() {
        String speak = "<speak>";
        for (SSMLObject ssmlObject : ssml) {
            speak += ssmlObject.toString();
        }
        speak += "</speak>";
        return speak;
    }
}
