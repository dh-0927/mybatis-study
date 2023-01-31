开发第一个MyBatis程序

1. resources目录：
    放在这个目录当中的，一般是资源文件，配置文件
    直接放到resources目录下的资源，等同于放到了
    类的根路径下

2. 开发步骤
* 第一步：打包方式：jar
* 第二步：引入依赖：
    - mybatis依赖
    - mysql驱动依赖
* 第三步：编写mybatis核心配置文件，mybatis-config.xml
* 第四步：编写XxxxMapper.xml文件
    在这个配置文件中编写SQL语句。
* 第五步：在mybatis-config.xml文件中指定XxxMapper.xml文件的路径
    <mapper resource="CarMapper.xml"/>
    注意：resource属性会自动从类的根路径下开始查找资源

* 第六步：编写mybatis程序。（使用mybatis的类库，编写mybatis程序，连接数据库，做增删改查就行了。）
    在MyBatis当中，负责执行SQL语句的那个对象叫做什么？
        SqlSession
    SqlSession是专门用来执行SQL语句的，是一个Java程序和数据库之间的一次会话

3. 从 XML 中构建 SqlSessionFactory

4. mybatis中有两个主要的配置文件
    其中一个是：mybatis-config.xml，这是一个核心配置文件，主要配置连接数据库的信息等。（一个）
    另一个是：XxxxMapper.xml，这个是专门用来编写SQL语句的配置文件（一个表一个）
        t_user表：一般会对应一个UserMapper.xml
        t_student表：一般会对应一个StudentMapper.xml
