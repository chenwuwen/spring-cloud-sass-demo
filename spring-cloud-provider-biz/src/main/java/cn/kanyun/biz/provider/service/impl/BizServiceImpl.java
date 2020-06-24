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
 * Annotation类型里面的参数设定注意:
 * 第一:只能用public或默认(default)这两个访问权修饰.例如,String value();
 * 第二:参数成员只能用基本类型byte,short,char,int,long,float,double,boolean八种基本数据类型和 String,Enum,Class,annotations等数据类型,以及这一些类型的数组
 * 第三,如果只有一个参数成员,最好把参数名称设为”value”,后加小括号
 * @author Kanyun
 */
@DynamicDataSource("#header.domain")
@Service
public class BizServiceImpl extends BaseServiceImpl<Long, Business> implements BizService   {
    @Resource
    private BizMapper bizMapper;

    @Override
    public List<Business> queryAll() {
        return super.queryAll();
    }
}
