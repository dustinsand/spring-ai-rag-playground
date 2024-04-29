Spring AI RAG Playground
---
The intent of this playground is to experiment with the different embeddings supported by Spring AI to load the entire text of a document into a vector store and 
then expose an API through which questions can be asked about the document's 
content.

## Experiments

Experiments have been done with OpenAI and Ollama so far. You will need to modify the application.properties to configure for the experiment you want to run.
                                                         
### OpenAI
Before running the application for OpenAI, you'll need to acquire an OpenAI API key.
Set the API key as an environment variable named `OPENAI_API_KEY`. E.g.,

```
$ export OPENAI_API_KEY=sk-1234567890abcdef1234567890abcdef
```

### Ollama
Before running the application for Ollama, you'll need to install Ollama and the model to use.

## Developer Setup

### Run Postgres & PGVector DB locally

```shell
docker run -it --rm --name postgres -p 5432:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres ankane/pgvector
```

You can connect to this server like this:
```shell
psql -U postgres -h localhost -p 5432
```

### Dota
You'll also need a document for it to load. Set the `app.resource` property 
in src/main/resources/application.properties to the resource URL of the
document. For example:

```
app.resource=file:///Users/someuser/Spring_in_Action_SixthIEdition.pdf
```

The resource URL can be a file, classpath, or even an HTTP URL. The file
itself can be any document type supported by Apache Tika, including PDF,
Word, HTML, and more.

Then run the application as you would any Spring Boot application. For
example, using Maven:

```
$ mvn spring-boot:run
```

The first time you run it, it will take a little while to load the document into
the vector store (which will be persisted at /tmp/vectorstore.json). Subsequent
runs will just use the persisted vector store and not try to load the document again.
(This means that if you change the document resource, you'll need to delete
/tmp/vectorstore.json so that it will be reloaded.)

Then you can use `curl` to ask questions:

```
$ curl localhost:8080/ask -H"Content-type: application/json" -d '{"question": "What annotation should I use to create a REST controller?"}'
```

> The question shown in the example was used to ask questions against my book,
[Spring in Action, 6th Edition](https://www.manning.com/books/spring-in-action-sixth-edition?a_aid=habuma&a_bid=f205d999&chan=habuma). 
You'll want to ask questions relevant to whatever document you're using.

Or with HTTPie it's a little easier:

```
http :8080/ask question="What annotation should I use to create a REST controller?"
```

## References
This playground is based off Craig Walls [example](https://github.com/habuma/spring-ai-rag-example).