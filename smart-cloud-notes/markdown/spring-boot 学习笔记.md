# spring-boot 学习笔记

## jsr 规范

<https://blog.csdn.net/hffyfdt/article/details/83889250>



## idea 远程调试 jar运行  remote

<https://coding.imooc.com/lesson/252.html#mid=16162>



## 处理前端合并请求思路 dive-in-spring-boot>springboot-rest

<https://coding.imooc.com/lesson/252.html#mid=17090>   and(+1)



## spring-reactive》ParallelDataLoader 并行计算

~~~java
ExecutorService executorService = Executors.*newFixedThreadPool*(3); *// 创建线程池*
CompletionService completionService = **new** ExecutorCompletionService(executorService);
~~~

##### 



## spring-boot 配置外部静态资源目录

```properties
spring.resources.static-locations=file:static/
```

## 获得发布后的jar当前路径

```java
public String getJarRoot(){
    ApplicationHome home = new ApplicationHome(getClass());
    File jarFile = home.getSource();
    return jarFile.getParentFile().getPath();
}
```

## spring-boot 上传图片到本地及读取本地图片问题

<https://blog.csdn.net/qq_38762237/article/details/81282444>

```java
 public void addResourceHandlers(ResourceHandlerRegistry registry) {        		   		registry.addResourceHandler("/imgs/**")
     //.addResourceLocations("file:F:/temp_img/");
     .addResourceLocations("file:"+getJarRoot()+"/upload/";
 }
```

## 

## 项目框架设计思路

### spring-boot-smart

###### 	服务  docker-compose.yml

nacos-server、sentinel

###### 	spring-boot-smart-core

- spring-boot-smart-regist (注册中心)

- spring-boot-smart-config （配置中心）

- spring-boot-smart-gateway （网关）

- spring-boot-smart-sentinel （限流）

- spring-boot-smart-cache （缓存）

- spring-boot-smart-services (服务)

  - spring-boot-smart-api 

- spring-boot-smart-modules (模块)

  - 角色、账户、资源、权限

    