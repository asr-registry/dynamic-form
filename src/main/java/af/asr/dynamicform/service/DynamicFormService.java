package af.asr.dynamicform.service;

import af.asr.dynamicform.model.DynamicForm;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public interface DynamicFormService {

    public DynamicForm save(DynamicForm dynamicForm);

    public DynamicForm getOne(long id);

    public void delete(long id);

    public List<DynamicForm> findall();

    public DynamicForm findByName(String name);

    public DynamicForm findByType(String type);
}
