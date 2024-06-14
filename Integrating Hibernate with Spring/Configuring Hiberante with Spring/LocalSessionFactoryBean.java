public class EmployeeDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void saveEmployee(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
    }
}