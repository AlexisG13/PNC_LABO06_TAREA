package com.capas.tarea6.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.capas.tarea6.domain.Importancia;

public interface ImportanciaDAO {

	public List<Importancia> findAll() throws DataAccessException;
}
