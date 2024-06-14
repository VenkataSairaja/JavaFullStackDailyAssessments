Session session = sessionFactory.getCurrentSession();

User user = new User();
user.setUsername("johnDoe");
user.setPassword("password");

session.beginTransaction();
session.save(user);
session.getTransaction().commit();