------

>### gradle命令打包 ###

2017-07-25 15：10

    >>>gradlew assembleRelease —— 打包所有渠道release版本

    >>>gradlew assembleDebug —— 打包所有渠道debug版本

    >>>gradlew assembleXiaomiRelease —— 单独打包小米应用市场渠道的release版本

    >>>gradlew assembleXiaomi —— 单独打包小米应用市场渠道的debug和release版本

-------

>### 项目介绍 ###

2017-07-25 10：10

   Notes:

   >>Gradle定制三种不同环境(生产环境、测试环境、开发环境)。

   >>切换不同的Build Variants实现。

   >>测试/开发环境Apk与生成环境Apk可以同时安装在一个设备上。

   >>切换环境方式或打包Apk方式：
         1.使用Build Variants视图下app的Build Variant选项
             开发环境(devDebug/devRelease)
             测试环境(offlineDebug/offlineRelease)
             生产环境(onlineDebug/onlineRelease)
         2.gradle命令

------