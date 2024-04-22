
## Project used to test beans:
    SpringBoot\Bookstore-Java-Rest-API-Sprinboot\src\main\java\Springboot\Bookstore\BeanTest

## The project files are as below:


    SpringBoot\Bookstore-Java-Rest-API-Sprinboot\src\main\java\Springboot\Bookstore\BeanTest

## Run project and go to:
    http://localhost:8080/api/bookstore/beans

## Sample code:

```
@RESTController
@RequestMapping("/api/bookstore")  
class TestingBeans{

    @Autowired
    public ApplicationContext applicationContext ;
    
    @GETMapping("/beans"
    public getAllBeans(){
        //  this prints gets all acrtive managed beans by spring
        applicationContext.getBeansDefinitions();
        
        //  this prints count INT of total acrtive managed beans by spring
        applicationContext.getBeansCount();
    }

}
```

To 