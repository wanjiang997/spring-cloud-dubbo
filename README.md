# springboot + dubbo + zookeeper + mysql
    springCloud 微服务基础架构demo
    
# dubbo、zookeeper启动步骤
    1、解压上方 dubbo_zookeeper 目录下的两个压缩包
      1、incubator-dubbo-ops-master.zip
        1.1 dubbo-admin
        1.2 dubbo-monitor-simple
        1.3 dubbo-registry-simple
            ...
      2、zookeeper-3.4.13.tar.gz
        2.1 zookeeper-3.4.13
        
    2、抽取需要的服务启动
      1、将 zookeeper-3.4.13/conf 目录下的 zoo_sample.cfg 重新拷贝一份并改名为 zoo.cfg （因该服务启动是默认加载 zoo.cfg 文件）
        1.1 将 zookeeper-3.4.13/conf 目录下的 zoo_sample.cfg 重新拷贝一份并改名为 zoo.cfg 
            （因该服务启动是默认加载 zoo.cfg 文件）
        1.2 修改拷贝后的文件 zoo.cfg 文件内容
            dataDir=../data （路径自己定义，本人默认放在该服务下的 data 目录下）
        1.3 进入bin目录，执行 zkServer.cmd 文件启动该服务
        
      2、将dubbo-admin抽取出来
        2.1 修改 resources 目露下的 application.properties 配置文件
            server.port=7001 （端口随意）
            dubbo.registry.address=zookeeper://127.0.0.1:2181
        2.2 启动该服务 方式：可直接启动或打 jar 包运行
        
      3、dubbo-monitor-simple （此为服务监听器，可用可不用，取决于个人）
        3.1 修改 conf 目录下的 dubbo.properties 配置文件
            dubbo.registry.address=zookeeper://127.0.0.1:2181
        3.2 进入 assembly.bin 目录下 执行 start.bat 文件启动服务
        
    注：以上必须先启动 zookeeper 注册中心

# springboot 启动
    1、先启动服务提供者 spring-boot-provider
    2、再启动服务消费者 spring-boot-consumer
    
# 访问地址
    1、dubbo-admin 
        http://localhost:7001/
        用户名：root
        密  码：root
     
    2、dubbo-monitor-simple
        http://localhost:8080/
    
    3、spring-cloud-dubbo
        http://localhost:8081/initOrder?uid=1