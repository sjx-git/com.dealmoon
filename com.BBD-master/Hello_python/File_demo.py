'读取文件r,但在文件不存在的情况下会报异常'
'写入文件w，但会覆盖原文件' \
'写入文件a，不会覆盖原文件，在尾部开始新增数据' \


'读写文件r+，但在文件不存在的情况下会报异常'
'读写文件w+，但会覆盖原文件' \
'读写文件a+，不会覆盖原文件，在尾部开始新增数据'

'''
读取大文件时，不得直接使用read和readline，有很大的风险会造成内存溢出
可以定义每次读取的内容大小 read(1024),并以循环的方式全部取出
'''
def OpenDemo():
    #打开一个文件
    old_name = input("请输入你要打开的文件名字：")
    #根据输入的文件名称，通过截取不带后缀的名称+复件两字+截取后缀 组成新的文件名称
    index = old_name.rfind(".")
    New_name = old_name[:index] + ("(复件)") + old_name[index:]
    #打开输入的文件，并写入一些东西
    f = open(old_name,"w+")
    f.write("Hello  World")
    #先关闭才能读取写入的数据
    f.close()
    #读取出文件内容
    a = open(old_name,"r+")
    #打开输入的文件，并写入一些东西
    n = open(New_name,"w+")
    try:#为了确保出现异常时，程序可以正常运行
        while True:
            h = a.read(1024)#当文件过大时，使用 h = a.read就会出现内存溢出而出现异常
            #print(old_name + "内容是："+ h) #for test
            n.write(h)
            if len(h)==0:
                break
    except Exception as res:#捕获出抛出的异常 用as 列表名的同义
        print('不能一次性读出所有数据')
    finally:
        n.close()
        a.close()
        #读取出文件内容
        #new_a = open(New_name,"r")#for test
        #print(New_name + "内容是："+ new_a.read())
#if __name__ == 'main':
OpenDemo()