package com.alibaba.json.test.bvt.bug;

import junit.framework.Assert;
import junit.framework.TestCase;

import com.alibaba.fastjson.JSON;

public class Bug_for_smoothrat2 extends TestCase {

    public void test_0() throws Exception {
        long millis = System.currentTimeMillis();
        
        java.sql.Time time = new java.sql.Time(millis);
        Entity entity = new Entity();
        
        entity.setValue(new java.sql.Time(millis));
        
        String text = JSON.toJSONString(entity);
        Assert.assertEquals("{\"value\":" + millis + "}", text);

        Entity entity2 = JSON.parseObject(text, Entity.class);
        
    }

    public static class Entity {

        private java.sql.Time value;

        public java.sql.Time getValue() {
            return value;
        }

        public void setValue(java.sql.Time value) {
            this.value = value;
        }

    }
}