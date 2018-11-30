package com.alacriti.bloodmanager.bo;

public class PartnerBO {
	
private long warehouseId;
private String name;
private String email;
private String phoneNo;
private String storageType;
private AddressBO address;
private String warehouseType;
private String totalArea;
private String availableArea;
private long addressId;

public long getWarehouseId() {
	return warehouseId;
}
public void setWarehouseId(long warehouseId) {
	this.warehouseId = warehouseId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhoneNo() {
	return phoneNo;
}
public void setPhoneNo(String phoneNo) {
	this.phoneNo = phoneNo;
}
public String getStorageType() {
	return storageType;
}
public void setStorageType(String storageType) {
	this.storageType = storageType;
}
public AddressBO getAddress() {
	return address;
}
public void setAddress(AddressBO address) {
	this.address = address;
}
public String getWarehouseType() {
	return warehouseType;
}
public void setWarehouseType(String warehouseType) {
	this.warehouseType = warehouseType;
}
public String getTotalArea() {
	return totalArea;
}
public void setTotalArea(String totalArea) {
	this.totalArea = totalArea;
}
public String getAvailableArea() {
	return availableArea;
}
public void setAvailableArea(String availableArea) {
	this.availableArea = availableArea;
}
public long getAddressId() {
	return addressId;
}
public void setAddressId(long addressId) {
	this.addressId = addressId;
}

}
