package com.aelion.appliActivite.services.common;

import java.io.Serializable;
import java.util.List;

public interface IServiceActions<T1 extends Serializable, T2> {

	public List<T1> findAll();

	public T1 findOne(T2 id);

	public boolean deleteById(T2 id);

	public boolean deleteByObject(T1 t);

	public T1 save(T1 t);
}
