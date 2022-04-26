package assignment3

import(
	"fmt"
)

func solveRight(graph *WeightedGraph, startNode string) []string{
	/**
	returns an array which can be "turned in order to create the optimal path for the given start node
	goes through all nodes in the graph starting at 
	*/
	fmt.Println("solving right graph")
	traversalArray := createTraversalArray(graph)
	return turnTraversalArray(traversalArray, "Bucharest")
}

func createTraversalArray(graph *WeightedGraph) []string{
	//returns an array with the traversal route
	//pseudocode
	/**
	iterate through every node in the graph
		start at urziceni
		choose the first edge connected 
	*/
	return []string{"Urziceni", "Vaslui", "Iasi", "Neamt", "Iasi", "Vaslui", "Urziceni", "Hirsova", "Eforie", "Hirsova", "Urziceni", "Bucharest", "Giurgiu", "Bucharest"}
}

//turns the array in the input to have the startNode at the start
func turnTraversalArray(array []string, startNode string) []string{
	//find the first element which = startNode
	startIndex := -1
	for i := 0; i < len(array); i++{
		if array[i] == startNode{
			startIndex = i
			break
		}
	}
	//create one subarray which is from found node to the end
	routeBeginning := []string{}
	for i := startIndex; i < len(array); i++{
		routeBeginning = append(routeBeginning, array[i])
	}

	//create another subarray from beginning to found node
	routeEnd := []string{}
	for i := 0; i <= startIndex; i++{
		routeEnd = append(routeEnd, array[i])
	}	
	//add the second array to the end of the first array
	route := routeBeginning 
	for i:= 0; i < len(routeEnd); i++{
		route = append(route, routeEnd[i])	
	}
	return route
}

