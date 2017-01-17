package org.podpage.alexa.skills.alexa.response;

/**
 * Created by Lino on 17.01.2017.
 */
public class SsmlText extends ResponseText {

    private String ssml;

    public SsmlText(String ssml) {
        super("SSML");
        this.ssml = ssml;
    }

    public String getSsml() {
        return ssml;
    }

    public void setSsml(String ssml) {
        this.ssml = ssml;
    }
}
