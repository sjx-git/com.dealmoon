'1.形参有默认值，可不传默认数据'
def test(a,b=2):
    pass
test(1)
'2.形参有默认值，想改变默认值,但是要改值得 名字一定要一致'
def test1(a,b=2):
    pass
test(1,b=3)
'3.实参传入的位置写错了，可用形参一致的名字标识'
def test2(a,b=2):
    pass
test(b = 3,a=1)


'默认形参取33；不定长参数（必须放在最后） *args 保存实参中的44,55,66,A  以元组展示；**kwargs 保存77,88,B  以字典展示'
A =(1,2)
B = {'name':'liming','sex':'nan'}
def test3(a,b,c=33,*args,**kwargs):
    pass
    '取值args,以加法举例'
    result= a + b
    for temp in args:
        result += temp

test3(11,22,33,44,55,66,age=88,id=77,*A,**B )