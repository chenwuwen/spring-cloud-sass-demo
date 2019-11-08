package cn.kanyun.common.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * @author Kanyun
 */
public class BaseServiceImpl <K extends Serializable,T extends Serializable> implements BaseService<K,T>{
    @Resource
    private BaseMapper<T> baseMapper;

    @Override
    public List<T> queryAll() {
        return baseMapper.selectList(null);
    }

    @Override
    public IPage<T> queryPage(IPage page, Serializable t) {
//        之前的EntityWrapper被改成了其他的，比如你查询的时候，就是QueryWrapper
        Wrapper queryWrapper = new QueryWrapper<T>().lambda();
        IPage<T> result = baseMapper.selectPage(page, queryWrapper);
        return result;
    }

    @Override
    public T queryById(K id) {
        return baseMapper.selectById(id);
    }

    @Override
    public int insert(T t) {
        return baseMapper.insert(t);
    }


    @Override
    public int remove(K k) {
        return baseMapper.deleteById(k);
    }

    @Override
    public int update(T t) {
        return baseMapper.updateById(t);
    }
}
