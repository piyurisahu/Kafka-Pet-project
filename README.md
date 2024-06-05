# Kafka PET project



## Content
- Basics of Kafka Java Programming
- Wikimedia Producer
- OpenSearch Consumer
- Kafka Streams Sample Application


## Module Kafka-basic
- This includes the fundamental code needed for kafka to produce/consume message
- Here I am using kafka cluster from https://upstash.com/
- Further information about this module is available under **KAFKA-BASIC's README**.

## Wikimedia Event Stream  Demo Project
  This project consume the **_wikimedia Event Stream_**, allowing analysis of recent changes on Wikimedia properties. You can interact with Chart to filter dynamically. Charts are updateed with new events as provided by API.

  
### Module kafka-producer-wikimedia
- This includes advanced Producer code for kafka which consume data from "https://stream.wikimedia.org/v2/stream/recentchange" and produce this data to Kafka-TOPIC
- Create local kafka cluster using docker.
- Concept Covered
  **- Producer implementation, Producer Ack Deep Dive, retries, making producer Idempotent, safe Kafka producer, Kafka Message compression, producing in batch for high throughput**
- Further information about this module is available under **Module-producer-wikimedia README**.


### Module Kafka-consumer-opensearch
- this includes advanced Consumer Code which consumer data from Kafka topic & ingest data to OpenSearch.
- Create local OpenSearch cluster using docker.
- Concept Covered
- Concept Covered
  - **Consumer Implementation, Delivery Semantics, Offset Commit, Offset commit Strategy, Batching data, Offset reset, replaying data,
  - consumer internal threads, replica fetching** 
  - Further information about this module is available under **Module-consumer-opensearch README**.

