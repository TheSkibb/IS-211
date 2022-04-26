package assignment3

import(
	"fmt"
)

/**
pseudo code

split the graph into two graphs: left and right
leftGraph, rightGraph := splitgraphs()

if startPoint is on left graph
	solve the left grpah first

	solve right graph using bucharest as starting point
else (start point is on right graph)
	solve right graph first using start point as start point

	solve left graph using bucharest as starting point

add the two paths together using bucharest as the starting point
*/

func Solution1(){
	leftGraph, rightGraph := splitGraphs()
	fmt.Println(leftGraph.Edges)
	rightPath := solveRight(rightGraph, rightGraph.Nodes[1].name)
	leftPath := cheapestLink(leftGraph)
	path := joinAtBucharest(leftPath, rightPath) 
	fmt.Println()
	fmt.Println("the optimal path found by solution1 is")
	fmt.Println(path)
	
}

func joinAtBucharest(leftArray, rightArray []string) []string{
	beginningLeft := []string{}
	endLeft := []string{}
	passedBucha := false
	for i := 0; i < len(leftArray); i ++{
		if passedBucha == false && leftArray[i] != "Bucharest" {
			beginningLeft = append(beginningLeft, leftArray[i])
		}else if passedBucha == true && leftArray[i] != "Bucharest"{
			endLeft = append(endLeft, leftArray[i])
		}
		if leftArray[i] == "Bucharest"{
			passedBucha = true
		}
	}

	route := beginningLeft
	for i := 0; i < len(rightArray); i++{
		route = append(route, rightArray[i])
	}

	for i := 0; i < len(endLeft); i++{
		route = append(route, endLeft[i])
	}
	
	return route
}
