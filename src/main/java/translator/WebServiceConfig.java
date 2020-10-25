package translator;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
/*que hago aqui con wsdl20?*/
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
  @Bean
  public ServletRegistrationBean<HttpServletBean> messageDispatcherServlet(ApplicationContext applicationContext) {
    MessageDispatcherServlet servlet = new MessageDispatcherServlet();
    servlet.setApplicationContext(applicationContext);
    servlet.setTransformWsdlLocations(true);
    return new ServletRegistrationBean<>(servlet, "/ws/*");
  }

  @Bean(name = "translator")
  public SimpleWsdl11Definition defaultWsdl11Definition() {
    SimpleWsdl11Definition s = new SimpleWsdl11Definition();
    s.setWsdl(new ClassPathResource("schemas/xjc/translator.wsdl"));
    return s;
  }
}

/*Enlaces de interés**/
//  https://glenmazza.net/blog/entry/switch-soap11-to-soap12
// https://docs.spring.io/spring-ws/docs/current/reference/
// https://www.w3.org/TR/soap12/
// https://moodle.unizar.es/add/pluginfile.php/2739988/mod_resource/content/6/IW_T4.1_Big_Web_Services.pdf
// https://stackoverflow.com/questions/6467234/how-to-convert-a-wsdl-file-made-for-soap-1-1-to-support-soap-1-2



