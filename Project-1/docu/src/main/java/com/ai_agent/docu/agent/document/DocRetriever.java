package com.ai_agent.docu.agent.document;

import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;

@Component
public class DocRetriever {

    public List<Doc> retriveDocs(String questions, List<Doc> docs) {
        String q = questions.toLowerCase(Locale.ROOT);
        return docs.stream()
                .map(doc -> new ScoredDoc(doc, score(q,doc.Content())))
                .filter(sd -> sd.score > 0)
                .sorted(Comparator.comparingInt(ScoredDoc::score).reversed())
                .limit(2)
                .map(ScoredDoc::doc)
                .toList();
    }

    private int score(String q, String content) {
        int score = 0;
        for(String word:q.split("\\s+")) {
            if(content.toLowerCase(Locale.ROOT).contains(word)) {
                score += 1;
            }
        }
        return score;
    }

    private record ScoredDoc(Doc doc, int score) {
    }
}
