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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.constants.Constants;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.constants.ConstantsDataTest;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.entities.PurchaseOrderHeader;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.CreatePurchaseOrderRequest;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.CreatePurchaseOrderResponse;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.GetPurchaseOrderResponse;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.PurchaseOderDetailModel;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.UpdatePurchaseOrderRequest;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.UpdatePurchaseOrderResponse;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.WebResponse;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.repository.ItemRepository;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.repository.PurchaseOrderHeaderRepository;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
class PurchaseOrderControllerTest {

	@Autowired
	private MockMvc mocMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockitoBean
	private PurchaseOrderHeaderRepository orderHeaderRepository;

	@MockitoBean
	private ItemRepository itemRepository;

	@BeforeEach
	void setupParentTest() {
		when(itemRepository.findById(1)).thenReturn(Optional.of(ConstantsDataTest.ItemsMokito.singleItem(1)));
		when(itemRepository.findById(2)).thenReturn(Optional.of(ConstantsDataTest.ItemsMokito.singleItem(2)));
		when(itemRepository.findById(3)).thenReturn(Optional.of(ConstantsDataTest.ItemsMokito.singleItem(3)));
		when(itemRepository.findById(4)).thenReturn(Optional.of(ConstantsDataTest.ItemsMokito.singleItem(4)));
		when(itemRepository.findById(5)).thenReturn(Optional.of(ConstantsDataTest.ItemsMokito.singleItem(5)));
		when(itemRepository.findById(10)).thenReturn(Optional.of(ConstantsDataTest.ItemsMokito.singleItem(10)));

		when(orderHeaderRepository.findById(1))
				.thenReturn(Optional.of(ConstantsDataTest.PurchaseOrderMockito.singleTransaction()));
		when(orderHeaderRepository.findAll()).thenReturn(ConstantsDataTest.PurchaseOrderMockito.listTransaction());
	}

	@Nested
	class createPurchaseOrder {

		private CreatePurchaseOrderRequest request;

		@BeforeEach
		void setup() {
			request = new CreatePurchaseOrderRequest();
			request.setDescription("Transaction data 1");

			List<PurchaseOderDetailModel> listOrders = new ArrayList<>();
			PurchaseOderDetailModel order = new PurchaseOderDetailModel();
			order.setItemId(1);
			order.setItemQty(10);
			listOrders.add(order);

			PurchaseOderDetailModel order2 = new PurchaseOderDetailModel();
			order2.setItemId(10);
			order2.setItemQty(1);
			listOrders.add(order2);

			request.setPurchaseOrderDetails(listOrders);
		}

		@Test
		void successCreate() throws Exception {
			when(orderHeaderRepository.save(any(PurchaseOrderHeader.class))).then(invocation -> {
				return invocation.getArgument(0);
			});

			mocMvc.perform(post("/api/po/create").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isOk()).andDo(result -> {
						WebResponse<CreatePurchaseOrderResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.OK.getCode(), response.getStatusCode());
						assertEquals(Constants.statusCode.OK.getDesc(), response.getDesc());
						assertNotNull(response.getData());
						assertEquals("Transaction data 1", response.getData().getDescription());
						assertEquals(0, response.getData().getId());
						assertEquals(2, response.getData().getPurchaseOrderDetails().size());
						assertEquals(5500, response.getData().getTotalCost());
						assertEquals(11000, response.getData().getTotalPrice());
					});

			ArgumentCaptor<PurchaseOrderHeader> argumentCaptor = ArgumentCaptor.forClass(PurchaseOrderHeader.class);
			verify(orderHeaderRepository).save(argumentCaptor.capture());

			PurchaseOrderHeader purcasedOrderCreated = argumentCaptor.getValue();
			assertEquals(0, purcasedOrderCreated.getId());
			assertEquals("Transaction data 1", purcasedOrderCreated.getDescription());
			assertEquals(2, purcasedOrderCreated.getPods().size());
		}

		@Test
		void failCreateDescription() throws Exception {
			request.setDescription(null);
			mocMvc.perform(post("/api/po/create").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<CreatePurchaseOrderResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals("description: cannot be null or empty", response.getDesc());
						assertNull(response.getData());
					});

			request.setDescription("");
			mocMvc.perform(post("/api/po/create").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<CreatePurchaseOrderResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals("description: cannot be null or empty", response.getDesc());
						assertNull(response.getData());
					});

			request.setDescription(ConstantsDataTest.EXCEED_CHARACTER);
			mocMvc.perform(post("/api/po/create").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<CreatePurchaseOrderResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals("description: character cannot more then 500", response.getDesc());
						assertNull(response.getData());
					});
		}

		@Test
		void failCreatePurchaseDetail() throws Exception {
			request.setPurchaseOrderDetails(null);
			mocMvc.perform(post("/api/po/create").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<CreatePurchaseOrderResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals("purchaseOrderDetails: cannot be null", response.getDesc());
						assertNull(response.getData());
					});

			request.setPurchaseOrderDetails(new ArrayList<PurchaseOderDetailModel>());
			mocMvc.perform(post("/api/po/create").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<CreatePurchaseOrderResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals("purchaseOrderDetails: purchase order detail must be at least 1",
								response.getDesc());
						assertNull(response.getData());
					});

			PurchaseOderDetailModel order3 = new PurchaseOderDetailModel();
			order3.setItemId(1);
			order3.setItemQty(0);
			request.getPurchaseOrderDetails().add(order3);
			mocMvc.perform(post("/api/po/create").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<CreatePurchaseOrderResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals("purchaseOrderDetails[0].itemQty: cannot less then 1", response.getDesc());
						assertNull(response.getData());
					});
		}

		@Test
		void failCreateNotFound() throws Exception {
			PurchaseOderDetailModel order3 = new PurchaseOderDetailModel();
			order3.setItemId(999);
			order3.setItemQty(1);
			request.getPurchaseOrderDetails().add(order3);
			mocMvc.perform(post("/api/po/create").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isNotFound()).andDo(result -> {
						WebResponse<CreatePurchaseOrderResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.NOT_FOUND.getCode(), response.getStatusCode());
						assertEquals(Constants.statusCode.REFERENCE_NOT_FOUND.getDesc(), response.getDesc());
						assertNull(response.getData());
					});
		}
	}

	@Nested
	class getPurchaseOrder {

		@Test
		void successGet() throws Exception {
			mocMvc.perform(get("/api/po/findPurchaseOrder/1").accept(MediaType.APPLICATION_JSON))
					.andExpectAll(status().isOk()).andDo(result -> {
						WebResponse<GetPurchaseOrderResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.OK.getCode(), response.getStatusCode());
						assertEquals(Constants.statusCode.OK.getDesc(), response.getDesc());
						assertNotNull(response.getData());
						assertEquals(ConstantsDataTest.PurchaseOrderMockito.singleTransaction().getDescription(),
								response.getData().getDescription());
						assertEquals(1, response.getData().getId());
						assertEquals(5, response.getData().getPurchaseOrderDetails().size());
						assertEquals(15000, response.getData().getTotalCost());
						assertEquals(7500, response.getData().getTotalPrice());
					});

			verify(orderHeaderRepository).findById(1);
		}

		@Test
		void failGetNotFound() throws Exception {
			mocMvc.perform(get("/api/po/findPurchaseOrder/9999").accept(MediaType.APPLICATION_JSON))
					.andExpectAll(status().isNotFound()).andDo(result -> {
						WebResponse<GetPurchaseOrderResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.NOT_FOUND.getCode(), response.getStatusCode());
						assertEquals(Constants.statusCode.NOT_FOUND.getDesc(), response.getDesc());
						assertNull(response.getData());
					});
		}

		@Test
		void failGetFromat() throws Exception {
			mocMvc.perform(get("/api/po/findPurchaseOrder/abc").accept(MediaType.APPLICATION_JSON))
					.andExpectAll(status().isBadRequest());
		}
	}

	@Nested
	class updatePurchaseOrder {

		private UpdatePurchaseOrderRequest request;

		@BeforeEach
		void setup() {
			request = new UpdatePurchaseOrderRequest();
			request.setDescription("Transaction data update 1");

			List<PurchaseOderDetailModel> listOrders = new ArrayList<>();
			PurchaseOderDetailModel order = new PurchaseOderDetailModel();
			order.setId(1);
			order.setItemId(1);
			order.setItemQty(50);
			listOrders.add(order);

			PurchaseOderDetailModel order2 = new PurchaseOderDetailModel();
			order2.setId(2);
			order2.setItemId(2);
			order2.setItemQty(50);
			listOrders.add(order2);

			request.setPurchaseOrderDetails(listOrders);
		}

		@Test
		void successUpdate() throws Exception {
			when(orderHeaderRepository.save(any(PurchaseOrderHeader.class))).then(invocation -> {
				return invocation.getArgument(0);
			});

			mocMvc.perform(put("/api/po/updatePurchaseOrder/1").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isOk()).andDo(result -> {
						WebResponse<UpdatePurchaseOrderResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.OK.getCode(), response.getStatusCode());
						assertEquals(Constants.statusCode.OK.getDesc(), response.getDesc());
						assertNotNull(response.getData());
						assertEquals(5, response.getData().getPurchaseOrderDetails().size());
						assertEquals(50000, response.getData().getTotalCost());
						assertEquals(100000, response.getData().getTotalPrice());
						assertEquals("Transaction data update 1", response.getData().getDescription());
					});

			mocMvc.perform(get("/api/po/findPurchaseOrder/1").accept(MediaType.APPLICATION_JSON))
					.andExpectAll(status().isOk()).andDo(result -> {
						WebResponse<GetPurchaseOrderResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.OK.getCode(), response.getStatusCode());
						assertEquals(Constants.statusCode.OK.getDesc(), response.getDesc());
						assertNotNull(response.getData());
						assertEquals(5, response.getData().getPurchaseOrderDetails().size());
						assertEquals(50000, response.getData().getTotalCost());
						assertEquals(100000, response.getData().getTotalPrice());
					});

			ArgumentCaptor<PurchaseOrderHeader> argumentCaptor = ArgumentCaptor.forClass(PurchaseOrderHeader.class);
			verify(orderHeaderRepository).save(argumentCaptor.capture());

			PurchaseOrderHeader orderSaved = argumentCaptor.getValue();
			assertEquals(1, orderSaved.getId());
			assertEquals(5, orderSaved.getPods().size());
			assertEquals(50000, orderSaved.getTotalCost());
			assertEquals(100000, orderSaved.getTotalPrice());
		}

		@Test
		void failUpdateDescription() throws Exception {
			request.setDescription(null);
			mocMvc.perform(put("/api/po/updatePurchaseOrder/1").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<UpdatePurchaseOrderResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals("description: cannot be null or empty", response.getDesc());
						assertNull(response.getData());
					});

			request.setDescription("");
			mocMvc.perform(put("/api/po/updatePurchaseOrder/1").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<UpdatePurchaseOrderResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals("description: cannot be null or empty", response.getDesc());
						assertNull(response.getData());
					});

			request.setDescription(ConstantsDataTest.EXCEED_CHARACTER);
			mocMvc.perform(put("/api/po/updatePurchaseOrder/1").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<UpdatePurchaseOrderResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals("description: character cannot more then 500", response.getDesc());
						assertNull(response.getData());
					});
		}

		@Test
		void failUpdatePurchaseDetail() throws Exception {
			request.setPurchaseOrderDetails(null);
			mocMvc.perform(put("/api/po/updatePurchaseOrder/1").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<UpdatePurchaseOrderResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals("purchaseOrderDetails: cannot be null", response.getDesc());
						assertNull(response.getData());
					});

			request.setPurchaseOrderDetails(new ArrayList<PurchaseOderDetailModel>());
			mocMvc.perform(put("/api/po/updatePurchaseOrder/1").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<UpdatePurchaseOrderResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals("purchaseOrderDetails: purchase order detail must be at least 1",
								response.getDesc());
						assertNull(response.getData());
					});

			request.getPurchaseOrderDetails().clear();
			PurchaseOderDetailModel order3 = new PurchaseOderDetailModel();
			order3.setId(1);
			order3.setItemId(1);
			order3.setItemQty(0);
			request.getPurchaseOrderDetails().add(order3);
			mocMvc.perform(put("/api/po/updatePurchaseOrder/1").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<UpdatePurchaseOrderResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals("purchaseOrderDetails[0].itemQty: cannot less then 1", response.getDesc());
						assertNull(response.getData());
					});

			request.getPurchaseOrderDetails().clear();
			PurchaseOderDetailModel order4 = new PurchaseOderDetailModel();
			order4.setId(null);
			order4.setItemId(1);
			order4.setItemQty(1);
			request.getPurchaseOrderDetails().add(order4);
			mocMvc.perform(put("/api/po//updatePurchaseOrder/1").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<UpdatePurchaseOrderResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals(Constants.statusCode.REFERENCE_NULL.getDesc(), response.getDesc());
						assertNull(response.getData());
					});

			for (int i = 1; i <= 8; i++) {
				PurchaseOderDetailModel order = new PurchaseOderDetailModel();
				order.setId(999 - i);
				order.setItemId(i);
				order.setItemQty(i);
				request.getPurchaseOrderDetails().add(order);
			}
			mocMvc.perform(put("/api/po/updatePurchaseOrder/1").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<UpdatePurchaseOrderResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals(Constants.statusCode.BAD_REQUEST.getDesc(), response.getDesc());
						assertNull(response.getData());
					});

			request.getPurchaseOrderDetails().clear();
			PurchaseOderDetailModel order5 = new PurchaseOderDetailModel();
			order5.setId(999);
			order5.setItemId(1);
			order5.setItemQty(1);
			request.getPurchaseOrderDetails().add(order5);
			mocMvc.perform(put("/api/po/updatePurchaseOrder/1").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<UpdatePurchaseOrderResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals(Constants.statusCode.REFERENCE_NOT_FOUND.getDesc(), response.getDesc());
						assertNull(response.getData());
					});
		}

		@Test
		void failUpdateNotFound() throws Exception {
			PurchaseOderDetailModel order3 = new PurchaseOderDetailModel();
			order3.setId(1);
			order3.setItemId(999);
			order3.setItemQty(1);
			request.getPurchaseOrderDetails().add(order3);
			mocMvc.perform(put("/api/po/updatePurchaseOrder/999").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isNotFound()).andDo(result -> {
						WebResponse<UpdatePurchaseOrderResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.NOT_FOUND.getCode(), response.getStatusCode());
						assertEquals(Constants.statusCode.NOT_FOUND.getDesc(), response.getDesc());
						assertNull(response.getData());
					});
		}
	}

	@Nested
	class deletePurchaseOrder {

		@Test
		void successDelete() throws Exception {
			doNothing().when(orderHeaderRepository).delete(any(PurchaseOrderHeader.class));

			mocMvc.perform(delete("/api/po/deletePurchaseOrder/1").accept(MediaType.APPLICATION_JSON))
					.andExpectAll(status().isOk()).andDo(result -> {
						WebResponse<Integer> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.OK.getCode(), response.getStatusCode());
						assertEquals(Constants.statusCode.OK.getDesc(), response.getDesc());
						assertNotNull(response.getData());
						assertEquals(1, response.getData());
					});

			ArgumentCaptor<PurchaseOrderHeader> argumentCaptor = ArgumentCaptor.forClass(PurchaseOrderHeader.class);
			verify(orderHeaderRepository).delete(argumentCaptor.capture());

			PurchaseOrderHeader deleteTransaction = argumentCaptor.getValue();
			assertEquals(1, deleteTransaction.getId());
		}

		@Test
		void failDeleteNotFound() throws Exception {
			mocMvc.perform(delete("/api/po/deletePurchaseOrder/9999").accept(MediaType.APPLICATION_JSON))
					.andExpectAll(status().isNotFound()).andDo(result -> {
						WebResponse<Integer> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.NOT_FOUND.getCode(), response.getStatusCode());
						assertEquals(Constants.statusCode.NOT_FOUND.getDesc(), response.getDesc());
						assertNull(response.getData());
					});
		}

		@Test
		void failDeleteFromat() throws Exception {
			mocMvc.perform(delete("/api/po/deletePurchaseOrder/abc").accept(MediaType.APPLICATION_JSON))
					.andExpectAll(status().isBadRequest());
		}
	}

	@Nested
	class GetAllPurchaseOrder {
		private Pageable pageable;
		private Pageable pageableNull;

		@BeforeEach
		void setup() {
			pageable = PageRequest.of(0, 10);
			Page<PurchaseOrderHeader> pagePurchaseOrder = new PageImpl<>(
					ConstantsDataTest.PurchaseOrderMockito.listTransaction(), pageable,
					ConstantsDataTest.PurchaseOrderMockito.listTransaction().size());
			when(orderHeaderRepository.findAll(pageable)).thenReturn(pagePurchaseOrder);

			pageableNull = PageRequest.of(2, 50);
			Page<PurchaseOrderHeader> pagePurchaseOrderNull = new PageImpl<>(Collections.emptyList(), pageableNull,
					ConstantsDataTest.PurchaseOrderMockito.listTransaction().size());
			when(orderHeaderRepository.findAll(pageableNull)).thenReturn(pagePurchaseOrderNull);
		}

		@Test
		void getAllPurchaseOrderDefault() throws Exception {
			mocMvc.perform(get("/api/po/findPurchaseOrder").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
					.andDo(result -> {
						WebResponse<List<GetPurchaseOrderResponse>> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.OK.getCode(), response.getStatusCode());
						assertEquals(Constants.statusCode.OK.getDesc(), response.getDesc());
						assertNotNull(response.getData());
						assertEquals(10, response.getData().size());
					});

			verify(orderHeaderRepository).findAll(pageable);
		}

		@Test
		void getAllPurchaseOrderDefaultPage() throws Exception {

			mocMvc.perform(get("/api/po/findPurchaseOrder").accept(MediaType.APPLICATION_JSON).param("pageSize", "10"))
					.andExpect(status().isOk()).andDo(result -> {
						WebResponse<List<GetPurchaseOrderResponse>> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.OK.getCode(), response.getStatusCode());
						assertEquals(Constants.statusCode.OK.getDesc(), response.getDesc());
						assertNotNull(response.getData());
						assertEquals(10, response.getData().size());
					});

			verify(orderHeaderRepository).findAll(pageable);
		}

		@Test
		void getAllPurchaseOrderDefaultTotalSize() throws Exception {

			mocMvc.perform(get("/api/po/findPurchaseOrder").accept(MediaType.APPLICATION_JSON).param("page", "0"))
					.andExpect(status().isOk()).andDo(result -> {
						WebResponse<List<GetPurchaseOrderResponse>> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.OK.getCode(), response.getStatusCode());
						assertEquals(Constants.statusCode.OK.getDesc(), response.getDesc());
						assertNotNull(response.getData());
						assertEquals(10, response.getData().size());
					});

			verify(orderHeaderRepository).findAll(pageable);
		}

		@Test
		void getAllPurchaseOrderNull() throws Exception {

			mocMvc.perform(get("/api/po/findPurchaseOrder").accept(MediaType.APPLICATION_JSON).param("page", "2")
					.param("pageSize", "50")).andExpect(status().isOk()).andDo(result -> {
						WebResponse<List<GetPurchaseOrderResponse>> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.OK.getCode(), response.getStatusCode());
						assertEquals(Constants.statusCode.OK.getDesc(), response.getDesc());
						assertEquals(0, response.getData().size());
					});

			verify(orderHeaderRepository).findAll(pageableNull);
		}
	}
}
