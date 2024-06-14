//Define a class Manager in the package com.example.company. Attempt to create an object of this class from a different package and observe the compilation result.
package com.example.company;

public class Manager {
    private String name;

    public Manager(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Attempting to create an object of Manager class from a different package
package com.example.test;

import com.example.company.Manager;

public class Test {
    public static void main(String[] args) {
        // Compilation error: Manager class is not public
        // Manager manager = new Manager("John Doe");
    }
}