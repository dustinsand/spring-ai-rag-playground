package com.dustin.ai.rag.myrag;

import org.springframework.ai.vectorstore.VectorStore;


import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("/add")
public class AddController {

    
    private final VectorStore vectorStore;
    
    public AddController(VectorStore vs){
        this.vectorStore =  vs;
    }


    @PostMapping
    public String add(@RequestBody DocumentList docs){
        System.out.print(docs);
        SpringRagHydrator.hydrateVectorStore(docs.urls());
        return "Success";
    }
    
}
