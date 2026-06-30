package sistemabibliotecadigitalutn;

import java.util.ArrayList;
import java.util.HashMap;

public class Repositorio<K,V> {
    private HashMap<K, V> repo;

    public Repositorio() {
        this.repo = new HashMap<K,V>();
    }
    
    public void registrar(K key, V value) {
        repo.put(key, value);
    }
    
    public ArrayList listar() {
        return new ArrayList<>(repo.values());
    }
    
    public boolean existe(K key) {
        return repo.containsKey(key);
    }
    
    public V buscar(K key) {
        return repo.get(key);
    }
}
