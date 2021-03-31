import java.util.{Date, Properties}

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord

object Producer extends App{
  val newArgs = Array("20","test","localhost:9092")
  val events = newArgs(0).toInt
  val topic = newArgs(1)
  val brokers = newArgs(2)
  val props = new Properties()
  props.put("bootstrap.servers", brokers)
  props.put("client.id", "producer")
  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")


  val producer = new KafkaProducer[String, String](props)
  val t = System.currentTimeMillis()
  for (nEvents <- Range(0, events)) {
    val key = "messageKey " + nEvents.toString
    val msg = "test message"
    val data = new ProducerRecord[String, String](topic, key, msg)

    //async
    //producer.send(data, (m,e) => {})
    //sync
    producer.send(data)
  }

  System.out.println("sent per second: " + events * 1000 / (System.currentTimeMillis() - t))
  producer.close()
}