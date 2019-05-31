# SpringApplication 入口 

## 1、事件监听 

### 	1.1、实现 ApplicationListener

​			onApplicationEvent

### 	1.2、META-INF/spring.factories

​			org.springframework.context.ApplicationListener=\

### 	1.3、指定执行顺序

#### 			1.3.1、注解方式

​					org.springframework.core.annotation.Order

#### 			1.3.2、实现接口			

​					org.springframework.core.Ordered#getOrder

## 2、启动完成后执行

### 	2.1、ApplicationRunner	

### 	2.2、CommandLineRunner



```
SimpleApplicationEventMulticaster
```