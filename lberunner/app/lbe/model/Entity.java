package lbe.model;

import java.util.Arrays;
import java.util.Iterator;

import lbe.instance.CaseInstance;
import lbe.instance.Instance;

public abstract class Entity extends Model {

	public static boolean extendsFrom(Entity entity, Entity from) {
		if (entity==null) return false;
		if (entity==from) return true;
		return extendsFrom(entity.extendsEntity(), from);
	}
	
	private static class  BaseEntityFirstIterable<E> implements Iterable<E> {

		private Iterable<E> baseEntityIterator;
		private E[] items;
		
		public BaseEntityFirstIterable(Iterable<E> baseEntityIterator, E[] items) {
			this.baseEntityIterator = baseEntityIterator;
			this.items = items;
		}

		@Override
		public Iterator<E> iterator() {
			return new BaseEntityFirstIterator(baseEntityIterator, items);
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
	
	public abstract Entity extendsEntity();
	
	public final Iterable<Attribute<? extends Instance, ? extends Object, ? extends Object>> getAttributes() {
		Entity extendsEntity = extendsEntity();
		Iterable<Attribute<? extends Instance, ? extends Object, ? extends Object>> baseEntityIterator=null;
		if (extendsEntity!=null) {
			baseEntityIterator = extendsEntity.getAttributes();
		}
		return new BaseEntityFirstIterable<Attribute<? extends Instance,? extends Object,? extends Object>>(baseEntityIterator, getLocalAttributes());
	}
	
	public final Iterable<Relation<? extends Instance, ? extends Object, ? extends Instance>> getRelations() {
		Entity extendsEntity = extendsEntity();
		Iterable<Relation<? extends Instance, ? extends Object, ? extends Instance>> baseEntityIterator=null;
		if (extendsEntity!=null) {
			baseEntityIterator = extendsEntity.getRelations();
		}
		return new BaseEntityFirstIterable<Relation<? extends Instance,? extends Object,? extends Instance>>(baseEntityIterator, getLocalRelations());
	}
	
	public final Iterable<Relation<? extends Instance, ? extends Object, ? extends Instance>> getRevereseRelations() {
		Entity extendsEntity = extendsEntity();
		Iterable<Relation<? extends Instance, ? extends Object, ? extends Instance>> baseEntityIterator=null;
		if (extendsEntity!=null) {
			baseEntityIterator = extendsEntity.getRevereseRelations();
		}
		return new BaseEntityFirstIterable<Relation<? extends Instance,? extends Object,? extends Instance>>(baseEntityIterator, getLocalReverseRelations());
	}
	
	public abstract Attribute<? extends Instance, ? extends Object, ? extends Object>[] getLocalAttributes();
	
	public abstract Relation<? extends Instance, ? extends Object, ? extends Instance>[] getLocalRelations();

	public abstract Relation<? extends Instance, ? extends Object, ? extends Instance>[] getLocalReverseRelations();

	public abstract Instance createInstance(CaseInstance caseInstance);

	public abstract Instance createInstance(CaseInstance caseInstance, long id);

}
