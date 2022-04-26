package assignment3

func buildGraph() *WeightedGraph {
	graph := NewGraph()
	nodes := AddNodes(graph,
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
		"Giurgiu",
		"Bucharest",
		"Urziceni",
		"Hirsova",
		"Eforie",
		"Vaslui",
		"Iasi",
		"Neamt",
	)
	graph.AddEdge(nodes["Oradea"], nodes["Zerind"], 71)
	graph.AddEdge(nodes["Oradea"], nodes["Sibiu"], 151)
	graph.AddEdge(nodes["Zerind"], nodes["Arad"], 75)
	graph.AddEdge(nodes["Arad"], nodes["Sibiu"], 140)
	graph.AddEdge(nodes["Arad"], nodes["Timisoara"], 118)
	graph.AddEdge(nodes["Timisoara"], nodes["Lugoj"], 111)
	graph.AddEdge(nodes["Lugoj"], nodes["Mehadia"], 75)
	graph.AddEdge(nodes["Mehadia"], nodes["Drobeta"], 75)
	graph.AddEdge(nodes["Drobeta"], nodes["Craiova"], 120)
	graph.AddEdge(nodes["Craiova"], nodes["Rimnicu Vilcea"], 146)
	graph.AddEdge(nodes["Craiova"], nodes["Pitesti"], 138)
	graph.AddEdge(nodes["Rimnicu Vilcea"], nodes["Sibiu"], 80)
	graph.AddEdge(nodes["Sibiu"], nodes["Fagaras"], 99)
	graph.AddEdge(nodes["Fagaras"], nodes["Bucharest"], 211)
	graph.AddEdge(nodes["Pitesti"], nodes["Bucharest"], 101)
	graph.AddEdge(nodes["Bucharest"], nodes["Giurgiu"], 90)
	graph.AddEdge(nodes["Bucharest"], nodes["Urziceni"], 85)
	graph.AddEdge(nodes["Urziceni"], nodes["Hirsova"], 98)
	graph.AddEdge(nodes["Hirsova"], nodes["Eforie"], 86)
	graph.AddEdge(nodes["Urziceni"], nodes["Vaslui"], 142)
	graph.AddEdge(nodes["Vaslui"], nodes["Iasi"], 92)
	graph.AddEdge(nodes["Iasi"], nodes["Neamt"], 87)
	graph.AddEdge(nodes["Rimnicu Vilcea"], nodes["Pitesti"], 97)

	return graph
}
