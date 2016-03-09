#MongoDB学习笔记

## 一.mongodb下载安装
    1.下载
        a. mongodb 版本下载 ：https://www.mongodb.org/dl/win32/x86_64-2008plus-ssl
        b. mongodb 驱动     ：http://central.maven.org/maven2/org/mongodb/mongo-java-driver/
        c. mongodb 的api    ：http://api.mongodb.org/java/current/index.html
    2.安装运行
        a. windows下安装mongodb（安装路径简单，路径下最好不要有空格符的文件夹）
        b. 在系统环境变量 path 添加 安装路径 如：E:\MongoDB\bin
        c. 在安装路径下手动添加三个文件:
            data文件夹,
            log文件夹（内添加一个mongo.log文件），
            mongo.config文件（mongo.config内写好配置：dbpath=E:\MongoDB\data  logpath=E:\MongoDB\log\mongo.log）
    3.运行
        a. cmd， 打开mongodb指令：mongod --config “e：\mongodb\mongo.config”
        b. 另启一个命令窗口，键入mongo即可对mongodb数据操作（增删改查）


## 二. Mongodb权限配置
    1. 设置管理员权限
        a. 先打开mongodb
        b. 再另启一个命令窗口，输入mongo回车进入配置
        c. use admin 切换到管理员数据库
        d. db.createUser({user: "lindec",pwd: "0123",roles: [ { role: "userAdminAnyDatabase", db: "admin" } ]})
        e. db.auth("lindec"，"0123") 可以认证下返回1，则说明创建成功
        Ctrl+C退出
    2.配置数据库权限
        a. mongo -u lindec -p --authenticationDatabase admin 回车提示输入密码，键入密码：0123
           也可以mongo进入配置use admin 然后再认证 db.auth("lindec","0123")
        b. use mydb
        c. db.createUser({user: "lindec",pwd: "123456",roles: [ { role: "readWrite", db: "mydb" } ]})
        d. db.auth("lindec","123456")
    3.认证配置：在mongo.config 加入 auth=true