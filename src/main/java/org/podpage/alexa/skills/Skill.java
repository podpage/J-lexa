package org.podpage.alexa.skills;

import org.podpage.alexa.skills.alexa.request.AlexaRequest;

public interface Skill {

    SkillResponse call(Header inheader, AlexaRequest alexaRequest);
}
