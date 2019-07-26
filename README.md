# spring-boot
Spring boot 整合

> 整合swagger2 

http://xx.xx.xx/doc.html
> redis单机安装

```sbtshell
docker search redis
docker pull redis:5.0
docker run -p 6379:6379 -d --name single-redis redis:5.0
#登录验证一下
docker exec -it single-redis redis-cli
```