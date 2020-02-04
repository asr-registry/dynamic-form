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
			"    \"properties\": {\n" +
			"      \"email\": {\n" +
			"        \"type\": \"string\",\n" +
			"        \"description\": \"email\",\n" +
			"        \"format\": \"email\"\n" +
			"      },\n" +
			"      \"password\": {\n" +
			"        \"type\": \"string\",\n" +
			"        \"description\": \"Password\"\n" +
			"      },\n" +
			"      \"rememberMe\": {\n" +
			"        \"type\": \"boolean\",\n" +
			"        \"default\": false,\n" +
			"        \"description\": \"Remember me\"\n" +
			"      },\n" +
			"        \"operatingSystem\": {\n" +
			"          \"type\": \"string\",\n" +
			"          \"oneOf\": [\n" +
			"            {\n" +
			"              \"enum\": [\n" +
			"                \"linux\"\n" +
			"              ],\n" +
			"              \"description\": \"GNU/Linux\"\n" +
			"            },\n" +
			"            {\n" +
			"              \"enum\": [\n" +
			"                \"osx\"\n" +
			"              ],\n" +
			"              \"description\": \"OSX\"\n" +
			"            },\n" +
			"            {\n" +
			"              \"enum\": [\n" +
			"                \"windows\"\n" +
			"              ],\n" +
			"              \"description\": \"Windows\"\n" +
			"            },\n" +
			"            {\n" +
			"              \"enum\": [\n" +
			"                \"other\"\n" +
			"              ],\n" +
			"              \"description\": \"Other\"\n" +
			"            }\n" +
			"          ],\n" +
			"          \"default\": \"other\"\n" +
			"        }\n" +
			"    },\n" +
			"    \"required\": [\"email\",\"password\",\"rememberMe\"],\n" +
			"     \"buttons\": [\n" +
			"           {\n" +
			"             \"id\": \"reset\",\n" +
			"             \"label\": \"Reset\"\n" +
			"           },\n" +
			"           {\n" +
			"             \"id\": \"custom_b\",\n" +
			"             \"label\": \"My custom button\",\n" +
			"             \"widget\": \"my_custom_button\" \n" +
			"           }\n" +
			"         ]\n" +
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