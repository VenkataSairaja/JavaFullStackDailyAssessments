public class EmployeeDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM employees WHERE id =?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new EmployeeRowMapper());
    }
}

class EmployeeRowMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setId(rs.getInt("id"));
        employee.setName(rs.getString("name"));
        employee.setSalary(rs.getDouble("salary"));
        return employee;
    }
}