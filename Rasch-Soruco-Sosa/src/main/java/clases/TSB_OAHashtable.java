package clases;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class TSB_OAHashtable<K,V> implements Map<K,V>, Cloneable, Serializable
{
    //************************ Constantes (privadas o públicas).

    // el tamaño máximo que podrá tener el arreglo de soporte...
    private final static int MAX_SIZE = Integer.MAX_VALUE;


    //************************ Atributos privados (estructurales).

    private Object[] items;

    // el tamaño inicial de la tabla (tamaño con el que fue creada)...
    private int initial_capacity;

    // la cantidad de objetos que contiene la tabla en TODAS sus listas...
    private int count;

    // el factor de carga para calcular si hace falta un rehashing...
    private float load_factor;

    //************************ Atributos privados (para gestionar las vistas).

    /*
     * (Tal cual están definidos en la clase java.util.Hashtable)
     * Cada uno de estos campos se inicializa para contener una instancia de la
     * vista que sea más apropiada, la primera vez que esa vista es requerida.
     * La vista son objetos stateless (no se requiere que almacenen datos, sino
     * que sólo soportan operaciones), y por lo tanto no es necesario crear más
     * de una de cada una.
     */
    private transient Set<K> keySet = null;
    private transient Set<Map.Entry<K,V>> entrySet = null;
    private transient Collection<V> values = null;

    //************************ Atributos protegidos (control de iteración).

    // conteo de operaciones de cambio de tamaño (fail-fast iterator).
    protected transient int modCount;

    //************************ Constructores.


    @Override
    public int size()
    {
        return 0;
    }

    @Override
    public boolean isEmpty()
    {
        return false;
    }

    @Override
    public boolean containsKey(Object key)
    {
        return false;
    }

    @Override
    public boolean containsValue(Object value)
    {
        return false;
    }

    @Override
    public V get(Object key)
    {
        return null;
    }

    @Override
    public V put(K key, V value)
    {
        return null;
    }

    @Override
    public V remove(Object key)
    {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m)
    {

    }

    @Override
    public void clear()
    {

    }

    @Override
    public Set<K> keySet()
    {
        return null;
    }

    @Override
    public Collection<V> values()
    {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet()
    {
        return null;
    }
}
