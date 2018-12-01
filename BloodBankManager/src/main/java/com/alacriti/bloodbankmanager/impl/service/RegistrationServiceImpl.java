package com.alacriti.bloodbankmanager.impl.service;

import org.apache.log4j.Logger;

import com.alacriti.bloodbankmanager.constants.MiscConstant;
/**
 * 
 * @author digvijaykumars
 *
 */
import com.alacriti.bloodbankmanager.dao.RegistrationDAO;
import com.alacriti.bloodbankmanager.impl.dao.RegistrationDAOImpl;
import com.alacriti.bloodbankmanager.request.RegisterCustomerRequest;
import com.alacriti.bloodbankmanager.request.RegisterPartnerRequest;
import com.alacriti.bloodbankmanager.service.RegistrationService;
import com.alacriti.bloodmanager.bo.UserBO;
import com.alacriti.bloodmanager.bo.AddressBO;
import com.alacriti.bloodmanager.bo.WarehouseBO;
import com.alacriti.bloodmanager.dao.exception.BloodManagerDAOException;

public class RegistrationServiceImpl implements RegistrationService {
	final static Logger log = Logger.getLogger(RegistrationServiceImpl.class);

	/*
	 * This Method to just register the customer.
	 */
	@Override
	public boolean registerCustomer(RegisterCustomerRequest request) {
		System.out.println("RegistrationServiceImpl.register()");
		RegistrationDAO dao = null;
		UserBO customerBo = null;
		int result = 0;
		dao = new RegistrationDAOImpl();
		customerBo = new UserBO();

		try {
			result = dao.insertUserInfo(customerBo);
		} catch (BloodManagerDAOException e) {
			log.error(e.getMessage());
		}
		if (result > 0)
			return true;
		else
			return false;
	}

	/*
	 * This method to register the warehouse
	 */
	@Override
	public boolean registerPartner(RegisterPartnerRequest request) {

		log.debug("RegistrationServiceImpl.registerPartner()");
		RegistrationDAO dao = null;
		WarehouseBO warehouseBo = null;
		AddressBO addressBo = null;
		UserBO customerBo = null;
		int addressId = 0;
		int warehouseId = 0;
		boolean result = false;
		dao = new RegistrationDAOImpl();
		warehouseBo = new WarehouseBO();
		addressBo = new AddressBO();
		// populating address object
		addressBo = populateAddressBo(request, addressBo);
		// populating User object
		customerBo = populateUserBo(request, customerBo);
		// populating warehouse object
		warehouseBo = populateWarehouseBo(request, warehouseBo);

		try {
			/*
			 * Saving the address object to db and getting the address id which
			 * will be use in warehouse_info_tbl as address_id
			 */
			addressId = dao.insertAddress(addressBo);
			log.debug("Address Id" + addressId);
			/*
			 * If Address details saved successfully then only saving the user
			 * info in user_tbl and the user id returned from user_tbl is using
			 * as warehouse_id in warehouse_info_tbl
			 */
			if (addressId > 0) {
				warehouseId = dao.insertUserInfo(customerBo);
				log.debug("warehouseId " + warehouseId);
			}
			/*
			 * Saving the warehouse details in db only if user details
			 * successfully saved
			 */
			if (warehouseId > 0) {
				warehouseBo.setWarehouseId(warehouseId);
				warehouseBo.setAddressId(addressId);
				result = dao.insertWarehouseDetails(warehouseBo);
			}
		} catch (BloodManagerDAOException e) {
			log.error(e.getMessage());
		}

		return result;
	}

	// Method to populate User object
	private UserBO populateUserBo(RegisterPartnerRequest request, UserBO userBo) {
		log.debug("RegistrationServiceImpl.populateUserBo()");
		AddressBO address = new AddressBO();
		userBo = new UserBO();

		userBo.setFullName(request.getFirstName() + " " + request.getLastName());
		address.setCountry(request.getCountry());
		userBo.setAddress(address);
		userBo.setEmail(request.getCustEmail());
		userBo.setPhoneNo(request.getCustPhoneNo());
		userBo.setStatus(MiscConstant.ACTIVE);
		userBo.setUserType(MiscConstant.USER_TYPE_WAREHOUSE);
		userBo.setLoginIp(request.getLoginIp());
		userBo.setPassword(request.getPassword());
		userBo.setLoginCounter(MiscConstant.LOGIN_COUNTER_ZERO);

		return userBo;
	}

	// Method to populate warehouse Object object
	private WarehouseBO populateWarehouseBo(RegisterPartnerRequest request, WarehouseBO wareHouseBo) {
		log.debug("RegistrationServiceImpl.populateWarehouseBo()");
		wareHouseBo = new WarehouseBO();
		wareHouseBo.setName(request.getName());
		wareHouseBo.setTotalArea(request.getTotalArea());
		wareHouseBo.setAvailableArea(request.getAvailableArea());
		wareHouseBo.setAvailableArea(request.getAvailableArea());
		wareHouseBo.setWarehouseType(Integer.parseInt(request.getWarehouseType()));
		return wareHouseBo;
	}

	// Method to populate Address object
	private AddressBO populateAddressBo(RegisterPartnerRequest request, AddressBO addressBo) {
		log.debug("RegistrationServiceImpl.populateAddressBo()");
		addressBo = new AddressBO();

		addressBo.setAddressLine1(request.getAddressLine1());
		addressBo.setAddressLine2(request.getAddressLine2());
		addressBo.setCity(request.getCity());
		addressBo.setState(request.getState());
		addressBo.setCountry(request.getCountry());
		addressBo.setZipCode(request.getZipCode());
		addressBo.setLattitude(request.getLattitude());
		addressBo.setLongitude(request.getLongitude());

		return addressBo;
	}
	// The method for tesing purpose later it should be removed
	/*
	 * public static void main(String[] args) { RegisterPartnerRequest
	 * request=new RegisterPartnerRequest(); request.setAddressLine1("xyz");
	 * request.setAddressLine2("abc"); request.setAvailableArea("1234");
	 * request.setCity("Hyd"); request.setCountry("IN");
	 * request.setCustEmail("xyz@gmail.com");
	 * request.setCustPhoneNo("56709873"); request.setEmail("ttttt@gmail.com");
	 * request.setFirstName("My Warehouse"); request.setLastName("limited ");
	 * request.setLattitude("2323"); request.setLoginIp("1.4.5.7");
	 * request.setLongitude("333"); request.setName("ware");
	 * request.setPassword("password"); request.setPhoneNo("9999999999");
	 * request.setState("Telangana"); request.setStorageType("shaded");
	 * request.setTotalArea("100000"); request.setWarehouseType("1");
	 * request.setZipCode("972902"); RegistrationService service=new
	 * RegistrationServiceImpl();
	 * System.out.println(service.registerPartner(request)); }
	 */

}
