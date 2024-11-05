package otus.moryakovdv.meteoservices.cache;

/***Общий интерфейс кешировния данных.*/
public interface CacheService<K,V> {

	
	V getFromCache(K key);
	
	V putInCache(K key,V value);
}
