package cn.kanyun.user.provider.config;

import cn.kanyun.domain.Tenant;
import cn.kanyun.dynamic.datasource.DynamicDataSourceCreator;
import cn.kanyun.dynamic.datasource.provider.AbstractCustomizeDataSourceProvider;
import cn.kanyun.dynamic.datasource.springboot.autoconfigure.DataSourceProperty;
import cn.kanyun.dynamic.datasource.springboot.autoconfigure.DynamicDataSourceProperties;
import cn.kanyun.user.provider.service.feign.BaseServiceInterface;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 初始化数据源
 * 从base-provide同过Feign获取数据源
 * 通过定义@Profile 可以在开发环境下 单数据源进行开发
 *
 * @author Kanyun
 */
@Component
//@Profile({"prod","uat","stage"})
@ConditionalOnProperty(prefix = DynamicDataSourceProperties.PREFIX, name = "enabled", havingValue = "true", matchIfMissing = true)
public class DataSourceHandler extends AbstractCustomizeDataSourceProvider {

    @Resource
    private BaseServiceInterface baseServiceInterface;

    /**
     * 注入动态数据源创建器 [在动态数据源依赖中]
     */
    @Resource
    private DynamicDataSourceCreator dataSourceCreator;

    @Override
    public Map<String, DataSource> getDataSourceMap() {
//        从base微服务中取到所有租户并组装数据源,所以启动该微服务前需要先启动base微服务
        List<DataSourceProperty> dataSourcePropertyList = baseServiceInterface.getDataSourceProperty();
        Map<String, DataSource> dataSourceMap = new HashMap<>(dataSourcePropertyList.size());
//        实例化动态数据源创建器[在动态数据源依赖中]
//        DynamicDataSourceCreator dataSourceCreator = new DynamicDataSourceCreator();
        for (DataSourceProperty dataSourceProperty : dataSourcePropertyList) {
//            创建数据源,此处虽然没有设置使用哪种数据库连接池,但是createDataSource()方法会根据项目中存在哪种数据库连接池依赖来选择
//            ,存在多种数据库连接池依赖默认选择使用Druid(如果存在),如果不存在任何数据库连接池依赖,该方法会创建一个基础的数据库连接池来使用
            DataSource dataSource = dataSourceCreator.createDataSource(dataSourceProperty);
            dataSourceMap.put(dataSourceProperty.getPollName(), dataSource);
        }
        return dataSourceMap;
    }


}
