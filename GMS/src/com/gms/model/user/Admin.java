package com.gms.model.user;

public class Admin {
	
	private int EMP_ID;
    private int ADMIN_ID;
    private String ADMIN_USERNAME;
    private String ADMIN_EMAIL;
    private String LOGIN_ID;
    private String ADMIN_PASSWORD;
    private String ADMIN_IS_ACTIVE;
    private int ROLE_CODE;
    private String MENU_ROLE;
    
    public Admin(int ADMIN_ID, String ADMIN_USERNAME,String ADMIN_EMAIL,String LOGIN_ID, String ADMIN_PASSWORD, String ADMIN_IS_ACTIVE) {
        this.ADMIN_ID = ADMIN_ID;
        this.ADMIN_USERNAME = ADMIN_USERNAME;
        this.ADMIN_EMAIL = ADMIN_EMAIL;
        this.LOGIN_ID = LOGIN_ID;
        this.ADMIN_PASSWORD = ADMIN_PASSWORD;
        this.ADMIN_IS_ACTIVE = ADMIN_IS_ACTIVE;
    }

    public Admin(String ADMIN_USERNAME,String ADMIN_EMAIL,String LOGIN_ID, String ADMIN_PASSWORD, String ADMIN_IS_ACTIVE) {
        this.ADMIN_EMAIL = ADMIN_EMAIL;
        this.LOGIN_ID = LOGIN_ID;
        this.ADMIN_USERNAME = ADMIN_USERNAME;
        this.ADMIN_PASSWORD = ADMIN_PASSWORD;
        this.ADMIN_IS_ACTIVE = ADMIN_IS_ACTIVE;
    }
    
    public Admin(String LOGIN_ID,String ADMIN_PASSWORD) {
        this.LOGIN_ID = LOGIN_ID;
        this.ADMIN_PASSWORD = ADMIN_PASSWORD;
    }

    public Admin() {
    }
    
    public int getEMP_ID() {
		return EMP_ID;
	}

	public void setEMP_ID(int eMP_ID) {
		EMP_ID = eMP_ID;
	}

	public int getADMIN_ID() {
        return ADMIN_ID;
    }

    public void setADMIN_ID(int ADMIN_ID) {
        this.ADMIN_ID = ADMIN_ID;
    }

    public String getADMIN_EMAIL() {
        return ADMIN_EMAIL;
    }

    public void setADMIN_EMAIL(String ADMIN_EMAIL) {
        this.ADMIN_EMAIL = ADMIN_EMAIL;
    }
    
    public String getLOGIN_ID() {
		return LOGIN_ID;
	}

	public void setLOGIN_ID(String lOGIN_ID) {
		LOGIN_ID = lOGIN_ID;
	}

	public String getADMIN_USERNAME() {
        return ADMIN_USERNAME;
    }

    public void setADMIN_USERNAME(String ADMIN_USERNAME) {
        this.ADMIN_USERNAME = ADMIN_USERNAME;
    }

    public String getADMIN_PASSWORD() {
        return ADMIN_PASSWORD;
    }

    public void setADMIN_PASSWORD(String ADMIN_PASSWORd) {
        this.ADMIN_PASSWORD = ADMIN_PASSWORd;
    }

    public String getADMIN_IS_ACTIVE() {
        return ADMIN_IS_ACTIVE;
    }

    public void setADMIN_IS_ACTIVE(String ADMIN_IS_ACTIVE) {
        this.ADMIN_IS_ACTIVE = ADMIN_IS_ACTIVE;
    }

    @Override
    public String toString() {
        return "Admin{" + "ADMIN_ID=" + ADMIN_ID + ", ADMIN_EMAIL=" + ADMIN_EMAIL +", LOGIN_ID=" + LOGIN_ID + ", ADMIN_PASSWORD=" + ADMIN_PASSWORD + ", ADMIN_IS_ACTIVE=" + ADMIN_IS_ACTIVE + '}';
    }

	public int getROLE_CODE() {
		return ROLE_CODE;
	}

	public void setROLE_CODE(int rOLE_CODE) {
		ROLE_CODE = rOLE_CODE;
	}

	public String getMENU_ROLE() {
		return MENU_ROLE;
	}

	public void setMENU_ROLE(String mENU_ROLE) {
		MENU_ROLE = mENU_ROLE;
	}
}