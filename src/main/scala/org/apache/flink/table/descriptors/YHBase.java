package org.apache.flink.table.descriptors;

import org.apache.flink.annotation.PublicEvolving;
import org.apache.flink.configuration.MemorySize;

import java.util.Map;

import static org.apache.flink.table.descriptors.YHBaseValidator.CONNECTOR_TYPE_VALUE_HBASE;

/**
 * Created by yuchunfan on 2020/4/29.
 */
@PublicEvolving
public class YHBase extends ConnectorDescriptor {
    private DescriptorProperties properties = new DescriptorProperties();

    public YHBase() {
        super(CONNECTOR_TYPE_VALUE_HBASE, 1, false);
    }

    public YHBase tableName(String tableName) {
        this.properties.putString("connector.table-name", tableName);
        return this;
    }

    public YHBase zookeeperQuorum(String zookeeperQuorum) {
        this.properties.putString("connector.zookeeper.quorum", zookeeperQuorum);
        return this;
    }

    public YHBase zookeeperNodeParent(String zookeeperNodeParent) {
        this.properties.putString("connector.zookeeper.znode.parent", zookeeperNodeParent);
        return this;
    }

    public YHBase writeBufferFlushMaxSize(String maxSize) {
        this.properties.putMemorySize("connector.write.buffer-flush.max-size", MemorySize.parse(maxSize, MemorySize.MemoryUnit.BYTES));
        return this;
    }

    public YHBase writeBufferFlushMaxRows(int writeBufferFlushMaxRows) {
        this.properties.putInt("connector.write.buffer-flush.max-rows", writeBufferFlushMaxRows);
        return this;
    }

    public YHBase writeBufferFlushInterval(String interval) {
        this.properties.putString("connector.write.buffer-flush.interval", interval);
        return this;
    }

    protected Map<String, String> toConnectorProperties() {
        return this.properties.asMap();
    }
}
