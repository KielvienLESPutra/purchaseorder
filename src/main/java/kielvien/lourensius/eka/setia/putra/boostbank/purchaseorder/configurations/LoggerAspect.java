package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.configurations;

import java.util.UUID;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggerAspect {
	private static final String TRACING_KEY = "tracingTransactionId";
	
	@Pointcut("execution(* kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.controllers..*(..)) ||"
			+ "execution(* kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.services..*(..))")
	public void executionMethodPoint() {

	}

	@Before("executionMethodPoint()")
	public void beforeJoinExecuted(JoinPoint joinPoint) {
		String tracingId = MDC.get(TRACING_KEY);
		if (tracingId == null) {
			tracingId = UUID.randomUUID().toString();
			MDC.put(TRACING_KEY, tracingId);
			log.info("Generate And Put Tracing Key: {}", tracingId);
		}
		log.info("Entaring tracing id [{}] executor point {} with parameter {}", tracingId, joinPoint.getSignature(),
				joinPoint.getArgs());
	}

	@After("executionMethodPoint()")
	public void afterJoinExecuted(JoinPoint joinPoint) {
		String tracingId = MDC.get(TRACING_KEY);
		log.info("Exiting tracing id [{}] executor point {} with parameter {}", tracingId, joinPoint.getSignature(),
				joinPoint.getArgs());
	}
}
