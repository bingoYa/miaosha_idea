Redis介绍：
Redis是一个开源的key—value型内存高速缓存数据库，支持string、list、set、zset(sorted set)和hash类型数据。对这些数据的操作都是原子性的，redus为了保证效率会定期持久化数据。

储存在Redis中的数据是持久化的，断电或重启后，数据也不会丢失。因为Redis的存储分为内存存储、磁盘存储和log文件三部分，重启后，Redis可以从磁盘重新将数据加载到内存中，这些可以通过配置文件对其进行配置，正因为这样，Redis才能实现持久化。


使用场景：
 1.配合关系型数据库做高速缓存：
 1）缓存高频次访问的数据，降低数据库io 2）分布式架构，做session共享
 2.可以持久化特定数据：
1)利用zset类型可以存储排行榜 2)利用list的自然时间排序存储最新n个数据
适用场景： 数据高并发的读写、海量数据的读写、针对扩展性要求高的数据

使用原因：
1.解决应用服务器的cpu和内存压力2.减少io的读操作，减轻io的压力3.关系型数据库的扩展性不强，难以改变表结构


因为在秒杀的环境下，访问数据量过大，如果直接访问到数据库会很容易把数据库击穿，使用Redis暂时存储访问数据能够很好的减轻数据库的访问压力，维持稳定性



今日代码收获
1.rest api json输出2.集成thymeleaf做页面模板
http://www.mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/   
快速入门：https://spring.io/projects/spring-boot
详细文档：http://docs.sprinng.io/spring-boot/docs/1.5.6RELEASE/reference/htmlsingle/

为了更好的封装，可以把set去掉，用private构造类函数，虽然不能new，但是如果可以set,依旧有可能从客户端改变数据

在controller中调用方法，为了避免不同的方法重复的调用相同类型数据导致数据硬编码，将重复部分数据进行封装，就有了CodeMsg类
return Result.success("hello,imooc");
return Result.error(CodeMsg.SERVER_ERROR)；

感觉是以前的知识，对项目的构建还是感觉有点别扭，比如Result.success,主动构造success和error方法还是想不到

搭建一个应用springboot和thymeleaf的模板

@Controller//这个标签是结点标签的标识，结点主要用于传值和跳转页面
@RequestMapping("/demo")//路径
public class SampleController {

    @RequestMapping("/thymeleaf")//当访问localhost：8080是默认的就会跳转到hello页面，通过映射来找到页面
    public String thymeleaf(Model model){//用model传递参数
        model.addAttribute("name","Joshua");//model里传了一个变量,name是传入前端的标识
        return "hello";
    }
}
hello.html:
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">引入th模板

<p th:text="'hello'+${name}"></p>//${}代表从客户端取值

1.4集成Mybatis
1.添加pom依赖:mybatis-spring-boot-starter;

2.添加配置：mybatis.*
添加mysql客户端和druid连接池依赖

Druid是一个JDBC组件，druid 是阿里开源在 github 上面的数据库连接池,它包括三部分：
* DruidDriver 代理Driver，能够提供基于Filter－Chain模式的插件体系。
* DruidDataSource 高效可管理的数据库连接池。
* SQLParser 专门解析 sql 语句


