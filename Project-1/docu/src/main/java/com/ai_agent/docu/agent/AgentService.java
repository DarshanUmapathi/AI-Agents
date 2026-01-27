package com.ai_agent.docu.agent;

import com.ai_agent.docu.agent.dto.AskRequest;
import com.ai_agent.docu.agent.dto.AskResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentService {

    private static final Logger logger = LoggerFactory.getLogger(AgentService.class);

    public AskResponse ask(AskRequest askRequest) {
        logger.info("Processing ask request: {}", askRequest);
        // Day1 : Stubbing
        AskResponse response = new AskResponse(" Stubbed Answer for :" + askRequest.question(), List.of(), false);
        logger.info("Generated response: {}", response);
        return response;
    }
}
