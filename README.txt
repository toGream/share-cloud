##################配置maven父子工程######################
1.父pom.xml引入依赖管理，目前只发现这个配置时有用的
<dependencyManagement>
      <dependencies>
			<dependency>
			    <groupId>org.springframework.boot</groupId>
			    <artifactId>spring-boot-dependencies</artifactId>
			    <version>1.5.8.RELEASE</version>
			    <type>pom</type>
			    <scope>import</scope>
			</dependency>
		</dependencies>
  </dependencyManagement>
另外两种方式不使用版本号都有问题，
1）
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.0.3.RELEASE</version>
    <relativePath/>
</parent>
<dependencies>
  <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-dependencies</artifactId>
      <version>Finchley.RELEASE</version>
      <type>pom</type>
      <scope>import</scope>
  </dependency>
</dependencies>
2）
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>1.5.2.RELEASE</version>
    <relativePath/>
</parent>
<dependencies>
	<dependency>
		<groupId>org.springframework.cloud</groupId>
		<artifactId>spring-cloud-dependencies</artifactId>
		<version>Camden.SR2</version>
		<type>pom</type>
		<scope>import</scope>
	</dependency>
</dependencies>

#######################服务获取配置中心数据########################
1.引入依赖
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-config</artifactId>
	<version>1.3.3.RELEASE</version>
</dependency>
2.在bootstrap.properties中配置：config-client-dev.properties在master分支
#applicationname 应用模块名称
spring.application.name=config-client

#label 分支名称
spring.cloud.config.label=master

#profile 环境名称(dev,sit,uat,production)
spring.cloud.config.profile=dev

#uri 配置中心地址
spring.cloud.config.uri= http://localhost:8888/

3.如何在应用中指定配置？
在eclipse vm参数中指定-Dspring.cloud.config.profile=sit
运行jar包时指定参数java -jar xxx.jar --server.port=8080

##########################maven打包报编译错误解决方案############################
1.Eclipse-->Window-->preferences-->Java-->Installed JREs指定jdk目录而不是jre目录，然后点击工程bulidPath指定对应的jdk
2.引入对应的springboot打包插件
<build>
  	<plugins>
		<plugin>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-maven-plugin</artifactId>
		</plugin>
	</plugins>
</build>













