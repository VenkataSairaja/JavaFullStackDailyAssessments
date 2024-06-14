@Entity
@Table(name = "users")
public class User {
    //...

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Address> addresses;

    //...
}

@Entity
@Table(name = "roles")
public class Role {
    //...
}

@Entity
@Table(name = "addresses")
public class Address {
    //...

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //...
}