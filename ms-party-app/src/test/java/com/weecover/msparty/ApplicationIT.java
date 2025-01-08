//package com.weecover.msparty;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.http.MediaType.APPLICATION_JSON;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//public class ApplicationIT {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    public void contextLoadsAndHealthCheckIsUp() throws Exception {
//        mockMvc.perform(get("/actuator/health").contentType(APPLICATION_JSON).accept(APPLICATION_JSON))
//               .andExpect(status().is(200))
//               .andExpect(jsonPath("$.status").value("UP"));
//    }
//}