package cn.connie.es.entity;

import cn.connie.config.center.common.base.BasicTO;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

public class BasicEsTO extends BasicTO {

    @Field(type = FieldType.Text)
    private String indexName;

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }
}
