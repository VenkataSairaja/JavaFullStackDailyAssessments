//@Autowired: This annotation is used to mark a constructor, setter, or field as a candidate for autowiring.
public class Employee {
    @Autowired
    private Department department;
    // getters and setters
}

//@Qualifier: This annotation is used to resolve autowiring conflicts by specifying the name of the bean to autowire.
public class Employee {
    @Autowired
    @Qualifier("hrDepartment")
    private Department department;
    // getters and setters
}

<bean id="hrDepartment" class="Department"/>
<bean id="financeDepartment" class="Department"/>

//@Resource: This annotation is used to autowire a dependency by name.
public class Employee {
    @Resource(name="myDepartment")
    private Department department;
    // getters and setters
}

<bean id="myDepartment" class="Department"/>

//