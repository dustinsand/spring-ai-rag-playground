package com.dustin.ai.rag.myrag.ollama;

import org.springframework.ai.embedding.EmbeddingClient;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class OllamaEmbeddingController {

    private final EmbeddingClient embeddingClient;

    @Autowired
    public OllamaEmbeddingController(EmbeddingClient embeddingClient) {
        this.embeddingClient = embeddingClient;
    }

    @GetMapping("/ai/ollama/embedding")
    public Map embed(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        EmbeddingResponse embeddingResponse = this.embeddingClient.embedForResponse(List.of(message));
        return Map.of("embedding", embeddingResponse);
    }
}
