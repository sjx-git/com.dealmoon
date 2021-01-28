'key 可以是字符串、数字、元组，不可变类型都可以；但 列表、字典 可变类型 不可以做'
dict = {'name':'liming','age':11}

'get key方式获取到value'
print(dict.get('name'))

'获取到key'
print(dict.keys())

'获取到value'
print(dict.values())

'获取到key,value'
print(dict.items())

'for循环遍历，并用元祖的拆包方式，取出key value的值'
for key,value in dict.items():
    print('key:%s,value:%s'%(key,value))