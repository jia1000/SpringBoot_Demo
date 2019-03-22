# SpringBoot_Demo
记录Spring Boot的学习过程。

目前，按照《Spring Boot2 精髓 从构建小系统到架构分布式大系统》书中所讲，逐步学习Spring Boot。

### 学习历程：

####  首先建立一个Hello World的示例程序
* 测试地址为：http://127.0.0.1:8080/hello
####  添加了热部署功能。（功能没成功）
* 依赖库：spring-boot-devtools
####  添加了AOP面向切面编程示例。
* 依赖库：spring-boot-starter-aop
* 关键词：@Configuration、 @Aspect、 @Around、 "@within。
####  添加了Controller的使用。
* 关键词：@RequestMapping、 @ResponseBody、 @PathVariable。
* 测试地址：
    http://127.0.0.1:8080/talk
    http://127.0.0.1:8080/user/1000
#### 添加ModelAttribute的使用：
* 关键词：@ModelAttribute、 Model
* 测试地址：http://127.0.0.1:8080/1000/get.json

