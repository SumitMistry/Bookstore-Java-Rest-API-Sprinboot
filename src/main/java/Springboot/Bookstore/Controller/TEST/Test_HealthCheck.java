package Springboot.Bookstore.Controller.TEST;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/api/bookstore")
public class Test_HealthCheck {


        @Value("${HealthCheckMessage}")
        private String HealthCheckMessage;
        @GetMapping(value = "/health")
        @ResponseStatus(HttpStatus.OK)
        @ResponseBody
        public String healthCheck(){
            return HealthCheckMessage;
        }


}
