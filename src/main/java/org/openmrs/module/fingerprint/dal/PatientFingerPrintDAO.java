package org.openmrs.module.fingerprint.dal;


import java.util.List;

import org.hibernate.Session;
import org.openmrs.module.fingerprint.model.PatientFingerPrint;
import org.openmrs.module.fingerprint.utilities.HibernateUtil;

public class PatientFingerPrintDAO {
	
	public PatientFingerPrintDAO(){
		
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
	 
	    public int saveFingerPrints(PatientFingerPrint patientFingerPrint){
	    	Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			int id = (Integer) session.save(patientFingerPrint);
			session.getTransaction().commit();
			session.close();
			
			return id;
	    }
}
