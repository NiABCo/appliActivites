package com.aelion.appliActivite.persistances.entities.services.common;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.aelion.appliActivite.exceptions.RessourceNotFoundException;

@Transactional
public abstract class AbstractService<T extends Serializable,T2> implements IServiceActions<T, T2>  {

	
	public abstract JpaRepository<T, T2> getRepo();
	
	
	@Override
	public List<T> findAll() {
		return getRepo().findAll();
	}

	@Override
	public T findOne(T2 id) {
		Optional<T> t = getRepo().findById(id);
		
		if(t.isEmpty()) {
			throw new RessourceNotFoundException("Object with id :" + id +" not found !");
		}else {
			return t.get();
		}
	}

	@Override
	public boolean deleteById(T2 id) {
		T t = findOne(id);
		
		try {
			getRepo().delete(t);
			return true;
		}catch (Exception e) {
			throw new RessourceNotFoundException("Id : "+id+" not deleted");
			
		}
	}

	@Override
	public boolean deleteByObject(T t) {
		try {
			getRepo().delete(t);
			return true;
		}catch (Exception e) {
			throw new RessourceNotFoundException(t +" not deleted");
			
		}
	}

	@Override
	public T save(T t) {
	return getRepo().save(t);
	}

}
