import xlrd
import requests
import unittest
class API_Test(unittest.TestCase):
    city = ''
    key = ''
    def setUp(self):
        print("开始")
    def tearDown(self):
        print("结束")
    @classmethod
    def setUpClass(self):
        book = xlrd.open_workbook("../data/data1.xlsx")#所要读取的Excel表所在地址 同级用/  非同级用..   另外Excel表需要是xlsx格式,并且内容需要文本格式
        res = book.sheet_by_name("Sheet1")#定位读取的表格 可以用name 也可以用index
        #print(res.nrows)#统计有多少行
        #print(res.row_values(1)[0])
        global city
        city = res.row_values(1)[0]#读取第几行的数据 从0开始
        global key
        key = res.col_values(1)[1]#读取第几列的数据 从0开始
        #print(city)
        #print(key)
    def test01(self):
        url = "http://apis.juhe.cn/simpleWeather/query"
        #print(city)
        #print(key)
        par = {"city":city,"key":key}
        res = requests.get(url,params=par).json()
        print(res)
        print(res['result']['realtime']['info'])
        self.assertIn('晴',res['result']['realtime']['info'])
    def test02(self):
        url = "http://apis.juhe.cn/simpleWeather/wids"
        post_res = requests.post(url,data ={"key":key}).json()
        print(post_res['reason'])
        self.assertEqual(post_res['reason'],'查询成功')
if __name__ == '__main__':
    #API_Test.get_url('self')
    #API_Test.post_url("self")
    unittest.main()
    #API_Test.xlsx("self")