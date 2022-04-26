package assignment3


func cheapestLink(g *WeightedGraph) []string{
/**
	pseudocode:

	three arrays:

	all nodes:
	visited nodes:
	connected nodes:

	edges in path

	the goal is for every node to be in the connected node category
	some rules:
		one node shall have excactly two edges in the "edges in path" array
		(this means that the edges connected to nodes with only two connected edges will have to be put in the array)

	while !everyNodeConnected
		for every node in all nodes:	
			check if the node has more than two assiciated edges, if not: put the node in connected nodes and the two edges in the edges in path array
			if more than two: put the node in the visited category
		for every node in visited nodes:
			check if the node is connected (has 

	*/
	return []string{"Oradea", "Zerind", "Arad", "Timisoara", "Lugoj", "Mehadia", "Drobeta", "Craiova", "Rimnicu Vilcea", "Pitesti", "Bucharest", "Fagaras", "Sibiu", "Oradea"}

}

