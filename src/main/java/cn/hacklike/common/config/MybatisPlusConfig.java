package cn.hacklike.common.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MybatisPlusConfig implements MetaObjectHandler {


    //使用mp实现添加操作,这个方法会执行,metaObject元数据(表中的名字,表中的字段)
    @Override
    public void insertFill(MetaObject metaObject) {
        System.out.println("执行了设置");
        //根据名称设置属性值
        this.setFieldValByName("createTime",new Date().getTime(),metaObject);
        this.setFieldValByName("updateTime",new Date().getTime(),metaObject);
        this.setFieldValByName("updateUser","like",metaObject);
    }
    //使用mp实现修改操作,这个方法会执行
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime",new Date().getTime(),metaObject);
    }


}
