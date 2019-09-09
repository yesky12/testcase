package lib.json.zson

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import com.zf.zson.ZSON
import com.zf.zson.result.ZsonResult



/**
 * ---------
zhangfei19841004/zson: 专为测试人员打造的JSON解析器
https://github.com/zhangfei19841004/zson
 */
fun main(args: Array<String>) {
    var json =
        """
        {
            "retCode": "200",
            "retMsg": "success",
            "data": [
            {
                "id": 1,
                "name": "test",
                "date": "2017-01-09 13:30:00"
            },
            {
                "id": 2,
                "name": "test1",
                "date": "2017-01-09 13:40:00"
            }
            ]
        }
        """
    val parseObject = JSON.parseObject(json)
    val toJSONString = JSON.toJSONString(parseObject)

    val zr = ZSON.parseJson(toJSONString)
    val names = zr.getValues("//name")  //names = [test, test1]
    println("names = ${names}")
}