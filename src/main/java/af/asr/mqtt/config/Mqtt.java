package af.asr.mqtt.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Component
public class Mqtt {

    private static IMqttClient instance;

    public  static String MQTT_PUBLISHER_ID;
    public  static String MQTT_SERVER_ADDRESS;

    @PostConstruct
    public void init()
    {
        System.out.println("PublisherId: "+ MQTT_PUBLISHER_ID);
    }

    public static IMqttClient getInstance() {
        try {
            if (instance == null) {
                instance = new MqttClient(MQTT_PUBLISHER_ID, MQTT_SERVER_ADDRESS);
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

    @Value("${mqtt.publisher_id}")
    public void setMqttPublisherId(String publisherId)
    {
        this.MQTT_PUBLISHER_ID = publisherId;
    }


    @Value("${mqtt.server_address}")
    public void setMqttServerAddress(String serverAddress)
    {
        this.MQTT_SERVER_ADDRESS = serverAddress;
    }

}