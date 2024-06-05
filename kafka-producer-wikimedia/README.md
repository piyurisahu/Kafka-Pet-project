
# Kafka Producer Wikimedia
- This includes advanced Producer code for kafka which consume data from "https://stream.wikimedia.org/v2/stream/recentchange" and produce this data to Kafka-TOPIC
- Create local kafka cluster using docker.
- Concept Covered
  **- Producer implementation, Producer Ack Deep Dive, retries, making producer Idempotent, safe Kafka producer, Kafka Message compression, producing in batch for high throughput**
- Further information about this module is available under **Module-producer-wikimedia README**.

### How to Run Project
- Prerequisite:- Docker and Java in your local machine.
- Folder condukto-plateform has **_docker-compose.yml_** which Start Local Kafka cluster with Conducktor UI interface using Docker.
- Go inside folder and hit **_docker-compose up_** command
- You can access the Docker console and local Kafka cluster at http://localhost:8080/console/topics after running the Docker compose file.- Click on the link and create topic "wikimedia.recentChange"
- ##### To start the producer, follow these steps: - 
  - Click the link and create a new subject named "wikimedia.recentChange"
  - Run the WikimediaChangesProducer.java file. 