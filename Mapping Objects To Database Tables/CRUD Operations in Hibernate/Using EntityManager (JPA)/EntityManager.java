EntityManager entityManager = entityManagerFactory.createEntityManager();

// Create
User user = new User();
user.setUsername("johnDoe");
user.setPassword("password");
entityManager.getTransaction().begin();
entityManager.persist(user);
entityManager.getTransaction().commit();

// Read
Integer userId = 1;
User user = entityManager.find(User.class, userId);

// Update
user.setUsername("janeDoe");
entityManager.getTransaction().begin();
entityManager.merge(user);
entityManager.getTransaction().commit();

// Delete
user = entityManager.find(User.class, userId);
entityManager.getTransaction().begin();
entityManager.remove(user);
entityManager.getTransaction().commit();