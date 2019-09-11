#!/usr/bin/env bash
#编译部署order站点

#需要配置如下参数
# 项目路径，在Execute Shell 中配置项目路径，pwd命令可以获取到该项目路径
# export PROJ_PATH=这jenkins任务在部署机器上的路径
# 输入机器上tomcat的全路径
# export TOMCAT_APP_PATH=tomcat在部署机器上的路径

###base函数
#killTomcat（）
#{
#pid=`ps -ef | grep tomcat | grep java | awk '{print $2}'`
#echo "tomcat Id list :$pid"
#if ["$pid" = "" ]
#then
#echo "no tomcat pid alive"
#else
# 	kill -9 $pid
#fi
#}


# 停止tomcat
#killTomcat

#maven构建项目
cd $PROJ_PATH/
mvn clean install

# 删除tomcat下webapps下的项目
rm -f $TOMCAT_APP_PATH/webapps/ceshi01.war
rm -rf $TOMCAT_APP_PATH/webapps/ceshi01

#修改war文件名称
cd $PROJ_PATH/all_Projects/target
mv ceshi01-0.0.1-SNAPSHOT.war ceshi01.war

# 复制新的工程到webapps
cp $PROJ_PATH/target/ceshi01.war $TOMCAT_APP_PATH/webapps/


# 启动tomcat
# cd $TOMCAT_APP_PATH/
# sh bin/startup.sh
