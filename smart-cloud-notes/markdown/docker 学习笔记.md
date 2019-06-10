<https://www.bilibili.com/video/av17854410>

# Docker 基本操作

## 启动容器

### 单次执行

docker run image [command] [arg]

### 启动交互式容器

docker run -i -t image /bin/bash

​	-i --interactive=true|false 默认 false  打开标准时输入

​	-t --tty=truye|false  默认 false 给docker 分配一个伪 tty 终端

## 查看容器

docker ps [-a] [-l]

​	docker ps 正在运行的容器

​	-a	所有的容器

​	-l 	最新创建的容器

## 查看已创建容器详情

docker inspect  [id] [name]

## 自定义容器名字

docker run --name=自定义名称 image

## 重新启动停止的容器

docker start [-i] 容器名称

## 删除容器

docker rm [id] [name]

## 删除所有已停止的容器

docker container prune

## 守护式容器

ctrl+p  ctrl+q

## 附加到运行中的容器（进入运行中容器）

docker attach [id] [name]

## 启动守护式容器

docker run -d 镜像名 [command] [arg]

## 查看容器日志

docker logs [-f] [-t] [--tail] 容器名

​	-f --follows=true|false 默认false	一直跟踪日志的变化并返回

​	-t --timestamps=true|false 默认false 在返回的结果上加上时间戳

​	--tail="all"  返回结尾处多少数量的日志

## 查看容器内进程

docker top 容器名

## 在运行中的容器内启动新进程

docker exec [-d] [-i] [-t] 容器名 [command] [arg]

## 停止守护式容器

docker stop 容器名

docker kill 容器名



# ================================

## 设置容器的端口映射

-P,--publish-all=true|false 默认false

​	docker run -P -i -t ubuntu /bin/bash

docker run -p 80 -i -t ubuntu /bin/bash

docker run -p 8080:80 -i -t ubuntu /bin/bash

docker run -p 0.0.0.0:80 -i -t ubuntu /bin/bash

docker run -p 0.0.0.0:8080:80 -i -t ubuntu /bin/bash

## 查看端口映射

docker port 容器名称

## 删除镜像

docker rmi 镜像:tag

## 删除虚悬的镜像

docker image prune

=====================================================

## 使用 Dockerfile 构建镜像

docker build [options] path | url|-

​	--force-rm=false

​	--no-cache=false

​	--pull=false

​	-q,--quiet=false

​	--rm=true

​	-t,--tag=""

## 镜像加速 

<https://www.cnblogs.com/atuotuo/p/6264800.html#_label0>

https://dev.aliyun.com/search.html

<https://cr.console.aliyun.com/cn-hangzhou/instances/images?search=nginx>

sudo mkdir -p /etc/docker
sudo tee /etc/docker/daemon.json <<-'EOF'
{
"registry-mirrors": ["https://8gunnt86.mirror.aliyuncs.com"]
}
EOF
sudo systemctl daemon-reload
sudo systemctl restart docker

## 权限问题

--privileged=true

Dockerfile 指令

![docker指令](https://note.youdao.com/yws/public/resource/24c16b234326541cbc49d6e2b286429a/xmlnote/B6A3EA4176D14E309FAC271FF9C01A03/3545)

