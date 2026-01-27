package com.ai_agent.docu.agent.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AskRequest(
        @NotBlank String question,
        boolean createTicket
) {}
