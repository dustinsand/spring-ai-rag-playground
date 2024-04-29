package com.dustin.ai.rag.myrag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAIRAGExample {

    public static void main(String[] args) {

        SpringApplication.run(SpringAIRAGExample.class, args);
    }

//    @Value("${app.vectorstore.path:/tmp/vectorstore.json}")
//    private String vectorStorePath;
//
//    @Value("${app.resource}")
//    private Resource pdfResource;

//    @Bean
//    SimpleVectorStore simpleVectorStore(EmbeddingClient embeddingClient) {
//
//        SimpleVectorStore simpleVectorStore = new SimpleVectorStore(embeddingClient);
//
//        File vectorStoreFile = new File(vectorStorePath);
//        if (vectorStoreFile.exists()) { // load existing vector store if exists
//            simpleVectorStore.load(vectorStoreFile);
//        } else { // otherwise load the documents and save the vector store
//
//
//            TikaDocumentReader documentReader = new TikaDocumentReader(pdfResource);
//
//            List<Document> documents = documentReader.get();
//            TextSplitter textSplitter = new TokenTextSplitter();
//            List<Document> splitDocuments = textSplitter.apply(documents);
//            simpleVectorStore.add(splitDocuments);
//            simpleVectorStore.save(vectorStoreFile);
//
//        }
//        return simpleVectorStore;
//    }

}
