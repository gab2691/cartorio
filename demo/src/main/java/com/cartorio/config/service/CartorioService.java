package com.cartorio.config.service;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.cartorio.config.models.Cartorio;

@Transactional
public interface CartorioService extends CrudRepository<Cartorio, Long> {

}
