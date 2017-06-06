package org.podpage.alexa.skills.alexa.response;

import org.podpage.alexa.skills.alexa.response.ssml.SSMLObject;
import org.podpage.alexa.skills.alexa.response.ssml.Speak;

/**
 * Created by Lino on 17.01.2017.
 */
public class SSMLText extends ResponseText {

    private String ssml;

    public SSMLText(Speak speak) {
        super("SSML");
        this.ssml = speak.toSSML();
        System.out.println(ssml);
    }

    public String getSSML() {
        return ssml;
    }

    public void setSsml(Speak ssml) {
        this.ssml = ssml.toSSML();
    }

    public String toString() {
        return ssml;
    }
}
