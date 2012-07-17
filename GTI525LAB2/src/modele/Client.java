package modele;


public class Client {
	
	private String NomClient ;
	private String PreClient ;
	private String CourrielClient ;
	private String AddrClient ;
	private String VilleClient ;
	private String ProvinceClient ;
	private String PaysClient ;
	private String CCClient ;
	private String ExpAClient ;
	private String ExpMClient ;
	private String cS ;
	
	public String getNomClient() {
		return NomClient;
	}
	public void setNomClient(String nomClient) {
		NomClient = nomClient;
	}
	public String getPreClient() {
		return PreClient;
	}
	public void setPreClient(String preClient) {
		PreClient = preClient;
	}
	public String getCourrielClient() {
		return CourrielClient;
	}
	public void setCourrielClient(String courrielClient) {
		CourrielClient = courrielClient;
	}
	public String getAddrClient() {
		return AddrClient;
	}
	public void setAddrClient(String addrClient) {
		AddrClient = addrClient;
	}
	public String getVilleClient() {
		return VilleClient;
	}
	public void setVilleClient(String villeClient) {
		VilleClient = villeClient;
	}
	public String getProvinceClient() {
		return ProvinceClient;
	}
	public void setProvinceClient(String provinceClient) {
		ProvinceClient = provinceClient;
	}
	public String getPaysClient() {
		return PaysClient;
	}
	public void setPaysClient(String paysClient) {
		PaysClient = paysClient;
	}
	public String getCCClient() {		
		return CCClient;
	}
	public String getCCs() {
		String s = CCClient.substring(14);
		return s;
	}
	public void setCCClient(String cCClient) {
		CCClient = cCClient;
	}
	public String getExpAClient() {
		return ExpAClient;
	}
	public void setExpAClient(String expAClient) {
		ExpAClient = expAClient;
	}
	public String getExpMClient() {
		return ExpMClient;
	}
	public void setExpMClient(String expMClient) {
		ExpMClient = expMClient;
	}
	public String getcS() {
		return cS;
	}
	public void setcS(String cS) {
		this.cS = cS;
	}

	


}
