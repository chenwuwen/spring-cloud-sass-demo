package cn.kanyun.consul;

/**
 * @author Kanyun
 */
public class NodeServiceInterfaceFallback implements NodeServiceInterface{
    @Override
    public String searchUsers() {
        return "NODE-SERVICE服务的 /search/users/ 接口出问题了";
    }
}
