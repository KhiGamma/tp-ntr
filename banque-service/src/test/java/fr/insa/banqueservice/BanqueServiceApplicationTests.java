package fr.insa.banqueservice;

import fr.insa.banqueservice.models.Client;
import fr.insa.banqueservice.models.Compte;
import fr.insa.banqueservice.models.Operation;
import fr.insa.banqueservice.resources.payload.ClientCreateModel;
import fr.insa.banqueservice.resources.payload.OperationCreateModel;
import fr.insa.banqueservice.services.ClientService;
import fr.insa.banqueservice.services.CompteService;
import fr.insa.banqueservice.services.OperationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BanqueServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	ClientService clientService;

	@Autowired
	CompteService compteService;

	@Autowired
	OperationService operationService;

	@Test
	public void getClient() throws Exception {
		Client client = clientService.getClientById("1");
		Assertions.assertNotNull(client);
	}

	@Test
	public void getNoClient() throws Exception {
		Assertions.assertThrows(Exception.class, () -> clientService.getClientById("4"));
	}

	@Test
	public void getCompte() throws Exception {
		Compte compte = compteService.getCompteById("1");
		Assertions.assertNotNull(compte);
	}

	@Test
	public void getNoCompte() throws Exception {
		Assertions.assertThrows(Exception.class, () -> compteService.getCompteById("4"));
	}

	@Test
	public void getOperationCompte() throws Exception {
		Assertions.assertEquals(2, compteService.getCompteById("1").getOperations().size());
	}

	@Test
	public void getOperationCompteFail() throws Exception {
		Assertions.assertNotEquals(2, compteService.getCompteById("2").getOperations().size());
	}

	@Test
	public void debitOK() throws Exception {
		OperationCreateModel operationCreateModel = new OperationCreateModel();
		operationCreateModel.setMontant(10);
		operationCreateModel.setType("debit");
		operationCreateModel.setCompte("2");

		operationService.saveOperationDebit(operationCreateModel);

		Assertions.assertEquals(2, compteService.getCompteById("2").getSolde());
	}

	@Test
	public void debitNotOK() throws Exception {
		OperationCreateModel operationCreateModel = new OperationCreateModel();
		operationCreateModel.setMontant(10);
		operationCreateModel.setType("debit");
		operationCreateModel.setCompte("2");

		operationService.saveOperationDebit(operationCreateModel);

		Assertions.assertNotEquals(18, compteService.getCompteById("2").getSolde());
	}

	@Test
	public void remboursementOK() throws Exception {
		OperationCreateModel operationCreateModel = new OperationCreateModel();
		operationCreateModel.setMontant(10);
		operationCreateModel.setType("remboursement");
		operationCreateModel.setCompte("2");

		operationService.saveOperationRemboursement(operationCreateModel);

		Assertions.assertNotEquals(18, compteService.getCompteById("2").getSolde());
	}

	@Test
	public void remboursementNotOK() throws Exception {
		OperationCreateModel operationCreateModel = new OperationCreateModel();
		operationCreateModel.setMontant(10);
		operationCreateModel.setType("remboursement");
		operationCreateModel.setCompte("2");

		operationService.saveOperationRemboursement(operationCreateModel);

		Assertions.assertNotEquals(-8, compteService.getCompteById("2").getSolde());
	}

}
