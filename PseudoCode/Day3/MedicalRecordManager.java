/*
INTERFACE Searchable
    METHODS
        search(criteria)
        filter(condition)

INTERFACE Printable
    METHODS
        print()
        export(format)

CLASS MedicalRecord implements Searchable, Printable
    FIELDS
        patientId, diagnosis, treatment, date
    
    METHODS
        OVERRIDE search(criteria)
        OVERRIDE print()

CLASS LabReport extends MedicalRecord
    FIELDS
        testType, results
    
    METHODS
        OVERRIDE print()
        analyzeResults()

CLASS PrescriptionRecord extends MedicalRecord
    FIELDS
        medications, dosage
    
    METHODS
        OVERRIDE print()
        checkDrugInteractions()
*/