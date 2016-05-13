package org.openmrs.module.fingerprint;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.openmrs.module.fingerprint.model.PatientFingerPrint;
import org.openmrs.module.fingerprint.utilities.HibernateUtil;


/**
 * Hello world!
 *
 */
public class App 
{
    @SuppressWarnings("unused")
	public static void main( String[] args )
    {
        System.out.println( "Hello World fingerprinters!" );
        String fingerPrintTemplate =  "C:\\Users\\maksph\\Documents\\FingerPrints\\indexMonday.fpt";
        App app = new App();
        int fingerprint1 =app.storeFingerPrints(1001,fingerPrintTemplate);
        
        List<PatientFingerPrint> patientFingerPrints = new ArrayList<PatientFingerPrint>();
        patientFingerPrints = app.getAllPatientFingerPrints();
        
        for(PatientFingerPrint patientFingerPrint : patientFingerPrints){
          System.out.println("FingerPrint size is: "+patientFingerPrint.getLeftIndex().length);
        }
    }
    @SuppressWarnings("unchecked")
	public List<PatientFingerPrint> getAllPatientFingerPrints(){
    	Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		List<PatientFingerPrint> patientFingerPrints = (List<PatientFingerPrint>)session.createQuery(
				"FROM PatientFingerPrint").list();
		
		session.getTransaction().commit();
		session.close();
		
		return patientFingerPrints;
    }
    public int storeFingerPrints(int patientID, String pathToFingerPrint){
    	PatientFingerPrint patientFingerPrint = new PatientFingerPrint();
    	patientFingerPrint.setPatientId(patientID);
    	
    	String absoluteFilePath = "";
    	absoluteFilePath = pathToFingerPrint;
    	File file = new File(absoluteFilePath);
    	byte[] leftIndexFinger = new byte[(int)file.length()];
    	
    	FileInputStream fileInputStream = null;
    	try {
			 fileInputStream = new FileInputStream(file);
			 fileInputStream.read(leftIndexFinger); 
			 fileInputStream.close();
			 
			 //add byteArray
			 patientFingerPrint.setLeftIndex(leftIndexFinger);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException io){
			
		}
    	
    	Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		int id = (Integer) session.save(patientFingerPrint);
		session.getTransaction().commit();
		session.close();
		
		System.out.println("Fingerprint successfully captured...");
		return id;
    }
}
