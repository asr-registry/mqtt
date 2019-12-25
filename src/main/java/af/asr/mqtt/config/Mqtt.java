package af.asr.mqtt.config;

import af.asr.mqtt.util.MqttServerConstants;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Mqtt {

    private static IMqttClient instance;

    public static IMqttClient getInstance() {
        try {
            if (instance == null) {
                instance = new MqttClient(MqttServerConstants.MQTT_PUBLISHER_ID, MqttServerConstants.MQTT_SERVER_ADDRESS);
            }

            MqttConnectOptions options = new MqttConnectOptions();
            options.setAutomaticReconnect(true);
            options.setCleanSession(true);
            options.setConnectionTimeout(10);

            if (!instance.isConnected()) {
                instance.connect(options);
            }
        } catch (MqttException e) {
            e.printStackTrace();
        }

        return instance;
    }

}