package com.alacriti.bloodbankmanager.dao;

import com.alacriti.bloodmanager.bo.AddressBO;
import com.alacriti.bloodmanager.bo.UserBO;
import com.alacriti.bloodmanager.bo.WarehouseBO;
import com.alacriti.bloodmanager.dao.exception.BloodManagerDAOException;

public interface RegistrationDAO {
	
	public int insertUserInfo(UserBO customerBo)  throws BloodManagerDAOException;
	public boolean insertWarehouseDetails(WarehouseBO partnerBo)  throws BloodManagerDAOException;
	public int insertAddress(AddressBO addressBo) throws BloodManagerDAOException ;
}
