package sat.solucoes.exception.response;

import java.time.LocalDateTime;

public class ResponseError {

	private String message;
	private String erro;
	private int codigo;
	private LocalDateTime timestemp;
	private String path;
	
	public ResponseError(String message, String erro, int codigo, LocalDateTime timestemp, String path) {
		this.message=message;
		this.erro = erro;
		this.codigo = codigo;
		this.timestemp = timestemp;
		this.path = path;
	}
	
	public ResponseError() {
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public LocalDateTime getTimestemp() {
		return timestemp;
	}

	public void setTimestemp(LocalDateTime timestemp) {
		this.timestemp = timestemp;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
	
}
