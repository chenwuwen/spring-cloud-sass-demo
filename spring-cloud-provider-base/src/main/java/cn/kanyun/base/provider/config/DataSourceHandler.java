package cn.kanyun.base.provider.config;

import cn.kanyun.common.util.YmlUtils;
import cn.kanyun.dynamic.datasource.DynamicRoutingDataSource;
import cn.kanyun.dynamic.datasource.provider.AbstractJdbcDataSourceProvider;
import cn.kanyun.dynamic.datasource.springboot.autoconfigure.DataSourceProperty;
import cn.kanyun.dynamic.datasource.springboot.autoconfigure.DynamicDataSourceProperties;
import com.alibaba.druid.pool.DruidDataSource;
import com.sun.tools.javac.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * 初始化数据源 通过继承AbstractJdbcDataSourceProvider类
 * 从数据库中读取数据源
 * 使用@Profile注解 表示 当运行环境为 prod / uat /stage 环境下 才注册该bean
 * 这么写是因为 在开发环境下,主要是针对业务进行编码,基本不涉及到数据源切换,所以可以简化代码
 * 当然具体还是需要考虑现实情况
 *
 * @author Kanyun
 */
//@Profile({"prod","uat","stage"})
@Slf4j
@Configuration
@ConditionalOnProperty(prefix = DynamicDataSourceProperties.PREFIX, name = "enabled", havingValue = "true", matchIfMissing = true)
public class DataSourceHandler extends AbstractJdbcDataSourceProvider {

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.name}")
    private String name;
////    @Value("#{'${spring.datasource.schema}'.split(',')}")
//    @Value("${spring.datasource.schema}")
//    private String schema;
////    @Value("#{'${spring.datasource.data}'.split(',')}")
//    @Value("${spring.datasource.data}")
//    private String data;

    /**
     * 数据源来源数据库属性
     */
    private static String srcDriverClassName;
    private static String srcUrl;
    private static String srcUsername;
    private static String srcPassword;


    static {
//        读取配置文件初始化属性值
        Map<String, String> prop = YmlUtils.getYmlByFileName(YmlUtils.application_file);
        srcDriverClassName = prop.get("jdbc.datasource.src.driverClassName");
        srcUrl = prop.get("jdbc.datasource.src.url");
        srcUsername = prop.get("jdbc.datasource.src.username");
        srcPassword = prop.get("jdbc.datasource.src.password");
    }

    public DataSourceHandler() {
        this(srcDriverClassName, srcUrl, srcUsername, srcPassword);
    }


    public DataSourceHandler(String driverClassName, String url, String username, String password) {
        super(driverClassName, url, username, password);
    }

    /**
     * 在保存数据源的数据库中执行SQL,返回所有的数据源
     * 返回为key-value形式
     * 因为后期在切换数据源时,是以key来切换的
     *
     * @param statement
     * @return
     * @throws SQLException
     */
    @Override
    protected Map<String, DataSourceProperty> executeStmt(Statement statement) throws SQLException {
        Map<String, DataSourceProperty> dataSourcePropertyMap = new HashMap<>();
        String sql = "select * from TENANT;";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            DataSourceProperty dataSourceProperty = new DataSourceProperty();
//            设置datasource的属性,至于设置为什么值,需要根据resultSet的返回值做决定
//            getXXX()方法中的参数不区分大小写
            dataSourceProperty.setUrl(resultSet.getString("db_url"));
            dataSourceProperty.setUsername(resultSet.getString("db_user"));
            dataSourceProperty.setPassword(resultSet.getString("db_pass"));
            dataSourceProperty.setDriverClassName("com.mysql.jdbc.Driver");

            dataSourcePropertyMap.put(resultSet.getString("domain"), dataSourceProperty);
        }
        dataSourcePropertyMap.put("base", innerDataSource());
//        此处的Statement不用关闭,在抽象类中的loadDataSources()方法中已经关闭了
//        statement.close();
        return dataSourcePropertyMap;
    }


    public DataSourceProperty innerDataSource() {
        DataSourceProperty dataSourceProperty = new DataSourceProperty();
        dataSourceProperty.setUrl(url);
        dataSourceProperty.setUsername(username);
        dataSourceProperty.setPassword(password);
        dataSourceProperty.setDriverClassName(driverClassName);
        dataSourceProperty.setSchema(List.of("classpath:schema.sql"));
        dataSourceProperty.setData(List.of("classpath:data.sql"));
        return dataSourceProperty;
    }

}
