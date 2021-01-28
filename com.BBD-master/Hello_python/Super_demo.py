'继承的方式'
'1.A是父类--动物  B是子类--狗   c是基类--哮天犬'
class A:
    pass
class B(A):
    def bark(self):
        print('汪汪叫')
class C(B):  # C 有用A、B的所有属性和功能
    pass

'重写方式'
class C(B):
    def bark(self):  # 重写父类的方法
        print('狂叫')
        '调用父类的方法 第一种'
        #B.bark('self')
        '调用父类的方法 第二种 建议使用这种'
        #super().bark()
c = C()
#c.bark()
b = B()
'私有方法和私有属性，' \
'1.在当前类也可以叫父类中，私有方法和私有属性 可以通过另一个公有的方法 进行调用使用' \
'2.在子类中，即继承了父类，私有方法和私有属性 不可以通过另一个公有的方法 进行调用'


'多态  1.当用一个函数，写好了调用一个方法，这个方法在父类和子类中都有一个相同的，设计好后，本身这个函数是不知道该调用哪儿个类的方法' \
'只能在 调用某个类之后，才能知道调用这个类中的方法     这就是多态'
def duotai(temp):
    temp.bark()
duotai(c)
duotai(b)

'类方法 类属性  实例方法 实例属性  静态属性'

class Demo(object):
    #类属性
    num = 0

    #类方法
    @classmethod
    def cls(cls):
        Demo.num = 10
    #实例方法
    def def_demo(self):
        #实例属性
        self.name = 'liming '

    #静态方法
    @staticmethod
    def sta_demo():
        print('静态方法')
demo = Demo()
'调用类方法和类属性'
Demo.cls()
print(Demo.num)
print(demo.num)

'调用实例方法和实例属性'
demo.def_demo()

'调用静态方法'
Demo.sta_demo()
demo.sta_demo()
