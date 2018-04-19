package com.hema.assist.common.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/8:上午11:09
 * Email: 656266591@qq.com
 * Desc: json转换工具
 */
public class GsonUtil {


    /**
     * json字符串转Model
     *
     * @param json
     * @param objClass
     * @param <T>
     * @return
     */
    public static <T> T jsonToObj(String json, Class<T> objClass) {
        Gson gson = new Gson();
        T t = gson.fromJson(json, objClass);//对于javabean直接给出class实例
        return t;
    }

    /**
     * json字符串转List集合
     *
     * @param json
     * @param objClass
     * @param <T>
     * @return
     */
    public static <T> List<T> jsonToList(String json, Class<T> objClass) {
        Gson gson = new Gson();
        List<T> persons = gson.fromJson(json, new TypeToken<List<T>>() {
        }.getType());//对于不是类的情况，用这个参数给出
        return persons;
    }

    /**
     * model 转 json字符串
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> String objToJson(T t) {
        Gson gson = new Gson();
        String json = gson.toJson(t);
        return json;
    }

    /**
     * model 集合 转 json字符串
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> String listToJson(List<T> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

}
