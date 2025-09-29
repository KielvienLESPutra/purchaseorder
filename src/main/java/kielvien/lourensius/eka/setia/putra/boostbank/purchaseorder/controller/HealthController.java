package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class HealthController {
	@GetMapping("/health")
	public String healthCheck() {
		return "{\"status\": \"UP\", \"message\": \"Service is running\"}";
	}
}
