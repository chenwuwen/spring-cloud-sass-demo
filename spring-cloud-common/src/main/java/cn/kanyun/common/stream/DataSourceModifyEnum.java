package cn.kanyun.common.stream;

/**
 * 数据源更改类型,是新增/更改还是删除
 *
 * @author Kanyun
 */
public enum DataSourceModifyEnum {

    /**
     * 数据源删除类型
     */
    DELETE,

    /**
     * 数据源更改类型,包括新增和更改
     */
    UPDATE

}
