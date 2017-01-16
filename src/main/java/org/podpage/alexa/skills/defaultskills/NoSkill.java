package org.podpage.alexa.skills.defaultskills;

import org.podpage.alexa.skills.*;
import org.podpage.alexa.skills.alexa.response.AlexaRequest;

public class NoSkill implements Skill {

    @Override
    public SkillResponse call(Header inheader, AlexaRequest alexaRequest) {
        return new SkillResponse(new ResponseHeader(ResponseHeader.ResponseCode.CODE_404),
                new ResponseContent().addContent("No Skill Found"));
    }
}
