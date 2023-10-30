package com.tecnica.pruebaInditex.infra.controlller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tecnica.pruebaInditex.domain.models.Price;
import com.tecnica.pruebaInditex.service.PricesService;

@RestController
@RequestMapping("/price")
public class PricesController {

	@Autowired
	private PricesService service;

	@GetMapping("/info")
	public ResponseEntity<Price> findPrice(

			@RequestParam(required = true) @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss") Date appDate,
			@RequestParam(required = true) int productId,
			@RequestParam(required = true) int brandId) {

		return ResponseEntity.of(Optional.ofNullable(service.findPrice(appDate, productId, brandId)));
	}

}