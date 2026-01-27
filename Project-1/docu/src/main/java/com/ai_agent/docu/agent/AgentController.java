package com.ai_agent.docu.agent;

import com.ai_agent.docu.agent.dto.AskRequest;
import com.ai_agent.docu.agent.dto.AskResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agent")
public class AgentController {

    private static final Logger logger = LoggerFactory.getLogger(AgentController.class);

    private final AgentService agentService;

    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @PostMapping("/ask")
    public AskResponse ask(@RequestBody AskRequest askRequest) {
        logger.info("ask request: {}", askRequest);
        AskResponse response = agentService.ask(askRequest);
        logger.info("ask response: {}", response);
        return response;
    }

}
