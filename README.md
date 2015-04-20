#dubianmayou

---

this is the code for website [dubianmayou.com](http://dubianmayou.com:8080)

## how to run local ##

### sql configuration ###

first create sql statement in db
	
	CREATE TABLE `user` (
	  `USER_ID` varchar(45) NOT NULL,
	  `PASSWORD` varchar(45) NOT NULL,
	  PRIMARY KEY (`USER_ID`),
	  UNIQUE KEY `USER_ID_UNIQUE` (`USER_ID`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;


	CREATE TABLE `akbs` (
	  `NAME` varchar(45) NOT NULL,
	  `COUNT` int(11) NOT NULL,
	  `akbid` varchar(45) NOT NULL,
	  PRIMARY KEY (`akbid`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;

then configure your db to applicationContextDao.xml
	
	<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
          <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
          <property name="url" value="jdbc:mysql://localhost:3306/world"/>
          <property name="username" value="root"/>
          <property name="password" value="123456"/>
    </bean>

to your own config

then you can run with tomcat in eclipse or intellij
