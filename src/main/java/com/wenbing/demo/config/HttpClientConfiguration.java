package com.wenbing.demo.config;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.IdleConnectionEvictor;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.concurrent.TimeUnit;

@Configuration
public class HttpClientConfiguration {

    @Value("${http.defaultMaxPerRoute}")
    private Integer defaultMaxPerRoute;
    @Value("${http.maxTotal}")
    private Integer maxTotal;
    @Value("${http.connectTimeout}")
    private Integer connectTimeout;
    @Value("${http.connectionRequestTimeout}")
    private Integer connectionRequestTimeout;
    @Value("${http.socketTimeout}")
    private Integer socketTimeout;


    @Bean
    public PoolingHttpClientConnectionManager poolingHttpClientConnectionManager(){
        PoolingHttpClientConnectionManager poolingHttpClientConnectionManager=new PoolingHttpClientConnectionManager();
        //单机最大并发数
        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(defaultMaxPerRoute);
        //最大连接数
        poolingHttpClientConnectionManager.setMaxTotal(maxTotal);

        return poolingHttpClientConnectionManager;
    }

    @Bean
    public IdleConnectionEvictor idleConnectionEvictor(){
        IdleConnectionEvictor idleConnectionEvictor = new IdleConnectionEvictor(poolingHttpClientConnectionManager(),60, TimeUnit.SECONDS);
        return idleConnectionEvictor;
    }

    @Bean
    @Scope("prototype")
    public CloseableHttpClient httpClient(){
        return HttpClients.custom().setConnectionManager(poolingHttpClientConnectionManager()).build();
    }

    @Bean
    public RequestConfig requestConfig() {
        return RequestConfig.custom().setConnectTimeout(connectTimeout)
                .setConnectionRequestTimeout(connectionRequestTimeout)
                .setSocketTimeout(socketTimeout).build();

    }

}
