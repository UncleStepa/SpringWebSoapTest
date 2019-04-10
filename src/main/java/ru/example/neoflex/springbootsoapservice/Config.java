package ru.example.neoflex.springbootsoapservice;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import ru.neoflex.xml.clientebm.ClientDataResEBM;
import ru.neoflex.xml.clientebm.ClientDataReqEBM;

@EnableWs
@Configuration
public class Config extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/service/*");
    }

    @Bean(name = "customersDetailsWsdl")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("CustomersDetailsPort");
        wsdl11Definition.setLocationUri("/service/customers-details");
        wsdl11Definition.setTargetNamespace("http://www.neoflex.ru/xml/customers");
        wsdl11Definition.setSchema(schema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema customersSchema() {
        return new SimpleXsdSchema(new ClassPathResource("Customers.xsd"));
    }
    
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setClassesToBeBound(ClientDataReqEBM.class, ClientDataResEBM.class);
        return jaxb2Marshaller;
    }

    @Bean(name = "urlEBM")
    public String getUrlEBM(){
        return "http://localhost:8088/mockClientsDetailsPortSoap11";
    }

}
