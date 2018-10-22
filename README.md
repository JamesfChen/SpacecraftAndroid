master branch : [![Build Status](https://travis-ci.org/HawksJamesf/SimpleWeather.svg?branch=master)](https://travis-ci.org/HawksJamesf/SimpleWeather)  develop branch : [![Build Status](https://travis-ci.org/HawksJamesf/SimpleWeather.svg?branch=develop)](https://travis-ci.org/HawksJamesf/SimpleWeather)  tinker branch : [![Build Status](https://travis-ci.org/HawksJamesf/SimpleWeather.svg?branch=tinker)](https://travis-ci.org/HawksJamesf/SimpleWeather)  kotlin-gradle branch : [![Build Status](https://travis-ci.org/HawksJamesf/SimpleWeather.svg?branch=kotlin-gradle)](https://travis-ci.org/HawksJamesf/SimpleWeather)

## 原由
之前一段时间一直在忙于工作和看书，并且看了一些的开源库代码和整理了一些笔记，终于有时间再来维护这个项目了。现在再来整理一下这个项目，发现很多地方当时没有处理好，所以决定重构一下。重构的思路主要在于框架，而UI展示会尽量简单。如果后续有时间再来扩展UI功能。

接下来的任务主要安排如下：

- [x] MVP框架搭建
- [x] Retrofit+RxJava2封装整合
- [ ] Room注解数据库的接入
- [ ] 定位系统的设计与封装
- [x] 组件化设计
- [x] 提供gradle plugin for version

~~-[x] 临时使用MockServer模拟后端数据~~
- [x] 提供mock环境、real环境、real local server环境

