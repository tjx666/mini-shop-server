# mini_shop 后端部分

## 技术栈
1. spring boot
2. spring data jpa
3. mysql
4. logback
5. lombok
6. gradle
7. IDEA

## 分层设计，开发 RESTful 风格 API，面向接口开发
1. controller 控制器，处理路由，校验请求参数，封装结果
2. service 封装业务服务
3. entity 实体类
4. repository 封装数据库操作
5. dto 数据传输使用到的各种类，比如 POST 请求体
6. filter 处理跨域等
7. utils 各种工具类
