package com.example.eschool;

import com.example.eschool.controllers.StudentController;
import com.example.eschool.mappers.StudentMapper;
import com.example.eschool.models.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(StudentController.class)
public class StudentControllerTests {
    @Autowired
    private MockMvc mvc;

    @Mock
    private StudentController controller;
    @Mock
    private StudentMapper studentMapper;




    @Test(groups={"unittest"})
    void checkNullObjectInsert() throws Exception {
        MockitoAnnotations.openMocks(this);
        Student student = new Student();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(student);
        this.mvc = MockMvcBuilders.standaloneSetup(controller).build();
        this.mvc.perform(post("/students/").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk());

    }
}
