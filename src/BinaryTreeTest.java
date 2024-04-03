package src;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTest {
    private BinaryTree<Integer> tree;

    @Before
    public void setUp() {
        tree = new BinaryTree<>();
    }

    @Test
    public void testInsert() {
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);

        // Verificar que los nodos se han insertado correctamente
        assertEquals(Integer.valueOf(5), tree.search(5));
        assertEquals(Integer.valueOf(3), tree.search(3));
        assertEquals(Integer.valueOf(7), tree.search(7));
    }

    @Test
    public void testSearch() {
        // Buscar en un árbol vacío debe devolver null
        assertNull(tree.search(5));

        // Insertar nodos y luego buscarlos
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        assertEquals(Integer.valueOf(5), tree.search(5));
        assertEquals(Integer.valueOf(3), tree.search(3));
        assertEquals(Integer.valueOf(7), tree.search(7));

        // Buscar un nodo que no está en el árbol
        assertNull(tree.search(10));
    }
}
