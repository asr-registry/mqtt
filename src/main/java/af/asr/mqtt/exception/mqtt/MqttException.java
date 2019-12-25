package af.asr.mqtt.exception.mqtt;

import af.asr.mqtt.exception.common.BaseCheckedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class MqttException extends BaseCheckedException {
    public MqttException(String message) {
        super(message);
    }
}