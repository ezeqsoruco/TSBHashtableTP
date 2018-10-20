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

    /**
     * Crea una tabla vacía, con la capacidad inicial igual a 5 y con factor
     * de carga igual a 0.8f.
     */
    public TSB_OAHashtable()
    {
        this(5, 0.5f);
    }

    /**
     * Crea una tabla vacía, con la capacidad inicial indicada y con factor
     * de carga igual a 0.8f.
     * @param initial_capacity la capacidad inicial de la tabla.
     */
    public TSB_OAHashtable(int initial_capacity)
    {
        this(initial_capacity, 0.5f);
    }

    /**
     * Crea una tabla vacía, con la capacidad inicial indicada y con el factor
     * de carga indicado. Si la capacidad inicial indicada por initial_capacity
     * es menor o igual a 0, la tabla será creada de tamaño 11. Si el factor de
     * carga indicado es negativo o cero, se ajustará a 0.8f.
     * @param initial_capacity la capacidad inicial de la tabla.
     * @param load_factor el factor de carga de la tabla.
     */
    public TSB_OAHashtable(int initial_capacity, float load_factor)
    {
        if(load_factor <= 0) { load_factor = 0.5f; }
        if(initial_capacity <= 0) { initial_capacity = 11; }
        else
        {
            if(initial_capacity > TSB_OAHashtable.MAX_SIZE)
            {
                initial_capacity = TSB_OAHashtable.MAX_SIZE;
            }
        }

        this.items = new Object[initial_capacity];

        this.initial_capacity = initial_capacity;
        this.load_factor = load_factor;
        this.count = 0;
        this.modCount = 0;
    }

    /**
     * Crea una tabla a partir del contenido del Map especificado.
     * @param t el Map a partir del cual se creará la tabla.
     */
    public TSB_OAHashtable(Map<? extends K,? extends V> t)
    {
        this(11, 0.5f);
        this.putAll(t);
    }

    //************************ Implementación de métodos especificados por Map.

    /**
     * Retorna la cantidad de elementos contenidos en la tabla.
     * @return la cantidad de elementos de la tabla.
     */
    @Override
    public int size()
    {
        return this.count;
    }

    /**
     * Determina si la tabla está vacía (no contiene ningún elemento).
     * @return true si la tabla está vacía.
     */
    @Override
    public boolean isEmpty()
    {
        return (this.count == 0);
    }

    /**
     * Determina si la clave key está en la tabla.
     * @param key la clave a verificar.
     * @return true si la clave está en la tabla.
     * @throws NullPointerException si la clave es null.
     */
    @Override
    public boolean containsKey(Object key)
    {
        return (this.get((K)key) == null);
    }

    /**
     * Determina si alguna clave de la tabla está asociada al objeto value que
     * entra como parámetro. Equivale a contains().
     * @param value el objeto a buscar en la tabla.
     * @return true si alguna clave está asociada efectivamente a ese value.
     */
    @Override
    public boolean containsValue(Object value)
    {
        return this.contains(value);
    }

    /**
     * Retorna el objeto al cual está asociada la clave key en la tabla, o null
     * si la tabla no contiene ningún objeto asociado a esa clave.
     * @param key la clave que será buscada en la tabla.
     * @return el objeto asociado a la clave especificada (si existe la clave) o
     *         null (si no existe la clave en esta tabla).
     * @throws NullPointerException si key es null.
     * @throws ClassCastException si la clase de key no es compatible con la
     *         tabla.
     */
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
    public int hashCode()
    {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        return super.equals(obj);
    }

    private boolean contains(Object value)
    {
        return false;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }

    @Override
    public String toString()
    {
        return super.toString();
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
