/*
CLASS Graph
    VARIABLES: V, adjacencyList
    METHOD addEdge(u, v)
        ADD v to adjacencyList[u]
        ADD u to adjacencyList[v]

CLASS CrimeAnalyzer
    VARIABLE: visited[]
    METHOD dfs(graph, zone)
        visited[zone] = TRUE
        FOR each neighbor in adjacencyList[zone]
            IF not visited[neighbor]
                CALL dfs(graph, neighbor)

MAIN
    CREATE graph with zones
    ADD edges based on crime connections
    RUN dfs for each zone
    PRINT high-risk connected zones
*/
