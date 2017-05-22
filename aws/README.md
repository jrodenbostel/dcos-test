## Setup Guide
https://dcos.io/docs/1.9/installing/cloud/aws/

## Helpful URLs
* http://{cloud formation output dns name}
* http://{cloud formation output dns name}/marathon/ui/#/apps
* https://dcos.io/docs/1.8/usage/cli/install/#osx

## DC/OS Change Target
* dcos config set core.dcos_url http://example.com
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

echo "Hello, world." | ./kafka-console-producer.sh --broker-list 10.0.3.237:9788,10.0.0.76:9385,10.0.1.87:9846 --topic topic-test

## Monitoring Config
dcos package install marathon-lb
dcos package install cadvisor
dcos package install influxdb
dcos package install grafana

## Services install
dcos marathon app add ../temperature-service/src/main/marathon/application.json
