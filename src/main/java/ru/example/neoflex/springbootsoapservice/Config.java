package ru.example.neoflex.springbootsoapservice;

import org.springframework.beans.factory.annotation.Value;
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
import ru.neoflex.xml.clientebm.ClientDataReqEBM;
import ru.neoflex.xml.clientebm.ClientDataResEBM;
import ru.neoflex.xml.customers.CustomerRequest;
import ru.neoflex.xml.customers.CustomerResponse;

import javax.xml.bind.Marshaller;
import java.util.TreeMap;

@EnableWs
@Configuration
public class Config extends WsConfigurerAdapter {

    @Value("${endpointBS}")
    private String endpointBS;

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/service/*");
    }

    @Bean(name = "customersDetailsWsdl")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("CustomersDetailsPort");
        wsdl11Definition.setLocationUri("/service/customers-details");
        wsdl11Definition.setTargetNamespace("http://www.neoflex.ru");
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
        jaxb2Marshaller.setMarshallerProperties(new TreeMap<String, Object>() {
            {
                put(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                put(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
                put("com.sun.xml.internal.bind.xmlHeaders", "<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            }
        });
        jaxb2Marshaller.setClassesToBeBound(ClientDataReqEBM.class, ClientDataResEBM.class, CustomerRequest.class, CustomerResponse.class);
        return jaxb2Marshaller;
    }

    @Bean(name = "endpointBS")
    public String getEndpointBS() {
        System.out.print("getEndpointBS ");
        System.out.println(endpointBS);
        return endpointBS;
    }

}
