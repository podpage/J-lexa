package org.podpage.alexa.skills.alexa.response;

import org.podpage.alexa.skills.alexa.response.ssml.SSMLObject;
import org.podpage.alexa.skills.alexa.response.ssml.Speak;

/**
 * Created by Lino on 17.01.2017.
 */
public class SSMLText extends ResponseText {

    private SSMLObject ssml;

    public SSMLText(Speak speak) {
        super("SSML");
        this.ssml = speak;
    }

    public SSMLObject getSSML() {
        return ssml;
    }

    public void setSsml(Speak ssml) {
        this.ssml = ssml;
    }

    public String toString() {
        return ssml.toSSML();
    }
}
