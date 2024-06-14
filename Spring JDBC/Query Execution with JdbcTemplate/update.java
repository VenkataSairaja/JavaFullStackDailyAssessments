public class EmployeeDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void updateEmployeeSalary(int id, double salary) {
        String sql = "UPDATE employees SET salary =? WHERE id =?";
        jdbcTemplate.update(sql, new Object[]{salary, id});
    }
}