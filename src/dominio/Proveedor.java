package dominio;

public class Proveedor {
	int codigoAsociado; 
	String nombreEmpresa;
	Pais paisDeLaEmpresa;
	String numeroTelefonico;
	
	public Proveedor(int codigoAsociado ,String nombreEmpresa, Pais paisDeLaEmpresa, String numeroTelefonico) {
		this.codigoAsociado = codigoAsociado;
		this.nombreEmpresa = nombreEmpresa;
		this.paisDeLaEmpresa = paisDeLaEmpresa;
		this.numeroTelefonico = numeroTelefonico;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public Pais getPaisDeLaEmpresa() {
		return paisDeLaEmpresa;
	}

	public void setPaisDeLaEmpresa(Pais paisDeLaEmpresa) {
		this.paisDeLaEmpresa = paisDeLaEmpresa;
	}

	public String getNumeroTelefonico() {
		return numeroTelefonico;
	}

	public void setNumeroTelefonico(String numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}

	public int getCodigoAsociado() {
		return codigoAsociado;
	}

	public void setCodigoAsociado(int codigoAsociado) {
		this.codigoAsociado = codigoAsociado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigoAsociado;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proveedor other = (Proveedor) obj;
		if (codigoAsociado != other.codigoAsociado)
			return false;
		return true;
	}
	
}

