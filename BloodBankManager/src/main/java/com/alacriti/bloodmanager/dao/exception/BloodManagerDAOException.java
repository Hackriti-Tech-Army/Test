package com.alacriti.bloodmanager.dao.exception;
/**
 * 
 * @author digvijaykumars
 *
 */
public final class BloodManagerDAOException  extends Exception{
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		/**
	     * Simple constructor
	     */
	    public BloodManagerDAOException()
	    {
	        super();
	    }

	    /**
	     * constructor with a message
	     */
	    public BloodManagerDAOException(Throwable t)
	    {
	        super(t);
	    }

	    /**
	     * constructor with a message
	     */
	    public BloodManagerDAOException(String message)
	    {
	        super(message);
	    }

	    /**
	     * constructor with a message
	     */
	    public BloodManagerDAOException(String message, Throwable t)
	    {
	        super(message, t);
	    }

}
