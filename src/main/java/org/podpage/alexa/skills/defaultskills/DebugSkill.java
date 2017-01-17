package org.podpage.alexa.skills.defaultskills;

import org.podpage.alexa.skills.*;
import org.podpage.alexa.skills.alexa.request.AlexaRequest;

public class DebugSkill implements Skill {

    @Override
    public SkillResponse call(Header inheader, AlexaRequest alexaRequest) {

        alexaRequest.getRequest().getIntent().getSlots().forEach((s, slot) -> {
            System.out.println(s + " - " + slot.toString());
        });

        ResponseContent rc = new ResponseContent();
        ResponseHeader responseHeader = new ResponseHeader(ResponseHeader.ResponseCode.CODE_200);
        return new SkillResponse(responseHeader, rc);
    }
}
