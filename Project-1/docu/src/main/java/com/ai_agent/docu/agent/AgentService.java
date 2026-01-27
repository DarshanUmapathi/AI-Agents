package com.ai_agent.docu.agent;

import com.ai_agent.docu.agent.dto.AskRequest;
import com.ai_agent.docu.agent.dto.AskResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentService {
    public AskResponse ask(AskRequest askRequest) {
        // Day1 : Stubbing
        return new AskResponse(" Stubbed Answer for :"+askRequest.question(), List.of(),false);
    }
}
