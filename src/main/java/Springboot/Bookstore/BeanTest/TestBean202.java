package Springboot.Bookstore.BeanTest;

import org.springframework.stereotype.Component;

//@Component(value = "") // by default bean name is "" taken from, TestBean
@Component(value = "bean202")
public class TestBean202 {

    @Override
    public String toString(){
        return "This is 2nd bean test with class name =TestBean202 ........ Component bean value=bean202 ";
    }

}
