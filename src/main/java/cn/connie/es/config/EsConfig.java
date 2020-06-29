package cn.connie.es.config;

import cn.connie.config.center.client.GlobalConfigration;
import cn.connie.config.center.client.properties.spring.AutoReloadPropertySourcesPlaceholderConfigurer;
import cn.connie.es.constant.EsConstant;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class EsConfig {

    public RestHighLevelClient getRestClient() {
//        String hostsString = GlobalConfigration.toString("es.host");
        String hostsString = "47.94.37.157:9200";
        String[] nodes = hostsString.split(",");
        List<HttpHost> httpHosts = new ArrayList<>();
        for (String node : nodes) {
            try {
                String[] parts = StringUtils.split(node, ":");
                Assert.notNull(parts, "Must defined");
                Assert.state(parts.length == 2, "Must be defined as 'host:port'");
                httpHosts.add(new HttpHost(parts[0], Integer.parseInt(parts[1]), "http"));
            } catch (RuntimeException ex) {
                throw new IllegalStateException("Invalid ES nodes " + "property '" + node + "'", ex);
            }
        }
        return EsClientBuilder.build(httpHosts)
                .setConnectionRequestTimeoutMillis(10000)
                .setConnectTimeoutMillis(10000)
                .setSocketTimeoutMillis(30000)
                .setMaxConnectTotal(100)
                .setMaxConnectPerRoute(20)
                .create();

    }

//    @Bean(name = "propertyConfigurer",initMethod ="init",destroyMethod = "destory")
//    public AutoReloadPropertySourcesPlaceholderConfigurer  propertyConfigurer() throws IOException {
//        AutoReloadPropertySourcesPlaceholderConfigurer configurer = new AutoReloadPropertySourcesPlaceholderConfigurer();
//        configurer.setApplication("test");
//        configurer.setPropertiesName("test");
//        return configurer;
//    }

    @Bean("elasticsearchTemplate")
    public ElasticsearchRestTemplate getElasticsearchRestTemplate() {
        return new ElasticsearchRestTemplate(getRestClient());
    }
}
