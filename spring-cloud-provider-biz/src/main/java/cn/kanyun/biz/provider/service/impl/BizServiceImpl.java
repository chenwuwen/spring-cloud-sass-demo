package cn.kanyun.biz.provider.service.impl;

import cn.kanyun.common.service.BaseServiceImpl;
import cn.kanyun.biz.provider.dao.BizMapper;
import cn.kanyun.biz.provider.service.BizService;
import cn.kanyun.domain.Business;
import cn.kanyun.dynamic.datasource.annotation.DynamicDataSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Kanyun
 */
@DynamicDataSource(targetDataSourceSrc = "#header.domain")
@Service
public class BizServiceImpl extends BaseServiceImpl<Long, Business> implements BizService   {
    @Resource
    private BizMapper bizMapper;

    @Override
    public List<Business> queryAll() {
        return super.queryAll();
    }
}
