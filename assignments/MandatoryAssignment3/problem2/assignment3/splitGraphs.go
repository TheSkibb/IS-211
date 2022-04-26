package assignment3


func splitGraphs() (leftGraph *WeightedGraph, rightGraph *WeightedGraph){
	/**
	pseudocode

	creates two new graphs from the old graph, splitting them at the splitting point
	new plan: create two graphs
	*/
	leftGraph = NewGraph()
	nodes := AddNodes(leftGraph,
		"Oradea",
		"Zerind",
		"Arad",
		"Timisoara",
		"Lugoj",
		"Mehadia",
		"Drobeta",	
		"Craiova",
		"Sibiu",
		"Rimnicu Vilcea",
		"Fagaras",
		"Pitesti",
		"Bucharest",
	)
	leftGraph.AddEdge(nodes["Oradea"], nodes["Zerind"], 71)
	leftGraph.AddEdge(nodes["Oradea"], nodes["Sibiu"], 151)
	leftGraph.AddEdge(nodes["Zerind"], nodes["Arad"], 75)
	leftGraph.AddEdge(nodes["Arad"], nodes["Sibiu"], 140)
	leftGraph.AddEdge(nodes["Arad"], nodes["Timisoara"], 118)
	leftGraph.AddEdge(nodes["Timisoara"], nodes["Lugoj"], 111)
	leftGraph.AddEdge(nodes["Lugoj"], nodes["Mehadia"], 75)
	leftGraph.AddEdge(nodes["Mehadia"], nodes["Drobeta"], 75)
	leftGraph.AddEdge(nodes["Drobeta"], nodes["Craiova"], 120)
	leftGraph.AddEdge(nodes["Craiova"], nodes["Rimnicu Vilcea"], 146)
	leftGraph.AddEdge(nodes["Craiova"], nodes["Pitesti"], 138)
	leftGraph.AddEdge(nodes["Rimnicu Vilcea"], nodes["Sibiu"], 80)
	leftGraph.AddEdge(nodes["Sibiu"], nodes["Fagaras"], 99)
	leftGraph.AddEdge(nodes["Fagaras"], nodes["Bucharest"], 211)
	leftGraph.AddEdge(nodes["Pitesti"], nodes["Bucharest"], 101)
	leftGraph.AddEdge(nodes["Rimnicu Vilcea"], nodes["Pitesti"], 97)

	rightGraph = NewGraph()
	nodes2 := AddNodes(rightGraph,
		"Bucharest",
		"Giurgiu",
		"Urziceni",
		"Hirsova",
		"Eforie",
		"Vaslui",
		"Iasi",
		"Neamt",
	)

	rightGraph.AddEdge(nodes2["Bucharest"], nodes2["Giurgiu"], 90)
	rightGraph.AddEdge(nodes2["Bucharest"], nodes2["Urziceni"], 85)
	rightGraph.AddEdge(nodes2["Urziceni"], nodes2["Hirsova"], 98)
	rightGraph.AddEdge(nodes2["Hirsova"], nodes2["Eforie"], 86)
	rightGraph.AddEdge(nodes2["Urziceni"], nodes2["Vaslui"], 142)
	rightGraph.AddEdge(nodes2["Vaslui"], nodes2["Iasi"], 92)
	rightGraph.AddEdge(nodes2["Iasi"], nodes2["Neamt"], 87)

	return leftGraph, rightGraph
}
