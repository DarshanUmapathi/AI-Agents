package com.ai_agent.docu.agent;

import com.ai_agent.docu.agent.document.Doc;
import com.ai_agent.docu.agent.document.DocRetriever;
import com.ai_agent.docu.agent.document.DocStore;
import com.ai_agent.docu.agent.dto.AskRequest;
import com.ai_agent.docu.agent.dto.AskResponse;
import com.ai_agent.docu.agent.dto.Citation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentService {

    private static final Logger logger = LoggerFactory.getLogger(AgentService.class);

    private final DocStore docStore;
    private final DocRetriever docRetriever;

    public AgentService(DocStore docStore, DocRetriever docRetriever) {
        this.docStore = docStore;
        this.docRetriever = docRetriever;
    }



    public AskResponse ask(AskRequest askRequest) {
        logger.info("Processing ask request: {}", askRequest);
        List<Doc> docs = docStore.loadDoc();
        List<Doc> relevantDocs = docRetriever.retriveDocs(askRequest.question(), docs);
        logger.info("Relevant docs: {}", relevantDocs);

        List<Citation> citations = relevantDocs.stream()
                .map(doc -> new Citation(doc.id(), snippet(doc.Content())))
                .toList();
        // Day1 : Stubbing
        String answer = relevantDocs.isEmpty() ? "No related documents" : "Answer based on documentation:" +relevantDocs.getFirst().Content();
        AskResponse response = new AskResponse(answer, citations , false);
        logger.info("Generated response: {}", response);
        return response;
    }

    private String snippet(String content) {
        return content.length() > 120 ? content.substring(0, 120) + "..." : content;
    }
}
