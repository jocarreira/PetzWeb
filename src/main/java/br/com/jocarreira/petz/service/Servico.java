package br.com.jocarreira.petz.service;

import java.util.List;

public interface Servico<T> {
	 
    T get(Long id);
    List<T> getAll();
    T save(T t);
    T update(T t);
    Boolean delete(Long i);
}
