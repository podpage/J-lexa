package org.podpage.alexa.skills.defaultskills;

import org.podpage.alexa.skills.*;
import org.podpage.alexa.skills.alexa.response.AlexaRequest;

public class NoAlexaSkill implements Skill {

    @Override
    public SkillResponse call(Header inheader, AlexaRequest alexaRequest) {
        return new SkillResponse(new ResponseHeader(ResponseHeader.ResponseCode.CODE_501),
                new ResponseContent().addContent("Only Alexa is allowed on here"));
    }
}
