package com.dustin.ai.rag.myrag;

import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.ai.transformer.splitter.TextSplitter;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SpringRagHydrator {

    final VectorStore vs;

    public SpringRagHydrator(VectorStore vs) {
        this.vs = vs;
    }

    public void hydrateVectorStore(ArrayList<String> documentUrls) {
        for (String docfile : documentUrls) {
            try {
                TikaDocumentReader dR = new TikaDocumentReader(docfile);
                TextSplitter textSplitter = new TokenTextSplitter();
                vs.add(textSplitter.apply(dR.get()));
            } catch (Exception e) {
                System.out.print("Error loading file into vector db. Will not be available for processing");
                throw e;
            }
        }
    }
}
