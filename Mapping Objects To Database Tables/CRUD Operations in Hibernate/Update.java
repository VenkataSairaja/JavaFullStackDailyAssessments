Session session = sessionFactory.getCurrentSession();

Integer userId = 1;
User user = session.get(User.class, userId);

if (user!= null) {
    user.setUsername("janeDoe");
    session.beginTransaction();
    session.update(user);
    session.getTransaction().commit();
}