package cn.kanyun.base.provider.service.impl;

import cn.kanyun.base.provider.mapper.TenantMapper;
import cn.kanyun.base.provider.service.TenantService;
import cn.kanyun.common.service.BaseServiceImpl;
import cn.kanyun.domain.Tenant;
import cn.kanyun.dynamic.datasource.annotation.DynamicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Kanyun
 */
@Service
@DynamicDataSource(targetDataSourceSrc = "base")
public class TenantServiceImpl extends BaseServiceImpl<Long, Tenant> implements TenantService {

    @Autowired
    private TenantMapper tenantMapper;

    @Override
    public List<Tenant> queryAll() {
        return super.queryAll();
    }
}
