import io.confluent.kafka.serializers.KafkaAvroDeserializer
import models.User
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.consumer.KafkaConsumer
import java.util.*

class Consumer {
    fun consumer(): KafkaConsumer<String,User>{
        val props =Properties()
        props[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG]="localhost:9092"
        props[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG]=KafkaAvroDeserializer::class.java
        props[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG]= KafkaAvroDeserializer::class.java
        props[ConsumerConfig.GROUP_ID_CONFIG]= "Group-X"


        val KafkaConsumer =KafkaConsumer<String,User>(props)
        KafkaConsumer.subscribe(listOf("Topic-A"))
        return KafkaConsumer
    }
}