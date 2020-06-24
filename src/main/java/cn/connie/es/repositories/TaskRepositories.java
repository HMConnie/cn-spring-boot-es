package cn.connie.es.repositories;

import cn.connie.es.entity.TaskTodoItemTO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component("taskRepositories")
public interface TaskRepositories extends ElasticsearchRepository<TaskTodoItemTO,String> {
}
