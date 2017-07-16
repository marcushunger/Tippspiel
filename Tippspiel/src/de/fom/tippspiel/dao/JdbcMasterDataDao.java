package de.fom.tippspiel.dao;

import javax.sql.DataSource;

public class JdbcMasterDataDao implements MasterDataDao {

	private DataSource ds;

	public JdbcMasterDataDao(DataSource ds) {
		// DB Verbindungen zur Verfügung stellen
		this.setDs(ds);
	}

	public DataSource getDs() {
		return ds;
	}

	public void setDs(DataSource ds) {
		this.ds = ds;
	}

}
