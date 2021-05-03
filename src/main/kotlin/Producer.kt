import io.confluent.kafka.serializers.KafkaAvroSerializer
import models.User
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import java.util.*

class Producer {
fun produce():KafkaProducer<String,User>{
    val props = Properties()
    props[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG]="localhost:9092"
    props[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG]=KafkaAvroSerializer::class.java
    props[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG]=KafkaAvroSerializer::class.java


    return KafkaProducer(props)
}
}