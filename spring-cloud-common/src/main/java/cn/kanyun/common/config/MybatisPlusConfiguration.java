package cn.kanyun.common.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * MybatisPlus 配置
 *
 * @author KANYUN
 */
@EnableTransactionManagement
@Configuration
@MapperScan(value = {"cn.kanyun.*.dao"})
public class MybatisPlusConfiguration {

    /**
     * 默认的DataSource
     * 定义在DruidDataSourceConfig中
     */
    @Resource
    private DataSource defaultDataSource;

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }


}