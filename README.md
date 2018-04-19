### Android基本框架使用说明

##编译环境
Android Studio 2.3.3，用gradle引用的许多第三方库，第一次加载会有点慢，加载完毕后要build一下

##基本架构说明
> * 整个架构使用`dagger2`解耦
> * 功能开发使用`mvp`进行分层
> * 网络使用`retrofit2 + okhttp + gson`配合`rxjava和rxAndroid`一起封装网络请求模块
> * 具体使用请参考登录功能实现

##项目包结构说明
> * `app`

> * `common` 通用包
>>* `action` 
>>* `adapter` 适配器
>>* `base` 基本包（封装了一些基类，如BaseActivity,BaseFragment...）
>>* `exception` 异常
>>* `loger` 日志
>>* `network` 网络请求包
>>* `utils` 工具包

> * `component` dagger2模块
> * `entity` 实体类包
> * `event`  eventbus事件
> * `module`  dagger2模块
> * `scope`  dagger2模块

> * `feature` 功能开发
>>* `login` 登录功能
>>>* `contract` 协议类（就是约定mvp各个模块要做的事情）
>>>* `model` 模型（数据处理：网络，本地）
>>>* `view`  视图（显示）
>>>* `presenter` 逻辑处理，model和view沟通的桥梁
>>>* `service` 网络服务
 
 ##项目功能开发步骤说明
> * 在feature包创建相应功能模块，比如登录功能`login`
> * 在功能模块分包 `contract`、`model`、`view`、`presenter`、`service`
> * 先写contract类，把`mvp`各个模块需要做的事情约定好
> * service类，完成后要在`module`层的`NetworkModule`配置下，具体参考登录功能
> * model类，完成后要在`module`层的`ModelMoudule`配置下，具体参考登录功能
> * presenter类，完成后要在`module`层的`PresenterMoudule`配置下，具体参考登录功能
> * view类（Activity，Fragment），完成后要在'component'层的`ActivityComponent`配置下，具体参考登录功能
 
 ##其他
 dagger2教程：
 https://www.jianshu.com/p/c556b415b800
 
 
 
 
 
 