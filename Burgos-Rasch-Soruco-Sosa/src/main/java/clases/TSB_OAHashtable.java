package clases;

import java.io.Serializable;
import java.util.*;
// pone estado de casilla

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

    //Value es cero al agregar, poner en el TEST
    @Override
    public V put(K key, V value)
    {
        if(key == null || value == null) throw new NullPointerException("put(): parámetro null");

        Object x = items[this.h(key)];




        /*


        int ib = this.h(key);
        TSBArrayList<Map.Entry<K, V>> bucket = this.table[ib];

        V old = null;
        Map.Entry<K, V> x = this.search_for_entry((K)key, bucket);
        if(x != null)
        {
            old = x.getValue();
            x.setValue(value);
        }
        else
        {
            if(this.averageLength() >= this.load_factor * 10) this.rehash();
            ib = this.h(key);
            bucket = this.table[ib];

            Map.Entry<K, V> entry = new Entry<>(key, value);
            bucket.add(entry);
            this.count++;
            this.modCount++;
        }
*/
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
    public Set<Map.Entry<K, V>> entrySet()
    {
        return null;
    }


    /*
     * Función hash. Toma una clave entera k y calcula y retorna un índice
     * válido para esa clave para entrar en la tabla.
     */
    private int h(int k)
    {
        return h(k, this.items.length);
    }

    /*
     * Función hash. Toma un objeto key que representa una clave y calcula y
     * retorna un índice válido para esa clave para entrar en la tabla.
     */
    private int h(K key)
    {
        return h(key.hashCode(), this.items.length);
    }

    /*
     * Función hash. Toma un objeto key que representa una clave y un tamaño de
     * tabla t, y calcula y retorna un índice válido para esa clave dedo ese
     * tamaño.
     */
    private int h(K key, int t)
    {
        return h(key.hashCode(), t);
    }

    /*
     * Función hash. Toma una clave entera k y un tamaño de tabla t, y calcula y
     * retorna un índice válido para esa clave dado ese tamaño.
     */
    private int h(int k, int t)
    {
        if(k < 0) k *= -1;
        return k % t;
    }

    private boolean esPrimo(int n)
    {
        int i;
        for (i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private int siguientePrimo(int n)
    {
        if(n % 2 == 0) n++;
        for(; !esPrimo(n); n+=2);
        return n;
    }



    private class Entry<K, V> implements Map.Entry<K, V>
    {
        private K key;
        private V value;
        private int cant;
        //Estados: -1: Tumbba; 0:Abierta; 1: Cerrada


        public Entry(K key, V value)
        {
            if(key == null || value == null)
            {
                throw new IllegalArgumentException("Entry(): parámetro null...");
            }

            this.key = key;
            this.value = value;
            this.cant = 0;

        }

        @Override
        public K getKey()
        {
            return key;
        }

        @Override
        public V getValue()
        {
            return value;
        }

        public int getCant()
        {
            return cant;
        }

        @Override
        public V setValue(V value)
        {
            if(value == null)
            {
                throw new IllegalArgumentException("setValue(): parámetro null...");
            }

            V old = this.value;
            this.value = value;
            return old;
        }

        public int hashCode()
        {
            int hash = 7;
            hash = 61 * hash + Objects.hashCode(this.key);
            hash = 61 * hash + Objects.hashCode(this.value);
            return hash;
        }


    }

    /*
     * Clase interna que representa una vista de todas los Claves mapeadas en la
     * tabla: si la vista cambia, cambia también la tabla que le da respaldo, y
     * viceversa. La vista es stateless: no mantiene estado alguno (es decir, no
     * contiene datos ella misma, sino que accede y gestiona directamente datos
     * de otra fuente), por lo que no tiene atributos y sus métodos gestionan en
     * forma directa el contenido de la tabla. Están soportados los metodos para
     * eliminar un objeto (remove()), eliminar todo el contenido (clear) y la
     * creación de un Iterator (que incluye el método Iterator.remove()).
     */
    private class KeySet extends AbstractSet<K>
    {
        @Override
        public Iterator<K> iterator()
        {
            return new KeySetIterator();
        }

        @Override
        public int size()
        {
            return TSB_OAHashtable.this.count;
        }

        @Override
        public boolean contains(Object o)
        {
            return TSB_OAHashtable.this.containsKey(o);
        }

        @Override
        public boolean remove(Object o)
        {
            return (TSB_OAHashtable.this.remove(o) != null);
        }

        @Override
        public void clear()
        {
            TSB_OAHashtable.this.clear();
        }

        private class KeySetIterator implements Iterator<K>
        {
            // índice de la lista actualmente recorrida...
            //private int current_bucket;

            // índice de la lista anterior (si se requiere en remove())...
            //private int last_bucket;

            // índice del elemento actual en el iterador (el que fue retornado
            // la última vez por next() y será eliminado por remove())...
            private int current_entry;

            // flag para controlar si remove() está bien invocado...
            private boolean next_ok;

            // el valor que debería tener el modCount de la tabla completa...
            private int expected_modCount;

            /*
             * Crea un iterador comenzando en la primera lista. Activa el
             * mecanismo fail-fast.
             */
            public KeySetIterator()
            {
                //current_bucket = 0;
               // last_bucket = 0;
                current_entry = -1;
                next_ok = false;
                expected_modCount = TSB_OAHashtable.this.modCount;
            }

            /*
             * Determina si hay al menos un elemento en la tabla que no haya
             * sido retornado por next().
             */
            @Override
            public boolean hasNext()
            {
                // variable auxiliar t para simplificar accesos...
                Object t[] = TSB_OAHashtable.this.items;

                if(TSB_OAHashtable.this.isEmpty()) { return false; }
                if(current_entry >= t.length) { return false; }
                if(t[current_entry+1] == null) {return false;}


                return true;
            }

            /*
             * Retorna el siguiente elemento disponible en la tabla.
             */
            @Override
            public K next()
            {
                // control: fail-fast iterator...
                if(TSB_OAHashtable.this.modCount != expected_modCount)
                {
                    throw new ConcurrentModificationException("next(): modificación inesperada de tabla...");
                }

                if(!hasNext())
                {
                    throw new NoSuchElementException("next(): no existe el elemento pedido...");
                }

                current_entry ++;
                Map.Entry<K,V> element = (Map.Entry) items[current_entry];

                return element.getKey();
            }

            /*
             * Remueve el elemento actual de la tabla, dejando el iterador en la
             * posición anterior al que fue removido. El elemento removido es el
             * que fue retornado la última vez que se invocó a next(). El método
             * sólo puede ser invocado una vez por cada invocación a next().
             */
            @Override
            public void remove()
            {
                if(!next_ok)
                {
                    throw new IllegalStateException("remove(): debe invocar a next() antes de remove()...");
                }

                // eliminar el objeto que retornó next() la última vez...
                Map.Entry<K, V> garbage = TSBHashtable.this.table[current_bucket].remove(current_entry);

                // quedar apuntando al anterior al que se retornó...
                if(last_bucket != current_bucket)
                {
                    current_bucket = last_bucket;
                    current_entry = TSBHashtable.this.table[current_bucket].size() - 1;
                }

                // avisar que el remove() válido para next() ya se activó...
                next_ok = false;

                // la tabla tiene un elementon menos...
                TSBHashtable.this.count--;

                // fail_fast iterator: todo en orden...
                TSBHashtable.this.modCount++;
                expected_modCount++;
            }
        }
    }

    /*
     * Clase interna que representa una vista de todos los PARES mapeados en la
     * tabla: si la vista cambia, cambia también la tabla que le da respaldo, y
     * viceversa. La vista es stateless: no mantiene estado alguno (es decir, no
     * contiene datos ella misma, sino que accede y gestiona directamente datos
     * de otra fuente), por lo que no tiene atributos y sus métodos gestionan en
     * forma directa el contenido de la tabla. Están soportados los metodos para
     * eliminar un objeto (remove()), eliminar todo el contenido (clear) y la
     * creación de un Iterator (que incluye el método Iterator.remove()).
     */
    private class EntrySet extends AbstractSet<Map.Entry<K, V>>
    {

        @Override
        public Iterator<Map.Entry<K, V>> iterator()
        {
            return new EntrySetIterator();
        }

        /*
         * Verifica si esta vista (y por lo tanto la tabla) contiene al par
         * que entra como parámetro (que debe ser de la clase Entry).
         */
        @Override
        public boolean contains(Object o)
        {
            if(o == null) { return false; }
            if(!(o instanceof Entry)) { return false; }

            Map.Entry<K, V> entry = (Map.Entry<K,V>)o;
            K key = entry.getKey();
            int index = TSBHashtable.this.h(key);

            TSBArrayList<Map.Entry<K, V>> bucket = TSBHashtable.this.table[index];
            if(bucket.contains(entry)) { return true; }
            return false;
        }

        /*
         * Elimina de esta vista (y por lo tanto de la tabla) al par que entra
         * como parámetro (y que debe ser de tipo Entry).
         */
        @Override
        public boolean remove(Object o)
        {
            if(o == null) { throw new NullPointerException("remove(): parámetro null");}
            if(!(o instanceof Entry)) { return false; }

            Map.Entry<K, V> entry = (Map.Entry<K, V>) o;
            K key = entry.getKey();
            int index = TSBHashtable.this.h(key);
            TSBArrayList<Map.Entry<K, V>> bucket = TSBHashtable.this.table[index];

            if(bucket.remove(entry))
            {
                TSBHashtable.this.count--;
                TSBHashtable.this.modCount++;
                return true;
            }
            return false;
        }

        @Override
        public int size()
        {
            return TSBHashtable.this.count;
        }

        @Override
        public void clear()
        {
            TSBHashtable.this.clear();
        }

        private class EntrySetIterator implements Iterator<Map.Entry<K, V>>
        {
            // índice de la lista actualmente recorrida...
            private int current_bucket;

            // índice de la lista anterior (si se requiere en remove())...
            private int last_bucket;

            // índice del elemento actual en el iterador (el que fue retornado
            // la última vez por next() y será eliminado por remove())...
            private int current_entry;

            // flag para controlar si remove() está bien invocado...
            private boolean next_ok;

            // el valor que debería tener el modCount de la tabla completa...
            private int expected_modCount;

            /*
             * Crea un iterador comenzando en la primera lista. Activa el
             * mecanismo fail-fast.
             */
            public EntrySetIterator()
            {
                current_bucket = 0;
                last_bucket = 0;
                current_entry = -1;
                next_ok = false;
                expected_modCount = TSBHashtable.this.modCount;
            }

            /*
             * Determina si hay al menos un elemento en la tabla que no haya
             * sido retornado por next().
             */
            @Override
            public boolean hasNext()
            {
                // variable auxiliar t para simplificar accesos...
                TSBArrayList<Map.Entry<K, V>> t[] = TSBHashtable.this.table;

                if(TSBHashtable.this.isEmpty()) { return false; }
                if(current_bucket >= t.length) { return false; }

                // bucket actual vacío o listo?...
                if(t[current_bucket].isEmpty() || current_entry >= t[current_bucket].size() - 1)
                {
                    // ... -> ver el siguiente bucket no vacío...
                    int next_bucket = current_bucket + 1;
                    while(next_bucket < t.length && t[next_bucket].isEmpty())
                    {
                        next_bucket++;
                    }
                    if(next_bucket >= t.length) { return false; }
                }

                // en principio alcanza con esto... revisar...
                return true;
            }

            /*
             * Retorna el siguiente elemento disponible en la tabla.
             */
            @Override
            public Map.Entry<K, V> next()
            {
                // control: fail-fast iterator...
                if(TSBHashtable.this.modCount != expected_modCount)
                {
                    throw new ConcurrentModificationException("next(): modificación inesperada de tabla...");
                }

                if(!hasNext())
                {
                    throw new NoSuchElementException("next(): no existe el elemento pedido...");
                }

                // variable auxiliar t para simplificar accesos...
                TSBArrayList<Map.Entry<K, V>> t[] = TSBHashtable.this.table;

                // se puede seguir en el mismo bucket?...
                TSBArrayList<Map.Entry<K, V>> bucket = t[current_bucket];
                if(!t[current_bucket].isEmpty() && current_entry < bucket.size() - 1) { current_entry++; }
                else
                {
                    // si no se puede...
                    // ...recordar el índice del bucket que se va a abandonar..
                    last_bucket = current_bucket;

                    // buscar el siguiente bucket no vacío, que DEBE existir, ya
                    // que se hasNext() retornó true...
                    current_bucket++;
                    while(t[current_bucket].isEmpty())
                    {
                        current_bucket++;
                    }

                    // actualizar la referencia bucket con el núevo índice...
                    bucket = t[current_bucket];

                    // y posicionarse en el primer elemento de ese bucket...
                    current_entry = 0;
                }

                // avisar que next() fue invocado con éxito...
                next_ok = true;

                // y retornar el elemento alcanzado...
                return bucket.get(current_entry);
            }

            /*
             * Remueve el elemento actual de la tabla, dejando el iterador en la
             * posición anterior al que fue removido. El elemento removido es el
             * que fue retornado la última vez que se invocó a next(). El método
             * sólo puede ser invocado una vez por cada invocación a next().
             */
            @Override
            public void remove()
            {
                if(!next_ok)
                {
                    throw new IllegalStateException("remove(): debe invocar a next() antes de remove()...");
                }

                // eliminar el objeto que retornó next() la última vez...
                Map.Entry<K, V> garbage = TSBHashtable.this.table[current_bucket].remove(current_entry);

                // quedar apuntando al anterior al que se retornó...
                if(last_bucket != current_bucket)
                {
                    current_bucket = last_bucket;
                    current_entry = TSBHashtable.this.table[current_bucket].size() - 1;
                }

                // avisar que el remove() válido para next() ya se activó...
                next_ok = false;

                // la tabla tiene un elementon menos...
                TSBHashtable.this.count--;

                // fail_fast iterator: todo en orden...
                TSBHashtable.this.modCount++;
                expected_modCount++;
            }
        }
    }

    /*
     * Clase interna que representa una vista de todos los VALORES mapeados en
     * la tabla: si la vista cambia, cambia también la tabla que le da respaldo,
     * y viceversa. La vista es stateless: no mantiene estado alguno (es decir,
     * no contiene datos ella misma, sino que accede y gestiona directamente los
     * de otra fuente), por lo que no tiene atributos y sus métodos gestionan en
     * forma directa el contenido de la tabla. Están soportados los metodos para
     * eliminar un objeto (remove()), eliminar todo el contenido (clear) y la
     * creación de un Iterator (que incluye el método Iterator.remove()).
     */
    private class ValueCollection extends AbstractCollection<V>
    {
        @Override
        public Iterator<V> iterator()
        {
            return new ValueCollectionIterator();
        }

        @Override
        public int size()
        {
            return TSBHashtable.this.count;
        }

        @Override
        public boolean contains(Object o)
        {
            return TSBHashtable.this.containsValue(o);
        }

        @Override
        public void clear()
        {
            TSBHashtable.this.clear();
        }

        private class ValueCollectionIterator implements Iterator<V>
        {
            // índice de la lista actualmente recorrida...
            private int current_bucket;

            // índice de la lista anterior (si se requiere en remove())...
            private int last_bucket;

            // índice del elemento actual en el iterador (el que fue retornado
            // la última vez por next() y será eliminado por remove())...
            private int current_entry;

            // flag para controlar si remove() está bien invocado...
            private boolean next_ok;

            // el valor que debería tener el modCount de la tabla completa...
            private int expected_modCount;

            /*
             * Crea un iterador comenzando en la primera lista. Activa el
             * mecanismo fail-fast.
             */
            public ValueCollectionIterator()
            {
                current_bucket = 0;
                last_bucket = 0;
                current_entry = -1;
                next_ok = false;
                expected_modCount = TSBHashtable.this.modCount;
            }

            /*
             * Determina si hay al menos un elemento en la tabla que no haya
             * sido retornado por next().
             */
            @Override
            public boolean hasNext()
            {
                // variable auxiliar t para simplificar accesos...
                TSBArrayList<Map.Entry<K, V>> t[] = TSBHashtable.this.table;

                if(TSBHashtable.this.isEmpty()) { return false; }
                if(current_bucket >= t.length) { return false; }

                // bucket actual vacío o listo?...
                if(t[current_bucket].isEmpty() || current_entry >= t[current_bucket].size() - 1)
                {
                    // ... -> ver el siguiente bucket no vacío...
                    int next_bucket = current_bucket + 1;
                    while(next_bucket < t.length && t[next_bucket].isEmpty())
                    {
                        next_bucket++;
                    }
                    if(next_bucket >= t.length) { return false; }
                }

                // en principio alcanza con esto... revisar...
                return true;
            }

            /*
             * Retorna el siguiente elemento disponible en la tabla.
             */
            @Override
            public V next()
            {
                // control: fail-fast iterator...
                if(TSBHashtable.this.modCount != expected_modCount)
                {
                    throw new ConcurrentModificationException("next(): modificación inesperada de tabla...");
                }

                if(!hasNext())
                {
                    throw new NoSuchElementException("next(): no existe el elemento pedido...");
                }

                // variable auxiliar t para simplificar accesos...
                TSBArrayList<Map.Entry<K, V>> t[] = TSBHashtable.this.table;

                // se puede seguir en el mismo bucket?...
                TSBArrayList<Map.Entry<K, V>> bucket = t[current_bucket];
                if(!t[current_bucket].isEmpty() && current_entry < bucket.size() - 1) { current_entry++; }
                else
                {
                    // si no se puede...
                    // ...recordar el índice del bucket que se va a abandonar..
                    last_bucket = current_bucket;

                    // buscar el siguiente bucket no vacío, que DEBE existir, ya
                    // que se hasNext() retornó true...
                    current_bucket++;
                    while(t[current_bucket].isEmpty())
                    {
                        current_bucket++;
                    }

                    // actualizar la referencia bucket con el núevo índice...
                    bucket = t[current_bucket];

                    // y posicionarse en el primer elemento de ese bucket...
                    current_entry = 0;
                }

                // avisar que next() fue invocado con éxito...
                next_ok = true;

                // y retornar la clave del elemento alcanzado...
                V value = bucket.get(current_entry).getValue();
                return value;
            }

            /*
             * Remueve el elemento actual de la tabla, dejando el iterador en la
             * posición anterior al que fue removido. El elemento removido es el
             * que fue retornado la última vez que se invocó a next(). El método
             * sólo puede ser invocado una vez por cada invocación a next().
             */
            @Override
            public void remove()
            {
                if(!next_ok)
                {
                    throw new IllegalStateException("remove(): debe invocar a next() antes de remove()...");
                }

                // eliminar el objeto que retornó next() la última vez...
                Map.Entry<K, V> garbage = TSBHashtable.this.table[current_bucket].remove(current_entry);

                // quedar apuntando al anterior al que se retornó...
                if(last_bucket != current_bucket)
                {
                    current_bucket = last_bucket;
                    current_entry = TSBHashtable.this.table[current_bucket].size() - 1;
                }

                // avisar que el remove() válido para next() ya se activó...
                next_ok = false;

                // la tabla tiene un elementon menos...
                TSBHashtable.this.count--;

                // fail_fast iterator: todo en orden...
                TSBHashtable.this.modCount++;
                expected_modCount++;
            }
        }
    }
}
