



# TODO 1 git开发环境搭建

## #linux相关命令

```shell

ls(ll)  #都是列出当前目录中的所有文件，只不过ll(两个ll)列出的内容更为详细。
touch   #新建一个文件 如 touch index.js 就会在当前目录下新建一个index.js文件。
rm      #删除一个文件, rm index.js 就会把index.js文件删除。
mkdir   #新建一个目录,就是新建一个文件夹。
rm -r   #删除一个文件夹, rm -r src 删除src目录
mv      #移动文件, mv index.html src index.html 是我们要移动的文件, src 是目标文件夹,当然, 这样写,必须保证文件和目标文件夹在同一目录下。
reset   #重新初始化终端/清屏。
clear   #清屏。
history #查看命令历史。
exit    #退出。
```


## 个人开发使用git完整指令

```shell
#初始化仓库
git init
#本地文件添加到本地缓存区（注意是’add .‘，点表示添加所有此目录下的文件）
git add .
#提交到本地缓存区，描述任意写
git commit -m "描述"
#添加远端地址,此处的地址改为github复制过来的地址。
git remote add origin "地址"
#切换分支为main
git checkout -b main
#下拉查看是否有内容
git pull --rebase origin main
#推送到main分支
git push -u origin main
#查看状态，检查用到
git status
```

```shell
#切换仓库
git remote rm origin
git remote add origin https://github.com/gcb1120/google2022.git

#新建本地分支与远程分支关联
git branch --set-upstream-to=origin/develop develop
```
## git协同开发相关命令：


### 成员需要怎么做
首先我们有一个共同开发的仓库。项目组长已经把框架建好。

小组成员此时本地还没有本项目，所以就需要从组长仓库中拉去代码到本地。
首先小组成员在本地找个合适的文件夹进入文件夹打开git bash 进入git面板操作git
下面是从远端拉取代码流程命令：

```shell
git init
git remote add origin https://github.com/gcb1120/google2022.git

#这就表示本地已经关联到远端。接着就是拉代码
#更新出远程分支索引
git fetch
#git清理被删除远程分支在本地库的缓存 
#使用git过程中，如果远程分支被删除，在本地使用git branch -a还是可以看到这些被删除分支。可以通过git remote prune 命令实现清理
git remote prune origin #非必要不执行

# 先切换分支到develop
git checkout develop
# 拉取远程代码
git pull --rebase origin develop
```
更多详情：[https://blog.csdn.net/m0_46636892/article/details/122985420](https://blog.csdn.net/m0_46636892/article/details/122985420)

## 成员提交代码到自己分支
```shell
# 新建自己的分支
git checkout -b "你的分支名"
# 提交到自己分支
git add .
git commit -m "描述"
git push -u origin "你的分支名" #去掉冒号
```
## 成员将自己分支代码合并到develop分支
```shell
# 想将自己的roydon分支合并到develop分支，操作如下：
    #1、首先切换到develop分支上
    git checkout develop
    #2.我们项目是多人开发，所以需要把远程develop上的代码pull下来
    git pull origin develop
    #3.然后我们把dev分支的代码合并到develop上
    git merge roydon
    #4。然后查看状态及执行提交命令
    git status
    git push origin develop
# 最后别忘了切换回自己的分支
git checkout roydon
```



# TODO 2 sql数据库











# TODO 3 springboot项目后台搭建

ali云短信服务：[https://www.aliyun.com/product/sms](https://www.aliyun.com/product/sms)
- 用于手机短信验证登录









# TODO 4 安卓前端







# TODO 5 安卓后端
