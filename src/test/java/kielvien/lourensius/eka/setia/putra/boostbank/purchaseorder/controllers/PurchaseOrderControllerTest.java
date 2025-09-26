package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

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
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.constants.ConstantsTest;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.CreatePurchaseOrderRequest;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.CreatePurchaseOrderResponse;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.GetPurchaseOrderResponse;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.PurchaseOderDetailModel;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.UpdatePurchaseOrderRequest;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.UpdatePurchaseOrderResponse;
import kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.models.WebResponse;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class PurchaseOrderControllerTest {

	@Autowired
	private MockMvc mocMvc;

	@Autowired
	private ObjectMapper objectMapper;

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
			mocMvc.perform(post("/api/po/create").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isOk()).andDo(result -> {
						WebResponse<CreatePurchaseOrderResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.OK.getCode(), response.getStatusCode());
						assertEquals(Constants.statusCode.OK.getDesc(), response.getDesc());
						assertNotNull(response.getData());
						assertEquals(2, response.getData().getPurchaseOrderDetails().size());
						assertEquals(55000, response.getData().getTotalCost());
						assertEquals(110000, response.getData().getTotalPrice());
					});
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

			request.setDescription(ConstantsTest.exceedString);
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
			mocMvc.perform(get("/api/po/findPurchaseOrder/10").accept(MediaType.APPLICATION_JSON))
					.andExpectAll(status().isOk()).andDo(result -> {
						WebResponse<GetPurchaseOrderResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.OK.getCode(), response.getStatusCode());
						assertEquals(Constants.statusCode.OK.getDesc(), response.getDesc());
						assertNotNull(response.getData());
						assertEquals(2, response.getData().getPurchaseOrderDetails().size());
						assertEquals(55000, response.getData().getTotalCost());
						assertEquals(110000, response.getData().getTotalPrice());
					});
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
			order.setId(14);
			order.setItemId(1);
			order.setItemQty(5);
			listOrders.add(order);

			PurchaseOderDetailModel order2 = new PurchaseOderDetailModel();
			order2.setId(15);
			order2.setItemId(2);
			order2.setItemQty(5);
			listOrders.add(order2);

			request.setPurchaseOrderDetails(listOrders);
		}

		@Test
		void successUpdate() throws Exception {
			mocMvc.perform(put("/api/po/updatePurchaseOrder/9").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isOk()).andDo(result -> {
						WebResponse<UpdatePurchaseOrderResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.OK.getCode(), response.getStatusCode());
						assertEquals(Constants.statusCode.OK.getDesc(), response.getDesc());
						assertNotNull(response.getData());
						assertEquals(2, response.getData().getPurchaseOrderDetails().size());
						assertEquals(30000, response.getData().getTotalCost());
						assertEquals(300000, response.getData().getTotalPrice());
						assertEquals("Transaction data update 1", response.getData().getDescription());
					});
		}

		@Test
		void failUpdateDescription() throws Exception {
			request.setDescription(null);
			mocMvc.perform(put("/api/po/updatePurchaseOrder/9").accept(MediaType.APPLICATION_JSON)
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
			mocMvc.perform(put("/api/po/updatePurchaseOrder/9").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<UpdatePurchaseOrderResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals("description: cannot be null or empty", response.getDesc());
						assertNull(response.getData());
					});

			request.setDescription(ConstantsTest.exceedString);
			mocMvc.perform(put("/api/po/updatePurchaseOrder/9").accept(MediaType.APPLICATION_JSON)
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
			mocMvc.perform(put("/api/po/updatePurchaseOrder/9").accept(MediaType.APPLICATION_JSON)
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
			mocMvc.perform(put("/api/po/updatePurchaseOrder/9").accept(MediaType.APPLICATION_JSON)
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
			mocMvc.perform(put("/api/po/updatePurchaseOrder/9").accept(MediaType.APPLICATION_JSON)
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
			mocMvc.perform(put("/api/po//updatePurchaseOrder/9").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
					.andExpectAll(status().isBadRequest()).andDo(result -> {
						WebResponse<UpdatePurchaseOrderResponse> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.BAD_REQUEST.getCode(), response.getStatusCode());
						assertEquals(Constants.statusCode.REFERENCE_NULL.getDesc(), response.getDesc());
						assertNull(response.getData());
					});

			request.getPurchaseOrderDetails().clear();
			PurchaseOderDetailModel order5 = new PurchaseOderDetailModel();
			order5.setId(997);
			order5.setItemId(1);
			order5.setItemQty(1);
			request.getPurchaseOrderDetails().add(order5);

			PurchaseOderDetailModel order6 = new PurchaseOderDetailModel();
			order6.setId(998);
			order6.setItemId(5);
			order6.setItemQty(1);
			request.getPurchaseOrderDetails().add(order6);

			PurchaseOderDetailModel order7 = new PurchaseOderDetailModel();
			order7.setId(999);
			order7.setItemId(10);
			order7.setItemQty(1);
			request.getPurchaseOrderDetails().add(order7);
			mocMvc.perform(put("/api/po/updatePurchaseOrder/9").accept(MediaType.APPLICATION_JSON)
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
			PurchaseOderDetailModel order8 = new PurchaseOderDetailModel();
			order8.setId(999);
			order8.setItemId(1);
			order8.setItemQty(1);
			request.getPurchaseOrderDetails().add(order8);
			mocMvc.perform(put("/api/po/updatePurchaseOrder/9").accept(MediaType.APPLICATION_JSON)
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
			mocMvc.perform(delete("/api/po/deletePurchaseOrder/37").accept(MediaType.APPLICATION_JSON))
					.andExpectAll(status().isOk()).andDo(result -> {
						WebResponse<Integer> response = objectMapper
								.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
								});

						assertEquals(Constants.statusCode.OK.getCode(), response.getStatusCode());
						assertEquals(Constants.statusCode.OK.getDesc(), response.getDesc());
						assertNotNull(response.getData());
						assertEquals(37, response.getData());
					});
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
}
