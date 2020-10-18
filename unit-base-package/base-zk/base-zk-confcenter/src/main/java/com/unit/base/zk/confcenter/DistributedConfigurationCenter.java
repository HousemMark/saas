package com.unit.base.zk.confcenter;

import com.unit.base.zk.client.IZkDataListener;
import com.unit.base.zk.client.ZkClient;
import com.unit.base.zk.client.serialize.ZkSerializer;
import org.apache.zookeeper.ZooDefs;

public class DistributedConfigurationCenter implements ConfigurationCenter {

    protected ZkClient _zk;

    public DistributedConfigurationCenter() {
        this("127.0.0.1:2181", 3000);
    }

    public DistributedConfigurationCenter(String zkServers, int zkClientTimeout) {
        _zk = new ZkClient(zkServers, zkClientTimeout);
    }

    public DistributedConfigurationCenter(String zkServers, int zkClientTimeout, ZkSerializer serializer) {
        _zk = new ZkClient(zkServers, zkClientTimeout, serializer);
    }

    @Override
    public void setupConfValue(String path, Object value) {
        if (!_zk.isConnected()) {
            _zk.waitUntilConnected();
        }
        if (!_zk.exists(path)) {
            _zk.createPersistent(path, true, ZooDefs.Ids.OPEN_ACL_UNSAFE);
        }
        _zk.writeData(path, value);
    }

    @Override
    public <T> T getConfValue(String path) {
        if (!_zk.isConnected()) {
            _zk.waitUntilConnected();
        }
        return _zk.readData(path, true);
    }

    @Override
    public <T> T getConfValue(String path, IZkDataListener listener) {
        if (!_zk.isConnected()) {
            _zk.waitUntilConnected();
        }
        T res = _zk.readData(path, true);
        _zk.subscribeDataChanges(path, listener);
        return res;
    }

    @Override
    public Boolean exists(String path) {
        boolean exists = _zk.exists(path);
        return exists;
    }

    @Override
    public void setNodeData(String path, Object value) {
        if (!_zk.isConnected()) {
            _zk.waitUntilConnected();
        }
        _zk.writeData(path, value);
    }

    @Override
    public ZkClient getZkClient() {
        return _zk;
    }
}
