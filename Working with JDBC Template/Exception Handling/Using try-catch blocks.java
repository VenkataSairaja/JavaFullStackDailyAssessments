public class EmployeeDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM employees WHERE id =?";
        Employee employee = null;
        try {
            employee = jdbcTemplate.queryForObject(sql, new Object[]{id}, new EmployeeRowMapper());
        } catch (DataAccessException e) {
            // Handle exception
            log.error("Error fetching employee: " + e.getMessage());
        }
        return employee;
    }
}