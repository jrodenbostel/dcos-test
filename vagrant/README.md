## DC/OS Change Target
* dcos config set core.dcos_url http://m1.dcos
* dcos auth login

## DC/OS Kafka Install
1. dcos package install kafka --options=kafka-minimal.json
2. dcos kafka topic create topic-test --partitions 1 --replication 1
3. dcos kafka topic list

## DC/OS Kafka Config
1. dcos kafka connection
2. dcos node ssh --master-proxy --leader
3. docker run -it mesosphere/kafka-client
4. echo "Hello, world." | ./kafka-console-producer.sh --broker-list {comma separated ip list} --topic topic-test
5. ./kafka-console-consumer.sh --zookeeper master.mesos:2181/dcos-service-kafka --topic topic-test --from-beginning