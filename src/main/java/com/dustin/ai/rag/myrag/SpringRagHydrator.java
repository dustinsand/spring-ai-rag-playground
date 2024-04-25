package com.dustin.ai.rag.myrag;

import java.io.File;
import java.util.ArrayList;

import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.ai.transformer.splitter.TextSplitter;
import org.springframework.ai.vectorstore.SimpleVectorStore;


public class SpringRagHydrator {
    
    static protected TikaDocumentReader dR;
    static protected TextSplitter spl;
    static protected String fileStorePath;
    static protected SimpleVectorStore vs;
   
 

    static SimpleVectorStore hydrateVectorStore(ArrayList<String> documentUrls){
        File vsf = new File(fileStorePath);
        for (String docfile : documentUrls) {
            try{
                dR =  new TikaDocumentReader(docfile);
                vs.add(spl.apply(dR.get()));
                vs.save(vsf);
                
            }
            catch(Exception e){
                System.out.print("Error loading file into vector db. Will not be available for procesesing");
            }
        }
        return vs;
    }
}
