package assignment3

import(
	"sync"
)
type Heap struct {
	elements []*Node
	mutex    sync.RWMutex
}

func (h *Heap) Size() int {
	h.mutex.RLock()
	defer h.mutex.RUnlock()
	return len(h.elements)
}

// push an element to the heap, re-arrange the heap
func (h *Heap) Push(element *Node) {
	h.mutex.Lock()
	defer h.mutex.Unlock()
	h.elements = append(h.elements, element)
	i := len(h.elements) - 1
	for ; h.elements[i].value < h.elements[parent(i)].value; i = parent(i) {
		h.swap(i, parent(i))
	}
}

// pop the top of the heap, which is the min value
func (h *Heap) Pop() (i *Node) {
	h.mutex.Lock()
	defer h.mutex.Unlock()
	i = h.elements[0]
	h.elements[0] = h.elements[len(h.elements)-1]
	h.elements = h.elements[:len(h.elements)-1]
	h.rearrange(0)
	return
}

// rearrange the heap
func (h *Heap) rearrange(i int) {
	smallest := i
	left, right, size := leftChild(i), rightChild(i), len(h.elements)
	if left < size && h.elements[left].value < h.elements[smallest].value {
		smallest = left
	}
	if right < size && h.elements[right].value < h.elements[smallest].value {
		smallest = right
	}
	if smallest != i {
		h.swap(i, smallest)
		h.rearrange(smallest)
	}
}

func (h *Heap) swap(i, j int) {
	h.elements[i], h.elements[j] = h.elements[j], h.elements[i]
}

func parent(i int) int {
	return (i - 1) / 2
}

func leftChild(i int) int {
	return 2*i + 1
}

func rightChild(i int) int {
	return 2*i + 2
}
