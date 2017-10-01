package tcs.exa;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
*
*/


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(value="tcs.exa")
public class SpringmvcApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SpringmvcApplication.class, args);
        //upstreamjjj'hjhj
    }
        @Bean
        public ServletRegistrationBean camelServletRegistrationBean() {
            ServletRegistrationBean registration = new ServletRegistrationBean(new CamelHttpTransportServlet(), "/camel/*");
            registration.setName("CamelServlet");
            return registration;
            //default
            //testing theComite
        }
        
        
      
        
        
    }

