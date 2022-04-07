package springserver.movimentotests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import springserver.model.Conta;
import springserver.model.Movimento;
import springserver.model.enumerators.ContaTipo;
import springserver.model.enumerators.MovimentoTipo;
import springserver.repository.MovimentoRepository;

import java.math.BigDecimal;

@DataJpaTest
@ActiveProfiles("test")
public class MovimentoRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    MovimentoRepository movimentoRepository;

    @Test
    public void testFindByConta() {

        Movimento movimento = new Movimento();
        Conta conta = new Conta();

        conta.setId(1L);
        conta.setAgencia("1234");
        conta.setNumero("12345");
        conta.setTipoconta(ContaTipo.CC);

        movimento.setConta(conta);
        movimento.setValor(new BigDecimal(100L));
        movimento.setMovimentoTipo(MovimentoTipo.DESPESA);
        movimento.setDescricao("Teste");

        testEntityManager.persist(conta);
        testEntityManager.persist(movimento);
        testEntityManager.flush();

        movimentoRepository.findByConta(conta);
    }

    @Test
    public void testFindByContaIdAndMovimentoTipo() {

        Movimento movimento = new Movimento();
        Conta conta = new Conta();

        conta.setId(1L);
        conta.setAgencia("1234");
        conta.setNumero("12345");
        conta.setTipoconta(ContaTipo.CC);

        movimento.setConta(conta);
        movimento.setValor(new BigDecimal(100L));
        movimento.setMovimentoTipo(MovimentoTipo.DESPESA);
        movimento.setDescricao("Teste");

        testEntityManager.persist(conta);
        testEntityManager.persist(movimento);
        testEntityManager.flush();

        movimentoRepository.findByContaIdAndMovimentoTipo(1L, MovimentoTipo.DESPESA);
    }


}
