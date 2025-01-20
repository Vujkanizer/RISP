package si.um.feri.ris;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import si.um.feri.ris.controllers.MizaController;
import si.um.feri.ris.models.Miza;
import si.um.feri.ris.repository.MizaRepository;
import si.um.feri.ris.service.MizaService;
import java.util.List;
import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class MizaControllerTest {

	@Autowired
	private MizaController mizaController;

	@Autowired
	private MizaService mizaService;

	@Autowired
	private MizaRepository mizaRepository;

	@BeforeEach
	void setup() {
		mizaRepository.deleteAll();
	}


	@Test
	void testGetAll() {
		Miza miza1 = new Miza();
		miza1.setStatus(true);
		mizaService.createMiza(miza1);

		Miza miza2 = new Miza();
		miza2.setStatus(false);
		mizaService.createMiza(miza2);

		List<Miza> allMizas = mizaController.getALL();
		Assertions.assertEquals(2, allMizas.size());
	}

	@Test
	void testGetById() {
		Miza miza = new Miza();
		miza.setStatus(true);
		Miza savedMiza = mizaService.createMiza(miza);

		Optional<Miza> retrievedMiza = mizaController.getById(savedMiza.getIdMiza());
		Assertions.assertTrue(retrievedMiza.isPresent());
	}

	@Test
	void testCreateMiza() {
		Miza miza = new Miza();
		miza.setStatus(true);
		Miza createdMiza = mizaController.createMiza(miza);

		Assertions.assertNotNull(createdMiza);
	}

	@Test
	void testUpdateMiza() {
		Miza originalMiza = new Miza();
		originalMiza.setStatus(true);
		Miza savedMiza = mizaService.createMiza(originalMiza);

		Miza updatedMiza = new Miza();
		updatedMiza.setStatus(false);
		mizaController.updateMiza(savedMiza.getIdMiza(), updatedMiza);

		Optional<Miza> retrievedMiza = mizaService.getById(savedMiza.getIdMiza());
		Assertions.assertTrue(retrievedMiza.isPresent());
		Assertions.assertFalse(retrievedMiza.get().isStatus());
	}

	@Test
	void testDeleteMiza() {
		Miza miza = new Miza();
		miza.setStatus(true);
		Miza savedMiza = mizaService.createMiza(miza);

		mizaController.deleteMiza(savedMiza.getIdMiza());
		Optional<Miza> retrievedMiza = mizaService.getById(savedMiza.getIdMiza());
		Assertions.assertFalse(retrievedMiza.isPresent());
	}
}
