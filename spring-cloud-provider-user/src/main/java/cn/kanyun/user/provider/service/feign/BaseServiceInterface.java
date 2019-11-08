package cn.kanyun.user.provider.service.feign;

import cn.kanyun.common.config.FeignHeaderConfiguration;
import cn.kanyun.dynamic.datasource.springboot.autoconfigure.DataSourceProperty;
import cn.kanyun.user.provider.service.feign.fallback.BaseServiceInterfaceFallBack;
import cn.kanyun.user.provider.service.feign.fallback.BaseServiceInterfaceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Kanyun
 * @FeignClient注解中的value的值是： provide 注册在 consul 中的服务名
 * RequestMapping 对应 provider 的具体映射
 * @FeignClient 注解必须应用在接口上，否则抛出异常 ->"@FeignClient can only be specified on an interface"
 * 当服务调用出错是会调用fallback指定类中的特定的方法,但是却无法显示错误信息
 * 如果需要显示错误信息,需要指定fallbackFactory
 * 需要注意的是fallback和fallbackFactory只能指定一个，如果2个都指定了，生效的是fallback
 * @FeignClient标注用于声明Feign客户端可访问的Web服务
 */
@FeignClient(value = "base-provider", fallback = BaseServiceInterfaceFallBack.class, fallbackFactory = BaseServiceInterfaceFallbackFactory.class, configuration = {FeignHeaderConfiguration.class})
public interface BaseServiceInterface {

    /**
     * 测试 Feign
     * 此注解中值与服务提供者的方法的Uri的值 一致
     * 即通过上面类的FeignClient 注解,知道了调用哪个服务,而这个方法
     * 则是调用服务里的哪个方法,需要调哪个方法,就去服务模块找对应的路径
     * 并写入到注解中去
     * <p>
     * 如果Feign访问的远程方法,是Get请求且接收query参数[即：xx.xx?bb=1&cc=2]
     * 那么需要Feign声明的接口的方法中添加@RequestParam注解,否则会报错：FeignException$MethodNotAllowed: status 405 reading
     * 需要注意的是,调用Feign定义的方法的方法和Feign实际远程访问的方法,则不必添加@RequestParam,但必须保证
     * key (参数名称)的一致性,所以全都加上@RequestParam注解,可以减少出错几率
     *
     * @return
     */
    @GetMapping("/base/hello/hello")
    String remoteHello(@RequestParam("message") String message);


    /**
     * 从 base-provider 微服务取到所有数据源属性
     * @return
     */
    @GetMapping("/base/datasource/getDataSourceProperty")
    List<DataSourceProperty> getDataSourceProperty();


}
