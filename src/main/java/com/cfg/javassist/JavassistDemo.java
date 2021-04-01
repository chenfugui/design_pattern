package com.cfg.javassist;

import javassist.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;

/**
 * @Description: JavassistDemo
 * javassist java 字节码操纵类库 动态修改字节码，动态生成字节码
 * @Author: chenfg
 * @Date: 2021/4/1
 * @Version:v1.0
 */
public class JavassistDemo {

    public static void simpleDemo() throws NotFoundException, CannotCompileException, IOException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        ClassPool pool = ClassPool.getDefault();
        CtClass  cc = pool.get("com.cfg.javassist.Student");
        CtClass  cP = pool.get("com.cfg.javassist.Person");
        cc.setSuperclass(cP);
        //cc.writeFile();
        String fileDir = "D:/tmp2/class";
        CtMethod ctMethod = cP.getDeclaredMethod("eat");
        ctMethod.insertBefore("log.info(\"I am befor eat ... \");");
        ctMethod.insertAfter("log.info(\"I am after eat ... \");");
        cc.writeFile(fileDir);
        cP.writeFile(fileDir);
        // 取当前应用运行的根路径
        String path = Student.class.getClassLoader().getResource("").getPath();
        path = path.contains(":") ? path.substring(1) : path;
        path = URLDecoder.decode(path, "utf-8");

        // 类生成到根路径下
        cP.writeFile(path);
        cc.writeFile(path);
        //转成class
        //Class<?> objClass = cc.toClass();
        /*Class<?> objClass = cc.toClass();
        Object objInstance =  objClass.newInstance();*/
        Loader loader = new Loader(pool);
        Class personClass = loader.loadClass("com.cfg.javassist.Person");
        //Class personClass = Class.forName("com.cfg.javassist.Person");
        Object objInstance = personClass.newInstance();
        Method eatMethod =  objInstance.getClass().getMethod("eat",String.class);
        eatMethod.invoke(objInstance,"apple");

    }

    public static void main(String[] args) {
        try {
            simpleDemo();
            String fileDir = "D:/tmp2/class";
            String targetDir = "D:/tmp2/jar";
            JarUtil.createTempJar(fileDir,targetDir,"mycommon");
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
