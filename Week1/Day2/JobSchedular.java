/*
CLASS Doctor
    FIELDS
        id, name, specialization, experience
    
    GETTERS AND SETTERS

CLASS HospitalDepartment
    PRIVATE FIELD
        Map<String, List<Doctor>> departmentMap
    
    METHOD addDoctor(department, Doctor)
        GET or CREATE list for department
        ADD doctor to list
    
    METHOD getDoctorsBySpecialization(specialization)
        USE streams to filter all departments
        RETURN matching doctors
    
    METHOD displayDepartmentStats()
        SHOW doctor count per department
*/