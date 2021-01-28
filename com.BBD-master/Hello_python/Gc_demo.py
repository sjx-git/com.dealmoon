'''gc垃圾回收機制：以引用计数為主，隔代 分代回收為輔
1.0代 鏈條-- 所有新創建的對象 都放在這個位置  當達到某一條件事，就會對這條鏈條上的所有對象的 如果此時有相互引用的垃圾時，引用计数 進行減一的操作 就會被清除；
             但不一定能清除引用计数為2的相互引用對象
2.1代 鏈條-- 將0代鏈條中，沒有相互引用的所有對象 放到此處，當達到某一條件事，就會對這條鏈條上的所有對象的  如果此時有相互引用的垃圾時，引用计数 進行減一的操作 就會被清除
3.2代 鏈條-- 將1代鏈條留下來的所有對象 放到此處'''
import sys
def Gc_demo():
    a  = 'hi'
    print(a)
    print(sys.getrefcount(a))#此方法显示 引用计数的统计数

Gc_demo()
