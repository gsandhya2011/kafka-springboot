# Implementing a kafka consumer and kafka producer with Spring Boot
* **Apache Kafka:** distributed streaming and messaging platform.Moves and transforms large amount of data between different systems
* **Producer:** Responsible for sending messages to a specific topic
* **Consumer:** Responsible for reading messages sent by producer from a topic of interest.
* **Topic:** unique name for Kafka stream. Subscriber subscribes to a topic of his interest.
* **Partition:** break the topic into multiple partition and distribute it to multiple computers(1partition on 1computer)
* **Offset:** A sequence id given to message in the order they arrive in a partition. Offsets are local to a partition not global across partitions.
* Created 4 packages with admin, 
