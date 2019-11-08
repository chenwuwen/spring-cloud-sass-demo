package cn.kanyun.base.provider.controller;

import cn.kanyun.base.provider.service.TenantService;
import cn.kanyun.domain.Tenant;
import cn.kanyun.dynamic.datasource.springboot.autoconfigure.DataSourceProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kanyun
 */
@RestController
@RequestMapping("/base/datasource")
public class DataSourceController {

    @Resource
    private TenantService tenantService;

    /**
     * 获取所有数据源属性,提供给其他服务调用
     *
     * @return
     */
    @GetMapping("/getDataSourceProperty")
    public List<DataSourceProperty> getDataSourceProperty() {
        List<Tenant> tenants = tenantService.queryAll();
        List<DataSourceProperty> dataSourcePropertyList = new ArrayList<>(tenants.size());
        for (Tenant tenant : tenants) {
            DataSourceProperty dataSourceProperty = new DataSourceProperty();
            dataSourceProperty.setUrl(tenant.getDbUrl());
            dataSourceProperty.setUsername(tenant.getDbUser());
            dataSourceProperty.setPassword(tenant.getDbPass());
            dataSourceProperty.setDriverClassName("com.mysql.jdbc.Driver");
            dataSourceProperty.setPollName(tenant.getDomain());
            dataSourcePropertyList.add(dataSourceProperty);
        }
        return dataSourcePropertyList;
    }
}
