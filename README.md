# hibernate-redis


同时包含jpa, hibernate, 但是如果不能同时运行起来，只能分开运行
如果要运行jpa 的，需要将所有关于hibernate 的注释掉。
1. 注释UserService 中的HibernateUserDao 
2. 将UserServiceTestHibernate 类注释

如果要运行hibernate的,注释jpa 相关信息。
1.注释UserService 中的UserDao 
2.将UserServiceTest 类注释