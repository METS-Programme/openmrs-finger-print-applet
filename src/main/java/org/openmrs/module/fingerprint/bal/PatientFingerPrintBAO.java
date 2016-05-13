package org.openmrs.module.fingerprint.bal;

import java.util.List;
import org.openmrs.module.fingerprint.dal.PatientFingerPrintDAO;
import org.openmrs.module.fingerprint.model.PatientFingerPrint;

public class PatientFingerPrintBAO {
	
	
	public PatientFingerPrintBAO(){
		
	}
	
	public List<PatientFingerPrint> getAllPatientFingerPrints(){
		PatientFingerPrintDAO patientFingerPrintDAO = new PatientFingerPrintDAO();
		return patientFingerPrintDAO.getAllPatientFingerPrints();
    }
	public int saveFingerPrints(PatientFingerPrint patientFingerPrint){
		PatientFingerPrintDAO patientFingerPrintDAO = new PatientFingerPrintDAO();
		return patientFingerPrintDAO.saveFingerPrints(patientFingerPrint);
	}

}
