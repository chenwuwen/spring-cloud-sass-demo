package cn.kanyun.base.provider.controller;

import cn.kanyun.base.provider.config.DataSourceModifyPoster;
import cn.kanyun.base.provider.service.TenantService;
import cn.kanyun.domain.Tenant;
import com.google.common.eventbus.EventBus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Kanyun
 */
@RestController
@RequestMapping("/base/tenant")
public class TenantController {

    @Resource
    private TenantService tenantService;
    @Resource
    private DataSourceModifyPoster dataSourceModifyPoster;
    @Resource
    private EventBus eventBus;

    /**
     * 获取所有的租户
     *
     * @return
     */
    @GetMapping("/getTenantList")
    public List<Tenant> getTenantList() {
        return tenantService.queryAll();
    }

    /**
     * 更改或新增或删除(假删除)Tenant
     *
     * @return
     */
    @PostMapping("/modifyTenant")
    public int modifyTenant(@RequestBody Tenant tenant) {
        eventBus.register(dataSourceModifyPoster);
        eventBus.post(tenant);
        return tenant.getId() != null ? tenantService.update(tenant) : tenantService.insert(tenant);
    }



}
