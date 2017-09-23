# CustomerManager
这是有关于jsp,servlet相关的基础知识所编写的一个非常小的Customer页面
知识搭建:
    1.jsp,servlet基础知识
    2.相关jar包的导入		
         c3p0-0.9.1.2.jar                     使c3p0驱动包,开源的连接池
         commons-beanutils-1.8.3.jar          关于javaBean操作的包
         commons-dbutils-1.4.jar              关于dbUtil的包
         commons-pool-1.5.6.jar
         jstl.jar                             关于EL标签的jar包
         standard.jar
         mysql-connector-java-5.1.28-bin.jar  关于java连接mysql数据库的jar包
    3.mysql数据库,在mysql数据库中创建相应的表,具体表结构参照 domain包中属性创建
    4.运用了java的dao设计模式
        
        webServlet层:存放servlet
        service层:承接webServlet层,下掉用dao层中的方法
        dao层:该层一般含有直接操作数据的方法
        数据库
        domain层:与数据库中的表对应的类
        uitl层:工具层
    5.使用部分关于分页的操作
    6.使用到了自定义标签的知识(jsp页面)
