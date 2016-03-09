# zookeeper安装配置

## 一. zookeeper安装配置与启动

### 1. zookeeper安装
    1) zookeeper官网：http://zookeeper.apache.org/，
    2) 在"Getting Started"中选择"DownLoad",可以在apache的镜像库中下载zookeeper的发行版本，选择合适的方式下载zookeeper，
    3) 将下载的压缩包解压。

### 2. zookeeper配置
    1) 进入conf文件夹，新建文件zoo.cfg,将zoo_sample.cfg文件中的所有内容拷贝到zoo.cfg中
    2) 在任意目录下新建文件夹，来存放数据，修改zoo.cfg文件中的"dataDir"，使其指向新建的数据文件夹
    3) 为避免端口冲突，可修改zookeeper的服务端口号，在zoo.cfg文件中新加入一行"admin.serverPort=9080"
    4) 回到zookeeper根目录，进入bin文件夹，如果为windows系统，则需要修改zkEnv.cmd文件，将最后一行的"%JAVA_HOME%\bin\java"加上双引号，将"%JAVA_HOME%\bin\java.exe"也加上双引号。

### 3. zookeeper启动
    1) windows环境
        a. 进入bin文件夹，按住"shift"键右击文件夹空白处，运行命令行，运行"zkServer.cmd"，
        b. 重复上面动作，运行"zkCli.cmd",
        c. 在"zkCli.cmd"命令行中将config压缩包（QQ群文件共享中有）所有的数据复制进去。
            配置服务节点
            create /config ""
            create /config/application ""
            配置具体mongodb参数(对mongodb参数必须预先配置好)：
            create /config/webtest ""
            create /config/webtest/mongo ""
            create /config/webtest/mongo/address 127.0.0.1
            create /config/webtest/mongo/port 27017
            create /config/webtest/mongo/database mydb
            create /config/webtest/mongo/username lindec
            create /config/webtest/mongo/password 123456
    2) 其他环境
        a. 直接运行zkServer.sh，再运行zkCli.sh，将config压缩包中所有的数据输入到zkCli.sh中。


## 二. 修改工程配置文件
    1) 将所有项目的"bootstrap.yml"（如果有）中的cloud下zookeeper下config下connect-string字段中的ip地址改为本机ip地址
       spring:
         application:
           name: webtest
         cloud:
           zookeeper:
             config:
               cacheEnabled: true
             connect-string: ${ZOOKEEPER1_HOST:127.0.0.1}:${ZOOKEEPER1_PORT:2181}
    2) pom.xml添加相关包
    3) 在application入口上加上@EnableDiscoveryClient


## 三. 启动项目
    1.