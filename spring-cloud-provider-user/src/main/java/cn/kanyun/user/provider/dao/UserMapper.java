package cn.kanyun.user.provider.dao;

import cn.kanyun.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Kanyun
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
