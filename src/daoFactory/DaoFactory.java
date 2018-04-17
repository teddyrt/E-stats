package daoFactory;

import java.sql.Connection;

public abstract class DaoFactory {

	public abstract Connection openConnection();

	public static DaoFactory getDatabase() {
		return new MySql();
	}

}
