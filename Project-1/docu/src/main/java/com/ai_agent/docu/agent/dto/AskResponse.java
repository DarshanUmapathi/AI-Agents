package com.ai_agent.docu.agent.dto;

import java.util.List;

public record AskResponse (
        String answer,
        List<Citation> citations,
        boolean shouldCreateTicket
) {
}
