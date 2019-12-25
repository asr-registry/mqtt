### CLient MQTT Library

MQTT (MQ Telemetry Transport) is a messaging protocol that was created to address the need for a simple and lightweight method to transfer data to/from low-powered devices, such as those used in industrial applications.

With the increased popularity of IoT (Internet of Things) devices, MQTT has seen an increased use, leading to its standardization by OASIS and ISO.

The protocol supports a single messaging pattern, namely the Publish-Subscribe pattern: each message sent by a client contains an associated “topic” which is used by the broker to route it to subscribed clients. Topics names can be simple strings like “oiltemp” or a path-like string “motor/1/rpm“.

In order to receive messages, a client subscribes to one or more topics using its exact name or a string containing one of the supported wildcards (“#” for multi-level topics and “+” for single-level”).

We are using Eclipse Paho Project. The Eclipse Paho project provides open-source client implementations of MQTT and MQTT-SN messaging protocols aimed at new, existing, and emerging applications for the Internet of Things (IoT).

#### Features

- 