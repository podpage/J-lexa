package org.podpage.alexa.skills.alexa.response.ssml;

/**
 * Created by Lino on 17.01.2017.
 */
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
