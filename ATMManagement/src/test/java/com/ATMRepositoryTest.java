
package com.klef.soa;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import com.klef.soa.entity.ATM;
import com.klef.soa.repository.ATMRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ATMRepositoryTest {

    @Autowired
    private ATMRepository repo;

    @BeforeEach
    public void setup() {

        repo.deleteAll();

        ATM a1 = new ATM();
        a1.setName("SBI");
        a1.setType("Bank ATM");
        a1.setStatus("ACTIVE");
        a1.setLocation("Vijayawada");

        ATM a2 = new ATM();
        a2.setName("HDFC");
        a2.setType("Bank ATM");
        a2.setStatus("ACTIVE");
        a2.setLocation("Guntur");

        ATM a3 = new ATM();
        a3.setName("Canara");
        a3.setType("White Label ATM");
        a3.setStatus("CLOSED");
        a3.setLocation("Tenali");

        repo.save(a1);
        repo.save(a2);
        repo.save(a3);
    }

    // 1. Test display all ATMs
    @Test
    public void testFindAll() {
        List<ATM> list = repo.findAll();
        assertEquals(3, list.size());
    }

    // 2. Test display ATM by ID
    @Test
    public void testFindById() {
        ATM atm = repo.findAll().get(0);
        assertNotNull(repo.findById(atm.getAtmId()).orElse(null));
    }

    // 3. Test search ATM by name
    @Test
    public void testFindByName() {
        List<ATM> list = repo.findByName("SBI");
        assertEquals(1, list.size());
    }

    // 4. Test search ATM by type
    @Test
    public void testFindByType() {
        List<ATM> list = repo.findByType("Bank ATM");
        assertEquals(2, list.size());
    }

    // 5. Test total ATM count
    @Test
    public void testCount() {
        assertEquals(3, repo.count());
    }
}
