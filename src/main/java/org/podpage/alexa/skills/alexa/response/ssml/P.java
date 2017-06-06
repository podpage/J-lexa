package org.podpage.alexa.skills.alexa.response.ssml;

public class P extends SSMLObject {

    private SSMLObject[] ssml;

    public P(SSMLObject... ssml) {
        this.ssml = ssml;
    }

    public String toSSML() {
        String speak = "<p>";
        for (SSMLObject ssmlObject : ssml) {
            speak += ssmlObject.toSSML();
        }
        speak += "</p>";
        return speak;
    }
}
