# algorithm

## 时间复杂度和空间复杂度
1. 常数操作，固定时间的操作，执行时间和数据量无关
2. 时间复杂度，一个和数据量有关(运行时间和数据量的关系)、只要高阶项、不要低阶项、不要常数项的操作次数表达式
3. 严格固定流程算法，一定强调最差情况！比如插入排序
4. 算法流程上利用随机行为作为重要部分的，要看平均或者期望的时间复杂度，因为最差的时间复杂度无意义（用生成相邻值不同的数组来说明）
5. 算法流程上利用随机行为作为重要部分的，还有随机快排（也只在乎平均或者期望的时间复杂度，因为最差的时间复杂度无意义）
6. 时间复杂度的内涵: 描述算法运行时间和数据量大小的关系，而且当数据量很大很大时，这种关系相当的本质，并且排除了低阶项、常数时间的干扰
7. 空间复杂度，强调额外空间；常数项时间，放弃理论分析、选择用实验来确定，因为不同常数操作的时间不同
8. 什么叫最优解，先满足时间复杂度最优，然后尽量少用空间的解
9. 时间复杂度的均摊，用动态数组的扩容来说明（O(1)） 并查集、单调队列，单调栈、哈希表等结构，均有这个概念
10. 不要用代码结构来判断时间复杂度，比如只有一个while循环的冒泡排序，其实时间复杂度O(N^2)
11. 不要用代码结构来判断时间复杂度，比如：N/1 + N/2 + N/3 + ... + N/N, 这个流程的时间复杂度是O(N*logN),著名的调和级数
12. 时间复杂度只能是对算法流程充分理解才能分析出来，而不是简单的看代码结构！这是一个常见的错误！甚至有些算法的实现用了多层循环嵌套，但时间复杂度是O(N)的。
13. 常见的复杂度一览：O(1) O(logN) O(N) O(N*logN) O(O^2)...O(N^k) O(2^N) O(K^N) ... O(N!)
14. 时间复杂度非常重要，可以直接判断某个方法能不能通过一个题目，根据数据量猜解法

## 算法和数据结构简介
### 硬计算机类算法、软计算机类算法
#### 硬计算机类算法：精确求解。但是某些问题使用硬计算机的算法，可能会让计算的复杂度较高
#### 软计算类算法：更注重逼近解决问题，而不是精确求解。计算时间可控 比如：模糊逻辑、神经网络、进化计算、概率理论、混沌理论、支持向量机、群体智能
连续结构 跳转结构
任何数据结构都一定是这两个结构拼出来的！没有例外


# 算法笔试中处理输入和输出
## 填函数式风格
## acm风格（笔试、比赛最常见）
1. 规定数据量（BufferedReader、StreamTokenizer、PrintWriter）,其他语言有对等的写法
2. 按行读（BufferedReader、PrintWriter）,其他语言有对等的写法
3. 不要用Scanner、System.out,IO效率慢
## 不推荐: 临时动态空间
## 推荐: 全局静态空间