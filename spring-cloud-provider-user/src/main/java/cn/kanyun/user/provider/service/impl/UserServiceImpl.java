package cn.kanyun.user.provider.service.impl;

import cn.kanyun.common.service.BaseServiceImpl;
import cn.kanyun.domain.User;
import cn.kanyun.dynamic.datasource.annotation.DynamicDataSource;
import cn.kanyun.user.provider.dao.UserMapper;
import cn.kanyun.user.provider.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Kanyun
 */
@Service
@DynamicDataSource(targetDataSourceSrc = "#header.domain")
public class UserServiceImpl extends BaseServiceImpl<Long, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> queryAll() {
        return super.queryAll();
    }
}
