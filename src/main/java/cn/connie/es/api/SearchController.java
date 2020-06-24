package cn.connie.es.api;

import cn.connie.config.center.common.base.CollectionTO;
import cn.connie.es.entity.EsCriteria;
import cn.connie.es.entity.TaskTodoItemTO;
import cn.connie.es.service.EsServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class SearchController {


    @Autowired
    private EsServicesImpl esServices;


    @RequestMapping(value = "/task",method = RequestMethod.GET)
    public CollectionTO<TaskTodoItemTO> search(@RequestParam("projectId")Long projectId ){
        EsCriteria esCriteria = new EsCriteria();
        esCriteria.setProjectId(projectId);
        CollectionTO<TaskTodoItemTO> taskTodoItemTOS = esServices.getTaskByCriteria(esCriteria);
        return taskTodoItemTOS;
    }
}
