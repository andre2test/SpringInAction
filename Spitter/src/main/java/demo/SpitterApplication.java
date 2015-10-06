package demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpitterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpitterApplication.class, args);
        
        ApplicationContext context =  new ClassPathXmlApplicationContext("/Beans.xml");
        
        SpitterJDBCTemplate spitterJDBCTemplate =  (SpitterJDBCTemplate)context.getBean("spitterJDBCTemplate");
	     
	     System.out.println("------Records Creation--------" );
	     spitterJDBCTemplate.create("KnifeHead", "knife12", "Ricardo Jiminez");
	     spitterJDBCTemplate.create("Yamarashi", "yama2", "Astacio Guererro");
	     spitterJDBCTemplate.create("Onibaba", "oni15", "Gilberto Morales");

	     System.out.println("------Listing Multiple Records--------" );
	     List<Spitter> spitters = spitterJDBCTemplate.listSpitters();
	     System.out.println("********** RECORDS  **************");
	     for (Spitter record : spitters) {
	        System.out.println("User Name : " + record.getUsername() );
	        System.out.println("Password : " + record.getPassword() );
	        System.out.println("Full Name : " + record.getFullname());
	        System.out.println("**********************************");
	     }

	     System.out.println("----Updating Record with User Name = Onibaba -----" );
	     spitterJDBCTemplate.updatePassword("Onibaba", "onicrasio15");

	     System.out.println("----Listing Record User Name = Onibaba -----" );
	     Spitter spitter = spitterJDBCTemplate.getSpitter("Onibaba");
	     System.out.println("User Name : " + spitter.getUsername() );
	     System.out.println("Password  : " + spitter.getPassword() );
	     System.out.println("Full Name : " + spitter.getFullname() );
        
        
        if (context != null)
            ((AbstractApplicationContext) context).close();
    }
}
