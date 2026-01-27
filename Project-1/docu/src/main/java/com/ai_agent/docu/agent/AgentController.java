package com.ai_agent.docu.agent;

import com.ai_agent.docu.agent.dto.AskRequest;
import com.ai_agent.docu.agent.dto.AskResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agent")
public class AgentController {

    private final AgentService agentService;

    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @PostMapping("/ask")
    public AskResponse ask(@RequestBody AskRequest askRequest) {
        return agentService.ask(askRequest);
    }

}
