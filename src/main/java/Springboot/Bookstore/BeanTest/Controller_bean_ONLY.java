package Springboot.Bookstore.BeanTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/api/bookstore")
public class Controller_bean_ONLY {

    // importing services from service name= applicationContext

    @Autowired
    public ApplicationContext applicationContext ;

    @GetMapping("/beans")
    @ResponseBody
    public List<String[]> print_all_beans_and_count(){
        List<String[]> list1 = new ArrayList<String[]>();

        String[] s1 = applicationContext.getBeanDefinitionNames();
        String[] s2 = new String[2];
                s2[0] = applicationContext.getBeanDefinitionCount() + " ";
        list1.add(s1);
        list1.add(s2);
        return list1;
    }

    /*
                    FOR BELOW METHOD:
                    Pass below Bean names manually using postman:
                        -   bean101
                        -   bean202
                        -   JDBC_bean_by_sumit
                        -   beanOfSumit_13_Apr_class_method101
     */
    @PostMapping("/beans")
    @ResponseBody
    public String print_provided_beans(@RequestParam(value = "bean_name") String bean_name){
        String a1  = applicationContext.getBean(bean_name).toString();
        return a1;
    }


}
