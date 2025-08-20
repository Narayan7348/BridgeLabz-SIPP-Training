/*
CLASS Job implements Comparable<Job>
    FIELDS
        id, deadline, processingTime, priority
    
    METHOD compareTo(Job other)
        COMPARE based on priority and deadline

CLASS JobScheduler
    PRIVATE FIELD
        PriorityQueue<Job> jobQueue
    
    METHOD addJob(Job job)
        ADD to priority queue
    
    METHOD processNextJob()
        REMOVE and process highest priority job
    
    METHOD displaySchedule()
        SHOW all jobs in order of execution
*/