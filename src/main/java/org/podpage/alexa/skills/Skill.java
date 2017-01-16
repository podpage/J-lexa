package org.podpage.alexa.skills;

import org.podpage.alexa.skills.alexa.response.AlexaRequest;

public interface Skill {

    SkillResponse call(Header inheader, AlexaRequest alexaRequest);
}
