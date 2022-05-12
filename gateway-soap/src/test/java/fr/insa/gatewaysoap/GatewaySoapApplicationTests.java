package fr.insa.gatewaysoap;

import fr.insa.gatewaysoap.obj.*;
import fr.insa.gatewaysoap.repostories.CompteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GatewaySoapApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private CompteRepository compteRepository;

	@Test
	public void debitOk() {
		Operation operation = new Operation();
		operation.setMontant(5);
		operation.setNumCompte("123456");

		DebitRequest request = new DebitRequest();
		request.setOperation(operation);

		DebitResponse response = compteRepository.debiterCompte(request);
		Assertions.assertEquals(-3, compteRepository.findCompte(operation.getNumCompte()).getSolde());
	}

	@Test
	public void debitNotOk() {
		Operation operation = new Operation();
		operation.setMontant(8);
		operation.setNumCompte("135246");

		DebitRequest request = new DebitRequest();
		request.setOperation(operation);

		DebitResponse response = compteRepository.debiterCompte(request);
		Assertions.assertEquals(2, compteRepository.findCompte(operation.getNumCompte()).getSolde());
	}

	@Test
	public void debitMontantNotOk() {
		Operation operation = new Operation();
		operation.setMontant(-5);
		operation.setNumCompte("123456");

		DebitRequest request = new DebitRequest();
		request.setOperation(operation);

		DebitResponse response = compteRepository.debiterCompte(request);
		Assertions.assertEquals("Le montant doit être supérieur à 0", response.getResponse());
	}

	@Test
	public void remboursementOk() {
		Operation operation = new Operation();
		operation.setMontant(3);
		operation.setNumCompte("654321");

		RemboursementRequest request = new RemboursementRequest();
		request.setOperation(operation);

		RemboursementResponse response = compteRepository.rembourserCompte(request);
		Assertions.assertEquals(5, compteRepository.findCompte(operation.getNumCompte()).getSolde());
	}

	@Test
	public void remboursementNotOk() {
		Operation operation = new Operation();
		operation.setMontant(8);
		operation.setNumCompte("135246");

		RemboursementRequest request = new RemboursementRequest();
		request.setOperation(operation);

		RemboursementResponse response = compteRepository.rembourserCompte(request);
		Assertions.assertEquals(2, compteRepository.findCompte(operation.getNumCompte()).getSolde());
	}

	@Test
	public void remboursementMontantNotOk() {
		Operation operation = new Operation();
		operation.setMontant(-5);
		operation.setNumCompte("654321");

		RemboursementRequest request = new RemboursementRequest();
		request.setOperation(operation);

		RemboursementResponse response = compteRepository.rembourserCompte(request);
		Assertions.assertEquals("Le montant doit être supérieur à 0", response.getResponse());
	}
}
