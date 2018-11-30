package com.alacriti.bloodmanager.bo;

public class PartnerBO {
	
private long partnerId;
private String name;
private String email;
private String phoneNo;
private String storageType;
private AddressBO address;

public long getPartnerId() {
	return partnerId;
}
public void setPartnerId(long partnerId) {
	this.partnerId = partnerId;
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

}
