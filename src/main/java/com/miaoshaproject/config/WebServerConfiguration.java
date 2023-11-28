package com.miaoshaproject.config;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

//当spring容器没有tomcatEmbeddedServletContainerFactory这个bean时，会把bean加载进spring容器中
@Component
public class WebServerConfiguration implements WebServerFactoryCustomizer {
    @Override
    public void customize(WebServerFactory factory) {
        //使用对应工厂类提供的接口定制化tomcat connector
        ((TomcatServletWebServerFactory)factory).addConnectorCustomizers(new TomcatConnectorCustomizer() {
            @Override
            public void customize(Connector connector) {
                Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();

                //定制化keepalivetimeout,30秒内没有请求自动断开
                protocol.setKeepAliveTimeout(30000);
                //当客户端发送超过10000个请求则自动断开keepalive连接
                protocol.setMaxKeepAliveRequests(1000);



            }
        });
    }
}
