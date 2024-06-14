public class EmployeeDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void saveEmployee(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
    }

    public Employee findById(int id) {
        return sessionFactory.getCurrentSession().get(Employee.class, id);
    }

    public void updateEmployee(Employee employee) {
        sessionFactory