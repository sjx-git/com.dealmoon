''''
不带参数的装饰器
对有参数，有返回值的函数，进行装饰即，做一个 通用装饰器
1.要注意在装饰器中，传入对应的形参，可以用不定长参数代替
2.在原来的函数中，该怎么调用还是怎么调用'''
import functools
def A(func):
    @functools.wraps(func)#如果不加此方法，再用help查看B的说明时，会打印装饰器A的说明
    def A(*args,**kwargs):
        '函数A的说明'
        print('A装饰器')
        return  func(*args,**kwargs)#有返回值的时候，记得最后要讲返回的数据给 return
    return A
@A
def B(a,b,c):
    '函数B的说明'
    return ('B的函数a=%d,b=%d,c=%d'%(a,b,c))
print(B(11,22,33))

print('-----------------华丽的分割线----------------------')

'''带有参数的装饰器
1.只需要在闭包的外层再加一个闭包就可以，最外层函数记得需要加个 形参'''
def AAA(temp):
    def A(func):
        def A_A(*args,**kwargs):
            print('A装饰器---%s'%temp)
            return  func(*args,**kwargs)#有返回值的时候，记得最后要讲返回的数据给 return
        return A_A
    return A
@AAA('你瞅啥')
def B(a,b,c):
    return ('B的函数a=%d,b=%d,c=%d'%(a,b,c))
print(B(11,22,33))