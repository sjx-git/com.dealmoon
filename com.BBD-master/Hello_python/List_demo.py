list7 = ['hi', 'world', 'are', 'you', 'ok?', '11', '22', '33', '11', '22', '33', '44']
list1 = ['Good']
'添加单个字符或者列表 在最后，会将列表整个加进去[[新加的列表]]'
list7.append('yes')
#print(list7)
'按下标添加'
list7.insert(0, 'haha')
#print(list7)
'只能合并列表，不能添加单个字符，不同于append ，[,新增的列表数据，合并到一起]'
list3  = list1 + list7
print(list3)
list7.extend(list1)
print(list7)

'删除最后一个'                                                
list7.pop()
print(list7)
'删除关键字'
list7.remove('hi')
print(list7)
'按下标删除'
del  list7[2]
print(list7)

'按下标更改'
list7[1] = 'no'
print(list7)

'查询 in  或者  not in'
if  'yes' in list7:
    print('查到了')
if  'gun' not in list7:
    print('不在这里边')

'排序 从小到大'
list7.sort()
print(sorted(list7))
print(list7)
'排序 从大到小'
list7.sort(reverse=True)
print(list7)
'排序 颠倒位置'
list7.reverse()
print(list7)

'去重 第一种'

list4 = []
for i in list7:
    if i not in list4:
        list4.append(i)
#print(list4)

'去重 第二种'
list5 = set(list7)
print(list5)
#list6 = list(list5)
#此处可以使用eval 原本是什么样的格式就转回什么样的格式
list6 = eval(str(list5))
print('list6的数值是%s'%list6)

