//byType: In this mode, Spring autowires a bean by matching the type of the bean in the configuration file with the type of the variable in the class
public class Employee {
    private Department department;
    // getters and setters
}

<bean id="employee" class="Employee">
    <property name="department" autowire="byType"/>
</bean>

<bean id="department" class="Department"/>

//byName: In this mode, Spring autowires a bean by matching the name of the bean in the configuration file with the name of the variable in the class.
public class Employee {
    private Department myDepartment;
    // getters and setters
}

<bean id="myDepartment" class="Department"/>

<bean id="employee" class="Employee" autowire="byName"/>

//constructor: In this mode, Spring autowires a bean by matching the constructor arguments of the class with the beans in the configuration file.
public class Employee {
    private Department department;
    public Employee(Department department) {
        this.department = department;
    }
}

<bean id="employee" class="Employee" autowire="constructor">
    <constructor-arg ref="department"/>
</bean>

<bean id="department" class="Department"/>

//autodetect: In this mode, Spring autowires a bean by detecting the type of the bean in the configuration file and matching it with the type of the variable in the class. If there's a constructor with a single argument, it will use constructor injection; otherwise, it will use setter injection.
public class Employee {
    private Department department;
    public Employee(Department department) {
        this.department = department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
}

<bean id="employee" class="Employee" autowire="autodetect">
    <!-- no explicit configuration needed -->
</bean>

<bean id="department" class="Department"/>

//no: In this mode, Spring does not perform autowiring and requires explicit configuration for dependencies.