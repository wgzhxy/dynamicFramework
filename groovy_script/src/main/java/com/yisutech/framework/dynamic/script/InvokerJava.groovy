package com.yisutech.framework.dynamic.script

import com.yisutech.framework.dynamic.domain.StudentEntity

StudentEntity studentEntity = new StudentEntity();
studentEntity.age = 32;
studentEntity.name = "good";
studentEntity.className = "计科032";

println(studentEntity.age + "_" + studentEntity.name + "_" + studentEntity.className);

println("=================进入到单元测试======================")