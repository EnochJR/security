# security
Spring Security 的一个小例子


## 简介
-----
    本例采用Spring Boot 搭建应用，主要引入了Spring Security 和Spring Data JPA.
    将用户信息的存储和权限信息交给JPA 存储到MySQL中，用Spring Security 进行网页的访问权限控制


## 版本
-----
  Spring boot--2.0.6
  
## 应用
------
1、在spring的配置文件 `src/main/resources/application.yml` 此文件下，将数据库的连接信息修改为自己可用的参数。\
2、往数据库中预先存储几条记录，注意。MySQL中存储的密码是加密之后的字符串，存储前可以在test中用`BCryptPasswordEncoder`加密后再存储
   本例没有提供注册功能\
3、运行`src/main/java/com/enchi/security/SecurityApplication.java`\
4、输入`http://localhost:8081`按提示进行操作
  
  
  
## 参考资料
---------
 * https://spring.io/guides/gs/securing-web/#run_the_app
  
 * 《Spring Boot2企业应用实战》疯狂软件著
