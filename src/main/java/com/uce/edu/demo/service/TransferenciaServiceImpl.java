package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICuentaBancariaRepository;
import com.uce.edu.demo.repository.ITransferenciaRepository;
import com.uce.edu.demo.repository.modelo.CuentaBancaria;
import com.uce.edu.demo.repository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService{

	@Autowired
	private ICuentaBancariaRepository iCuentaBancariaRepository;
	
	@Autowired
	private ITransferenciaRepository iTransferenciaRepository;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarTransferencia(String NumeroCuentaOrigen, String NumeroCuentaDestino, BigDecimal monto) { //begin
		// TODO Auto-generated method stub

		//0. Buscar la Cta de Origen (obtener el saldo)
		CuentaBancaria cuentaOrigen = this.iCuentaBancariaRepository.buscarPorNumero(NumeroCuentaOrigen);
		
		//1. Restar el monto a la cuenta de Origen
		BigDecimal resto = cuentaOrigen.getSaldo().subtract(monto);
		cuentaOrigen.setSaldo(resto);
		this.iCuentaBancariaRepository.actualizar(cuentaOrigen);
		CuentaBancaria cuentaDestino = this.iCuentaBancariaRepository.buscarPorNumero(NumeroCuentaDestino);
		
		//2. Sumar el monto a la cuenta de Destino
		BigDecimal saldoFinal = cuentaDestino.getSaldo().add(monto);
		cuentaDestino.setSaldo(saldoFinal);
		this.iCuentaBancariaRepository.actualizar(cuentaDestino);
		
		//3. Insertar la transferencia
		Transferencia transferencia = new Transferencia();
		transferencia.setFecha(LocalDateTime.now());
		transferencia.setMonto(monto);
		transferencia.setCuentaOrigen(cuentaOrigen);
		transferencia.setCuentaDestino(cuentaDestino);
		
		this.iTransferenciaRepository.insertar(transferencia);
	}//commit

	@Override
	@Transactional(value = TxType.REQUIRED)
	//si le ponemos REQUIRES_NEW al realizar transferencia usamos este
	public void realizarTransferenciaFachada(String numeroCtaOrigen, String numeroCtaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		this.realizarTransferencia(numeroCtaOrigen, numeroCtaDestino, monto);
	}
}
