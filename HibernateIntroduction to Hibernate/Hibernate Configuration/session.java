SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
Session session = sessionFactory.getCurrentSession();