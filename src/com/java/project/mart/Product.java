package com.java.project.mart;

public class Product{

	private String seq;				//번호
	private String ProductName;		//상품명
	private String category;		//상품카테고리 중복 ■ 표시
	private String manufacturer;	//제조사
	private String substitute;		//상품검색어 중복 ■ 표시
	private String veg;				//베지테리언단계(8단계)
	private String minor;			//미성년자구매가능여부(T/F)
	private String ProductCount;	//상품수량(기본 수량 100개)
	private String ProductPrice;	//가격(100 ~ 1,000,000원)
	
	public Product() {
		this("", "", "", "", "", "", "", "", "");
	}
	
	public Product(String seq, String ProductName, String category
			       , String manufacturer, String substitute, String veg
			       , String minor, String ProductCount, String ProductPrice) {
		this.seq = seq;
		this.ProductName = ProductName;
		this.category = category;
		this.manufacturer = manufacturer;
		this.substitute = substitute;
		this.veg = veg;
		this.minor = minor;
		this.ProductCount = ProductCount;
		this.ProductPrice = ProductPrice;
	
	}
	
	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getSubstitute() {
		return substitute;
	}

	public void setSubstitute(String substitute) {
		this.substitute = substitute;
	}

	public String getVeg() {
		return veg;
	}

	public void setVeg(String veg) {
		this.veg = veg;
	}

	public String getMinor() {
		return minor;
	}

	public void setMinor(String minor) {
		this.minor = minor;
	}

	public String getProductCount() {
		return ProductCount;
	}

	public void setProductCount(String productCount) {
		ProductCount = productCount;
	}

	public String getProductPrice() {
		return ProductPrice;
	}

	public void setProductPrice(String productPrice) {
		ProductPrice = productPrice;
	}

	@Override
	public String toString() {
		return "[번호=" + seq + ", 이름=" + ProductName + ", 카테고리=" + category +
					", 제조사=" + manufacturer + ", 대체어=" + substitute +
					", 베지테리언=" + veg + ", 미성년자="+ minor +
					", 상품수량=" + ProductCount + ", 가격=" + ProductPrice + "]";
	}
	
	
}