package inn.shopping.api.exception;

import inn.shopping.api.enums.APICode;

public class ApiException extends RuntimeException {

	private static final long serialVersionUID = -1611719326185520599L;
	private APICode errcode;

	public ApiException(String errmsg) {
		super(errmsg);
	}

	public ApiException(APICode errcode) {
		super(errcode.getCodeMessage() + ",errcode " + errcode.getCode());
		this.errcode = errcode;
	}

	public APICode getErrcode() {
		return errcode;
	}

	public void setErrcode(APICode errcode) {
		this.errcode = errcode;
	}

	public static void main(String[] args) throws ApiException {
		throw new ApiException(APICode.API_EXPIRED_CODE);
	}
}