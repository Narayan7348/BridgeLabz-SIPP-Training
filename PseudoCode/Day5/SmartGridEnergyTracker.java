/*Map<String, Map<String, List<Integer>>> data; // Zone → Day → Readings

// Process
for each zone in data:
    for each day in zone:
        List<Integer> readings = data[zone][day];
        int peak = max(readings);
        print("Zone: " + zone + ", Day: " + day + ", Peak: " + peak);
*/