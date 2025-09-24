package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class ItemControllerTest {
	@Autowired
	private MockMvc mocMvc;

	@Autowired
	private ObjectMapper objectMapper;
}
