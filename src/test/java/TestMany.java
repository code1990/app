import org.apache.zookeeper.*;

/**
 * zkClient伪分布式连接实例
 */
public class TestMany {
    public static void main(String[] args) throws Exception {
        ZooKeeper zk = new ZooKeeper("127.0.0.1:2181",30000,new TestWatacher());
    }


}
