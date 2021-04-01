package com.cfg.aviator.measure;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Options;

import java.util.Map;

/**
 * @Description: ComputeEngine 公式解析引擎
 * @Author: chenfg
 * @Date: 2021/3/19
 * @Version:v1.0
 */
public class ComputeEngine {

     static{
         // 设置默认转换浮点数到decimal高精度计算
         AviatorEvaluator.setOption(Options.ALWAYS_PARSE_FLOATING_POINT_NUMBER_INTO_DECIMAL,true);
    }

    public static Object compute(String pattern, Map<String,Object> env){
        return AviatorEvaluator.execute(pattern,env);
    }


}
