### Module kafka-producer-wikimedia
- This includes advanced Producer code for kafka which consume data from "https://stream.wikimedia.org/v2/stream/recentchange" and produce this data to Kafka-TOPIC
- Create local kafka cluster using docker.
- Concept Covered
  **- Producer implementation, Producer Ack Deep Dive, retries, making producer Idempotent, safe Kafka producer, Kafka Message compression, producing in batch for high throughput**
- Further information about this module is available under **Module-producer-wikimedia README**.

### How to Run Project
- Folder kafka-consumer-opensearch has **_docker-compose.yml_** which Start Local Kafka cluster with Conducktor UI interface using Docker.
- Go inside folder and hit **_docker-compose up_** command

- You can access the open search console at http://localhost:5601/app/dev_tools#/console after running the Docker compose file

- Run the OpenSearchConsumer.java file. 
  - **The process will start the ingestion of data from a Kafka topic into the wikimedia index in OpenSearch..**



- Good to know open search command
    - https://opensearch.org/docs/latest/getting-started/intro/ is a good place to get an idea about opensearch.
    - _Create Index_
        - PUT /my-first-index
    - _Add some data to index_
        - PUT /my-first-index/_doc/1
          {"name": "Test"}
    - _Get data_
        - GET /my-first-index/_doc/1