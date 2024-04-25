package com.dustin.ai.rag.myrag;

import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/add")
public class AddController {

    private final SpringRagHydrator ragHydrator;
    private final VectorStore vectorStore;

    public AddController(VectorStore vs, SpringRagHydrator ragHydrator) {
        this.ragHydrator = ragHydrator;
        this.vectorStore = vs;
    }

    @PostMapping
    public String add(@RequestBody DocumentList docs) {

        ragHydrator.hydrateVectorStore(docs.urls());
        return "Success";
    }

}
