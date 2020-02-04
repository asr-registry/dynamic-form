package af.asr.dynamicform.repository;

import af.asr.dynamicform.model.DynamicForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DynamicFormRepository extends JpaRepository<DynamicForm, Long> {
}
