package Springboot.Bookstore.BeanTest;

import org.springframework.stereotype.Component;

//@Component(value = "") // by default bean name is "" taken from, TestBean
@Component(value = "bean101")
public class TestBean101 {

    @Override
    public String toString(){
        return "I am running ...this bean test-beanOfSumit_13_Apr_class_method101";
    }

}
