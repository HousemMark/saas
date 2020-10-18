package com.unit.base.zk.confcenter.listener;

import com.unit.base.zk.client.IZkDataListener;

public interface DataListener extends IZkDataListener {
    void doDataChange(String dataPath, Object data);

    void doDataDelete(String dataPath);
}
