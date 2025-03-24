import java.util.*;

class Grafo {
    private Map<Integer, List<Integer>> adyacencias;

    public Grafo() {
        this.adyacencias = new HashMap<>();
    }

    public void agregarArista(int origen, int destino) {
        adyacencias.putIfAbsent(origen, new ArrayList<>());
        adyacencias.get(origen).add(destino);
    }

    public void mostrarGrafo() {
        for (Map.Entry<Integer, List<Integer>> entry : adyacencias.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public Grafo limpiaGrafo(int valor) {
        Grafo grafoLimpio = new Grafo();

        for (Map.Entry<Integer, List<Integer>> entry : adyacencias.entrySet()) {
            int nodo = entry.getKey();
            if (nodo != valor) {
                List<Integer> vecinos = new ArrayList<>();
                for (int vecino : entry.getValue()) {
                    if (vecino != valor) {
                        vecinos.add(vecino);
                    }
                }
                for (int v : vecinos) {
                    grafoLimpio.agregarArista(nodo, v);
                }
            }
        }
        return grafoLimpio;
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        grafo.agregarArista(1, 2);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(2, 3);
        grafo.agregarArista(3, 4);

        System.out.println("Grafo original:");
        grafo.mostrarGrafo();

        Grafo grafoLimpio = grafo.limpiaGrafo(3);

        System.out.println("\nGrafo después de limpiar el nodo 3:");
        grafoLimpio.mostrarGrafo();
    }
}

