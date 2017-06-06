package org.podpage.alexa.skills.alexa.response.ssml;

public class S extends SSMLObject {

    private SSMLObject[] ssml;

    public S(SSMLObject... ssml) {
        this.ssml = ssml;
    }

    public String toSSML() {
        String speak = "<s>";
        for (SSMLObject ssmlObject : ssml) {
            speak += ssmlObject.toString();
        }
        speak += "</s>";
        return speak;
    }
}
