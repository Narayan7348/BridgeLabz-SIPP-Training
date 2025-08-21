/*
CLASS Patient
    FIELDS
        id, name, age, medicalHistory
    
    METHOD generateHash()
        RETURN unique hash based on id

CLASS PatientRecordSystem
    PRIVATE FIELD
        HashMap<String, Patient> patientRecords
    
    METHODS
        addPatient(Patient)
            COMPUTE hash
            STORE in HashMap
        
        getPatient(String id)
            COMPUTE hash
            RETRIEVE from HashMap
        
        updatePatient(String id, Patient newData)
            COMPUTE hash
            UPDATE in HashMap
        
        deletePatient(String id)
            COMPUTE hash
            REMOVE from HashMap
*/