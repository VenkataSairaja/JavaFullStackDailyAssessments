//SELECT query
Query<User> query = session.createQuery("FROM User u WHERE u.name = :name", User.class);
query.setParameter("name", "John Doe");
List<User> users = query.list();

//UPDATE query
Query<User> query = session.createQuery("UPDATE User u SET u.email = :email WHERE u.name = :name", User.class);
query.setParameter("email", "johndoe@example.com");
query.setParameter("name", "John Doe");
int updatedCount = query.executeUpdate();

//DELETE query
Query<User> query = session.createQuery("DELETE FROM User u WHERE u.name = :name", User.class);
query.setParameter("name", "John Doe");
int deletedCount = query.executeUpdate();

//Parameterized queries
Query<User> query = session.createQuery("FROM User u WHERE u.name = :name", User.class);
query.setParameter("name", "John Doe");
List<User> users = query.list();



