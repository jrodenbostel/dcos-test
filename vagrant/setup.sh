cd vagrant
vagrant up --provision
cd ..
dcos auth login
dcos package install kafka --options=kafka-minimal.json
dcos package install marathon-lb
dcos package install cadvisor
dcos package install influxdb
dcos package install grafana
dcos marathon app add ../temperature-service/src/main/marathon/application.json
