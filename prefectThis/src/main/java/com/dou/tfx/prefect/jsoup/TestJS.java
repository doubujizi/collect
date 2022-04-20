package com.dou.tfx.prefect.jsoup;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.SimpleBindings;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2022/1/10 11:45 上午
 */
public class TestJS {
    public static ScriptEngine engine;
    public static String str;

    public static void getValues() throws Exception {
        str = "  var msg='hello';          "
                + "  var number = 123;         "
                + "  var array=['A','B','C'];  "
                + "  var json={                "
                + "      'name':'pd',          "
                + "      'subjson':{           "
                + "           'subname':'spd'  "
                + "           ,'id':123        "
                + "           }                "
                + "      };                    ";
        engine.eval(str);
        str = "msg+=' world';number+=5";
        System.out.println(engine.get("msg"));
        System.out.println(engine.get("number"));
        //获取数组
        ScriptObjectMirror array = (ScriptObjectMirror) engine.get("array");
        System.out.println(array.getSlot(0));

        ScriptObjectMirror json = (ScriptObjectMirror) engine.get("json");
        System.out.println(json.get("name"));

        //json嵌套
        ScriptObjectMirror subjson = (ScriptObjectMirror) json.get("subjson");
        System.out.println(subjson.get("subname"));

        str = "var r = new Date;" +
                "var cc = r.getFullYear()" +
                "    , o = r.getMonth() + 1" +
                "    , n = r.getDate()" ;
        engine.eval(str);
        System.out.println(engine.get("r"));
        System.out.println(engine.get("cc"));
        System.out.println(engine.get("o"));
        System.out.println(engine.get("n"));
    }

    public static void getObject() throws Exception {
        str = "  var obj=new Object();     "
                + "  obj.info='hello world';   "
                + "  obj.getInfo=function(){   "
                + "        return this.info;   "
                + "  };                        ";
        engine.eval(str);
        ScriptObjectMirror obj = (ScriptObjectMirror) engine.get("obj");
        System.out.println(obj.get("info"));
        System.out.println(obj.get("getInfo"));
        str = "obj.getInfo()";
        System.out.println(engine.eval(str));
    }

    //给js传递变量
    public static void putValue() throws Exception {
        str = "Math.pow(a,b)";
        Map<String, Object> input = new TreeMap<>();
        input.put("a", 2);
        input.put("b", 8);
        System.out.println(engine.eval(str, new SimpleBindings(input)));
    }

    //调用js函数
    public static void callJSFunction() throws Exception {
        str = "function add (a, b) {return a+b; }";
        //执行js脚本定义函数
        engine.eval(str);
        Invocable invocable = (Invocable) engine;
        Object res = invocable.invokeFunction("add", new Object[]{2, 3});
        System.out.println(res);

    }

    //读取js文件，执行函数;易变业务使用脚本编写，这样即使修改脚本，也不需重新部署java程序
    public static void callJSFunctionFromFile() throws Exception {
        ////执行js
        //while (true) {
            //模拟执行期间add.js被修改
            Thread.sleep(5000);
            engine.eval(new FileReader("/Users/tianfuxian/getRateForNewEnergy.js"));
            Invocable invocable = (Invocable) engine;
            Object res = invocable.invokeFunction("getRateForNewEnergy", new Object[]{"101", "01",350000,"2"});
            System.out.println(res);
        //}
    }
    //读取js文件，执行函数;易变业务使用脚本编写，这样即使修改脚本，也不需重新部署java程序
    public static void callJSFunctionFromFile1() throws Exception {
        //执行js
        while (true) {
            //模拟执行期间add.js被修改
            Thread.sleep(5000);
            engine.eval(new FileReader("/Users/tianfuxian/add.js"));
            Invocable invocable = (Invocable) engine;
            Object res = invocable.invokeFunction("add", "2016-01-19", "105",5,"1");
            System.out.println(res);
        }
    }

    public static void main(String[] args) throws Exception {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        engine = scriptEngineManager.getEngineByName("javascript");
        //getValues();
        //getObject();
        //putValue();
        //callJSFunction();
        callJSFunctionFromFile();
    }
}
