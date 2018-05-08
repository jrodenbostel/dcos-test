## Setup Guide
https://dcos.io/docs/1.11/installing/cloud/aws/

## Helpful URLs
* http://{cloud formation output dns name} (dcos)
* http://{cloud formation output dns name}/marathon/ui/#/apps (marathon)
* http://{public slave ec2 elb dns name}:9090/haproxy?stats (marathon-lb)
* http://{public slave ec2 elb dns name}:13000 (grafana)
* http://influxdb.marathon.l4lb.thisdcos.directory:8086 (internal lb url for influx)
* https://dcos.io/docs/1.11/usage/cli/install/#osx

## DC/OS Change Target
* `dcos config set core.dcos_url http://example.com`
* `dcos auth login`


## DC/OS Kafka Install
1. `dcos package install kafka --options=kafka-minimal.json`
2. `dcos kafka topic create topic-test --partitions 1 --replication 1`
3. `dcos kafka topic list`

## DC/OS Kafka Config
1. `dcos kafka connection`
2. `dcos node ssh --master-proxy --leader`
3. `docker run -it mesosphere/kafka-client`
4. `echo "Hello, world." | ./kafka-console-producer.sh --broker-list {comma separated ip list} --topic topic-test`
5. `./kafka-console-consumer.sh --zookeeper master.mesos:2181/dcos-service-kafka --topic topic-test --from-beginning`

Example: `echo "Hello, world." | ./kafka-console-producer.sh --broker-list 10.0.3.237:9788,10.0.0.76:9385,10.0.1.87:9846 --topic topic-test`

## Monitoring Install
1. `dcos package install marathon-lb`
2. `dcos package install cadvisor --options=cadvisor-config.json` (exposes external access through marathon lb at http://{public slave ec2 elb dns name}:18080)
3. `dcos package install influxdb --options=influxdb-config.json` (exposes external access through marathon lb at http://{public slave ec2 elb dns name}:18086)
4. `dcos package install grafana`

## Services Install
`dcos marathon app add ../temperature-service/src/main/marathon/application.json`

## Monitoring config
1. create cadvisor database in influxdb: `curl -XPOST 'http://ec2-34-229-237-148.compute-1.amazonaws.com:18086/query?pretty=true' --data-urlencode 'q=CREATE DATABASE "cadvisor"'`
2. create data source in grafana (grafana credentials are admin/admin, cadvisor db credentials are root/root)
3. import grafana dashboard config
