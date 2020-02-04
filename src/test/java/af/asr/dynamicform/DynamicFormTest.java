package af.asr.dynamicform;

import af.asr.dynamicform.model.DynamicForm;
import af.asr.dynamicform.repository.DynamicFormRepository;
import af.asr.dynamicform.service.DynamicFormService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DynamicFormApplication.class)
public class DynamicFormTest {

	@Autowired
	private DynamicFormService dynamicFormService;

	@MockBean
	private DynamicFormRepository repository;

	private  final static  String SCHEMA = "{\n" +
			"  \"title\": \"Otherschema\",\n" +
			"  \"fieldsets\": [\n" +
			"    {\n" +
			"      \"fields\": [\n" +
			"        \"title\",\n" +
			"        \"description\"\n" +
			"      ],\n" +
			"      \"id\": \"default\",\n" +
			"      \"title\": \"Default\"\n" +
			"    },\n" +
			"    {\n" +
			"      \"fields\": [\n" +
			"        \"author\",\n" +
			"        \"language\"\n" +
			"      ],\n" +
			"      \"id\": \"settings\",\n" +
			"      \"title\": \"Settings\"\n" +
			"    }\n" +
			"  ],\n" +
			"  \"properties\": {\n" +
			"    \"description\": {\n" +
			"      \"description\": \"Short description\",\n" +
			"      \"minLength\": 0,\n" +
			"      \"title\": \"Summary\",\n" +
			"      \"type\": \"string\",\n" +
			"      \"widget\": {\n" +
			"        \"id\": \"textarea\"\n" +
			"      }\n" +
			"    },\n" +
			"    \"title\": {\n" +
			"      \"description\": \"\",\n" +
			"      \"title\": \"Title\",\n" +
			"      \"type\": \"string\",\n" +
			"      \"widget\": {\n" +
			"        \"id\": \"string\"\n" +
			"      }\n" +
			"    },\n" +
			"    \"author\": {\n" +
			"      \"description\": \"\",\n" +
			"      \"title\": \"Author\",\n" +
			"      \"type\": \"string\",\n" +
			"      \"widget\": {\n" +
			"        \"id\": \"string\"\n" +
			"      }\n" +
			"    },\n" +
			"    \"language\": {\n" +
			"      \"description\": \"\",\n" +
			"      \"oneOf\": [\n" +
			"        {\n" +
			"          \"enum\": [\n" +
			"            \"es\"\n" +
			"          ],\n" +
			"          \"description\": \"Spanish\"\n" +
			"        },\n" +
			"        {\n" +
			"          \"enum\": [\n" +
			"            \"fr\"\n" +
			"          ],\n" +
			"          \"description\": \"French\"\n" +
			"        }\n" +
			"      ],\n" +
			"      \"title\": \"Language\",\n" +
			"      \"type\": \"string\",\n" +
			"      \"widget\": {\n" +
			"        \"id\": \"select\"\n" +
			"      }\n" +
			"    }\n" +
			"  },\n" +
			"  \"required\": [\n" +
			"    \"title\"\n" +
			"  ],\n" +
			"  \"type\": \"object\",\n" +
			"  \"widget\": {\n" +
			"    \"id\": \"object\"\n" +
			"  }\n" +
			"}";

	@Before
	public void setup ()
	{
		DynamicForm dynamicForm = DynamicForm.builder().name("salary").type("m41").schema(SCHEMA).build();
		dynamicFormService.save(dynamicForm);
	}

	@Test
	public void saveDynamicFormType() {

		Mockito.when(repository.save(ArgumentMatchers.any(DynamicForm.class))).thenReturn(new DynamicForm());
		DynamicForm dynamicForm = DynamicForm.builder().name("payment").type("m16").schema(SCHEMA).build();
		assertTrue(dynamicFormService.save(dynamicForm) !=null );
	}


//	@Test
	public void getOneTest() {

		DynamicForm dynamicForm = dynamicFormService.getOne(1);
		System.out.println("Schema>"+ dynamicForm.getSchema());
		assertTrue(dynamicForm !=null );
	}


}