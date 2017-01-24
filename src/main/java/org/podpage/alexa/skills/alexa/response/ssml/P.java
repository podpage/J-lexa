package org.podpage.alexa.skills.alexa.response.ssml;

/**
 * Created by Lino on 17.01.2017.
 */
public class P extends SSMLObject {

    private SSMLObject[] ssml;

    public P(SSMLObject... ssml) {
        this.ssml = ssml;
    }

    public String toSSML() {
        String speak = "<p>";
        for (SSMLObject ssmlObject : ssml) {
            speak += ssmlObject.toString();
        }
        speak += "</p>";
        return speak;
    }
}
