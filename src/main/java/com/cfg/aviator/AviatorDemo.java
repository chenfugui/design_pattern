package com.cfg.aviator;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDouble;
import com.googlecode.aviator.runtime.type.AviatorObject;
import org.nfunk.jep.function.Add;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description: 描述
 * @author: chenfg
 * @time: 2020/8/27 14:29
 */
public class AviatorDemo {

    public static void main(String[] args) {

        Long result = (Long) AviatorEvaluator.execute("1+2+3");
        System.out.println(result);
        char ni='好';
        /*test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();*/
        test12();


    }

    public static void test1(){
        String yourName = "Michael";
        Map<String, Object> env = new HashMap<String, Object>();
        env.put("yourName", yourName);
        String result = (String) AviatorEvaluator.execute(" 'hello ' + yourName ", env);
        System.out.println(result);  // hello Michael
    }

    public static void test2(){
        AviatorEvaluator.execute(" 'a\"b' ");           // 字符串 a"b
        AviatorEvaluator.execute(" \"a\'b\" ");         // 字符串 a'b
        AviatorEvaluator.execute(" 'hello ' + 3 ");     // 字符串 hello 3
        AviatorEvaluator.execute(" 'hello '+ unknow "); // 字符串 hello null
    }

    public static void test3(){
        String name = "dennis";
        AviatorEvaluator.exec(" 'hello ' + yourName ", name); // hello dennis
    }

    public static void test4(){
        // 调用java函数
        AviatorEvaluator.execute("string.length('hello')");  // 5
        AviatorEvaluator.execute("string.contains(\"test\", string.substring('hello', 1, 2))");  // true
    }



    static class AddFunction extends AbstractFunction {
        @Override
        public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
            Number left = FunctionUtils.getNumberValue(arg1, env);
            Number right = FunctionUtils.getNumberValue(arg2, env);
            return new AviatorDouble(left.doubleValue() + right.doubleValue());
        }

        public String getName() {
            return "add";
        }

    }
    public static void test5(){
        //自定义函数
        //注册函数
        AviatorEvaluator.addFunction(new AddFunction());
        System.out.println(AviatorEvaluator.execute("add(1, 2)"));           // 3.0
        System.out.println(AviatorEvaluator.execute("add(add(1, 2), 100)")); // 103.0
    }
        public static void test6(){
            String expression = "a-(b-c)>100";
            // 编译表达式
            Expression compiledExp = AviatorEvaluator.compile(expression);
            Map<String, Object> env = new HashMap<String, Object>();
            env.put("a", 100.3);
            env.put("b", 45);
            env.put("c", -199.100);
            // 执行表达式
            Boolean result = (Boolean) compiledExp.execute(env);
            System.out.println(result);  // false
        }

        public static void test7(){
            //访问数组和集合
            //可以通过中括号去访问数组和java.util.List对象, 可以通过map.key访问java.util.Map中key对应的value
            final List<String> list = new ArrayList<String>();
            list.add("hello");
            list.add(" world");
            final int[] array = new int[3];
            array[0] = 0;
            array[1] = 1;
            array[2] = 3;
            final Map<String, Date> map = new HashMap<String, Date>();
            map.put("date", new Date());
            Map<String, Object> env = new HashMap<String, Object>();
            env.put("list", list);
            env.put("array", array);
            env.put("mmap", map);
            System.out.println(AviatorEvaluator.execute("list[0]+list[1]", env));   // hello world
            System.out.println(AviatorEvaluator.execute("'array[0]+array[1]+array[2]=' + (array[0]+array[1]+array[2])", env));  // array[0]+array[1]+array[2]=4
            System.out.println(AviatorEvaluator.execute("'today is ' + mmap.date ", env));  // today is Wed Feb 24 17:31:45 CST 2016
        }

        public static void test8(){
            //Aviator 不提供if else语句, 但是提供了三元操作符?:用于条件判断,使用上与 java 没有什么不同:
            AviatorEvaluator.exec("a>0? 'yes':'no'", 1);  // yes
        }

        public static void test9(){
            //正则表达式匹配
            //Aviator 支持类 Ruby 和 Perl 风格的表达式匹配运算,通过=~操作符, 如下面这个例子匹配 email 并提取用户名返回:
            String email = "killme2008@gmail.com";
            Map<String, Object> env = new HashMap<String, Object>();
            env.put("email", email);
            String username = (String) AviatorEvaluator.execute("email=~/([\\w0-8]+)@\\w+[\\.\\w+]+/ ? $1 : 'unknow' ", env);
            System.out.println(username); // killme2008
        }

    static class TestAviator {
        int i;
        float f;
        Date date;

        // 构造方法
        public TestAviator(int i, float f, Date date) {
            this.i = i;
            this.f = f;
            this.date = date;
        }
    }

    public static void test10(){
        //Aviator 有个方便用户使用变量的语法糖, 当你要访问变量a中的某个属性b, 那么你可以通过a.b访问到, 更进一步, a.b.c将访问变量a的b属性中的c属性值, 推广开来也就是说 Aviator 可以将变量声明为嵌套访问的形式。
        TestAviator foo = new TestAviator(100, 3.14f, new Date());
        Map<String, Object> env = new HashMap<String, Object>();
        env.put("foo", foo);
        System.out.println(AviatorEvaluator.execute("'foo.i = '+foo.i", env));   // foo.i = 100
        System.out.println(AviatorEvaluator.execute("'foo.f = '+foo.f", env));   // foo.f = 3.14
        System.out.println(AviatorEvaluator.execute("'foo.date.year = '+(foo.date.year+1990)", env));  // foo.date.year = 2106
    }

    /**
     * big int和decimal的表示与其他数字不同,两条规则:
     *
     * 以大写字母N为后缀的整数都被认为是big int,如1N,2N,9999999999999999999999N等, 都是big int类型。
     * 超过long范围的整数字面量都将自动转换为big int类型。
     * 以大写字母M为后缀的数字都被认为是decimal, 如1M,2.222M, 100000.9999M等, 都是decimal类型。
     * 用户也可以通过变量传入这两种类型来参与计算。
     * big int和decimal的运算,跟其他数字类型long,double没有什么区别,操作符仍然是一样的。 aviator重载了基本算术操作符来支持这两种新类型:
     */
    public static void test11(){
        Object rt = AviatorEvaluator.exec("9223372036854775807100.356M * 2");
        System.out.println(rt + " " + rt.getClass());  // 18446744073709551614200.712 class java.math.BigDecimal
        rt = AviatorEvaluator.exec("92233720368547758074+1000");
        System.out.println(rt + " " + rt.getClass());  // 92233720368547759074 class java.math.BigInteger
        BigInteger a = new BigInteger(String.valueOf(Long.MAX_VALUE) + String.valueOf(Long.MAX_VALUE));
        BigDecimal b = new BigDecimal("3.2");
        BigDecimal c = new BigDecimal("9999.99999");
        rt = AviatorEvaluator.exec("a+10000000000000000000", a);
        System.out.println(rt + " " + rt.getClass());  // 92233720368547758089223372036854775807 class java.math.BigInteger
        rt = AviatorEvaluator.exec("b+c*2", b, c);
        System.out.println(rt + " " + rt.getClass());  // 20003.19998 class java.math.BigDecimal
        rt = AviatorEvaluator.exec("a*b/c", a, b, c);
        System.out.println(rt + " " + rt.getClass());  // 2.951479054745007313280155218459508E+34 class java.math.BigDecimal
    }

    // abc age：{at#A.age} abc sex{at#A.sex}  abc age：{at#B.age} abc sex{at#B.sex}
    public static void test12(){
        //正则表达式匹配
        //Aviator 支持类 Ruby 和 Perl 风格的表达式匹配运算,通过=~操作符, 如下面这个例子匹配 email 并提取用户名返回:
        String email = "@123#sdf@456#qqwq";
        Map<String, Object> env = new HashMap<String, Object>();
        env.put("email", email);
        String username = (String) AviatorEvaluator.execute("email=~/@(.*?)#/ ? $1 : 'unknow' ", env);
        System.out.println(username); // killme2008

        String reg = "@(.*?)#";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(email);
        List<String> list = new ArrayList<>();
        int count = matcher.groupCount();
        for(int j=0;j<count;j++){
            list.add(matcher.group(j+1));
        }
        for (String s : list) {
            System.out.println(s);
        }
    }

}