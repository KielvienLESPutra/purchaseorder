package kielvien.lourensius.eka.setia.putra.boostbank.purchaseorder.constants;

public class Constants {
	public static final String USER_SYSTEM = "SYSTEM";
	
	public enum statusCode {
		OK("00", "SUCCESS"), BAD_REQUEST("01", "BAD REQUEST"), NOT_FOUND("02","NOT FOUND");

		private String code;
		private String desc;

		private statusCode(String code, String desc) {
			this.code = code;
			this.desc = desc;
		}

		public String getCode() {
			return code;
		}

		public String getDesc() {
			return desc;
		}
	}
}
