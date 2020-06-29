package cn.connie.es;

import cn.connie.config.center.common.utils.Dui1DuiStringUtils;
import cn.connie.es.constant.EsConstant;
import cn.connie.es.entity.TaskTodoItemTO;
import cn.connie.es.service.EsServicesImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class MainTests {

    @Autowired
    EsServicesImpl services;

    @Test
    void contextLoads() {
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        List<TaskTodoItemTO> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TaskTodoItemTO taskTodoItemTO = new TaskTodoItemTO();
            taskTodoItemTO.setItemId(Dui1DuiStringUtils.generateUUID());
            taskTodoItemTO.setCreateTime((int) (new Date().getTime() / 1000));
            taskTodoItemTO.setProjectId(200L);
            taskTodoItemTO.setItemIndex(EsConstant.ES_INDEX_AUDIT_PROJECT_ITEM_INFO + date);
            list.add(taskTodoItemTO);
        }
        services.insertAll(list);
    }

}
