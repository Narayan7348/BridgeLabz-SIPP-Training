/*
CLASS Flight
    VARIABLES: flightNo, price, duration

CLASS FlightComparator
    METHOD compare(f1, f2)
        IF f1.price != f2.price
            RETURN f1.price - f2.price
        ELSE
            RETURN f1.duration - f2.duration

CLASS FlightAnalyzer
    METHOD main()
        CREATE list of flights
        SORT flights using MergeSort and FlightComparator
        PRINT sorted flights
*/