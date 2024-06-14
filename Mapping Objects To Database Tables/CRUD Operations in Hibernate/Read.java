Session session = sessionFactory.getCurrentSession();

Integer userId = 1;
User user = session.get(User.class, userId);

if (user!= null) {
    System.out.println("Username: " + user.getUsername());
    System.out.println("Password: " + user.getPassword());
}