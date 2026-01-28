package com.ai_agent.docu.agent.document;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
public class DocStore {

    public List<Doc> loadDoc(){
        return List.of(
                load("auth.md"),
                load("oncall.md"),
                load("payments.md")
        );
    }

    private Doc load(String filename) {
        try (var is = getClass().getClassLoader().getResourceAsStream("docs/"+filename)) {
            if(is == null) {
                throw  new IllegalStateException("docs/"+filename+" not found");
            }

            String content = new String(is.readAllBytes(), StandardCharsets.UTF_8);
            return new Doc(filename, content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
