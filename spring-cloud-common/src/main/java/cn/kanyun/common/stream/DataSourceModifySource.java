package cn.kanyun.common.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * 自定义SpringCloud Stream消息发射器
 * 创建 StreamClient 接口，通过 @Input和 @Output注解定义输入通道和输出通道，
 * 另外，@Input 和 @Output 注解都还有一个 value 属性，该属性可以用来设置消息通道的名称，
 * 这里指定的消息通道名称分别是 myInput 和 myOutput。如果直接使用两个注解而没有指定具体的 value 值，
 * 则会默认使用方法名作为消息通道的名称
 *
 * @author Kanyun
 */
public interface DataSourceModifySource {


    /**
     * 定义一个常量,当使用SpringCloud stream 时,用来设置header
     */
    String MESSAGE_HEADER_MODIFY_TYPE = "DataSourceModifySource.MESSAGE_HEADER_MODIFY_TYPE";

    /**
     * 自定义管道名称
     * 这里设置的名称是要和配置文件的消息发送端配置对应的
     * 因此修改application.yml 中stream的配置
     */
    String INPUT_PIPE_NAME = "datasourceInput";
    String OUT_PIPE_NAME = "datasourceOutPut";


    /**
     * 消息接收端
     *
     * @return
     */
    @Input(INPUT_PIPE_NAME)
    SubscribableChannel input();

    /**
     * 消息发送端
     *
     * @return
     */
    @Output(OUT_PIPE_NAME)
    MessageChannel output();
}
