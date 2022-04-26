package assignment3

import(
	"fmt"
	//"math"
)
func Run(startPoint, endPoint string) {
	// build and run Dijkstra's algorithm on graph
	graph := buildGraph()
	dijkstra(graph, startPoint)
	
	fmt.Printf("The shortest distance from %s to %s\n", startPoint, endPoint)
	
	for _, node := range graph.Nodes{
		if node.name == endPoint{
			for n := node; n.through != nil; n = n.through {
				fmt.Print(n.name, " <- ")
			}
		}
	}

	fmt.Print(startPoint, "\n")

}
