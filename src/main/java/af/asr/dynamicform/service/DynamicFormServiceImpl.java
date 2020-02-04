package af.asr.dynamicform.service;

import af.asr.dynamicform.model.DynamicForm;
import af.asr.dynamicform.repository.DynamicFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DynamicFormServiceImpl  implements DynamicFormService{

    @Autowired
    private DynamicFormRepository dynamicFormRepository;


    @Override
    public DynamicForm save(DynamicForm dynamicForm) {
        return dynamicFormRepository.save(dynamicForm);
    }

    @Override
    public DynamicForm getOne(long id) {
        return dynamicFormRepository.getOne(id);
    }

    @Override
    public void delete(long id) {
        dynamicFormRepository.deleteById(id);
    }

    @Override
    public List<DynamicForm> findall() {
        return dynamicFormRepository.findAll();
    }

    @Override
    public DynamicForm findByName(String name) {
        return dynamicFormRepository.findByName(name);
    }

    @Override
    public DynamicForm findByType(String type) {
        return dynamicFormRepository.findByType(type);
    }
}
