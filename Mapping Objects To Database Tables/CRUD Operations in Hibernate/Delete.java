Session session = sessionFactory.getCurrentSession();

Integer userId = 1;
User user = session.get(User.class, userId);

if (user!= null) {
    session.beginTransaction();
    session.delete(user);
    session.getTransaction().commit();
}