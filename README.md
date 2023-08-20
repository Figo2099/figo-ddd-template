#sic-ddd-template DDD分层架构模板

## 各模块依赖：
接口层-》应用层-》领域层-》基础层
全部依赖于公共层，层级依次从上向下调用，不建议出现跨层级调用关系，会膨胀成传统的三层架构，各层级的职责会不清晰

## 层级职责：
1、interfaces（接口层）：对外提供接口的能力
2、application（应用层）：根据接口能力，各领域之间进行编排重组，领域事件的发布
3、domain（领域层）：实体、值对象聚合成领域模型，核心的业务逻辑，原则上禁止跨领域之间的调用
4、infra（基础层）：提供基础的资源服务，如数据库、缓存、中间件等
5、common（公共层）：跨层之间引用的公共实体、枚举、异常等

## 领域划分：

## package定义：

### sic-ddd-template-application（应用层）：
aspect：切面，日志统一打印request、response，异常统一处理
event：领域事件，某个领域的某个功能，走完主流程需要后续处理逻辑
service：除领域之外的接口能力，比如定时任务、bi打点、jvm的钩子等
  domain：接口层能力的实现，跨领域间的domainService编排、重组封装，事件发送，service的调用等
transferUtil：实体间的转换，req转换领域实体,领域实体转换dto

### sic-ddd-template-common（公共层）：
annotation:自定义注解
constants：常量定义
enums：模块共用的枚举
event: 领域事件实体Bean，事件定义
exception：自定义check异常，aop中需要单独处理
model：共用实体、值对象
publish：初始化spring 容器对象
util：共用工具类


### sic-ddd-template-domain（领域层）：
template：领域名称
TemplateDomainService：领域的聚合根（聚合根id、值对象、实体的聚合）
  dapter：类似门面模式，对仓储层能力定义接口（数据操作）
  aggerage：领域的聚合根（聚合根id、值对象、实体的聚合）
  entity：实体、值对象的定义
    enums：领域的枚举定义

### sic-ddd-template-infra（基础层）：
config：业务自定义的配置
dependency：领域、事件需要外部接口能力rpc调用
repo：数据存储
  domain：实现领域层adapter包接口，对数据库、缓存编排操作
    mysql：数据库操作
      mapper：sql接口入口
      po：数据库实体
    redis: 缓存操作
      util：不同领域的keyUtil的构建
transferUtil: 领域聚合转换sql实体
resources目录：/mapper,sqlXml文件

### sic-ddd-template-interfaces（接口层）：
api：对外暴露接口的controller，尽量不要掺杂业务逻辑
  external：对接web端api
  internal：对接内部系统api
interfaces：接口能力的设定
model：入参、出参的定义
  dto：dto包返回实体
  req：请求参数定义
  resp: 多个dto的组合，根据具体业务组合