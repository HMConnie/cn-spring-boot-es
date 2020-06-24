package cn.connie.es.config;

import cn.connie.es.constant.EsConstant;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class IndexNameConfig {

    private String indexName;

    @Getter
    public String getIndexName() {
        return EsConstant.ES_INDEX_AUDIT_PROJECT_ITEM_INFO + new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }
}
