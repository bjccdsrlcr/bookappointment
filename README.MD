# 图书管理系统：

该项目主要使用SpringMVC + MyBatis + Maven + Bootstrap完成;

目前主要功能有：

* 登录： 分为管理员登录以及用户登录. 少量的权限区分

* 图书列表的显示： 有分页功能，根据用户选择的页数以及每页显示的条数进行筛选

* 图书列表的排序方式： 根据图书的ID，图书当前剩余的数量进行顺序/逆序排列

* 图书的添加功能： 管理员拥有添加的权限

* 预约图书： 普通用户和管理员均可以预约图书，并且查看图书详情

* 查看用户的预约情况

* 搜索功能 

- - -
该项目还在更新中------

## 项目的目录情况

* 主要的代码在java包中

* spring, mybatis配置文件在resources文件夹中

* 前端的资源文件在web/resources文件夹中

## 部分项目截图

![list](https://github.com/bjccdsrlcr/bookappointment/blob/master/imgfolder/list.png)

![list](https://github.com/bjccdsrlcr/bookappointment/blob/master/imgfolder/list1.png)

![list](https://github.com/bjccdsrlcr/bookappointment/blob/master/imgfolder/list2.png)

![list](https://github.com/bjccdsrlcr/bookappointment/blob/master/imgfolder/login.png)

![list](https://github.com/bjccdsrlcr/bookappointment/blob/master/imgfolder/sort.png)

![list](https://github.com/bjccdsrlcr/bookappointment/blob/master/imgfolder/add.png)

![list](https://github.com/bjccdsrlcr/bookappointment/blob/master/imgfolder/add1.png)

![list](https://github.com/bjccdsrlcr/bookappointment/blob/master/imgfolder/applist.png)

![list](https://github.com/bjccdsrlcr/bookappointment/blob/master/imgfolder/appoint.png)

分页组件代码太冗余了，可以优化一下...