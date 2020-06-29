package cn.connie.es.config;

import cn.connie.es.entity.BasicEsTO;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class IndexAspect {

    private static String indexName; //动态修改索引名


    /**
     * 获取动态修改后的索引名
     */
    public static String getIndexName() {
        return indexName;
    }


    @Pointcut("execution(public * cn.connie.es.service.EsServicesImpl.*(..)))")
    public void indexAspect() {

    }

    private BasicEsTO getBasicEsTO(Object[] args) {
        BasicEsTO basicEsTO = null;
        if (args.length > 0) {
            for (Object arg : args) {
                if (arg instanceof BasicEsTO) {
                    basicEsTO = (BasicEsTO) arg;
                    break;
                }
            }
        }
        return basicEsTO;
    }


    @Autowired
    ElasticsearchRestTemplate elasticsearchTemplate;

    @Around("indexAspect()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        BasicEsTO basicEsTO = getBasicEsTO(pjp.getArgs());
        if (basicEsTO != null) {
            if (StringUtils.isEmpty(basicEsTO.getIndexName())) {
                throw new RuntimeException("索引名不能为空!");
            }
            //必须判断索引是否存在，否则会报索引不存在错误
            if (!basicEsTO.getIndexName().contains("*") && !elasticsearchTemplate.indexExists(basicEsTO.getIndexName())) {
                elasticsearchTemplate.createIndex(basicEsTO.getIndexName());
            }
            IndexAspect.indexName = basicEsTO.getIndexName();
        }
        return pjp.proceed(); // 此处必须加入返回值，否则所有方法都返回的null
    }
}
