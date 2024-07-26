A home for Xavier lovers.
# 项目架构
目前是按论坛做的。代码由`common`、`controller`、`entity`、`mapper`、`service`这几个部分组成。我也才刚刚开始学springboot，有什么不对或者不准确的地方还请大家批评指正。

用到的是springboot+MyBatis

## 代码部分

src/main/java/com.wululu.wululu/下

### common

存放通用类，如现有的`Result`。

*`Result`是一个统一的封装类，用于封装API的响应数据，使得前端可以统一处理各种响应。通常包含状态码、消息和数据三个属性。*——from kimi

已完成关于最简单的成功和失败的响应。后续其他代码可以直接调用该响应，大家也可以继续完善这个文件。

示例：

```java
//controller/userController.java中的添加用户
import com.wululu.wululu.common.Result;

@RestController
@RequestMapping("/user")
public class userController {
    @Resource
    private userService userService;

    @PostMapping("/insert")
    public Result add(@RequestBody User user) {
        /*添加用户*/
        userService.insert(user);
        return Result.success("插入成功！");
    }
}
```



### controller

*负责处理HTTP请求和返回HTTP响应。*——from kimi

`adminController`是管理员的`controller`文件，管理员用户的增删改查部分在这里完成。只完成了插入操作。

`userController`是普通用户的`controller`文件，普通用户的增删改查部分在这里完成。只完成了插入操作。

`webController`是关于网页的`controller`文件。

### **Service**

*包含业务逻辑。*——from kimi

下有`adminService`和`userService`。里面只有插入操作。

### entity

`Account`是用户父类，管理员类`Admin`和普通用户类`User`均继承自该类。后续攻略组的用户类理论上也要继承于该类。

用户基本属性的设置见数据库部分的介绍。

### mapper

*与数据库交互。*——from kimi

下有`adminMapper`和`userMapper`这两个接口。两个文件里面目前只完成插入用户操作。

## resource

src/main/resources下，用于存放模板等资源文件。

本项目使用MyBatis作为ORM工具时，通过xml配置SQL映射。因此，除了项目自动生成的文件之外，这里有一个和src/main/java/com/wululu/wululu/mapper对应的mapper目录。目录里面在单独的XML文件中定义SQL语句，并在Mapper接口中通过注解或配置来引用这些XML文件。

具体对应方法：

- **Mapper接口**：定义数据库操作的方法，方法名通常与数据库操作相关，例如`insert`、`update`、`delete`、`selectById`等。

- **XML文件**：在XML文件中定义具体的SQL语句，并为每个操作指定一个唯一的ID。这个ID与Mapper接口中的方法名相对应。

  例如，假设有一个`UserMapper`接口和一个`userMapper.xml`文件：

  ```java
  //UserMapper.java
  public interface userMapper {
      void insert(User user);
  }
  ```

  ```xml
  <?xml version="1.0" encoding="UTF-8" ?>
  <!DOCTYPE mapper
          "-//mybatis.org//DTD Mapper 3.0//EN"
          "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
  <mapper namespace="com.wululu.wululu.mapper.userMapper">
  
      <insert id="insert">
          insert into user
          <trim prefix="(" suffix=")" suffix0verrides=",">
              <if test="ID != null">id </if>
              <if test="ACCOUNT_ID != nul">username,</if>
              <if test="PASSWORD != null">password,</if>
              <if test="NAME != null">name,</if>
              <if test="TOKEN != null">phone,</if>
              <if test="ROLE != null">email,</if>
              <if test="AVATAR != null">avatar,</if>
              <if test="INFO != null">role,</if>
          </trim>
          <trim prefix="values(" suffix=")" suffix0verrides=",">
              <if test="ID != null">#{id},</if>
              <if test="ACCOUNT_ID != null">#{username},</if>
              <if test="PASSWORD != null">#{password},</if>
              <if test="NAME != null">#{name},</if>
              <if test="TOKEN != null">#{phone},</if>
              <if test="ROLE != null">#{email},</if>
              <if test="AVATAR != null">#{avatar},</if>
              <if test="INFO != null">#{role},</if>
          </trim>
      </insert>
  </mapper>
  ```

  在这个例子中，`UserMapper`接口的`insert`方法对应`userMapper.xml`文件中的`<insert id="insert">`标签。

## 数据库

采用h2数据库。已在src/main/resources/application.properties中完成配置。目前只有S_USER一张表，属性包括`ID`(唯一id)、`ACCOUNT_ID`（其他平台关联的用户id）、`NAME`、`TOKEN`（用于使用其他平台账户登录的一个令牌之类的）、`GMT_CREATE`（创建时间）、`GMT_MODIFY`（修改时间）、`PASSWORD`、`ROLE`（用于标识管理员、普通用户和攻略组）、`AVATAR`（头像）、`INFO`（用户简介）。

# 待完成部分

如果是论坛的话，我目前想到的可能有下面这些

- [ ] 用户的其他操作
- [ ] jwt + 拦截器配置
- [ ] Redis

静态展示的那种网页我还不是很清楚后端需要做什么。

# Reference

[一课学会SpringBoot教程-从零深入SpringBoot【实战解读SpringBoot】_哔哩哔哩_bilibili](https://www.bilibili.com/video/BV1PZ4y1j7QK/?spm_id_from=333.788.top_right_bar_window_custom_collection.content.click&vd_source=d51002bd85a670684d2dbccfab2a3107)

[【Spring Boot 实战】论坛项目【第一季】_哔哩哔哩_bilibili](https://www.bilibili.com/video/BV1r4411r7au/?spm_id_from=333.1007.top_right_bar_window_custom_collection.content.click)

[【从0带做】博客论坛系统，基于SpringBoot+Vue的个人博客系统，多人博客系统，论坛管理系统，适合做实习项目、毕业设计_哔哩哔哩_bilibili](https://www.bilibili.com/video/BV1ou4y1c7HF/?spm_id_from=333.999.0.0&vd_source=d51002bd85a670684d2dbccfab2a3107)

[Vue + Spring Boot 项目实战（一）：项目简介_springboot 项目-CSDN博客](https://learner.blog.csdn.net/article/details/88925013)