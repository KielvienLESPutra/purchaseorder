package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.constants.Constants;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.constants.ConstantsDataTest;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.entities.Item;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.CreateItemRequest;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.CreateItemResponse;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.GetItemResponse;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.WebResponse;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
class ItemControllerTest {
	@Autowired
	private MockMvc mocMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockitoBean
	private ItemRepository itemRepository;

	@BeforeEach
	void setupParentTest() {
		when(itemRepository.findById(1)).thenReturn(Optional.of(ConstantsDataTest.ItemsMokito.singleItem()));
		when(itemRepository.findAll()).thenReturn(ConstantsDataTest.ItemsMokito.listItem());
	}

	@Nested
	class createItem {
		private CreateItemRequest request;

		@BeforeEach
		void setup() {
			Item itemDummy = new Item();
			itemDummy.setName("Barang a");
			itemDummy.setDescription("Barang a grade 1");
			itemDummy.setPrice(10000);
			itemDummy.setCost(5000);

			when(itemRepository.save(any(Item.class))).thenReturn(itemDummy);

			request = new CreateItemRequest();
			request.setName("Barang a");
			request.setDescription("Barang a grade 1");
			request.setPrice(10000);
			request.setCost(5000);
		}

		@Test
		void successCreate() throws Exception {
			when(itemRepository.save(any(Item.class))).then(inovacation -> {
				return inovacation.getArgument(0);
			});

			mocMvc.perform(post("/api/item/create").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isOk()).andDo(result -> {
						WebResponse<CreateItemResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.OK.getCode(), response.getStatusCode());
						assertEquals(Constants.statusCode.OK.getDesc(), response.getDesc());
						assertNotNull(response.getData());
						assertEquals("Barang a", response.getData().getName());
						assertEquals("Barang a grade 1", response.getData().getDescription());
						assertEquals(10000, response.getData().getPrice());
						assertEquals(5000, response.getData().getCost());
					});

			ArgumentCaptor<Item> argumentCaptor = ArgumentCaptor.forClass(Item.class);
			verify(itemRepository).save(argumentCaptor.capture());

			Item itemCreated = argumentCaptor.getValue();
			assertEquals(0, itemCreated.getId());
			assertEquals("Barang a", itemCreated.getName());
			assertEquals("Barang a grade 1", itemCreated.getDescription());
			assertEquals(10000, itemCreated.getPrice());
			assertEquals(5000, itemCreated.getCost());
		}

		@Test
		void failCreateName() throws Exception {
			request.setName(null);
			mocMvc.perform(post("/api/item/create").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<CreateItemResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals("name: cannot be null or empty", response.getDesc());
						assertNull(response.getData());
					});

			request.setName("");
			mocMvc.perform(post("/api/item/create").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<CreateItemResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals("name: cannot be null or empty", response.getDesc());
						assertNull(response.getData());
					});

			request.setName(ConstantsDataTest.EXCEED_CHARACTER);
			mocMvc.perform(post("/api/item/create").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<CreateItemResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals("name: character cannot more then 500", response.getDesc());
						assertNull(response.getData());
					});
		}

		@Test
		void failCreateDesc() throws Exception {
			request.setDescription(null);
			mocMvc.perform(post("/api/item/create").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<CreateItemResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals("description: cannot be null or empty", response.getDesc());
						assertNull(response.getData());
					});

			request.setDescription("");
			mocMvc.perform(post("/api/item/create").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<CreateItemResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals("description: cannot be null or empty", response.getDesc());
						assertNull(response.getData());
					});

			request.setDescription(ConstantsDataTest.EXCEED_CHARACTER);
			mocMvc.perform(post("/api/item/create").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<CreateItemResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals("description: character cannot more then 500", response.getDesc());
						assertNull(response.getData());
					});
		}

		@Test
		void failCreatePrice() throws Exception {
			request.setPrice(0);
			mocMvc.perform(post("/api/item/create").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<CreateItemResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals("price: cannot less then 1", response.getDesc());
						assertNull(response.getData());
					});
		}

		@Test
		void failCreateCost() throws Exception {
			request.setCost(0);
			mocMvc.perform(post("/api/item/create").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<CreateItemResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals("cost: cannot less then 1", response.getDesc());
						assertNull(response.getData());
					});
		}
	}

	@Nested
	class getItemTest {

		@Test
		void successGet() throws Exception {
			mocMvc.perform(get("/api/item/finditem/1").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
					.andDo(result -> {
						WebResponse<GetItemResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.OK.getCode(), response.getStatusCode());
						assertEquals(Constants.statusCode.OK.getDesc(), response.getDesc());
						assertNotNull(response.getData());
						assertEquals(ConstantsDataTest.ItemsMokito.singleItem().getName(),
								response.getData().getName());
						assertEquals(ConstantsDataTest.ItemsMokito.singleItem().getDescription(),
								response.getData().getDescription());
						assertEquals(ConstantsDataTest.ItemsMokito.singleItem().getPrice(),
								response.getData().getPrice());
						assertEquals(ConstantsDataTest.ItemsMokito.singleItem().getCost(),
								response.getData().getCost());
					});

			verify(itemRepository).findById(1);
		}

		@Test
		void failGetNotFound() throws Exception {
			mocMvc.perform(get("/api/item/finditem/9999").accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isNotFound()).andDo(result -> {
						WebResponse<GetItemResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertNull(response.getData());
						assertEquals(Constants.statusCode.NOT_FOUND.getCode(), response.getStatusCode());
						assertEquals(Constants.statusCode.NOT_FOUND.getDesc(), response.getDesc());
					});
		}

		@Test
		void failGetFormat() throws Exception {
			mocMvc.perform(get("/api/item/finditem/abc").accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isBadRequest());
		}
	}

	@Nested
	class updateItem {
		private CreateItemRequest request;

		@BeforeEach
		void setup() {
			request = new CreateItemRequest();
			request.setName("Barang b");
			request.setDescription("Barang b grade 3");
			request.setPrice(50000);
			request.setCost(1000);
		}

		@Test
		void successUpdate() throws Exception {
			when(itemRepository.save(any(Item.class))).thenAnswer(invocationEvent -> {
				return invocationEvent.getArgument(0);
			});

			mocMvc.perform(put("/api/item/update/1").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isOk()).andDo(result -> {
						WebResponse<CreateItemResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.OK.getCode(), response.getStatusCode());
						assertEquals(Constants.statusCode.OK.getDesc(), response.getDesc());
						assertNotNull(response.getData());
						assertEquals("Barang b", response.getData().getName());
						assertEquals("Barang b grade 3", response.getData().getDescription());
						assertEquals(50000, response.getData().getPrice());
						assertEquals(1000, response.getData().getCost());
					});

			mocMvc.perform(get("/api/item/finditem/1").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
					.andDo(result -> {
						WebResponse<GetItemResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.OK.getCode(), response.getStatusCode());
						assertEquals(Constants.statusCode.OK.getDesc(), response.getDesc());
						assertNotNull(response.getData());
						assertEquals("Barang b", response.getData().getName());
						assertEquals("Barang b grade 3", response.getData().getDescription());
						assertEquals(50000, response.getData().getPrice());
						assertEquals(1000, response.getData().getCost());
					});

			ArgumentCaptor<Item> argumentCaptor = ArgumentCaptor.forClass(Item.class);
			verify(itemRepository).save(argumentCaptor.capture());

			Item itemUpdated = argumentCaptor.getValue();
			assertEquals(1, itemUpdated.getId());
			assertEquals("Barang b", itemUpdated.getName());
			assertEquals("Barang b grade 3", itemUpdated.getDescription());
			assertEquals(50000, itemUpdated.getPrice());
			assertEquals(1000, itemUpdated.getCost());
		}

		@Test
		void failUpdateName() throws Exception {
			request.setName(null);
			mocMvc.perform(put("/api/item/update/1").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<CreateItemResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals("name: cannot be null or empty", response.getDesc());
						assertNull(response.getData());
					});

			request.setName("");
			mocMvc.perform(put("/api/item/update/1").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<CreateItemResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals("name: cannot be null or empty", response.getDesc());
						assertNull(response.getData());
					});

			request.setName(ConstantsDataTest.EXCEED_CHARACTER);
			mocMvc.perform(put("/api/item/update/1").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<CreateItemResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals("name: character cannot more then 500", response.getDesc());
						assertNull(response.getData());
					});
		}

		@Test
		void failUpdateDesc() throws Exception {
			request.setDescription(null);
			mocMvc.perform(put("/api/item/update/1").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<CreateItemResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals("description: cannot be null or empty", response.getDesc());
						assertNull(response.getData());
					});

			request.setDescription("");
			mocMvc.perform(put("/api/item/update/1").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<CreateItemResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals("description: cannot be null or empty", response.getDesc());
						assertNull(response.getData());
					});

			request.setDescription(ConstantsDataTest.EXCEED_CHARACTER);
			mocMvc.perform(put("/api/item/update/1").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<CreateItemResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals("description: character cannot more then 500", response.getDesc());
						assertNull(response.getData());
					});
		}

		@Test
		void failUpdatePrice() throws Exception {
			request.setPrice(0);
			mocMvc.perform(put("/api/item/update/1").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<CreateItemResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals("price: cannot less then 1", response.getDesc());
						assertNull(response.getData());
					});
		}

		@Test
		void failUpdateCost() throws Exception {
			request.setCost(0);
			mocMvc.perform(put("/api/item/update/1").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<CreateItemResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals("cost: cannot less then 1", response.getDesc());
						assertNull(response.getData());
					});
		}

		@Test
		void failUpdateNotfound() throws Exception {
			mocMvc.perform(put("/api/item/update/999").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isNotFound()).andDo(result -> {
						WebResponse<CreateItemResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.NOT_FOUND.getCode(), response.getStatusCode());
						assertEquals(Constants.statusCode.NOT_FOUND.getDesc(), response.getDesc());
						assertNull(response.getData());
					});
		}
	}

	@Nested
	class deleteItemTest {
		
		@Test
		void successDelete() throws Exception {
			doNothing().when(itemRepository).delete(any(Item.class));

			mocMvc.perform(delete("/api/item/delete/1").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
					.andDo(result -> {
						WebResponse<Integer> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.OK.getCode(), response.getStatusCode());
						assertEquals(Constants.statusCode.OK.getDesc(), response.getDesc());
						assertNotNull(response.getData());
						assertEquals(1, response.getData());
					});

			ArgumentCaptor<Item> argumentCaptor = ArgumentCaptor.forClass(Item.class);
			verify(itemRepository).delete(argumentCaptor.capture());

			Item itemDelete = argumentCaptor.getValue();
			assertEquals(1, itemDelete.getId());
		}

		@Test
		void failDeleteNotFound() throws Exception {
			mocMvc.perform(delete("/api/item/delete/9999").accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isNotFound()).andDo(result -> {
						WebResponse<Integer> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertNull(response.getData());
						assertEquals(Constants.statusCode.NOT_FOUND.getCode(), response.getStatusCode());
						assertEquals(Constants.statusCode.NOT_FOUND.getDesc(), response.getDesc());
					});
		}

		@Test
		void failDeleteFormat() throws Exception {
			mocMvc.perform(delete("/api/item/delete/abc").accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isBadRequest());
		}
	}
}
