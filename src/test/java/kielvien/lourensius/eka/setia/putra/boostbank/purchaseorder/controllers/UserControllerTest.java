package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.constants.Constants;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.CreateUserRequest;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.CreateUserResponse;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.GetUserResponse;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.UpdateUserRequest;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.WebResponse;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class UserControllerTest {
	@Autowired
	private MockMvc mocMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Nested
	class createUserTest {

		private CreateUserRequest request;

		@BeforeEach
		void setup() {
			request = new CreateUserRequest();
			request.setFirstName("Kielvien");
			request.setLastName("Lourensius Eka Setia Putra");
			request.setEmail("kielvien12345@gmail.com");
			request.setPhone("085888888888");
		}

		@Test
		void successCreate() throws Exception {
			mocMvc.perform(post("/api/user/create").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isOk()).andDo(result -> {
						WebResponse<CreateUserResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.OK.getCode(), response.getStatusCode());
						assertEquals(Constants.statusCode.OK.getDesc(), response.getDesc());
						assertNotNull(response.getData());
						assertEquals("Kielvien", response.getData().getFirstName());
						assertEquals("Lourensius Eka Setia Putra", response.getData().getLastName());
						assertEquals("kielvien12345@gmail.com", response.getData().getEmail());
						assertEquals("085888888888", response.getData().getPhone());
					});
		}

		@Test
		void failFirstName() throws Exception {
			request.setFirstName("");
			mocMvc.perform(post("/api/user/create").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<CreateUserResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertNull(response.getData());
						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals("firstName: cannot be null or empty", response.getDesc());
					});

			request.setFirstName(null);
			mocMvc.perform(post("/api/user/create").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<CreateUserResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertNull(response.getData());
						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals("firstName: cannot be null or empty", response.getDesc());
					});
		}

		@Test
		void failLastName() throws Exception {
			request.setLastName("");
			mocMvc.perform(post("/api/user/create").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<CreateUserResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertNull(response.getData());
						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals("lastName: cannot be null or empty", response.getDesc());
					});

			request.setLastName(null);
			mocMvc.perform(post("/api/user/create").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<CreateUserResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertNull(response.getData());
						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals("lastName: cannot be null or empty", response.getDesc());
					});
		}

		@Test
		void failEmail() throws Exception {
			request.setEmail("");
			mocMvc.perform(post("/api/user/create").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<CreateUserResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertNull(response.getData());
						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertTrue(response.getDesc().contains("email: cannot be null or empty")
								|| response.getDesc().contains("email: pattern is invalid"));
					});

			request.setEmail(null);
			mocMvc.perform(post("/api/user/create").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<CreateUserResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertNull(response.getData());
						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertTrue(response.getDesc().contains("email: cannot be null or empty")
								|| response.getDesc().contains("email: pattern is invalid"));
					});

			request.setEmail("youremailishere.com");
			mocMvc.perform(post("/api/user/create").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<CreateUserResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertNull(response.getData());
						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals("email: pattern is invalid", response.getDesc());
					});
		}

		@Test
		void failPhone() throws Exception {
			request.setPhone("");
			mocMvc.perform(post("/api/user/create").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<CreateUserResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertNull(response.getData());
						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertTrue(response.getDesc().contains("phone: cannot be null or empty")
								|| response.getDesc().contains("phone: pattern is invalid"));
					});

			request.setPhone(null);
			mocMvc.perform(post("/api/user/create").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<CreateUserResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertNull(response.getData());
						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertTrue(response.getDesc().contains("phone: cannot be null or empty")
								|| response.getDesc().contains("phone: pattern is invalid"));
					});

			request.setPhone("12345");
			mocMvc.perform(post("/api/user/create").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<CreateUserResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertNull(response.getData());
						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals("phone: pattern is invalid", response.getDesc());
					});
		}
	}

	@Nested
	class getUserTest {

		@Test
		void successGet() throws Exception {
			mocMvc.perform(get("/api/user/finduser/13").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
					.andDo(result -> {
						WebResponse<GetUserResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.OK.getCode(), response.getStatusCode());
						assertEquals(Constants.statusCode.OK.getDesc(), response.getDesc());
						assertNotNull(response.getData());
						assertEquals("Kielvien", response.getData().getFirstName());
						assertEquals("Lourensius Eka Setia Putra", response.getData().getLastName());
						assertEquals("kielvien12345@gmail.com", response.getData().getEmail());
						assertEquals("085888888888", response.getData().getPhone());
					});
		}

		@Test
		void failNotFound() throws Exception {
			mocMvc.perform(get("/api/user/finduser/9999").accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isNotFound()).andDo(result -> {
						WebResponse<GetUserResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertNull(response.getData());
						assertEquals(Constants.statusCode.NOT_FOUND.getCode(), response.getStatusCode());
						assertEquals(Constants.statusCode.NOT_FOUND.getDesc(), response.getDesc());
					});
		}

		@Test
		void failFormat() throws Exception {
			mocMvc.perform(get("/api/user/finduser/abc").accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isBadRequest());
		}
	}

	@Nested
	class updateUserTest {

		private UpdateUserRequest request;

		@BeforeEach
		void setup() {
			request = new UpdateUserRequest();
			request.setFirstName("Kielvien Lourensius");
			request.setLastName("EkaSetiaPutra");
			request.setEmail("kielvien679@gmail.com");
			request.setPhone("085871321234");
		}

		@Test
		void successUpdate() throws Exception {
			mocMvc.perform(put("/api/user/update/14").contentType(MediaType.APPLICATION_JSON_VALUE)
					.accept(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpect(status().isOk()).andDo(result -> {
						WebResponse<GetUserResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.OK.getCode(), response.getStatusCode());
						assertEquals(Constants.statusCode.OK.getDesc(), response.getDesc());
						assertNotNull(response.getData());
						assertEquals("Kielvien Lourensius", response.getData().getFirstName());
						assertEquals("EkaSetiaPutra", response.getData().getLastName());
						assertEquals("kielvien679@gmail.com", response.getData().getEmail());
						assertEquals("085871321234", response.getData().getPhone());
					});
		}
		
		@Test
		void failNotFound() throws Exception {
			mocMvc.perform(put("/api/user/update/999").contentType(MediaType.APPLICATION_JSON_VALUE)
					.accept(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpect(status().isNotFound()).andDo(result -> {
						WebResponse<GetUserResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.NOT_FOUND.getCode(), response.getStatusCode());
						assertEquals(Constants.statusCode.NOT_FOUND.getDesc(), response.getDesc());
						assertNull(response.getData());
					});
		}
		
		@Test
		void failLastName() throws Exception {
			request.setLastName("");
			mocMvc.perform(put("/api/user/update/14").contentType(MediaType.APPLICATION_JSON_VALUE)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<CreateUserResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertNull(response.getData());
						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals("lastName: cannot be null or empty", response.getDesc());
					});

			request.setLastName(null);
			mocMvc.perform(put("/api/user/update/14").contentType(MediaType.APPLICATION_JSON_VALUE)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<CreateUserResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertNull(response.getData());
						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals("lastName: cannot be null or empty", response.getDesc());
					});
		}

		@Test
		void failEmail() throws Exception {
			request.setEmail("");
			mocMvc.perform(put("/api/user/update/14").contentType(MediaType.APPLICATION_JSON_VALUE)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<CreateUserResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertNull(response.getData());
						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertTrue(response.getDesc().contains("email: cannot be null or empty")
								|| response.getDesc().contains("email: pattern is invalid"));
					});

			request.setEmail(null);
			mocMvc.perform(put("/api/user/update/14").contentType(MediaType.APPLICATION_JSON_VALUE)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<CreateUserResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertNull(response.getData());
						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertTrue(response.getDesc().contains("email: cannot be null or empty")
								|| response.getDesc().contains("email: pattern is invalid"));
					});

			request.setEmail("youremailishere.com");
			mocMvc.perform(put("/api/user/update/14").contentType(MediaType.APPLICATION_JSON_VALUE)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<CreateUserResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertNull(response.getData());
						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals("email: pattern is invalid", response.getDesc());
					});
		}

		@Test
		void failPhone() throws Exception {
			request.setPhone("");
			mocMvc.perform(put("/api/user/update/14").contentType(MediaType.APPLICATION_JSON_VALUE)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<CreateUserResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertNull(response.getData());
						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertTrue(response.getDesc().contains("phone: cannot be null or empty")
								|| response.getDesc().contains("phone: pattern is invalid"));
					});

			request.setPhone(null);
			mocMvc.perform(put("/api/user/update/14").contentType(MediaType.APPLICATION_JSON_VALUE)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<CreateUserResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertNull(response.getData());
						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertTrue(response.getDesc().contains("phone: cannot be null or empty")
								|| response.getDesc().contains("phone: pattern is invalid"));
					});

			request.setPhone("12345");
			mocMvc.perform(put("/api/user/update/14").contentType(MediaType.APPLICATION_JSON_VALUE)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<CreateUserResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertNull(response.getData());
						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals("phone: pattern is invalid", response.getDesc());
					});
		}
	}
}
