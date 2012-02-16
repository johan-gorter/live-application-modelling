package org.instantlogic.fabric.model;

import java.util.Iterator;
import java.util.SortedMap;

import org.instantlogic.fabric.Instance;


/**
 * Can be compared to a Class, only more powerful
 */
public abstract class Entity<I extends Instance<I>> extends Concept {

	public SortedMap<String, Entity<?>> getAllEntities() {
		for (Relation<I, ? extends Object, ? extends Instance<?>> relation : getRelations()) {
			relation.getTo();
		}
		throw new RuntimeException("TODO");
	}
	
	public static boolean extendsFrom(Entity<?> entity, Entity<?> from) {
		if (entity==from) return true;
		if (entity==null) return false;
		return extendsFrom(entity.extendsEntity(), from);
	}
	
	private static class BaseEntityFirstIterable<E> implements Iterable<E> {

		private Iterable<E> baseEntityIterator;
		private E[] items;
		
		public BaseEntityFirstIterable(Iterable<E> baseEntityIterator, E[] items) {
			this.baseEntityIterator = baseEntityIterator;
			this.items = items;
		}

		@Override
		public Iterator<E> iterator() {
			return new BaseEntityFirstIterator<E>(baseEntityIterator, items);
		}
	}
	
	private static class  BaseEntityFirstIterator<E> implements Iterator<E> {

		private Iterator<E> baseEntityIterator;
		private E[] items;
		private int index = 0;
		
		public BaseEntityFirstIterator(Iterable<E> baseEntityIterator, E[] items) {
			if (baseEntityIterator!=null) {
				this.baseEntityIterator = baseEntityIterator.iterator();
			}
			this.items = items;
		}

		@Override
		public boolean hasNext() {
			if (baseEntityIterator!=null) {
				boolean hasNext = baseEntityIterator.hasNext();
				if (hasNext) {
					return true;
				} else {
					baseEntityIterator = null;
				}
			}
			return index<items.length;
		}

		@Override
		public E next() {
			if (baseEntityIterator!=null) {
				return baseEntityIterator.next();
			}
			return items[index++];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("Not implemented");
		}
		
	}
	
	public Entity<?> extendsEntity() {
		return null;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public final Iterable<Attribute<I, ? extends Object, ? extends Object>> getAttributes() {
		Entity<?> extendsEntity = extendsEntity();
		Iterable<?> baseEntityIterator=null;
		if (extendsEntity!=null) {
			baseEntityIterator = (Iterable<?>)extendsEntity.getAttributes();
		}
		return new BaseEntityFirstIterable(baseEntityIterator, getLocalAttributes());
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public final Iterable<Relation<I, ? extends Object, ? extends Instance<?>>> getRelations() {
		Entity<?> extendsEntity = extendsEntity();
		Iterable<?> baseEntityIterator=null;
		if (extendsEntity!=null) {
			baseEntityIterator = (Iterable<?>)extendsEntity.getRelations();
		}
		return new BaseEntityFirstIterable(baseEntityIterator, getLocalRelations());
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public final Iterable<Relation<? extends Instance<?>, ? extends Object, I>> getReverseRelations() {
		Entity<?> extendsEntity = extendsEntity();
		Iterable<?> baseEntityIterator=null;
		if (extendsEntity!=null) {
			baseEntityIterator = extendsEntity.getReverseRelations();
		}
		return new BaseEntityFirstIterable(baseEntityIterator, getLocalReverseRelations());
	}
	
	public abstract Attribute<I, ? extends Object, ? extends Object>[] getLocalAttributes();
	
	public abstract Relation<I, ? extends Object, ? extends Instance<?>>[] getLocalRelations();

	public abstract Relation<? extends Instance<?>, ? extends Object, I>[] getLocalReverseRelations();

	public abstract I createInstance();
	
	public abstract Class<I> getInstanceClass();

}
