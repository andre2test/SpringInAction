package demo;

import java.util.List;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;


public class SpitterJDBCTemplate {
	public DataSource dataSource;
	public JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	/**
	 * Insert into Spitter Table
	 * @param username
	 * @param password
	 * @param fullname
	 */
	public void create(String username, String password, String fullname){
		String SQL = "insert into Spitter (username, password, fullname) values (?, ?, ?)";
	      
	    jdbcTemplateObject.update( SQL, username, password, fullname);
	    System.out.println("Created User Name = " + username 
	    		+ " Password = " + password + "Full Name = " + fullname);
	    return;
		
	}
	
	public void delete(String username){
		String SQL = "delete from Spitter where username = ?";
	    jdbcTemplateObject.update(SQL, username);
	    System.out.println("Deleted Record with User Name = " + username );
	    return;
		
	}
	
	public void updatePassword(String username, String password){
		String SQL = "update Spitter set password  = ? where username = ? ";
	    jdbcTemplateObject.update(SQL,  password);
	    System.out.println("Updated Record for User Name = " + username 
	    		+ " with Password = " + password );
	    return;
	}
	
	public Spitter getSpitter(String username) {
	      String SQL = "select * from Spitter where username = ?";
	      Spitter spitter = jdbcTemplateObject.queryForObject(SQL, 
	                        new Object[]{username}, new SpitterMapper());
	      return spitter;
	   }

	   public List<Spitter> listSpitters() {
	      String SQL = "select * from Spitter";
	      List <Spitter> spitters = jdbcTemplateObject.query(SQL, 
	                                new SpitterMapper());
	      return spitters;
	   }


}
