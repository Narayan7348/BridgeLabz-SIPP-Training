/*class SurveyResponse {
    String restaurantName
    int rating
}

method generateReport(responsesList) {
    map<String, List<Integer>> grouped

    // Group ratings by restaurant
    for response in responsesList:
        grouped[response.restaurantName].add(response.rating)

    // Calculate average
    map<String, Double> avgRatings
    for each restaurant in grouped:
        avg = average(grouped[restaurant])
        avgRatings[restaurant] = avg

    print(avgRatings)
    print("Highest rated: " + max(avgRatings))
    print("Lowest rated: " + min(avgRatings))
}

// Example run
main() {
    responses = [PizzaHut 4, PizzaHut 5, KFC 3, KFC 4, Subway 5, Subway 4, Subway 5]
    generateReport(responses)
}
*/
