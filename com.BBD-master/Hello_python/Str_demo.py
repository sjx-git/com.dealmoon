str = "   This is a demo for str         "
str1= ['hi','world']

'按下标查询'
print(str[0])
'此方法在无匹配结果得时候  会报异常'
print(str.index('This'))
'按关键字查询，即使无结果，也不会报异常，以 -1 返回，可以用此方法进行if 首条件的判断'
print(str.find('1'))
'统计该关键字出现的次数'
print(str.count('a'))
'旧值，被新值替换   但因字符是不可变类型，所以不会改变原有数据'
print(str.replace('str','string'))
'去除空格 \t等的字段  只保留字符，并以列表的形式展示'
print(str.split())
'去除所填写的关键字 字段  只保留字符，并以列表的形式展示'
print(str.split(' '))
'以关键字 进行  左右的分割成三部分字符串，并以元组的形式展示'
print(str.partition('a'))
'居中显示'
print(str.center(10))
'删除空格'
print(str.strip())
'删除右边空格'
print(str.rstrip())
'删除左边空格'
print(str.lstrip())
'全部小写'
print(str.lower())
'全部大写'
print(str.upper())
'合并'
print(str.join(str1))

